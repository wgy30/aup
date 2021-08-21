package com.wgy.aup.common.utils;

import com.wgy.aup.common.utils.ResultCode;
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
    public String code;

    public BaseResponse() {
    }

    public BaseResponse(ResultCode resultCode) {
        this.message = resultCode.getMessage();
        this.code = resultCode.getCode();
    }

}
