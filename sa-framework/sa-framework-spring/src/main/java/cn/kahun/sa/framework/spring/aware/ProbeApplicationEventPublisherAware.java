package cn.kahun.sa.framework.spring.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author kahun
 */
@Slf4j
@Component("probeApplicationEventPublisherAware")
public class ProbeApplicationEventPublisherAware implements ApplicationEventPublisherAware {

  private static ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {

    log.info("application event publisher aware...");
    ProbeApplicationEventPublisherAware.applicationEventPublisher = applicationEventPublisher;
  }

  public static void publish(ApplicationEvent applicationEvent){

    applicationEventPublisher.publishEvent(applicationEvent);
  }
}
