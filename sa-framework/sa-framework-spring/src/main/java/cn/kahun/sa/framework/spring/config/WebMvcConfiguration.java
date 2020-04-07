package cn.kahun.sa.framework.spring.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @create: 2020/4/2 9:32 下午
 * @author: liboah
 * @description:
 **/
@Configuration
public class WebMvcConfiguration {

  @Bean
  public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder){

    return jackson2ObjectMapperBuilder.createXmlMapper(false).serializationInclusion(
        Include.NON_EMPTY).featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .featuresToEnable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS, Feature.ALLOW_SINGLE_QUOTES)
        .build();
  }

}
