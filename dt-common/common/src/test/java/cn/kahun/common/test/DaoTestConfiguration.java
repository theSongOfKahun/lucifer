package cn.kahun.common.test;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(DataSourceAutoConfiguration.class)
public class DaoTestConfiguration {

}
