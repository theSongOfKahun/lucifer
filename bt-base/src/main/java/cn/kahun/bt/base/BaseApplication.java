package cn.kahun.bt.base;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @create: 2019/12/24 12:40 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@EnableCircuitBreaker
@SpringBootApplication
public class BaseApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(BaseApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }

}
