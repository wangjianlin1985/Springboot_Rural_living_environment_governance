package com.lhz.config.interceptor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
@EnableCaching
public class Application implements WebMvcConfigurer {
	@Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration ir=registry.addInterceptor(new MyInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns(
        		"/TLogin/login",
        		"/TUser/insertTUser",
        		"/kaptcha/verification",
        		"/TLogin/index",
        		"/js/**",
        		"/html/**",
        		"/images/**",
        		"/img/**",
        		"/css/**",
        		"/plugins/**"
        	
        );
    }


}
