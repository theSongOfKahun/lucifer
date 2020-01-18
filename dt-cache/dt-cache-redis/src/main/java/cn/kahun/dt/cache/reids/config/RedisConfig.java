package cn.kahun.dt.cache.reids.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @create: 2020/1/6 1:14 下午
 * @author: liboah
 * @description: redis 配置
 **/
@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){

    RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);

    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.string());
    redisTemplate.setHashKeySerializer(RedisSerializer.json());
    redisTemplate.setHashValueSerializer(RedisSerializer.string());
    redisTemplate.setStringSerializer(RedisSerializer.string());
    redisTemplate.setDefaultSerializer(RedisSerializer.string());

    redisTemplate.afterPropertiesSet();

    return redisTemplate;
  }

}
