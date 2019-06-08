package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class Location {

  @JSONField(name = "Address")
  private String address;

  @JSONField(name = "DetailAddress")
  private String detailAddress;

  @JSONField(name = "Longitude")
  private double longitude;

  @JSONField(name = "Latitude")
  private double latitude;

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }
}
