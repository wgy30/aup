package com.wgy.aup.common.utils;

import com.wgy.aup.common.utils.ResultCode;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wgy
 * @version 2021/8/21 20:50:21
 */
@Data
public class BaseResponse implements Serializable {

    /**
     * 响应消息
     */
    public String message;

    /**
     * 状态码
     */
    public Integer code = 200;

    public BaseResponse() {
    }

    public BaseResponse(String message){
        this.message = message;
    }

    public BaseResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

}
