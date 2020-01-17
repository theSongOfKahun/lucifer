package cn.kahun.common.test.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * 航空电子行程单的实体类 invoice_air
 *
 * @author liuqiangm
 */
@Getter
@Setter
public class AirVo {

  private Long id;

  @JSONField(format = "yyyyMMdd")
  @NotNull(message = "时间不能为空")
  private Date date;

  private String ticketNum;

  private String checkCode;

  private String agentCode;

  private String issueBy;

  private BigDecimal fare;

  private BigDecimal tax;

  private BigDecimal fuelSurcharge;

  private BigDecimal caacDevelopFund;

  private BigDecimal insurance;

  @NotNull(message = "金额不能为空")
  private BigDecimal totalAmount;

  private String userName;

  private String userId;

  private Integer purchaserStatus;

  private String kind;

  private BigDecimal feeWithoutTax;

  private BigDecimal taxAmount;

  private Integer airportType;

  private String filePath;

  private List<AirItem> itemList;

}
