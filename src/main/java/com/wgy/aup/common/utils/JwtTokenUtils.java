package com.wgy.aup.common.utils;

import java.util.Map;

/**
 * description token工具类
 * author wgy
 * version 2021/8/13 03:10:14
 */
public class JwtTokenUtils implements JwtTokenHelper {

    private static final long EXPIRE_TIME = 10 * 60 * 60 * 1000;//token到期时间10小时
    private static final String TOKEN_SECRET = "ADFVGJHFGFWOD4GASDF237887jASDhjJDWSDKO53";  //密钥盐

    @Override
    public Map<String, Object> parseToken(String token) {
        return null;
    }


    @Override
    public String createToken(Object obj) {

        return null;
    }
}
