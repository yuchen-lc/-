package com.shijihui.mapper;

import com.shijihui.entity.ProductInfo;
import com.shijihui.query.ProductInfoQuery;

import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(Integer id);

    Integer countByQuery(ProductInfoQuery query);

    List<ProductInfo> selectByQuery(ProductInfoQuery query);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}