package cn.kahun.sa.framework.spring.bean;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @create: 2020/1/17 10:15 上午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@Getter
@Setter
@NoArgsConstructor
public class TestBean {

  private String name;

  private List<String> groupList;

}
