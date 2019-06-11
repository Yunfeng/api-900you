package cn.buk.api.jiubaiyou.dto;

/**
 * @author yfdai
 */
public class PriceResponse {

  /**
   * OK:成功
   * NO_SERVICE:该城市无服务NO_VEHICLE:车型不提供服务NO_TIMESERVICE: 用 车 时 间
   * 接近或者超过业务预定时间，无
   * 法预定
   */
  private String msgCode;

  /**
   * 提示信息
   */
  private String message;

  /**
   * 价格标示符号，用来标明本次约定的价格（下单时使用）
   * 最长25位，非必须
   */
  private String priceMark;

  /**
   * 其他费用详情（高速费，路桥费轮渡费等）
   * 非必须
   */
  private OtherPriceDetailDto otherPriceDetail;

  public String getMsgCode() {
    return msgCode;
  }

  public void setMsgCode(String msgCode) {
    this.msgCode = msgCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPriceMark() {
    return priceMark;
  }

  public void setPriceMark(String priceMark) {
    this.priceMark = priceMark;
  }

  public OtherPriceDetailDto getOtherPriceDetail() {
    return otherPriceDetail;
  }

  public void setOtherPriceDetail(OtherPriceDetailDto otherPriceDetail) {
    this.otherPriceDetail = otherPriceDetail;
  }
}
