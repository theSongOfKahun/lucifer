package cn.kahun.common.test.validator;

import cn.kahun.common.test.BaseTest;
import cn.kahun.common.test.entity.AirVo;
import com.alibaba.fastjson.JSON;
import java.util.Set;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.junit.Test;

/**
 * @create: 2020/1/9 4:14 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class HibernateValidatorTest extends BaseTest {

  @Resource
  private Validator hibernateValidator;

  @Test
  public void testNotNull(){

    AirVo airVo = new AirVo();
    Set<ConstraintViolation<AirVo>> constraintViolationSet = hibernateValidator.validate(airVo);

    constraintViolationSet.forEach(System.out::println);

  }

}
