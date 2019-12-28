package cn.kahun.dt.cache.local;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @create: 2019/12/18 11:00 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@SpringBootApplication
public class LocalCacheApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(LocalCacheApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }

}
