package com.chanx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全面扩展SpringMVC(官方建议)
 * 以下配置可以自定义mvc功能，把以下组件交给springboot即可。
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 添加自定义视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        // 首页重定向
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    // 自定义国际化组件生效
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    // 添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加并配置连接器
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/css/*", "/img/*", "/js/*");
    }
}
