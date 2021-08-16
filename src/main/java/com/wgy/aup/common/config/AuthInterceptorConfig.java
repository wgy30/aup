package com.wgy.aup.common.config;

import com.wgy.aup.common.interceptor.AuthTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
public class AuthInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AuthTokenInterceptor authTokenInterceptor;

    public List<String> excludePath() {
        List<String> list = new ArrayList<>();
        list.add("**/login");
        list.add("/register");
        list.add("/static/**");
        return list;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有接口，除login外
        registry.addInterceptor(authTokenInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                .allowedHeaders("*")
//                .allowCredentials(true)//是否允许证书 不再默认开启
                //设置允许的方法
                .allowedMethods("GET", "POST", "PUT", "DELETE");
//                .maxAge(3600);//跨域允许时间
    }
}
