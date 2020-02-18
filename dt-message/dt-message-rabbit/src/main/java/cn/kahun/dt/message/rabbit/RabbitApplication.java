package cn.kahun.dt.message.rabbit;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author libo
 * @date 2020/2/10 9:54
 * @description 记得写注释
 */
@SpringBootApplication
public class RabbitApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(RabbitApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
