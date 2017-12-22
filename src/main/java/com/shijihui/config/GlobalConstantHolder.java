package com.shijihui.config;

import lombok.Data;

/**
 * Created by jiangzhiyong on 16/11/10.
 */
@Data
public class GlobalConstantHolder {


    public static GlobalConstantHolder instance = new GlobalConstantHolder();

    private boolean openPowerFilterLog = true;

    private long accessUpperLimit = 60;

}
