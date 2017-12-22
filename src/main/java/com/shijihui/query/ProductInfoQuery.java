package com.shijihui.query;

import lombok.Data;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class ProductInfoQuery extends PagerQuery {

    private String chinessName;

    private String chinessSynonym;

    private Integer casInfoId;

    private String cas;

}
