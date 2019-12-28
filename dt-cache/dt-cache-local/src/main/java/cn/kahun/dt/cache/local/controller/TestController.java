package cn.kahun.dt.cache.local.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create: 2019/12/24 9:09 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@Slf4j
@RestController
public class TestController {

  @GetMapping(value = "/test")
  public void test(long ts) throws InterruptedException {

    long timestamp = System.currentTimeMillis();

    log.info(ts + "===============" + Thread.currentThread().getName());

    Thread.sleep(ts);

    log.info(ts + "===============" + Thread.currentThread().getName());
    log.info("最内实现方法耗时为：{}",(System.currentTimeMillis() - timestamp));

  }

}
