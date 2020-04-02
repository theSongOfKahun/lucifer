package cn.kahun.sa.framework.spring.test.test;

import cn.kahun.sa.framework.spring.SpringApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

/**
 * @create: 2020/4/2 2:58 下午
 * @author: liboah
 * @description: junit 5
 **/
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class SpringTest {

  @Autowired
  private BeanFactory beanFactory;

  @Test
  public void test(){

    System.out.println(beanFactory);
  }



}
