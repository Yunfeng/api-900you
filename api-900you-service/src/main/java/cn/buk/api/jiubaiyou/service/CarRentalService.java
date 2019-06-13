package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.OrderCreateRequest;
import cn.buk.api.jiubaiyou.dto.OrderQueryRequest;
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
   * @return 返回PriceResponse对象
   */
  PriceResponse searchPrice(PriceRequest request, final String channel, final String type,
      final String version, final String secretKey);

  /**
   * 创建订单
   *
   * @param priceRequest
   * @param vendorId
   * @param channel
   * @param version
   * @param secretKey
   * @return
   */
  PriceResponse createOrder(OrderCreateRequest priceRequest, final String channel, final String type, String version, String secretKey);

  /**
   * 查询订单
   * @param priceRequest
   * @param vendorId
   * @param channel
   * @param version
   * @param secretKey
   * @return
   */
  PriceResponse queryOrder(OrderQueryRequest priceRequest, final String channel, final String type, String version, String secretKey);
}
