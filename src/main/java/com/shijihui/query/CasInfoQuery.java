package com.shijihui.query;

import lombok.Data;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class CasInfoQuery extends PagerQuery {

    private String chinessName;

    private String chinessSynonym;

    private String cas;

}
