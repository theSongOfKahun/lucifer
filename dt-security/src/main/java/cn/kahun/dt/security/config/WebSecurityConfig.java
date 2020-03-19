package cn.kahun.dt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author libo
 * @date 2020/2/22 22:35
 * @description 记得写注释
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests(
        authorizeRequestsCustomizer ->
            authorizeRequestsCustomizer
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER"))
        .formLogin(
            httpSecurityFormLoginConfigurer ->
                httpSecurityFormLoginConfigurer
                    .loginPage("/login")
                    .failureUrl("/login-error"));
  }

  @Bean
  @Override
  public UserDetailsService userDetailsService() {

    UserDetails userDetails = User.withDefaultPasswordEncoder()
        .username("user")
        .password("password")
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(userDetails);
  }
}
