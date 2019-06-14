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

  /**
   * 900游订单编号
   */
  @JSONField(name = "EtripOrderID")
  private String etripOrderId;



  public String getThirdOrderId() {
    return thirdOrderId;
  }

  public void setThirdOrderId(String thirdOrderId) {
    this.thirdOrderId = thirdOrderId;
  }

  public String getEtripOrderId() {
    return etripOrderId;
  }

  public void setEtripOrderId(String etripOrderId) {
    this.etripOrderId = etripOrderId;
  }
}
