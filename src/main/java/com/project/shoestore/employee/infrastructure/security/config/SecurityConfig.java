package com.project.shoestore.employee.infrastructure.security.config;

import com.project.shoestore.employee.infrastructure.dtos.RoleEnum;
import com.project.shoestore.employee.infrastructure.security.JwtTokenValidator;
import com.project.shoestore.employee.infrastructure.security.JwtUtils;
import com.project.shoestore.employee.infrastructure.security.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtUtils jwtUtils) throws Exception {
    return httpSecurity
      .csrf(AbstractHttpConfigurer::disable)
      .httpBasic(Customizer.withDefaults())
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(http -> {
        http.requestMatchers(HttpMethod.GET, "/employee/**").hasAnyRole(RoleEnum.ADMIN.name(), RoleEnum.MANAGER.name());
        http.requestMatchers(HttpMethod.POST, "/employee/**").hasAnyRole(RoleEnum.ADMIN.name(), RoleEnum.MANAGER.name());
        http.requestMatchers(HttpMethod.PUT, "/employee/**").hasAnyRole(RoleEnum.ADMIN.name(), RoleEnum.MANAGER.name());
        http.requestMatchers(HttpMethod.DELETE, "/employee/**").hasRole(RoleEnum.ADMIN.name());
        http.requestMatchers("/category/**").anonymous();
        http.requestMatchers("/brand/**").anonymous();
        http.requestMatchers("/size/**").anonymous();
        http.requestMatchers("/product/**").anonymous();
        http.requestMatchers("/auth/login").anonymous();
        http.requestMatchers("/provider/**").anonymous();
        http.requestMatchers("/client/**").anonymous();
      })
      .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
      .cors(Customizer.withDefaults())
      .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailService);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.addAllowedOrigin("http://localhost:4200");
    corsConfig.addAllowedMethod("*");
    corsConfig.addAllowedHeader("*");
    corsConfig.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
  }
}
