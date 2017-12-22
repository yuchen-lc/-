package com.shijihui.mapper;

import com.shijihui.entity.CasInfo;
import com.shijihui.query.CasInfoQuery;

import java.util.List;

public interface CasInfoMapper {
    int insert(CasInfo record);

    int insertSelective(CasInfo record);

    CasInfo selectByPrimaryKey(Integer id);

    Integer countByQuery(CasInfoQuery query);

    List<CasInfo> selectByQuery(CasInfoQuery query);
}