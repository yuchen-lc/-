package com.shijihui.mapper;

import com.shijihui.entity.BlacklistIp;

public interface BlacklistIpMapper {
    int deleteByPrimaryKey(Long ipLong);

    int insert(BlacklistIp record);

    int insertSelective(BlacklistIp record);

    BlacklistIp selectByPrimaryKey(Long ipLong);

    Long selectIpLongByPrimaryKey(Long ipLong);

    int updateByPrimaryKeySelective(BlacklistIp record);

    int updateByPrimaryKey(BlacklistIp record);
}