package com.wgy.aup.common.interceptor;

import com.wgy.aup.common.annotation.CheckUserToken;
import com.wgy.aup.common.annotation.UserTokenIgnore;
import com.wgy.aup.common.core.BaseContextHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * description token拦截
 * author wgy
 * version 2021/8/13 02:31:44
 */
public class AuthTokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");
        //若不是映射到方法，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //不需要验证token
        if (method.isAnnotationPresent(UserTokenIgnore.class)){
            UserTokenIgnore userTokenIgnore = method.getAnnotation(UserTokenIgnore.class);
            if (userTokenIgnore.required()){
                //UserTokenIgnore注解注释，直接通过
                return true;
            }
        }
        //检查是否有token认证注解
        if (method.isAnnotationPresent(CheckUserToken.class)){
            CheckUserToken checkUserToken = method.getAnnotation(CheckUserToken.class);
            if (checkUserToken.required()){
                //执行认证
                if (token == null){
                    throw new RuntimeException("User token is null");
                }
                BaseContextHandler.setToken(token);
                //解析token

            }
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
