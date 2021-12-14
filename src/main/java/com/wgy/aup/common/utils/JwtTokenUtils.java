package com.wgy.aup.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.wgy.aup.common.core.context.Constants.*;


/**
 * @author wgy
 * @version 2021/8/13 03:10:14
 */
@Slf4j
public class JwtTokenUtils {


    private static final long EXPIRE_TIME = 30 * 60 * 1000;//token到期时间15小时
    private static final String TOKEN_SECRET = "ADjoKeFire4GarDF237887jASDhjO53";  //密钥盐

    /**
     * 生成token
     *
     * @param code   编码
     * @param name   姓名
     * @param number 工号/学号
     * @return
     */
    public static String createToken(String code, String name, String number) {
        Date expire_time = DateUtils.getAddParamTime(EXPIRE_TIME);
        Map<String, Object> header = new HashMap<>();
        header.put("HMAC256", "JWT");
        String token = "";
        try {
            JWTCreator.Builder builder = JWT.create();
            builder.withHeader(header);
            builder.withIssuedAt(DateUtils.getNowTime());  //开始时间
            builder.withExpiresAt(expire_time);   //过期时间
            builder.withClaim(KEY_CURRENT_CODE, code);
            builder.withClaim(KEY_CURRENT_NAME, name);
            builder.withClaim(KEY_CURRENT_NUMBER, number);//当前时间
            token = builder.sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            log.info("token.error.message：{}", e.getMessage());
            throw new RuntimeException("Token generation failure");
        }
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> parseToken(String token) {
        Map<String, Claim> claim;
        try {
            if (token.contains(KEY_TOKEN_PREFIX)) {
                token = token.substring(7);
            }
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            claim = jwt.getClaims();
        } catch (Exception e) {
            log.info("resolveToken.error.message: {}", e.getMessage());
            throw new RuntimeException("token resolution failed");
        }
        return claim;
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static boolean verifyToken(String token) {
        try {
            if (token.contains(KEY_TOKEN_PREFIX)) {
                token = token.substring(7);
            }
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt != null;
        } catch (Exception e) {
            throw new RuntimeException("verify token failed");
        }
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public static String refresh(String token) {
        try {
            //拿到token中的信息
            Map<String, Claim> map = parseToken(token);
            String code = map.get(KEY_CURRENT_CODE).asString();
            String name = map.get(KEY_CURRENT_NAME).asString();
            String number = map.get(KEY_CURRENT_NUMBER).asString();
            return createToken(code, name, number);
        }catch (Exception e){
            log.info("token刷新失败");
            throw new RuntimeException("token don't refresh");
        }
    }
}
