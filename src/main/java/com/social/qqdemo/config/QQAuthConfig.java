package com.social.qqdemo.config;

import com.social.qqdemo.connect.QQConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.autoconfigure.SocialAutoConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
public class QQAuthConfig extends SocialAutoConfigurerAdapter {

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory("qq", "101448999", "1d958787a87559bad371c0a9e26eef61");
    }

}
