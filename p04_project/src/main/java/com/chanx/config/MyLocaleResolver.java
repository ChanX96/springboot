package com.chanx.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 地区解析器：用于国际化配置
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 解析请求
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // 获取请求中的语言参数
        String language = request.getParameter("l");
        // 如果没有就是用默认的
        Locale locale = Locale.getDefault();
        // 如果传入的链接携带了国际化的参数
        if (!StringUtils.isEmpty(language)) {
            // 国家_地区
            String[] split = language.split("_");
            return new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
