package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.PriceRequest;
import cn.buk.api.jiubaiyou.dto.PriceResponse;

/**
 * 租车服务接口
 *
 * @author yfdai
 * @date 2019-06-08
 */
public interface CarRentalService {

  /**
   * 查询租车价格
   *
   * @param request 请求参数
   * @param vendorId 供应商ID
   * @param channel 通道
   * @param version 版本
   * @param secretKey 秘钥
   */
  PriceResponse searchPrice(PriceRequest request, final String vendorId, final String channel,
      final String version, final String secretKey);
}
