package cn.kahun.dt.cache.reids;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @create: 2019/12/12 10:51 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@SpringBootApplication
public class RedisApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(RedisApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);
  }
}
