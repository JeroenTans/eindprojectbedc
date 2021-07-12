package com.example.eindprojectbedc.config;

import com.example.eindprojectbedc.Service.CustomUserDetailsService;
import com.example.eindprojectbedc.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/authenticate").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/v1/tips/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//                .antMatchers("http://localhost:3000/link").hasRole("ADMIN")
//                .antMatchers("/api/v1/tips/standardTip_upload").permitAll()
//                .antMatchers(HttpMethod.GET,"/api/v1/tips/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET,"/api/v1/users/**/authorities").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

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
