package cn.kahun.sa.framewok.spring.test.beans;

import cn.kahun.sa.framework.spring.bean.TestBean;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * @create: 2020/1/16 6:58 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class BeanWrapperTest {



  @Test
  public void testGetPropertyType(){

    TestBean testBean = new TestBean();

    testBean.setName("kahunsha");
    testBean.setGroupList(Arrays.asList("1","2","3"));

    BeanWrapper beanWrapper = new BeanWrapperImpl(testBean);

    Class<?> fieldClass = beanWrapper.getPropertyType("name");

    assert fieldClass != null;
    System.out.println(fieldClass.getSimpleName());

    System.out.println();

    Object object = beanWrapper.getPropertyValue("name");

    System.out.println(object);

  }

  @Test
  public void test() throws IOException {

    String filepath = "/users/prague/Downloads/tianchuang.txt";
    byte[] content = Files.readAllBytes(Paths.get(filepath));

    Base64.getDecoder().decode(content);

  }

}
