package cn.kahun.dt.cache.reids.aspect;

import cn.kahun.dt.cache.reids.annotation.AdmissionControl;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;

/**
 * @create: 2020/1/15 2:56 下午
 * @author: liboah
 * @description: 许可控制切面
 *
 * 多种情况执行顺序
 *
 * =======@around before==========
 * ========@before=========
 * =======@around after=============
 * ========@after==========
 * ========@after returning==========
 *
 * 业务逻辑异常之后
 *
 * =======@around before==========
 * ========@before=========
 * ========@after==========
 *
 **/
@Slf4j
@Aspect
@Component
public class AdmissionControlAspect {

  @Resource
  private RedisTemplate<String,String> redisTemplate;
  private static final String REMAINING_NUM_PREFIX = "admissionControl:%s:remaining";

  @Pointcut("@annotation(admissionControl)")
  public void executeAdmissionControl(AdmissionControl admissionControl){

  }

  @Before(value = "executeAdmissionControl(admissionControl)", argNames = "admissionControl")
  public void admissionControlBefore(AdmissionControl admissionControl){

    System.out.println("========@before=========");

  }

  @Around(value = "executeAdmissionControl(admissionControl)", argNames = "proceedingJoinPoint,admissionControl")
  public Object deductConsumption(ProceedingJoinPoint proceedingJoinPoint,AdmissionControl admissionControl)
      throws Throwable {

    System.out.println("=======@around before==========");

    Object[] args = proceedingJoinPoint.getArgs();
    Object returnValue = proceedingJoinPoint.proceed(args);

    System.out.println("=======@around after=============");

    return returnValue;
  }

  @After(value = "executeAdmissionControl(admissionControl)",argNames = "admissionControl")
  public void admissionControlAfter(AdmissionControl admissionControl){

    System.out.println("========@after==========");

  }

  @AfterReturning(value = "executeAdmissionControl(admissionControl)",argNames = "admissionControl")
  public void admissionControlAfterReturning(AdmissionControl admissionControl){

    System.out.println("========@after returning==========");

  }

}
