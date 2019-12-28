package cn.kahun.mt.netflix.hystrix.service;

import cn.kahun.mt.netflix.hystrix.annotation.HystrixCommand2;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @create: 2019-08-20 14:15
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Component
public class StoreIntegration {

  private static final Logger logger = LoggerFactory.getLogger(StoreIntegration.class);

  @HystrixCommand(fallbackMethod = "defaultStores",commandProperties = {
      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
  })
  public String getStores(){

    pretendToDoSomething();

    return "genericStores";
  }

  public String defaultStores(){

    return "defaultStores";
  }

  @HystrixCommand2(fallbackMethod = "defaultSpecifyStores",timeoutInSeconds = 6)
  public String getSpecifyStores(){

    pretendToDoSomething();

    return "getSpecifyStores";
  }

  public String defaultSpecifyStores(){

    return "defaultSpecifyStores";
  }

  private void pretendToDoSomething(){

    long ts = System.currentTimeMillis();
    long randomMilliSeconds = new Random().nextInt(12) * 1000;

    System.out.println("The Thread Will Sleep "+ randomMilliSeconds +"ms");

    try {
      Thread.sleep(randomMilliSeconds);
    } catch (InterruptedException e) {
      logger.error("thread interrupted ...");
    }

    System.out.println("The Thread Really Sleep "+(System.currentTimeMillis() - ts ) + "ms");
  }

}
