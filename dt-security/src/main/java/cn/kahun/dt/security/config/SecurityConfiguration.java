package cn.kahun.dt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author kahun
 */
@Configuration
public class SecurityConfiguration {

//  @Bean
//  public UserDetailsService userDetailsService(){
//
//    UserDetails userDetails = User.withUsername("username").password("{noop}password").roles("USER").build();
//
//    return new InMemoryUserDetailsManager(userDetails);
//
//  }

}
