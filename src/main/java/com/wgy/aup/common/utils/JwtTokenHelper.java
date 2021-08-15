package com.wgy.aup.common.utils;

import java.util.Map;

/**
 * description
 * author wgy
 * version 2021/8/13 02:53:16
 */
public interface JwtTokenHelper {
   Map<String,Object> parseToken(String token);

   String createToken(Object obj);
}
