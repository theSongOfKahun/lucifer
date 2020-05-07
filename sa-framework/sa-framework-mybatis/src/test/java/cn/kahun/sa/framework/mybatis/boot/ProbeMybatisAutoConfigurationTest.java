package cn.kahun.sa.framework.mybatis.boot;

import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import cn.kahun.sa.framework.mybatis.schedule.ScheduleService;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;

/**
 * @create: 2020/4/29 4:20 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ProbeMybatisAutoConfigurationTest {

  @Resource
  private DataSource dataSource;
  @Resource
  private SqlSessionFactory sqlSessionFactory;
  @Resource
  private SqlSession sqlSession;
  @Resource
  private UserMapper userMapper;


  @Test
  public void testUserMapper(){

    Assertions.assertNotNull(userMapper);
    Assertions.assertNotNull(userMapper.selectByPrimaryKey(1L));

  }
  @Test
  public void testSqlSession(){

    Assertions.assertNotNull(sqlSession);
    log.info(sqlSession.getClass().getSimpleName());

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    Assertions.assertNotNull(userMapper.selectByPrimaryKey(1L));

  }

  @Test
  public void testSqlSessionFactory() throws JsonProcessingException {

    Assertions.assertNotNull(sqlSessionFactory);
    log.info(sqlSessionFactory.getClass().getSimpleName());

    Configuration configuration = sqlSessionFactory.getConfiguration();

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    log.info(objectMapper.writeValueAsString(configuration.getMapperRegistry().getMappers()));

    log.info(objectMapper.writeValueAsString(configuration.getIncompleteMethods()));

    log.info(objectMapper.writeValueAsString(configuration.getIncompleteResultMaps()));

  }

  @Test
  public void testDataSource() throws SQLException {

    Assertions.assertNotNull(dataSource);
    log.info(dataSource.getClass().getSimpleName());
    Assertions.assertNotNull(dataSource.getConnection());
  }

}
