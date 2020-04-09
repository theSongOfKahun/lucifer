package cn.kahun.sa.mybatis.mapper.test;

import cn.kahun.sa.mybatis.mapper.UserMapper;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @create: 2020/4/9 4:48 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@SpringBootTest(
    properties = "application.yml",
    classes = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class MapperTest {

  @Resource
  private DataSource dataSource;
  @Resource
  private SqlSessionFactory sqlSessionFactory;

  @Test
  public void testDataSource(){

    System.out.println(dataSource.getClass().getSimpleName());

  }

  @Test
  public void testSqlSessionFactory(){

    SqlSession sqlSession = sqlSessionFactory.openSession();

    System.out.println(sqlSessionFactory.getClass().getSimpleName());

  }



}
