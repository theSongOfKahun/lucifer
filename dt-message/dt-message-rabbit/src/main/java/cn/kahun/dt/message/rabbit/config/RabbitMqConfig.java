package cn.kahun.dt.message.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author libo
 * @date 2020/2/13 21:21
 * @description rabbit mq config
 */
@Configuration
public class RabbitMqConfig {

  public static final String QUEUE_NAME_ONE = "queue-name-one";
  public static final String QUEUE_NAME_TWO = "queue-name-two";
  public static final String QUEUE_NAME_THREE = "queue-name-three";
  public static final String DIRECT_EXCHANGE_NAME = "rabbit-direct-exchange";


  @Bean(name = "connectionFactory")
  public ConnectionFactory rabbitConnectionFactory(RabbitProperties rabbitProperties){

    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();

    connectionFactory.setHost(rabbitProperties.getHost());
    connectionFactory.setPort(rabbitProperties.getPort());
    connectionFactory.setVirtualHost(rabbitProperties.getVirtualHost());
    connectionFactory.setUsername(rabbitProperties.getUsername());
    connectionFactory.setPassword(rabbitProperties.getPassword());

    return connectionFactory;
  }

  @Bean(DIRECT_EXCHANGE_NAME)
  public DirectExchange testExchange(){
    return new DirectExchange(DIRECT_EXCHANGE_NAME,true,false);
  }

  @Bean(QUEUE_NAME_ONE)
  public Queue queueOne(){
    return new Queue(QUEUE_NAME_ONE,true,false,false);
  }

  @Bean(QUEUE_NAME_TWO)
  public Queue queueTwo(){
    return new Queue(QUEUE_NAME_TWO,true,false,false);
  }

  @Bean(QUEUE_NAME_THREE)
  public Queue queueThree(){
    return new Queue(QUEUE_NAME_ONE,true,false,false);
  }

  @Bean
  public Binding bindingOne(DirectExchange exchange,@Qualifier(QUEUE_NAME_ONE) Queue queue){
    return BindingBuilder.bind(queue).to(exchange).withQueueName();
  }

  @Bean
  public Binding bindingTwo(DirectExchange exchange,@Qualifier(QUEUE_NAME_TWO) Queue queue){
    return BindingBuilder.bind(queue).to(exchange).withQueueName();
  }

  @Bean
  public Binding bindingThree(DirectExchange exchange,@Qualifier(QUEUE_NAME_THREE) Queue queue){
    return BindingBuilder.bind(queue).to(exchange).withQueueName();
  }


//  @Bean
//  public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){
//
//    return new RabbitAdmin(connectionFactory);
//  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){

    return new RabbitTemplate(connectionFactory);
  }
}
