package cn.kahun.sa.framework.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/7 4:14 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Disabled(value = "Disabled until bug #42 has been resolved")
public class DisableTest {

  @Test
  public void test(){

  }


  @Test
  @Disabled(value = "Disabled until bug #99 has been fixed")
  public void test2(){


  }

}
