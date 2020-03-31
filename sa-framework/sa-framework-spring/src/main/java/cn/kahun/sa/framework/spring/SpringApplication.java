package cn.kahun.sa.framework.spring;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author kahun
 */
@Log4j2
@SpringBootApplication
public class SpringApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(SpringApplication.class)
        .web(WebApplicationType.SERVLET)
        .bannerMode(Mode.OFF)
        .listeners(log::debug)
        .run(args);

  }

}
