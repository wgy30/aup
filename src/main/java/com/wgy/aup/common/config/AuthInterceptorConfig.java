package com.wgy.aup.common.config;

import com.wgy.aup.common.interceptor.AuthTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * description token注册拦截器
 * author wgy
 * version 2021/8/13 02:43:55
 */
@Configuration
@EnableWebMvc
public class AuthInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public AuthTokenInterceptor getAuthTokenInterception(){
        return new AuthTokenInterceptor();
    }

    public List<String> excludePath(){
        List<String> list = new ArrayList<>();
        list.add("/login");
        list.add("/register");
        list.add("/static/**");
        return list;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有接口，除login外
        registry.addInterceptor(getAuthTokenInterception()).addPathPatterns("*/**").excludePathPatterns(excludePath());
    }
}
