package com.hui.springbootproj.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/11 18:47
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器
     * @param registry .
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }
}