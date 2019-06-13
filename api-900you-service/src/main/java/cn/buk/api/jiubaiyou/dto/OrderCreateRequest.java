package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 下单请求
 *
 * @author yfdai
 */
public class OrderCreateRequest extends AbstractBaseRequest {
  /**
   * 我方（租出平台接入方）订单号
   */
  @JSONField(name = "ThirdOrderID")
  private String orderNo;


  /**
   * 产品价格
   */
  @JSONField(name = "Price")
  private Double price;

  /**
   * 最长25位，非必须	价格标示符号，用来标明本次约定的价格（下单时使用）
   */
  private String priceMark;

  /**
   *  必须	车型ID
   */
  @JSONField(name = "VehicleType")
  private int vehicleType;

  /**
   * 必须	客户手机
   */
  @JSONField(name = "Mobile")
  private String mobile;

  /**
   * 非必须	客户姓名
   */
  @JSONField(name = "Name")
  private String name;

  /**
   * 航班号
   */
  @JSONField(name = "FlightNumber")
  private String flightNo;


  public java.lang.String getFlightNo() {
    return flightNo;
  }

  public void setFlightNo(java.lang.String flightNo) {
    this.flightNo = flightNo;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getPriceMark() {
    return priceMark;
  }

  public void setPriceMark(String priceMark) {
    this.priceMark = priceMark;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(int vehicleType) {
    this.vehicleType = vehicleType;
  }


  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }
}
