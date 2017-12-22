package com.shijihui.vo;

import lombok.Data;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class WebRetureVo<T> {

    /**
     * 0成功，1失败
     */
    private int success = 0;

    /**
     * 原因
     */
    private String msg;

    /**
     * 内容
     */
    private T data;


    public WebRetureVo(String msg) {
        this.msg = msg;
    }

    public WebRetureVo(T data) {
        this.data = data;
    }

    public static WebRetureVo fail(String msg) {
        WebRetureVo retureVo = new WebRetureVo(msg);
        retureVo.setSuccess(1);
        retureVo.setMsg(msg);
        return retureVo;
    }


}
