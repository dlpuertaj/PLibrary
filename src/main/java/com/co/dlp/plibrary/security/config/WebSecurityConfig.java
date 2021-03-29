package com.co.dlp.plibrary.security.config;

import com.co.dlp.plibrary.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private Environment environment;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String enabled = environment.getProperty("spring.mail.active");
        System.out.println("Email verification enabled: " + enabled);
        http
                .csrf().disable();

        if(enabled.equalsIgnoreCase("S")){
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/api/v*/registration/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated().and()
                    .formLogin();
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String enabled = environment.getProperty("spring.mail.active");
        if(enabled.equalsIgnoreCase("S")){
            auth.authenticationProvider(authenticationProvider());
        }
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
    }
}
