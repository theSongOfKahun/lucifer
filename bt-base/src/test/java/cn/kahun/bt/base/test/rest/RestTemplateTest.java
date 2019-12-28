package cn.kahun.bt.base.test.rest;

import cn.kahun.bt.base.test.BaseTest;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

/**
 * @create: 2019/12/24 12:43 下午
 * @author: liboah
 * @description: 测试复现restTemplate超时时间失效
 **/
public class RestTemplateTest extends BaseTest {

  @Resource(name = "restTemplateForTest")
  private RestTemplate restTemplate;

  @Test
  public void testInit(){

    long ts = System.currentTimeMillis();

    RestTemplate restTemplate = new RestTemplate();

    System.out.println(System.currentTimeMillis() - ts);

  }

  @Test
  public void test2(){

    RestTemplate restTemplate = new RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(3))
        .setReadTimeout(Duration.ofSeconds(10))
        .build();

    restTemplate.getForEntity("http://localhost:8080/test2?ts=12000",String.class);

  }

  @Test
  public void test3(){

    restTemplate.getForEntity("http://localhost:8080/test2?ts=16000",String.class);

  }

  public static void main(String[] args) throws InterruptedException {

    int count = 20;

    CountDownLatch countDownLatch = new CountDownLatch(count);

    RestTemplate restTemplate = new RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(3))
        .setReadTimeout(Duration.ofSeconds(10))
        .build();

    for (int i = 0; i < count; i++) {

      new Thread(() -> get(restTemplate)).start();

      countDownLatch.countDown();

    }

    countDownLatch.await();

  }

  private static void get(RestTemplate restTemplate){

    restTemplate.getForEntity("http://localhost:8080/test2?ts=12000",String.class);

  }

}
