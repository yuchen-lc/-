package com.shijihui.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class DataPageVo<T> {

    private List<T> models;

    private PagerVo pager;

    public DataPageVo(List<T> model, int curPage, int pageSize, int total) {
        this.models = model;
        this.pager = new PagerVo(curPage, pageSize, total);
    }

}
