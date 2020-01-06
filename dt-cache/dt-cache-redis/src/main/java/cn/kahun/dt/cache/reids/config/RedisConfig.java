package cn.kahun.dt.cache.reids.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @create: 2020/1/6 1:14 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){

    RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL,Visibility.ANY);

    jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

    redisTemplate.setStringSerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

    redisTemplate.afterPropertiesSet();

    return redisTemplate;
  }

}
