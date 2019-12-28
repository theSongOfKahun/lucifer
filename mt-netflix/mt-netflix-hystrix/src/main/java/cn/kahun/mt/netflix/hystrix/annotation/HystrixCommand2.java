package cn.kahun.mt.netflix.hystrix.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @create: 2019-08-24 15:19
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface HystrixCommand2 {

  String fallbackMethod() default "";

  int timeoutInSeconds() default 30;

}
