package com.kucw.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

  @Bean
  public InMemoryUserDetailsManager userDetailsManager() {
    UserDetails user1 = User.withUsername("A").password("{noop}aaa").roles("ADMIN", "USER").build();
    UserDetails user2 = User.withUsername("B").password("{noop}bbb").roles("USER").build();

    return new InMemoryUserDetailsManager(user1, user2);

  }

}
