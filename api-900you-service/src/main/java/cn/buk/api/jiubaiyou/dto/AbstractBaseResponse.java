package cn.buk.api.jiubaiyou.dto;

/**
 * 接口响应的基础类
 * @author yfdai
 */
public class AbstractBaseResponse {

  /**
   * OK:成功
   * NO_SERVICE:该城市无服务
   * NO_VEHICLE:车型不提供服务
   * NO_TIMESERVICE: 用 车 时 间
   * 接近或者超过业务预定时间，无
   * 法预定
   */
  private String msgCode;

  /**
   * 提示信息
   */
  private String message;

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
}
