package cn.kahun.dt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author libo
 * @date 2020/2/22 22:35
 * @description 记得写注释
 */
//@EnableWebSecurity SpringBoot 不需要重新标注
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

  @Bean
  public UserDetailsService userDetailsService(){

    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("ADMIN").build());

    return manager;
  }
}
