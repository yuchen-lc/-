package com.shijihui.service;

import com.shijihui.entity.ProductInfo;
import com.shijihui.query.ProductInfoQuery;

import java.util.List;

/**
 * Created by jiangzhiyong on 16/11/2.
 */
public interface ProductInfoService {

    public ProductInfo selectById(Integer id);

    Integer countByQuery(ProductInfoQuery query);

    List<ProductInfo> selectByQuery(ProductInfoQuery query);

}
