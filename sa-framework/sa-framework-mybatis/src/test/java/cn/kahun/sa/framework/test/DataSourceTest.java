package cn.kahun.sa.framework.test;

import cn.kahun.sa.framework.mybatis.entity.User;
import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import cn.kahun.sa.framework.test.config.DataAccessConfiguration;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = DataAccessConfiguration.class)
public class DataSourceTest {

  @Resource
  private DataSource dataSource;
  @Resource
  private UserMapper userMapper;

  @Test
  public void testInitDataSource(){

    log.info(dataSource.getClass().getSimpleName());
  }

  @Test
  public void testGetMapper(){

    Assertions.assertNotNull(userMapper);

    User user = userMapper.selectByPrimaryKey(1L);

    Assertions.assertNotNull(user);
  }

}
