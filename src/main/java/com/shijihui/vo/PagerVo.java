package com.shijihui.vo;

import lombok.Data;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class PagerVo {

    private int curPage = 1; // 当前页
    private int pageSize = 10; // 每页多少行
    private int totalRow; // 共多少行
    private int totalPage; // 共多少页

    public PagerVo() {}

    public PagerVo(int curPage, int pageSize, int totalRow) {
        this.curPage = curPage;
        this.pageSize = pageSize;
        this.totalRow = totalRow;
        this.totalPage = (totalRow + pageSize - 1) / pageSize;
    }

}
