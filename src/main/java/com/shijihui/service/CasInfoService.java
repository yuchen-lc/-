package com.shijihui.service;

import com.shijihui.entity.CasInfo;
import com.shijihui.query.CasInfoQuery;

import java.util.List;

/**
 * Created by jiangzhiyong on 16/11/2.
 */
public interface CasInfoService {

    public CasInfo selectById(Integer id);

    Integer countByQuery(CasInfoQuery query);

    List<CasInfo> selectByQuery(CasInfoQuery query);

}
