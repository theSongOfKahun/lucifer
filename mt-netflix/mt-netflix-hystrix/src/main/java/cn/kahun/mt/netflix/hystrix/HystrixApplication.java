package cn.kahun.mt.netflix.hystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @create: 2019/12/12 3:05 下午
 * @author: liboah
 * @description:
 **/


@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixApplication {

  public static void main(String[] args) {

    new SpringApplicationBuilder(HystrixApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
