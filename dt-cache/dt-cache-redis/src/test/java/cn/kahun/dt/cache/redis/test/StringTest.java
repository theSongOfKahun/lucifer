package cn.kahun.dt.cache.redis.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @create: 2020/1/18 2:28 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

public class StringTest extends BaseTest {

  private static final String key = "key";

  @Test
  public void testSet(){

    redisTemplate.opsForValue().set(key+1,"value1");
    redisTemplate.opsForValue().set(key+2,"value2",10, TimeUnit.SECONDS);
    redisTemplate.opsForValue().set(key+3,"value3", Duration.ofSeconds(16));
    redisTemplate.opsForValue().set(key+4,"value4",3);

  }

  @Test
  public void testGet(){


  }


}
