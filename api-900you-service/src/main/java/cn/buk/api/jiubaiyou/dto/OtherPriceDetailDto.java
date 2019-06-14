package cn.buk.api.jiubaiyou.dto;

import java.util.List;

/**
 * @author yfdai
 */
public class OtherPriceDetailDto {

  /**
   * 查询结果
   */
  private List<ShoppingQueryProductDto> queryResultList;


  public List<ShoppingQueryProductDto> getQueryResultList() {
    return queryResultList;
  }

  public void setQueryResultList(
      List<ShoppingQueryProductDto> queryResultList) {
    this.queryResultList = queryResultList;
  }
}
