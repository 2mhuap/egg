package com.egg.biblioteca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.egg.biblioteca.enumeraciones.Rol;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SeguridadWeb {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
    .authorizeHttpRequests(authorize -> authorize
      .requestMatchers("/admin/**").hasRole(Rol.ADMIN.name())
      // .requestMatchers("/css/", "/js/", "/img/", "/**").permitAll()
      .requestMatchers("/css/**", "/js/**", "/img/**", "/**").permitAll()

    )
    .formLogin(form -> form
      .loginPage("/login")
      .loginProcessingUrl("/logincheck")
      .usernameParameter("email")
      .passwordParameter("password")
      .defaultSuccessUrl("/inicio", true)
      .permitAll()
    )
    .logout(logout -> logout
      .logoutUrl("/logout")
      .logoutSuccessUrl("/login")
      .permitAll()
    )
    .csrf(csrf -> csrf.disable());
    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  
}
