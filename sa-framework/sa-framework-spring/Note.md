## Logging-logback

> `Logger` `Appender` `Layouts`

在logback-classic中，分类是logger的一部分，每个logger都依附在LoggerContext上，它负责产生logger，并通过一个树状层级来管理logger。

logger的层级管理通过名字来区分，名为`com`的logger是com.*.*的祖先，如果一个给定的logger没有指定层级，就会继承他的父类的层级，root logger的默认层级为debug

logback允许日志在多个地方输出，输出的目的地叫`appender`，appender包括`console`，`file`，`remote socket server`，`DB`，`JMS`等

`layout`的作用是将日志格式化