package cn.kahun.dt.message.rabbit.starter.consumer;

import cn.kahun.dt.message.rabbit.config.RabbitMqConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author libo
 * @date 2020/3/1 22:26
 * @description 记得写注释
 */
@Component
@RabbitListener(bindings = {
    @QueueBinding(
        value = @Queue(name = RabbitMqConfig.QUEUE_NAME_ONE),
        exchange = @Exchange(name = RabbitMqConfig.DIRECT_EXCHANGE_NAME,type = ExchangeTypes.DIRECT),
        key = RabbitMqConfig.QUEUE_NAME_ONE
    ),
    @QueueBinding(
        value = @Queue(name = RabbitMqConfig.QUEUE_NAME_TWO),
        exchange = @Exchange(name = RabbitMqConfig.DIRECT_EXCHANGE_NAME,type = ExchangeTypes.DIRECT),
        key = RabbitMqConfig.QUEUE_NAME_TWO
    ),
    @QueueBinding(
        value = @Queue(name = RabbitMqConfig.QUEUE_NAME_THREE),
        exchange = @Exchange(name = RabbitMqConfig.DIRECT_EXCHANGE_NAME,type = ExchangeTypes.DIRECT),
        key = RabbitMqConfig.QUEUE_NAME_THREE
    ),
})
public class DirectListener {

  @RabbitHandler
  public void onMessage(@Payload String message){

    System.out.println(message);
  }

}
