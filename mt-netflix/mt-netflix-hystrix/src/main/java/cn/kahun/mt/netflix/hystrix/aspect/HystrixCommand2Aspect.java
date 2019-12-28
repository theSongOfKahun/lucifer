package cn.kahun.mt.netflix.hystrix.aspect;

import cn.kahun.mt.netflix.hystrix.annotation.HystrixCommand2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @create: 2019-08-24 15:23
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Aspect
@Component
public class HystrixCommand2Aspect {

  private ExecutorService executorService = Executors.newFixedThreadPool(8);

  @Around("execution(* *.*(..)) && @annotation(hystrixCommand2))")
  public Object breaker(ProceedingJoinPoint proceedingJoinPoint,
      HystrixCommand2 hystrixCommand2)
      throws InterruptedException, ExecutionException, TimeoutException {

    Object returnValue;

    Object[] args = proceedingJoinPoint.getArgs();

    int timeoutSecond = hystrixCommand2.timeoutInSeconds();

    Future<?> future = executorService.submit(() -> {
      try {
        return proceedingJoinPoint.proceed(args);
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      }
      return null;
    });

    try {
      returnValue = future.get(timeoutSecond, TimeUnit.SECONDS);

      System.out.println("returnValue == "+returnValue);

    } catch (InterruptedException | ExecutionException | TimeoutException e) {

      future.cancel(Boolean.TRUE);

      //调用超时，返回容错结果
      if (e instanceof TimeoutException){

        String fallbackMethodName = hystrixCommand2.fallbackMethod();

        Object target = proceedingJoinPoint.getTarget();


        Class<?>[] argsTypeArray = new Class[args.length];

        for (int i = 0; i < args.length; i++) {

          argsTypeArray[i] = args[i].getClass();
        }

        Method fallbackMethod = null;

        try {
          fallbackMethod = target.getClass().getMethod(fallbackMethodName,argsTypeArray);
        } catch (NoSuchMethodException ex) {
          ex.printStackTrace();
        }

        try {
          assert fallbackMethod != null;
          return fallbackMethod.invoke(target,args);
        } catch (IllegalAccessException | InvocationTargetException ex) {
          ex.printStackTrace();
        }

      }

      throw e;
    }

    return returnValue;

  }

}
