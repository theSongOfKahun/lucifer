package cn.kahun.common.reflect;

import cn.kahun.common.reflect.subject.RealSubjectImpl;
import cn.kahun.common.reflect.subject.Subject;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/30 3:45 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class InvocationHandlerTest {

  @Test
  public void test(){

    Subject subject = (Subject) Proxy.newProxyInstance(this.getClass().getClassLoader(),
        new Class[]{Subject.class},new MyInvocationHandler(new RealSubjectImpl()));

    subject.print();
  }

}
