package cn.kahun.sa.framework.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceUnwrapper;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kahun
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class HikariConfiguration {

  @Bean(name = "hikariDataSource")
  public DataSource hikariDataSource(DataSourceProperties properties){

    return properties.initializeDataSourceBuilder().build();
  }

}
