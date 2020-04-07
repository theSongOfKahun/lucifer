package cn.kahun.sa.framework.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/7 4:17 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Tag("taggingTest")
public class TaggingTest {

  @Test
  @Tag("taggingTestOne")
  public void taggingTestOne(){

  }

}
