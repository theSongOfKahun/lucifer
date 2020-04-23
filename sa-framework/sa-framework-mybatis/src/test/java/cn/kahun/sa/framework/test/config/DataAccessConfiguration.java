package cn.kahun.sa.framework.test.config;

import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataAccessConfiguration {

  private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

  @Bean
  public DataSource hikariDataSource(DataSourceProperties dataSourceProperties) {

    return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);

    String[] mapperLocations = new String[]{"classpath:/mapper/*.xml"};

    Resource[] resources = Stream.of(Optional.of(mapperLocations).orElse(new String[0]))
        .flatMap(location -> Stream.of(getResources(location))).toArray(Resource[]::new);
    sqlSessionFactoryBean.setMapperLocations(resources);

    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public UserMapper userMapper(SqlSessionFactory sqlSessionFactory) throws Exception {

    MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>(UserMapper.class);
    mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);

    return mapperFactoryBean.getObject();
  }

  private Resource[] getResources(String location){

    try {

      return resourcePatternResolver.getResources(location);
    } catch (IOException e) {

      return new Resource[0];
    }
  }

}
