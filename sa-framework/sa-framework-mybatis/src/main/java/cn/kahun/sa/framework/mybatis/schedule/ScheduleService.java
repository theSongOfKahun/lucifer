package cn.kahun.sa.framework.mybatis.schedule;

import cn.kahun.sa.framework.mybatis.entity.User;
import cn.kahun.sa.framework.mybatis.mapper.UserMapper;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @create: 2020/4/23 5:43 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Slf4j
@Service
public class ScheduleService {

  @Resource
  private UserMapper userMapper;

  @Scheduled(cron = "*/30 * * * * ?")
  public void schedulingSelect(){

    User user = userMapper.selectByPrimaryKey(1L);

    log.info("定时执行，{}",user);

  }

}
