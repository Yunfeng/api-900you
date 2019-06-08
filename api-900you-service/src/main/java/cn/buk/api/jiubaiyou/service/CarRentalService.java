package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.PriceRequest;

/**
 * 租车服务接口
 * @author yfdai
 * @date 2019-06-08
 */
public interface CarRentalService {

  /**
   * 查询租车价格
   */
  void searchPrice(PriceRequest request, final String secretKey);
}
