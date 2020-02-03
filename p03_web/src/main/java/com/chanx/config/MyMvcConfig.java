package com.chanx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 全面扩展SpringMVC(官方建议)
 * 以下配置可以自定义mvc功能，把以下组件交给springboot即可。
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 自定义视图跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/aaa").setViewName("test");
    }

    //    @Bean
//    public ViewResolver myViewResolver() {
//        return new MyViewResolver();
//    }
//
//    // 自定义了一个视图解析器
//    public static class MyViewResolver implements ViewResolver {
//
//        @Override
//        public View resolveViewName(String viewName, Locale locale) throws Exception {
//            return null;
//        }
//    }
}
