package com.example.HomeService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.HomeService.Repo.UserSeRepo;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    //     http.csrf(Customizer->Customizer.disable());
    //     http.authorizeHttpRequests(request->request.anyRequest().authenticated());
    //     http.formLogin(Customizer.withDefaults());
    //     return http.build();
    // }
    // @Bean
    // public DaoAuthenticationProvider daoAuthenticationProvider(){
    //     DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    //     daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    //     daoAuthenticationProvider.setUserDetailsService(null);
    //     return daoAuthenticationProvider;
    // }
// security/SecurityConfig.java
@Bean
public UserDetailsService userDetailsService(UserSeRepo repo) {
    return new CustomUserDetailsService();
}

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers( "/login").permitAll()
        .requestMatchers("/**").hasRole("ADMIN") // needs ROLE_ADMIN
        .anyRequest().authenticated()
        .and()
        .formLogin().defaultSuccessUrl("/**", true)
        .and()
        .logout().logoutSuccessUrl("/login");
    return http.build();
}


}
