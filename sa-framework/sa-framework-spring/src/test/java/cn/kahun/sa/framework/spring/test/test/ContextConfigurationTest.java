package cn.kahun.sa.framework.spring.test.test;

import cn.kahun.sa.framework.spring.beans.Inventor;
import cn.kahun.sa.framework.spring.config.TestConfiguration;
import cn.kahun.sa.framework.spring.config.WebMvcConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestConfiguration.class)
@SpringJUnitConfig(classes = TestConfiguration.class)
public class ContextConfigurationTest {

  @Resource
  private Inventor inventor;

  @Test
  public void testInject(){

    System.out.println(inventor);
  }

}
