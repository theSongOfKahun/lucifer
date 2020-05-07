package cn.kahun.common.invoke;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/30 3:30 下午
 * @author: liboah
 * @description: 记得写注释。。。
 * @see java.lang.invoke.MethodHandles
 **/
@Slf4j
public class MethodHandlesTest {

  private static final Constructor<Lookup> lookupConstructor;
  private static final Method privateLookupInMethod;

  static{

    Method privateLookupIn;

    try {
      privateLookupIn = MethodHandles.class.getMethod("privateLookupIn",Class.class,MethodHandles.Lookup.class);
    } catch (NoSuchMethodException e) {
      privateLookupIn = null;
      log.error("",e);
    }

    privateLookupInMethod = privateLookupIn;

    Constructor<Lookup> lookup = null;

    if (privateLookupInMethod == null){

      try {
        lookup = Lookup.class.getDeclaredConstructor(Class.class,int.class);
        lookup.setAccessible(true);
      } catch (NoSuchMethodException e) {
        log.error("",e);
        lookup = null;
      }

    }

    lookupConstructor = lookup;
  }

  @Test
  public void test(){

    System.out.println(lookupConstructor);
  }

}
