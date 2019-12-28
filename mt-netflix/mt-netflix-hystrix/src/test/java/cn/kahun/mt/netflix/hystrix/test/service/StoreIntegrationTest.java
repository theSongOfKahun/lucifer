package cn.kahun.mt.netflix.hystrix.test.service;

import cn.kahun.mt.netflix.hystrix.service.StoreIntegration;
import cn.kahun.mt.netflix.hystrix.test.BaseTest;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * @create: 2019-08-20 14:41
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class StoreIntegrationTest extends BaseTest {

  @Resource
  private StoreIntegration storeIntegration;

  @Test
  public void testTimeout(){


    for (int i = 0; i < 6; i++) {

      System.out.println("*****************");

      String result = storeIntegration.getStores();

      System.out.println(result);

    }

  }

  @Test
  public void testTimeout2(){

    for (int i = 0; i < 6; i++) {

      System.out.println("*****************");

      String result = storeIntegration.getSpecifyStores();

      System.out.println(result);

    }
  }

}
