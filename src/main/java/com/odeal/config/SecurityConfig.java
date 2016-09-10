package com.odeal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by hikuley on 09/09/16.
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    *
    *  REST service with Basic authentication and HTTPS encryption.
    *
    * */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and().
                withUser("user1").password("secret1").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().fullyAuthenticated();
        http.httpBasic();
        http.csrf().disable();

        // All other request need to be authenticated or user cutom method @AuthenticationPrincipal final UserDetails user
        http.anonymous().and().authorizeRequests().anyRequest().authenticated().and();

    }
}
