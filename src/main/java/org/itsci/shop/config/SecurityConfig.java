package org.itsci.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public
class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(configurer -> {
            //configurer.anyRequest().authenticated();
            configurer.antMatchers("/shop/**").hasRole("ADMIN");
        });
        http.exceptionHandling(configurer -> {configurer.accessDeniedPage("/access-denied");
        });
        http.formLogin(configurer -> {
            try {
                configurer.loginPage("/login").loginProcessingUrl("/authenticate").permitAll().and().logout().permitAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return http.build();
    }
}
