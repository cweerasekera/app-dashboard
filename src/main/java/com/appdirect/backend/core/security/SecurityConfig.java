package com.appdirect.backend.core.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by cweerasekera
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private AuthSuccess authSuccess;

    @Autowired
    private AuthFailure authFailure;

    @Autowired
    private EntryPointUnauthorizedHandler unauthorizedHandler;

   /* @Autowired
    private OpenIdUserDetailsService openIdUserDetailsService;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception {
        LOG.trace("ENTER configAuthBuilder()");
        builder.userDetailsService(openIdUserDetailsService);
        LOG.trace("EXIT configAuthBuilder()");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOG.trace("ENTER configure()");
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/resources/**")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint(unauthorizedHandler)
                    .and()
                .openidLogin()
                .successHandler(authSuccess)
                    .failureHandler(authFailure)
                    .loginPage("/login")
                    .permitAll()
                    .authenticationUserDetailsService(new CustomUserDetailsService())
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
        LOG.trace("EXIT configure()");
    }
}
