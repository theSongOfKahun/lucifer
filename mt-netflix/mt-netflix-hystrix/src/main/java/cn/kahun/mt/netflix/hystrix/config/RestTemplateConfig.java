package cn.kahun.mt.netflix.hystrix.config;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @create: 2019/12/3 12:29 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Configuration
public class RestTemplateConfig {

  @Bean(name = "commonRestTemplate")
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

    return restTemplateBuilder
        .setConnectTimeout(Duration.ofSeconds(3))
        .setReadTimeout(Duration.ofSeconds(10))
        .build();
  }

  @Bean(name = "timeoutRestTemplate")
  public RestTemplate timeoutRestTemplate(RestTemplateBuilder restTemplateBuilder) {

    return restTemplateBuilder
        .setConnectTimeout(Duration.ofSeconds(3))
        .setReadTimeout(Duration.ofSeconds(15))
        .build();
  }
}
