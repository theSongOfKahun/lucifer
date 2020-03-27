package cn.kahun.sa.framework.spring;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author kahun
 */
@SpringBootApplication
public class SpringApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(SpringApplication.class)
        .web(WebApplicationType.SERVLET)
        .bannerMode(Mode.OFF)
        .logStartupInfo(false)
        .listeners(event -> {
          System.out.println("****************");
          System.out.println(event);
          System.out.println();
        })
        .run(args);

  }

}
