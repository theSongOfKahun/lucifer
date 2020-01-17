package cn.kahun.common;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @create: 2020/1/9 4:13 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@SpringBootApplication
public class CommonApplicationForTest {

  public static void main(String[] args) {

    new SpringApplicationBuilder(CommonApplicationForTest.class)
        .web(WebApplicationType.NONE)
        .run(args);
  }

}
