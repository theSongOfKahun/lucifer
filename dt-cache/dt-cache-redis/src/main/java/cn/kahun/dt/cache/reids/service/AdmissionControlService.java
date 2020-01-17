package cn.kahun.dt.cache.reids.service;

import cn.kahun.dt.cache.reids.annotation.AdmissionControl;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @create: 2020/1/15 4:24 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Service
public class AdmissionControlService {

  @AdmissionControl(businessType = "1")
  public void doSomeThing(String name, List<String> groupList){

    throw new RuntimeException("1234567890");

  }

}
