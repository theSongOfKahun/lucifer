package cn.kahun.dt.cache.redis.test;

import cn.kahun.dt.cache.reids.RedisApplication;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @create: 2020/1/18 2:28 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class BaseTest {

  @Resource
  protected RedisTemplate<String,String> redisTemplate;


}
