package com.onlinetool.common;

public enum ResponseCode {
    SUCCESS(20000,"SUCCESS"),
    ERROR(1,"SUCCESS");

    private final int code;

    private final String desc;

    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
