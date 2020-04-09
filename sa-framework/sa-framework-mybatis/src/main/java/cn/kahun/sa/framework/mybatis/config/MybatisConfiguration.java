package cn.kahun.sa.framework.mybatis.config;

import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import javax.sql.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kahun
 */
@Configuration
@MapperScan(basePackages = "cn.kahun.sa.**.mapper")
public class MybatisConfiguration {

  @Bean
  public SqlSessionFactory sqlSessionFactory(
      @Qualifier("hikariDataSource") DataSource dataSource) throws Exception {

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

    sqlSessionFactoryBean.setDataSource(dataSource);

    return sqlSessionFactoryBean.getObject();
  }

//  @Bean
//  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
//
//    return new SqlSessionTemplate(sqlSessionFactory);
//  }

//  @Bean
//  public MapperFactoryBean<UserMapper> mapperFactoryBean(SqlSessionFactory sqlSessionFactory){
//
//    MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>();
//    mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
//    mapperFactoryBean.setMapperInterface(UserMapper.class);
//
//    return mapperFactoryBean;
//  }

}
