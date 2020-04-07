package cn.kahun.sa.framework.spring.test.test;

import cn.kahun.sa.framework.spring.beans.Inventor;
import cn.kahun.sa.framework.spring.config.TestConfiguration;
import cn.kahun.sa.framework.spring.config.WebMvcConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(classes = TestConfiguration.class)
public class ContextConfigurationTest {

  @Resource
  private Inventor inventor;

  @Test
  public void testInject(){

    System.out.println(inventor);
  }

}
