package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
 * @author yfdai
 */
public abstract class AbstractBaseRequest {

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

  @JSONField(name = "CityCode")
  private String cityCode;

  @JSONField(name = "DuseLocationAddress")
  private String duseLocationAddress;

  @JSONField(name = "DuseLocationDetailAddress")
  private String duseLocationDetailAddress;


  @JSONField(name = "DuseLocationLongitude")
  private String duseLocationLongitude;

  @JSONField(name = "DuseLocationLatitude")
  private String duseLocationLatitude;


  @JSONField(name = "AuseLocationAddress")
  private String auseLocationAddress;

  @JSONField(name = "AuseLocationDetailAddress")
  private String auseLocationDetailAddress;


  @JSONField(name = "AuseLocationLongitude")
  private String auseLocationLongitude;

  @JSONField(name = "AuseLocationLatitude")
  private String auseLocationLatitude;


  @JSONField(name = "UseTime", format="yyyyMMddHHmm")
  private Date useTime;

  @JSONField(name = "FixedCode")
  private String fixedCode;

  /**
   *  最长200位	出发地址
   *  (地标名称等)
   *   若出发地为机场的时候为机场名称，如果该机场有航站楼则包含
   *   航站楼名称。
   */
  public String getDuseLocationAddress() {
    return duseLocationAddress;
  }

  public void setDuseLocationAddress(String duseLocationAddress) {
    this.duseLocationAddress = duseLocationAddress;
  }

  /**
   * String	最长200位	出发详细地址(地标名称等，例如:上海市金钟路XXX号)
   *   若出发地位机场的时候为机场时和Address内容一致
   */
  public String getDuseLocationDetailAddress() {
    return duseLocationDetailAddress;
  }

  public void setDuseLocationDetailAddress(String duseLocationDetailAddress) {
    this.duseLocationDetailAddress = duseLocationDetailAddress;
  }

  /**出发经度
   * 6位小数，不足6位后补0
   */
  public String getDuseLocationLongitude() {
    return duseLocationLongitude;
  }

  public void setDuseLocationLongitude(String duseLocationLongitude) {
    this.duseLocationLongitude = duseLocationLongitude;
  }

  /**
   * 出发纬度
   * 6位小数，不足6位后补0
   */
  public String getDuseLocationLatitude() {
    return duseLocationLatitude;
  }

  public void setDuseLocationLatitude(String duseLocationLatitude) {
    this.duseLocationLatitude = duseLocationLatitude;
  }

  public String getAuseLocationAddress() {
    return auseLocationAddress;
  }

  public void setAuseLocationAddress(String auseLocationAddress) {
    this.auseLocationAddress = auseLocationAddress;
  }

  public String getAuseLocationDetailAddress() {
    return auseLocationDetailAddress;
  }

  public void setAuseLocationDetailAddress(String auseLocationDetailAddress) {
    this.auseLocationDetailAddress = auseLocationDetailAddress;
  }

  public String getAuseLocationLongitude() {
    return auseLocationLongitude;
  }

  public void setAuseLocationLongitude(String auseLocationLongitude) {
    this.auseLocationLongitude = auseLocationLongitude;
  }

  public String getAuseLocationLatitude() {
    return auseLocationLatitude;
  }

  public void setAuseLocationLatitude(String auseLocationLatitude) {
    this.auseLocationLatitude = auseLocationLatitude;
  }

  /**
   * String		用车时间
   *   格式：yyyyMMddHHmm
   *   例	如	：	2016/08/16	16:31 201608161630
   */
  public Date getUseTime() {
    return useTime;
  }

  public void setUseTime(Date useTime) {
    this.useTime = useTime;
  }

  /**
   * 	机场三字码/火车站ID
   */
  public String getFixedCode() {
    return fixedCode;
  }

  public void setFixedCode(String fixedCode) {
    this.fixedCode = fixedCode;
  }

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

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }
}
