package cn.kahun.dt.message.rabbit.test.direct;

import cn.kahun.dt.message.rabbit.config.RabbitMqConfig;
import cn.kahun.dt.message.rabbit.test.BaseTest;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author libo
 * @date 2020/2/13 21:54
 * @description 记得写注释
 */
public class TestDirectExchange extends BaseTest {

  @Resource
  private RabbitTemplate rabbitTemplate;

  @Test
  public void testSend(){

    rabbitTemplate.convertAndSend(RabbitMqConfig.QUEUE_NAME_ONE,"风急天高猿啸哀，渚清沙白鸟飞回");

  }

}
