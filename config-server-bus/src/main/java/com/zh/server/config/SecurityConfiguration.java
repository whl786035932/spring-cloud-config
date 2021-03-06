package com.zh.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName: com.zh.server.config.SecurityConfiguration
 * @Description: TODO
 * @Author wanghaili
 * @Date 2019/11/13 14:06
 **/
@Configuration
public class SecurityConfiguration   extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();  //关闭端点的安全校验
    }
}
