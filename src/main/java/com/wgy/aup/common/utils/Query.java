package com.wgy.aup.common.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author wgy
 * @version 2021/8/21 23:05:58
 */
public class Query extends LinkedHashMap<String, Object> {

    private Integer page = 1;

    private Integer limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        if (!Objects.isNull(get("page")) || !("".equals(get("page")))) {
            this.page = Integer.parseInt(get("page").toString());
        }
        if (!Objects.isNull(get("limit")) || !("".equals(get("limit")))) {
            this.limit = Integer.parseInt(get("limit").toString());
        }
        this.remove("page");
        this.remove("limit");
    }

    public Integer getPage() {
        return page;
    }

    public Integer getLimit() {
        return limit;
    }
}
