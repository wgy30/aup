package com.wgy.aup.common.utils;

import lombok.Getter;

/**
 * @author wgy
 * @version 2021/8/21 21:04:43
 */

@Getter
public enum ResultCode {

    //请求状态码
    SUCCESS("2000", "success"),
    FAIL("2001", "fail"),
    NO_LOGIN("2002", "user don't login"),
    NO_PERMISSION("2003", "you don't have the permission"),

    //页面状态码
    PAGE_SUCCESS("4000", "find ths page"),
    PAGE_FAIL("4001", "don't find the page"),

    //操作状态码
    OP_SUCCESS("5000", "Operation is successful"),
    OP_FAIL("5001", "Operation is failed"),

    //未知异常状态码
    ERROR("3000", "Unknown exception");

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public static String getMessage(String name) {
        for (ResultCode item : values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return null;
    }

    public static String getCode(String name) {
        for (ResultCode item : values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
