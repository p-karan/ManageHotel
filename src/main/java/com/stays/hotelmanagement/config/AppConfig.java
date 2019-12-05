package com.stays.hotelmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*noop - To indicate its not encrypted */
        auth.inMemoryAuthentication().withUser("india").password("{noop}india").roles("USERS");
    }

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/cibilScore/**").authenticated()
                .and().formLogin().and().logout().logoutSuccessUrl("/cibilScore").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and().csrf().disable();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/booking/**").authenticated()
                .and().httpBasic().and().csrf().disable();
    }
}
