package com.ddori.service.app.config.auth;

import com.ddori.service.app.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC = new String[] {
            "/","/login","/error","logout"};

    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    private final CustomOAuth2UserService customOAuth2UserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                    .antMatchers(PUBLIC).permitAll()
                    .antMatchers("/test2").permitAll()
                    .antMatchers("/api/users/**").hasRole(Role.USER.name())
                    .antMatchers("/hello").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
            .and()
                .logout()
                .deleteCookies("JSESSIONID", "SESSION")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .successHandler(loginSuccessHandler)
                    //.failureHandler()
                    //.loginPage("/oauth_login")
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);

    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "static/**", "/css/**", "/images/**", "/js/**","/favicon.ico");
    }
}
