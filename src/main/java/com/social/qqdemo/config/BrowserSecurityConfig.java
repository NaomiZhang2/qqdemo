package com.social.qqdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringSocialConfigurer qqSocialSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //apply的作用就是往当前的过滤链上加过滤器,过滤器会拦截某些特定的请求,收到请求后引导用户去做社交登录
                .apply(qqSocialSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/index", "/login", "/403", "/css/**", "/js/**", "/fonts/**").permitAll() // 不设限制，都允许访问
                .anyRequest()
                .authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }


}
