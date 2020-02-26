package cn.kahun.dt.security.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libo
 * @date 2020/2/22 22:52
 * @description 记得写注释
 */
@RestController
public class TestController {

  @GetMapping("/")
  public JSONObject json(){

    JSONObject jsonObject = new JSONObject();

    jsonObject.put("key","value");

    return jsonObject;

  }

  @GetMapping("/user")
  public String user(){

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails){

      return JSON.toJSONString(principal);
    }else {

      return principal.toString();
    }

  }

}
