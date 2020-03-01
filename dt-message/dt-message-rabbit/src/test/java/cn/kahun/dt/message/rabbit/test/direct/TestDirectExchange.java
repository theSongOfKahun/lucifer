package cn.kahun.dt.message.rabbit.test.direct;

import cn.kahun.dt.message.rabbit.config.RabbitMqConfig;
import cn.kahun.dt.message.rabbit.starter.producer.DirectProducer;
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
  private DirectProducer directProducer;

  @Test
  public void testSend(){

    directProducer.send(RabbitMqConfig.QUEUE_NAME_ONE,"queueNameOne");
    directProducer.send(RabbitMqConfig.QUEUE_NAME_TWO,"queueNameTwo");
    directProducer.send(RabbitMqConfig.QUEUE_NAME_THREE,"queueNameThree");

  }

}
