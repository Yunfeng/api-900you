package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单状态查询返回内容
 *
 * msgCode的代码含义如下：
 * OK:成功
 * ERROR_PRICEMARK:价格标示符号已经使用，不可以重复使用
 * ERROR:其他错误（正常情况下不应该出现。）
 *
 * @author yfdai
 */
public class OrderInfoResponse extends AbstractBaseResponse {

  /**
   * 900游订单编号
   */
  @JSONField(name = "EtripOrderID")
  private String etripOrderID;


  /**
   *  司机编号（唯一）
   *  最长25位
   */
  @JSONField(name = "DriverID")
  private String driverId;

  /**
   * 司机姓名
   */
  @JSONField(name = "DriverName")
  private String driverName;

  /**
   * 司机手机
   */
  @JSONField(name = "DriverPhone")
  private String driverPhone;


  /**
   * 司机车牌号码
   * 最长20位
   */
  @JSONField(name = "VehicleNumber")
  private String vehicleNumber;

  /**
   * 具体车辆品牌，例如：奔驰C200
   * 最长30位
   */
  @JSONField(name = "VehicleTypeBrand")
  private String vehicleTypeBrand;


  /**
   * 车辆级别(经济,舒适等)
   * 最长30位
   */
  @JSONField(name = "VehicleType")
  private String vehicleType;

  /**
   * 车辆备注
   */
  @JSONField(name = "Remark")
  private String remark;


  /**
   * 司机状态
   * 1:司机就位
   * 2:司机开始服务
   * 3:司机服务完成
   */
  @JSONField(name = "DriverStatus")
  private int driverStatus;

  /**
   * 订单状态
   * 1：派车中(无司机)
   * 2：已派车（有司机）
   * 3：取消(订单取消)
   * 4：完成(订单完成)
   */
  @JSONField(name = "OrderStatus")
  private int orderStatus;

  public String getEtripOrderID() {
    return etripOrderID;
  }

  public void setEtripOrderID(String etripOrderID) {
    this.etripOrderID = etripOrderID;
  }

  public String getDriverId() {
    return driverId;
  }

  public void setDriverId(String driverId) {
    this.driverId = driverId;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public String getDriverPhone() {
    return driverPhone;
  }

  public void setDriverPhone(String driverPhone) {
    this.driverPhone = driverPhone;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public String getVehicleTypeBrand() {
    return vehicleTypeBrand;
  }

  public void setVehicleTypeBrand(String vehicleTypeBrand) {
    this.vehicleTypeBrand = vehicleTypeBrand;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public int getDriverStatus() {
    return driverStatus;
  }

  public void setDriverStatus(int driverStatus) {
    this.driverStatus = driverStatus;
  }

  public int getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(int orderStatus) {
    this.orderStatus = orderStatus;
  }
}
