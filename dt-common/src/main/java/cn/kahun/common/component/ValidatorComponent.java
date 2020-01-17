package cn.kahun.common.component;

import java.util.Set;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.stereotype.Component;

/**
 * @create: 2020/1/9 6:12 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Component
public class ValidatorComponent {

  @Resource
  private Validator validator;

  public <T> Set<ConstraintViolation<T>> validate(T t){

    return validator.validate(t);
  }

}
