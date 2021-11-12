package com.koi.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(user.username("koi").password("password").roles("EMPLOYEE", "ADMIN"));
        auth.inMemoryAuthentication().withUser(user.username("an").password("password").roles("EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // Any request must be authenticated (must be logged in)
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/customer/**").hasRole("EMPLOYEE")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin()
                // URL for custome login page
                // Must use field name "username" and "password"
                .loginPage("/showLoginPage")
                // Spring Security provides by default (no code require)
                .loginProcessingUrl("/authenticateUser")
                // Allow everyone to see login page
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
