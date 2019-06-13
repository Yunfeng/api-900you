package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单查询请求
 *
 * @author yfdai
 */
public class OrderQueryRequest {

  /**
   * 己方的订单号
   */
  @JSONField(name = "ThirdOrderID")
  private String thirdOrderId;


  public String getThirdOrderId() {
    return thirdOrderId;
  }

  public void setThirdOrderId(String thirdOrderId) {
    this.thirdOrderId = thirdOrderId;
  }
}
