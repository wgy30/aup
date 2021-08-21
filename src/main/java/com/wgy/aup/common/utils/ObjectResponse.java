package com.wgy.aup.common.utils;

import lombok.Data;

/**
 * @author wgy
 * @version 2021/8/21 21:02:29
 */
@Data
public class ObjectResponse<T> extends BaseResponse {

    private T data;

    public ObjectResponse() {
    }

    public ObjectResponse(ResultCode resultCode) {
        super(resultCode);
        this.message = getMessage();
        this.code = getCode();
    }


    public ObjectResponse(T data) {
        super(ResultCode.SUCCESS);
        this.data = data;
    }

    public ObjectResponse<T> ok() {
        ObjectResponse<T> response = new ObjectResponse<>(ResultCode.SUCCESS);
        return response;
    }

    public ObjectResponse<T> ok(T data) {
        ObjectResponse<T> response = new ObjectResponse<T>(ResultCode.SUCCESS);
        response.setData(data);
        return response;
    }

    public ObjectResponse<T> fail() {
        ObjectResponse<T> response = new ObjectResponse<>(ResultCode.FAIL);
        return response;
    }

    public ObjectResponse<T> fail(T data) {
        ObjectResponse<T> response = new ObjectResponse<>(ResultCode.FAIL);
        return response;
    }
}

