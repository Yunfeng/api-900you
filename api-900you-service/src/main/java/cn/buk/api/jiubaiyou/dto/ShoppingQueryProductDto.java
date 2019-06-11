package cn.buk.api.jiubaiyou.dto;

/**
 *
 * @author yfdai
 */
public class ShoppingQueryProductDto {

  /**
   * 车型ID
   */
  private int vehicleType;

  /**
   * 		价格（不包含附加服务部分）
   */
  private double price;

  public int getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(int vehicleType) {
    this.vehicleType = vehicleType;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
