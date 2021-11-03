package com.wgy.aup.common.utils;

import lombok.Data;

@Data
public class ObjectResponse<T> extends BaseResponse {

    private T data;

    public ObjectResponse() {
    }

    public ObjectResponse(T data){
        this.data = data;
    }

    public ObjectResponse<T> ok() {
        return new ObjectResponse<>();
    }

    public ObjectResponse<T> data(T data) {
        ObjectResponse<T> response = new ObjectResponse<>();
        response.setData(data);
        return response;
    }

    public ObjectResponse<T> fail(Integer code,String message) {
        ObjectResponse<T> response = new ObjectResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return this;
    }
}

