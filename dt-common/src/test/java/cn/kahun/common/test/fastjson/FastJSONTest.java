package cn.kahun.common.test.fastjson;

import com.alibaba.fastjson.JSON;
import java.util.Date;

/**
 * @create: 2020/2/28 1:41 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
public class FastJSONTest {

  private static String str = "{\n"
      + "\t\t\"id\":\"1074\",\n"
      + "\t\t\"fpHm\":\"95685877\",\n"
      + "\t\t\"fpDm\":\"122009267205\",\n"
      + "\t\t\"ts\":\"2019-12-17 19:36:34\"\n"
      + "\t}";

  public void test(){

    CommonVo commonVo = JSON.parseObject(str,CommonVo.class);

    System.out.println(commonVo.getTs());



  }

  static class CommonVo{

    private Integer id;
    private Date ts;

    public void setId(Integer id) {
      this.id = id;
    }

    public Integer getId() {
      return id;
    }

    public Date getTs() {
      return ts;
    }

    public void setTs(Date ts) {
      this.ts = ts;
    }
  }

}
