package com.shijihui.service;

import com.shijihui.entity.BlacklistIp;

/**
 * Created by jiangzhiyong on 16/12/31.
 */
public interface BlacklistIpService {

    boolean existIplong(Long ipLong);

    int insert(BlacklistIp blacklistIp);
}
