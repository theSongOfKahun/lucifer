package cn.kahun.sa.framework.mybatis.standalone;

import cn.kahun.sa.framework.mybatis.entity.User;
import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/28 12:43 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class StandAloneTest {

  private static SqlSession sqlSession;

  private static SqlSessionFactory sqlSessionFactory;

  private static final String RESOURCE = "standalone/mybatis-config.xml";


  @Test
  public void testMapper(){

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    User user = userMapper.selectByPrimaryKey(1L);

    Assertions.assertNotNull(user);
  }

  @Test
  public void testSelectOne(){

    User user = sqlSession.selectOne("cn.kahun.sa.framework.mybatis.mapper.UserMapper.selectByPrimaryKey",1L);

    Assertions.assertNotNull(user);
  }

  @Test
  public void testOpenSession(){

    Assertions.assertNotNull(sqlSession);
  }

  @Test
  public void testSqlSessionFactory(){

    Assertions.assertNotNull(sqlSessionFactory);
  }

  @BeforeAll
  static void config() throws IOException {

    InputStream inputStream = Resources.getResourceAsStream(RESOURCE);

    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    sqlSession = sqlSessionFactory.openSession();
  }

}
