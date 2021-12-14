package com.wgy.aup.exception;

/**
 * @author wgy
 * @version 2021/10/4 15:53:55
 */
public class BaseException extends RuntimeException {

    private String message;

    private Integer code;

    BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
