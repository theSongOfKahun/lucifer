package cn.kahun.bt.base.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @create: 2019/12/24 12:46 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Slf4j
@RestController
public class TestController {

  @Resource(name = "restTemplate")
  private RestTemplate restTemplate;

  @GetMapping(value = "/test2")
  @HystrixCommand(fallbackMethod = "fallbackRequest",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
      @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout",value = "true"),
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "100"),
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "30000")
  })
  public void test2(long ts){

    pretendToRequest(ts);

  }

  public void pretendToRequest(long ts){

    long timestamp = System.currentTimeMillis();
    log.info("invoke common method");

    restTemplate.getForEntity("http://localhost:8081/test?ts="+ts,String.class);

    log.info("调用测试接口，耗时为：{}",(System.currentTimeMillis() - timestamp));

  }

  public void fallbackRequest(long ts){

    long timestamp = System.currentTimeMillis();
    log.info("invoke fallback method");

//    restTemplate.getForEntity("http://localhost:8080/test?ts="+ts,String.class);

    log.info("调用容错请求，耗时为：{}",(System.currentTimeMillis() - timestamp));

  }
}
