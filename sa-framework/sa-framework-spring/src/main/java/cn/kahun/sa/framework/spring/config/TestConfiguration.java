package cn.kahun.sa.framework.spring.config;

import cn.kahun.sa.framework.spring.beans.Inventor;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

  @Bean
  public Inventor inventor(){

    Inventor inventor = new Inventor();
    inventor.setName("Jackson");
    inventor.setBirthdate(new Date());
    return inventor;
  }
}
