package com.shijihui.entity;

public class BlacklistIp {
    private Long ipLong;

    private String ipAddress;

    private Integer ctime;

    public Long getIpLong() {
        return ipLong;
    }

    public BlacklistIp setIpLong(Long ipLong) {
        this.ipLong = ipLong;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public BlacklistIp setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public Integer getCtime() {
        return ctime;
    }

    public BlacklistIp setCtime(Integer ctime) {
        this.ctime = ctime;
        return this;
    }
}