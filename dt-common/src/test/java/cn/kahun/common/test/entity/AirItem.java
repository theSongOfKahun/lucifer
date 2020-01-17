package cn.kahun.common.test.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirItem {

  private Long id;

  private Long airId;

  private String from;

  private String to;

  private String flightNumber;

  private String carrier;

  private String seat;

  @JSONField(format = "yyyyMMdd")
  private Date date;

  private String time;


}
