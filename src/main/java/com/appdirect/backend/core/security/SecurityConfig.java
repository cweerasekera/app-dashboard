package com.appdirect.backend.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by cweerasekera
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthSuccess authSuccess;

    @Autowired
    private AuthFailure authFailure;

    @Autowired
    private EntryPointUnauthorizedHandler unauthorizedHandler;

    @Autowired
    private OpenIdUserDetailsService openIdUserDetailsService;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(openIdUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .formLogin()
                    .successHandler(authSuccess)
                    .failureHandler(authFailure)
                .and()
                .authorizeRequests()
                    .antMatchers("*//**")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                .openidLogin()
                    .loginPage("/login.html")
                    .permitAll()
                    .attributeExchange("https://www.google.com/.*")
                        .attribute("email")
                            .type("http://axschema.org/contact/email")
                            .required(true)
                            .and()
                        .attribute("firstname")
                            .type("http://axschema.org/namePerson/first")
                            .required(true)
                            .and()
                        .attribute("lastname")
                            .type("http://axschema.org/namePerson/last")
                            .required(true)
                            .and()
                        .and()
                    .attributeExchange(".*yahoo.com.*")
                        .attribute("email")
                            .type("http://axschema.org/contact/email")
                            .required(true)
                            .and()
                        .attribute("fullname")
                            .type("http://axschema.org/namePerson")
                            .required(true)
                            .and()
                        .and()
                    .attributeExchange(".*myopenid.com.*")
                        .attribute("email")
                            .type("http://schema.openid.net/contact/email")
                            .required(true)
                            .and()
                        .attribute("fullname")
                            .type("http://schema.openid.net/namePerson")
                            .required(true);
    }
}
