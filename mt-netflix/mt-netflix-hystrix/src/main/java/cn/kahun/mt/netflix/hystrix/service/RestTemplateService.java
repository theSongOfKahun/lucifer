package cn.kahun.mt.netflix.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.Random;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @create: 2019/12/6 10:44 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Slf4j
@Service
public class RestTemplateService {

  @Resource(name = "commonRestTemplate")
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "localOcr",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "200"),
      @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout",value = "true"),
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "80"),
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000")
  })
  public void fakeOcr(){

    int millis = new Random().nextInt(1000);

    log.info("param millis is :{} ms",millis);

    String url = "http://localhost:8080/test/timeout2?millis="+(millis);

    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);

    System.out.println(responseEntity.getBody());

  }

  public void localOcr(){

    System.out.println("timeout!!! local method is invoked");
  }

}
