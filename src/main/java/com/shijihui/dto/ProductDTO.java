package com.shijihui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jiangzhiyong on 17/1/14.
 */
@Data
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -6060838563783488823L;

    //主键ID
    private int id;

    //cas
    private String cas;

    //中文名称
    private String cName;

    //英文名称
    private String eName;

}
