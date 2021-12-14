package com.wgy.aup.common.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.sun.prism.impl.BaseContext;
import com.wgy.aup.common.annotation.CheckUserToken;
import com.wgy.aup.common.annotation.UserTokenIgnore;
import com.wgy.aup.common.core.BaseContextHandler;
import com.wgy.aup.common.core.context.Constants;
import com.wgy.aup.common.utils.JwtTokenUtils;
import com.wgy.aup.exception.BasicServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * description token拦截
 * author wgy
 * version 2021/8/13 02:31:44
 */
@Component
@Slf4j
public class AuthTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String token = request.getHeader(Constants.KEY_TOKEN_HEADER);
        //若不是映射到方法，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //不需要验证token
        if (method.isAnnotationPresent(UserTokenIgnore.class)) {
            UserTokenIgnore userTokenIgnore = method.getAnnotation(UserTokenIgnore.class);
            if (userTokenIgnore.required()) {
                //UserTokenIgnore注解注释，直接通过
                return true;
            }
        }
        //检查是否有token认证注解
        if (method.isAnnotationPresent(CheckUserToken.class)) {
            CheckUserToken checkUserToken = method.getAnnotation(CheckUserToken.class);
            if (checkUserToken.required()) {
                if (token == null) {
                    throw new RuntimeException("token不能为空");
                }
                //验证token是否正确
                boolean flag = JwtTokenUtils.verifyToken(token);
                if (!flag) {
                    throw new BasicServiceException("token是非法的");
                }
                Map<String, Claim> map = JwtTokenUtils.parseToken(token);
                String account = map.get(Constants.KEY_CURRENT_CODE).asString();
                if (redisTemplate.hasKey(account)) {
                    long expire = redisTemplate.getExpire(account);
                    if (expire < 5 * 60 * 1000) {
                        //过期剩余时间小于5分钟,刷新token
                        token = JwtTokenUtils.refresh(token);
                        redisTemplate.opsForValue().set(account,token,30, TimeUnit.MINUTES);
                    }
                }
                response.setHeader("authorization", Constants.KEY_TOKEN_PREFIX + token);
                BaseContextHandler.setToken(token);
                BaseContextHandler.setCurrentCode(account);
                BaseContextHandler.setCurrentName(map.get(Constants.KEY_CURRENT_NAME).asString());
                BaseContextHandler.setCurrentNumber(map.get(Constants.KEY_CURRENT_NUMBER).asString());
                return true;
            } else {
                throw new BasicServiceException("token is not valid");
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
    }
}
