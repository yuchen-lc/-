package com.shijihui.service.impl;

import com.shijihui.entity.CasInfo;
import com.shijihui.mapper.CasInfoMapper;
import com.shijihui.query.CasInfoQuery;
import com.shijihui.service.CasInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiangzhiyong on 16/11/2.
 */
@Service
public class CasInfoServiceImpl implements CasInfoService {

    @Resource
    private CasInfoMapper casInfoMapper;

    @Override
    public CasInfo selectById(Integer id) {
        return casInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CasInfo> selectByQuery(CasInfoQuery query) {
        return casInfoMapper.selectByQuery(query);
    }

    @Override
    public Integer countByQuery(CasInfoQuery query) {
        return casInfoMapper.countByQuery(query);
    }
}
