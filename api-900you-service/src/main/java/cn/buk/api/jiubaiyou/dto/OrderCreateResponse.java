package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;

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
  @JSONField(name = "EtripOrderID")
  private String etripOrderID;


  /**
   * 接机人联系电话
   * 非必须（选择举牌接机时必须）
   */
  @JSONField(name = "PickUpPhone")
  private String pickUpPhone;


  public String getEtripOrderID() {
    return etripOrderID;
  }

  public void setEtripOrderID(String etripOrderID) {
    this.etripOrderID = etripOrderID;
  }

  public String getPickUpPhone() {
    return pickUpPhone;
  }

  public void setPickUpPhone(String pickUpPhone) {
    this.pickUpPhone = pickUpPhone;
  }
}
