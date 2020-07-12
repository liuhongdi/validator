package com.validator.demo.config;


import com.validator.demo.interceptor.ValidatorInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @desc: mvc config
 * @author: liuhongdi
 * @date: 2020-07-01 11:40
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class DefaultMvcConfig implements WebMvcConfigurer {

    @Resource
    private ValidatorInterceptor validatorInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/home/home");
    }

    /**
     * 添加Interceptor
     * 检验参数不能全部覆盖，因为可能有供第三方访问的接口地址，例如支付的回调接口
     * 所以需要把不用的排除掉
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(validatorInterceptor)
                .addPathPatterns("/**")                    //所有请求都需要进行报文签名sign
                .excludePathPatterns("/home/age**","/home/home**","/home/user**","/js/**","/");   //排除age/home...url
    }

}
