package cn.kahun.dt.security;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author libo
 * @date 2020/2/22 22:33
 * @description 记得写注释
 */
@SpringBootApplication
public class SecurityApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(SecurityApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
