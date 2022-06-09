package com.jin.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String langyage = request.getParameter("1");

        Locale locale = Locale.getDefault();//默认的

        //如果请求的链接携带了国际化的参数
        if(!StringUtils.isEmpty(langyage)){
            String[] split = langyage.split("_");
            //国家地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
