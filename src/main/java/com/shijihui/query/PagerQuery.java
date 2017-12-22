package com.shijihui.query;

import lombok.Data;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class PagerQuery {

    private int curPage = 1; // 当前页
    private int pageSize = 10; // 每页多少行
    private int totalRow; // 共多少行
    private int start;// 当前页起始行
    private int end;// 结束行
    private int totalPage; // 共多少页

    private boolean needPage = true;

    public int getCurPage() {
        if (curPage < 1) {
            curPage = 1;
        }
        return curPage;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = 10;
        }
        return pageSize;
    }

    public int getStart() {
        start = getPageSize() * (getCurPage() - 1);
        return start;
    }

    public int getEnd() {
        end = getPageSize() * getCurPage();
        return end;
    }

}
