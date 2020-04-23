package cn.kahun.sa.framework.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @create: 2020/4/8 10:59 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/

@EnableScheduling
@SpringBootApplication
public class MybatisApplication {

  public static void main(String[] args) {

    SpringApplication.run(MybatisApplication.class,args);
  }
}
