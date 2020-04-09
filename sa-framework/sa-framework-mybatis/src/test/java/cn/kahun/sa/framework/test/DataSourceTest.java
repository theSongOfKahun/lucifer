package cn.kahun.sa.framework.test;

import cn.kahun.sa.framework.mybatis.config.HikariConfiguration;
import cn.kahun.sa.framework.mybatis.config.MybatisConfiguration;
import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import com.zaxxer.hikari.HikariDataSource;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@SpringBootTest(classes = {HikariConfiguration.class, MybatisConfiguration.class})
public class DataSourceTest {

  @Resource
  private DataSource dataSource;
//  @Resource
//  private SqlSessionTemplate sqlSessionTemplate;
  @Resource
  private UserMapper userMapper;

  @Test
  public void testInitDataSource(){

    log.info(dataSource.getClass().getSimpleName());
  }

  @Test
  public void testGetMapper(){

    Assertions.assertNotNull(userMapper);
  }

}
