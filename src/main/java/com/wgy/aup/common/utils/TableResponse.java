package com.wgy.aup.common.utils;

import com.wgy.aup.common.utils.BaseResponse;
import com.wgy.aup.common.utils.ResultCode;

import java.util.List;

/**
 * @author wgy
 * @version 2021/8/21 22:59:38
 */
public class TableResponse<T> extends BaseResponse {

    private Integer rows;

    private Integer total;

    private List<T> data;

    public Integer getTotal() {
        return this.total;
    }

    public TableResponse() {
    }

    public TableResponse(ResultCode resultCode){
        super(resultCode);
    }


}
