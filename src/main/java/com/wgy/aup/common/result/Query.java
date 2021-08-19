package com.wgy.aup.common.result;

import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * description 查询参数封装
 * author wgy
 * version 2021/8/19 23:14:29
 */
@Slf4j
public class Query extends LinkedHashMap<Object,Object> {
    //请求页码
    private Integer page = 1;

    private Integer limit = 10;

    public Query(Map<String,Object> params){
        this.putAll(params);
        log.info("query.params:{}",this);
        if(!Objects.isNull(params.get("page"))){
            this.page = Integer.valueOf(params.get("page").toString());
        }
        if (Objects.isNull(params.get("limit"))){
            this.limit = Integer.valueOf(params.get("limit").toString());
        }
        this.remove("page");
        this.remove("limit");
    }


    public Integer getPage(){
        return this.page;
    }

    public Integer getLimit(){
        return this.limit;
    }

}
