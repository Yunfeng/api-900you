package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
 * 价格信息查询请求
 *
 * @author yfdai
 */
public class PriceRequest {

  /**
   * 服务类型
   * 1：接送机
   * 2：接送火车
   */
  @JSONField(name = "UseType")
  private int useType;

  /**
   * 用车形态
   * 1: 接机
   * 2: 送机
   */
  @JSONField(name = "PatternType")
  private int patternType;

  @JSONField(name = "VehicleTypeList")
  private int[] vehicleTypes;

  @JSONField(name = "DuseLocation")
  private Location duseLocation;

  @JSONField(name = "AuseLocation")
  private Location auseLocation;

  @JSONField(name = "UseTime")
  private Date useTime;

  @JSONField(name = "FixedCode")
  private String fixedCode;

  public int getUseType() {
    return useType;
  }

  public void setUseType(int useType) {
    this.useType = useType;
  }

  public int getPatternType() {
    return patternType;
  }

  public void setPatternType(int patternType) {
    this.patternType = patternType;
  }


  public int[] getVehicleTypes() {
    return vehicleTypes;
  }

  public void setVehicleTypes(int[] vehicleTypes) {
    this.vehicleTypes = vehicleTypes;
  }

  public Location getDuseLocation() {
    return duseLocation;
  }

  public void setDuseLocation(Location duseLocation) {
    this.duseLocation = duseLocation;
  }

  public Location getAuseLocation() {
    return auseLocation;
  }

  public void setAuseLocation(Location auseLocation) {
    this.auseLocation = auseLocation;
  }

  public Date getUseTime() {
    return useTime;
  }

  public void setUseTime(Date useTime) {
    this.useTime = useTime;
  }

  public String getFixedCode() {
    return fixedCode;
  }

  public void setFixedCode(String fixedCode) {
    this.fixedCode = fixedCode;
  }
}
