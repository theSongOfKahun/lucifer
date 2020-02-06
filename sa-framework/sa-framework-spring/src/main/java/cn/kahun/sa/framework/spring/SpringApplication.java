package cn.kahun.sa.framework.spring;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author kahun
 */
@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(SpringApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

    }

}
