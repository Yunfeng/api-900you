package cn.buk.api.jiubaiyou.dto;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;

/**
 * 价格信息查询请求
 *
 * @author yfdai
 */
public class PriceRequest extends AbstractBaseRequest {

  @JSONField(name = "VehicleTypeList")
  private int[] vehicleTypes;

  /**
   * 来源类型
   * 1.	app
   * 2.	机票
   */
  @JSONField(name = "FromType")
  private int fromType;

  /**
   * 航班号
   */
  @JSONField(name = "FltNo")
  private String fltNo;

  public int[] getVehicleTypes() {
    return vehicleTypes;
  }

  public void setVehicleTypes(int[] vehicleTypes) {
    this.vehicleTypes = vehicleTypes;
  }


}
