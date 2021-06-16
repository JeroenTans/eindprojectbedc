package com.example.eindprojectbedc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Configuration
    public class WebConfig {

        @Autowired
        private CrosFilter corsFilter;

        @Bean
        public FilterRegistrationBean corsFilter() {
            FilterRegistrationBean registration = new FilterRegistrationBean();
            registration.setFilter(corsFilter);
            registration.addUrlPatterns("/*");
            registration.setName("corsFilter");
            registration.setOrder(1);
            return registration;
        }
    }

}
