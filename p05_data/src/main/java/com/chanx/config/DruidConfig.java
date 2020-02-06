package com.chanx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    /**
     * 将数据源与application.yml绑定
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 相当于web.xml
     * 由于springboot内置了Servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 后台需要有人登陆，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();

        //添加配置
        initParameters.put("loginUsername","admin"); // 登陆的key为固定的
        initParameters.put("loginPassword","123456");
        // 允许谁能访问
        initParameters.put("allow", "");
        // 禁止谁能访问
//        initParameters.put("chanx", "192.168.1.1");

        bean.setInitParameters(initParameters); //设置初始化参数

        return bean;
    }

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        // 设置过滤器
        bean.setFilter(new WebStatFilter());
        // 可以过滤哪些请求
        HashMap<String, String> initParameters = new HashMap<>();
        // 这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/**");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
