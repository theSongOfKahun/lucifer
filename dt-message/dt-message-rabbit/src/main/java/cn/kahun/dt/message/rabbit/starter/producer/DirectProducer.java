package cn.kahun.dt.message.rabbit.starter.producer;

import cn.kahun.dt.message.rabbit.config.RabbitMqConfig;
import javax.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author libo
 * @date 2020/3/1 22:26
 * @description 记得写注释
 */
@Component
public class DirectProducer {

  @Resource
  private RabbitTemplate rabbitTemplate;

  public void send(String routingKey,Object message){

    rabbitTemplate.convertAndSend(routingKey,RabbitMqConfig.QUEUE_NAME_ONE,message);
  }

}
