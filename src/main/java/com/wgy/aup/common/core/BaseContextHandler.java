package com.wgy.aup.common.core;

import com.wgy.aup.common.core.context.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * author wgy
 * description 应用上下文
 * version 2021/8/8 17:11:38
 */
public class BaseContextHandler {
    private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    private static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    private static Object get(String key) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }

        return map.get(key);
    }


    public static void setCurrentName(String name){
        set(Constants.KEY_CURRENT_NAME,name);
    }

    public static void setCurrentCode(String code){
        set(Constants.KEY_CURRENT_CODE,code);
    }


    public static void setCurrentNumber(String number){
        set(Constants.KEY_CURRENT_NUMBER,number);
    }

    public static void setToken(String token){
        set(Constants.KEY_TOKEN_PREFIX,token);
    }

    /**
     * 获取当前编码
     */
    public static Object getCurrentCode(){
        Object value = get(Constants.KEY_CURRENT_CODE);
        return returnObjectValue(value);
    }

    /**
     * 获取当前token
     * @return
     */
    public static Object getToken(){
        Object value = get(Constants.KEY_TOKEN_PREFIX);
        return returnObjectValue(value);
    }

    /**
     * 获取工号/学号
     */
    public static Object getCurrentNumber(){
        Object value = get(Constants.KEY_CURRENT_NUMBER);
        return returnObjectValue(value);
    }

    /**
     * 获取当前用户名
     * @return
     */
    public static Object getCurrentName(){
        Object value = get(Constants.KEY_CURRENT_NAME);
        return returnObjectValue(value);
    }

    private static Object returnObjectValue(Object value) {
        return value == null? null:value.toString();
    }
}
