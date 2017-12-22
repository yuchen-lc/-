package com.shijihui.filter;

import com.shijihui.config.GlobalConstantHolder;
import com.shijihui.util.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiangzhiyong on 15/12/12.
 */
@Component
public class PowerFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(PowerFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ThreadContext.clear();

        long start = System.currentTimeMillis();
        filterChain.doFilter(request, response);

        if (GlobalConstantHolder.instance.isOpenPowerFilterLog()) {
            long end = System.currentTimeMillis();
            log.info("uri = {}, costTime = {}", request.getRequestURI(), end - start);
        }
    }
}
