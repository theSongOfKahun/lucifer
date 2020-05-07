package cn.kahun.common.reflect;

import cn.kahun.common.reflect.subject.RealSubjectImpl;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/30 4:02 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class MethodTest {

  Class<?> clazz = RealSubjectImpl.class;

  @Test
  public void test() throws NoSuchMethodException {


    Method method = clazz.getMethod("print");

    Method[] methods = clazz.getMethods();

    Method method1 = clazz.getDeclaredMethod("print");

    Method[] methods1 = clazz.getDeclaredMethods();

    clazz.getEnclosingClass();

  }

  @Test
  public void testGetDeclareClass() throws NoSuchMethodException {

    Method print = clazz.getMethod("print");

    System.out.println(print.getDeclaringClass().getSimpleName());
  }

  @Test
  public void testGetDefault() throws NoSuchMethodException{

    Method method = clazz.getMethod("print");

    System.out.println(method.isDefault());
  }

}
