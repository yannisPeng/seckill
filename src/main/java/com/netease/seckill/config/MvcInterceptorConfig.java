/**
 * @(#)MvcInterceptorConfig.java, 2019/8/15.
 * <p/>
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.netease.seckill.interceptor.MyInterceptor;

/**
 * @author 彭羽(pengyu @ .corp.netease.com)
 */
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MyInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
