package com.chanx.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean：3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        // 添加shiro内置过滤器
        // anno：无需认证即可访问
        // authc：认证才能访问
        // user：必须拥有记住我功能才能用
        // perms：拥有对某个资源的权限才能访问
        // roles：拥有个角色权限才能访问
        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add", "authc");
//        filterMap.put("/user/update", "authc");

        // 授权，正常情况下没有授权会跳转到授权页面
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");

        // 拦截
        filterMap.put("/user/**", "authc");

        bean.setFilterChainDefinitionMap(filterMap);

        // 设置登录请求
        bean.setLoginUrl("/toLogin");
        // 设置未授权页面
        bean.setUnauthorizedUrl("/noauth");

        return bean;
    }

    // DefaultWebSecurityManager：2
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联Realm对象
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // 创建Realm，需要自定义：1
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    // 整合ShiroDialect：方言 yonglaizhenghe shiro-thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
