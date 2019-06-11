package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单查询请求
 *
 * @author yfdai
 */
public class OrderQueryRequest {

  @JSONField(name = "EtripOrderID")
  private long orderID;

  /**
   * 平台订单编号
   * @return
   */
  public long getOrderID() {
    return orderID;
  }

  public void setOrderID(long orderID) {
    this.orderID = orderID;
  }
}
