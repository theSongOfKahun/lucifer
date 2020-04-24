package cn.kahun.sa.framework.spring.test.scanner;

import cn.kahun.sa.framework.spring.scanner.ProbeClassPathBeanDefinitionScanner;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.Set;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @create: 2020/4/24 4:41 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class AnnotationScannerTest {

  private ProbeClassPathBeanDefinitionScanner scanner = new ProbeClassPathBeanDefinitionScanner();

  @Test
  public void testScan() throws IOException {

    String basePackages = "cn.kahun";

    Set<BeanDefinition> bds = scanner.scanCandidateComponents(basePackages);

    System.out.println(bds.size());

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);	//格式化输出
    objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);	//键按自然顺序输出
    objectMapper.setSerializationInclusion(Include.NON_EMPTY);	//忽略POJO中属性为空的字段

    String s = objectMapper.writeValueAsString(bds);

    System.out.println(s);

  }

}
