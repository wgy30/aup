package com.wgy.aup.common.utils;

import com.wgy.aup.common.utils.BaseResponse;
import com.wgy.aup.common.utils.ResultCode;

import java.util.List;

/**
 * @author wgy
 * @version 2021/8/21 22:59:38
 */
public class TableResponse<T> extends BaseResponse {

    private TableData<T> data;

    public TableResponse() {
    }

    public TableResponse(List<T> data){
        this.data = new TableData<>(data);
    }

    public TableResponse(Integer total,List<T> data){
        this.data = new TableData<>(total, data);
    }

    public TableResponse<T> ok(){
        this.data = new TableData<>();
        return this;
    }

    public TableResponse<T> data(List<T> data){
        this.data = new TableData<>(data);
        return this;
    }

    public TableResponse<T> fail(String message){
        this.setMessage(message);
        return this;
    }

    private static class TableData<T>{
        protected Integer total;
        protected List<T> rows;

        TableData(){};

        TableData(List<T> rows){
            this.rows = rows;
            this.total = rows.size();
        }

        TableData(Integer total, List<T> rows){
            this.total = total;
            this.rows = rows;
        }
    }



}
