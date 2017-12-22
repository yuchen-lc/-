package com.shijihui.filter;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shijihui.config.GlobalConstantHolder;
import com.shijihui.entity.BlacklistIp;
import com.shijihui.service.BlacklistIpService;
import com.shijihui.util.IPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jiangzhiyong on 16/12/31.
 * 防止爬虫filter
 */
@Component
public class ReverseCrawlerFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(ReverseCrawlerFilter.class);

    @Resource
    private BlacklistIpService blacklistIpService;
    //最多记录的ip个数
    private static final int accessMaximuxSize = 10000;
    //单个ip的统计周期为1分钟
    private static final int accessValidMinutes = 1;
    private static LoadingCache<Long, AtomicLong> ipAccessCount = CacheBuilder.newBuilder()
            .maximumSize(accessMaximuxSize)
            .expireAfterWrite(accessValidMinutes, TimeUnit.MINUTES)
            .build(new CacheLoader<Long, AtomicLong>() {
                @Override
                public AtomicLong load(Long key) throws Exception {
                    return new AtomicLong(0);
                }

            });


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        long start = System.currentTimeMillis();
        String ipAddress = IPUtils.getIpAddr(request);
        long ipLong = IPUtils.ipToLong(ipAddress);
        if (ipLong > 0) {
            //如果是黑名单ip，返回到迷路页面
            boolean black = blacklistIpService.existIplong(ipLong);
            if (black) {
                response.sendRedirect("/");
                return;
            }
            try {
                //次数+1，1分钟内方位次数超过60，写黑名单记录
                AtomicLong count = ipAccessCount.get(ipLong);
                long next = count.getAndIncrement();
                if (next >= GlobalConstantHolder.instance.getAccessUpperLimit()) {
                    blacklistIpService.insert(new BlacklistIp().setIpLong(ipLong).setIpAddress(ipAddress).setCtime((int)(System.currentTimeMillis() / 1000L)));
                    ipAccessCount.invalidate(ipLong);
                    response.sendRedirect("/");
                    return;
                }
            } catch (ExecutionException e) {
                log.error("process ipAccessCount error", e);
            }

        }
        log.info("LoadingCache : {}", ipAccessCount.asMap());
        if (GlobalConstantHolder.instance.isOpenPowerFilterLog()) {
            long end = System.currentTimeMillis();
            log.info("process ipAccessCount, costTime = {}", end - start);
        }
        filterChain.doFilter(request, response);
    }
}
