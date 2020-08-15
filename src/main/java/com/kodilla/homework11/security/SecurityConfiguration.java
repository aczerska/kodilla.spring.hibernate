package com.kodilla.homework11.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/homework/**")
                .hasAnyRole("R3", "R2", "R1")
                .mvcMatchers(HttpMethod.POST, "/homework/**")
                .hasAnyRole("R2", "R1")
                .mvcMatchers(HttpMethod.PUT, "/homework/**")
                .hasAnyRole("R1")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("requestor3").password("requestor3").roles("R3");
        auth.inMemoryAuthentication().withUser("requestor2").password("requestor2").roles("R2");
        auth.inMemoryAuthentication().withUser("requestor1").password("requestor1").roles("R1");
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
