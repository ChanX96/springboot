package com.chanx.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * aop：有点类似拦截器
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，功能页只有对应有权限的人可以访问
        // 请求授权的规则
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认到登录页，需要开启登陆页面，定制登录页
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password");

        // 关闭防止网站攻击
        http.csrf().disable();

        // 开启注销功能
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能，cookie，默认保存两周
        // 自定义接受前端的参数
        http.rememberMe().rememberMeParameter("rememberMe");
    }

    /**
     * 认证：AuthenticationManagerBuilder
     * 密码编码：PasswordEncoder
     * 在Spring Security 5.0+中新增了很多加密方法，不能直接使用明文密码
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // 也可以从数据库中读取
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("chanx").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
