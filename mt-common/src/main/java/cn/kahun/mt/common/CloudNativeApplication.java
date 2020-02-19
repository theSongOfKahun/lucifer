package cn.kahun.mt.common;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author libo
 * @date 2020/2/18 22:41
 * @description Cloud Native is a style of application development that encourages easy adoption of
 * best practices in the areas of continuous delivery and value-driven development.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudNativeApplication {

  public static void main(String[] args) {



    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
    annotationConfigApplicationContext.setId("application-context-2");
    annotationConfigApplicationContext.refresh();

    new SpringApplicationBuilder(CloudNativeApplication.class)
        .web(WebApplicationType.SERVLET)
        .parent(annotationConfigApplicationContext)
        .run(args);



  }
}
