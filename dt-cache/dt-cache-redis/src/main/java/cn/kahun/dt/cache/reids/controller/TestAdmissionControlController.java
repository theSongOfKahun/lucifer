package cn.kahun.dt.cache.reids.controller;

import cn.kahun.dt.cache.reids.service.AdmissionControlService;
import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create: 2020/1/15 4:08 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@RestController
public class TestAdmissionControlController {

  @Resource
  private RedisTemplate<String,String> redisTemplate;
  @Resource
  private AdmissionControlService admissionControlService;

  @RequestMapping("/test")
  public JSONObject test(){

    admissionControlService.doSomeThing("kahunsha", Arrays.asList("1234","4567","7890"));

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("err","ok");

    return jsonObject;

  }

  @RequestMapping("/test2")
  public JSONObject test2(Integer num){

    String key = "admissionControl:1:remaining";

    redisTemplate.opsForValue().set(key, String.valueOf(num));

    JSONObject jsonObject = new JSONObject();
    jsonObject.put("num",num);

    return jsonObject;

  }

}
