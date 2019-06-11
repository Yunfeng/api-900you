package cn.buk.api.jiubaiyou.dto;

import java.util.List;

/**
 * @author yfdai
 */
public class OtherPriceDetailDto {

  /**
   * 高速费
   */
  private double highWayFee;

  /**
   * 路桥费
   */
  private double tollFee;

  /**
   * 轮渡费
   */
  private double ferryFee;

  /**
   * 查询结果
   */
  private List<ShoppingQueryProductDto> queryResultList;


  public double getHighWayFee() {
    return highWayFee;
  }

  public void setHighWayFee(double highWayFee) {
    this.highWayFee = highWayFee;
  }

  public double getTollFee() {
    return tollFee;
  }

  public void setTollFee(double tollFee) {
    this.tollFee = tollFee;
  }

  public double getFerryFee() {
    return ferryFee;
  }

  public void setFerryFee(double ferryFee) {
    this.ferryFee = ferryFee;
  }

  public List<ShoppingQueryProductDto> getQueryResultList() {
    return queryResultList;
  }

  public void setQueryResultList(
      List<ShoppingQueryProductDto> queryResultList) {
    this.queryResultList = queryResultList;
  }
}
