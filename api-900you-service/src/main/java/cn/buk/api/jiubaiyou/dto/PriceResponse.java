package cn.buk.api.jiubaiyou.dto;

/**
 * @author yfdai
 */
public class PriceResponse extends AbstractBaseResponse {

  /**
   * 价格标示符号，用来标明本次约定的价格（下单时使用）
   * 最长25位，非必须
   */
  private String priceMark;

  /**
   * 其他费用详情（高速费，路桥费轮渡费等）
   * 非必须
   */
  private OtherPriceDetailDto otherPriceDetail;

  public String getPriceMark() {
    return priceMark;
  }

  public void setPriceMark(String priceMark) {
    this.priceMark = priceMark;
  }

  public OtherPriceDetailDto getOtherPriceDetail() {
    return otherPriceDetail;
  }

  public void setOtherPriceDetail(OtherPriceDetailDto otherPriceDetail) {
    this.otherPriceDetail = otherPriceDetail;
  }
}
