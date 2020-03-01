# Message Queue

## 1. RabbitMQ

### 1.1 相关概念

* Producer：生产者，投递消息的一方
* Consumer：消费者，接受消息的一方
* Broker：消息中间件的服务节点

* Queue：队列，RabbitMQ的内部对象，用于存储消息。RabbitMQ的消息都只能存储在队列中，生产者生产消息并最终投递到队列中，消费者可以从队列中获取消息并消费
* Exchange：交换机，接受生产者的消息并转发到对应的队列中。有fanout、direct、topic、headers四种类型
* RoutingKey：路由键，指定消息的路由规则，路由键需要与交换机类型和绑定键联合使用才能最终生效
* BindingKey：绑定，RabbitMQ中通过BindingKey将交换机和队列关联起来