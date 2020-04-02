package cn.kahun.sa.framework.spring.test.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * @create: 2020/3/31 9:24 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class LogbackTest {

  @Test
  public void testHelloWorld(){

    Logger logger = LoggerFactory.getLogger(LogbackTest.class);
    logger.debug("hello world");

  }

  @Test
  public void testLoggerStatus(){

    Logger logger = LoggerFactory.getLogger(LogbackTest.class);
    logger.debug("test print logger status");

    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    StatusPrinter.print(loggerContext);

  }

  @Test
  public void testHierarchy(){

    ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("org");
    Logger childLogger = LoggerFactory.getLogger("org.springframework");

    Logger rootLogger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    logger.setLevel(Level.INFO);

    logger.debug("child logger level is debug");
    childLogger.debug("child logger level is debug");

    logger.info("logger level is info");
    childLogger.info("child logger level is info");

    rootLogger.debug("root logger debug log");

  }

  @Test
  public void testPattern(){

    Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    MDC.put("requestId","1234567");

    logger.info("面对疾风吧");

  }

}
