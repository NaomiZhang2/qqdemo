package com.social.qqdemo.config;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

public class QQSpringSocialConfigurer extends SpringSocialConfigurer {
    private String filterProcessesUrl;

    public QQSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
//        filter.setSignupUrl("/register");
        return (T) filter;
    }
}

