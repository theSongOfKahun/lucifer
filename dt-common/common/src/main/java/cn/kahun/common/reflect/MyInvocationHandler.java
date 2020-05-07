package cn.kahun.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @create: 2020/4/30 3:36 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class MyInvocationHandler implements InvocationHandler {

  private Object subject;

  public MyInvocationHandler(Object subject) {
    this.subject = subject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    System.out.println("print something before");

    Object returnVal = method.invoke(subject,args);

    System.out.println("print something after");

    return returnVal;
  }
}
