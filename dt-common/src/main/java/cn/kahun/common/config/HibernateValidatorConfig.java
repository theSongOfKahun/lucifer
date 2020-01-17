package cn.kahun.common.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @create: 2020/1/9 4:07 下午
 * @author: liboah
 * @description: hibernate validator
 **/
@Configuration
public class HibernateValidatorConfig {

  @Bean
  public Validator hibernateValidator(){

    ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
        .configure()
        .failFast(false)
        .buildValidatorFactory();
    return validatorFactory.getValidator();
  }

}
