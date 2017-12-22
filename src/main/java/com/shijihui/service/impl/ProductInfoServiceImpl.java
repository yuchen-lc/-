package com.shijihui.service.impl;

import com.shijihui.entity.ProductInfo;
import com.shijihui.mapper.ProductInfoMapper;
import com.shijihui.query.ProductInfoQuery;
import com.shijihui.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiangzhiyong on 16/11/2.
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public ProductInfo selectById(Integer id) {
        return productInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductInfo> selectByQuery(ProductInfoQuery query) {
        return productInfoMapper.selectByQuery(query);
    }

    @Override
    public Integer countByQuery(ProductInfoQuery query) {
        return productInfoMapper.countByQuery(query);
    }
}
