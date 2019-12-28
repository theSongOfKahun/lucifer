package cn.kahun.bt.base.config;

import java.time.Duration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @create: 2019/12/24 7:29 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Configuration
public class RestTemplateConfig {

  @Bean(name = "restTemplate")
  public RestTemplate restTemplate(){

    return new RestTemplateBuilder()
//        .requestFactory(SimpleClientHttpRequestFactory::new)
        .setConnectTimeout(Duration.ofSeconds(3))
        .setReadTimeout(Duration.ofSeconds(10))
        .build();
  }

  @Bean(name = "restTemplateForTest")
  public RestTemplate restTemplateForTest(){

    return new RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(3))
        .setReadTimeout(Duration.ofSeconds(15))
        .build();
  }

}
