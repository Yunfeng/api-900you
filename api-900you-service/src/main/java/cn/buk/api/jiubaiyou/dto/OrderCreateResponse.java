package cn.buk.api.jiubaiyou.dto;

/**
 * 下单接口的返回
 *
 * msgCode的代码含义如下：
 * OK:成功
 * ERROR_PRICEMARK:价格标示符号已经使用，不可以重复使用
 * ERROR:其他错误（正常情况下不应该出现。）
 *
 * @author yfdai
 */
public class OrderCreateResponse extends AbstractBaseResponse {

  /**
   * 900游订单编号
   */
  private String serviceOrderId;

  public String getServiceOrderId() {
    return serviceOrderId;
  }

  public void setServiceOrderId(String serviceOrderId) {
    this.serviceOrderId = serviceOrderId;
  }
}
