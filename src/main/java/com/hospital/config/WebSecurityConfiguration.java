package com.hospital.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/doctor/*").permitAll()
                .antMatchers(HttpMethod.POST, "/pathology/*").permitAll()
                .antMatchers(HttpMethod.POST,"/patient/*").permitAll()
                .antMatchers(HttpMethod.POST,"/pharmacy/*").permitAll()
                .antMatchers(HttpMethod.PUT,"/doctor/*").permitAll()
                .antMatchers(HttpMethod.PUT, "/pathology/*").permitAll()
                .antMatchers(HttpMethod.PUT,"/patient/*").permitAll()
                .antMatchers(HttpMethod.PUT,"/pharmacy/*").permitAll()
                .antMatchers(HttpMethod.GET,"/doctor/*").permitAll()
                .antMatchers(HttpMethod.GET, "/pathology/*").permitAll()
                .antMatchers(HttpMethod.GET,"/patient/*").permitAll()
                .antMatchers(HttpMethod.GET,"/pharmacy/*").permitAll()
                .antMatchers(HttpMethod.DELETE,"/doctor/*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/pathology/*").permitAll()
                .antMatchers(HttpMethod.DELETE,"/patient/*").permitAll()
                .antMatchers(HttpMethod.DELETE,"/pharmacy/*").permitAll()
                .antMatchers("/adminHome")
                .hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
