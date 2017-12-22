package com.shijihui.service.impl;

import com.shijihui.entity.BlacklistIp;
import com.shijihui.mapper.BlacklistIpMapper;
import com.shijihui.service.BlacklistIpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jiangzhiyong on 16/12/31.
 */
@Service
public class BlacklistIpServiceImpl implements BlacklistIpService {

    @Resource
    private BlacklistIpMapper blacklistIpMapper;

    @Override
    public boolean existIplong(Long ipLong) {
        return blacklistIpMapper.selectIpLongByPrimaryKey(ipLong) != null;
    }

    @Override
    public int insert(BlacklistIp blacklistIp) {
        return blacklistIpMapper.insert(blacklistIp);
    }
}
