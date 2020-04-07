package cn.kahun.sa.framework.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/7 3:36 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class Junit5Test {

  @Test
  public void test(){

    System.out.println("the first junit jupiter test");

    Assertions.assertEquals(1,1);


  }

}
