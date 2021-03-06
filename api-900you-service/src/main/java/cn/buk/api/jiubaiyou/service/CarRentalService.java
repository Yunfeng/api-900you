package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.BaseResponse;
import cn.buk.api.jiubaiyou.dto.OrderCreateRequest;
import cn.buk.api.jiubaiyou.dto.OrderCreateResponse;
import cn.buk.api.jiubaiyou.dto.OrderInfoResponse;
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
   * @param channel 通道
   * @param type 通道
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
   * @param channel
   * @param type 通道
   * @param version
   * @param secretKey
   * @return
   */
  OrderCreateResponse createOrder(OrderCreateRequest priceRequest, final String channel, final String type, String version, String secretKey);

  /**
   * 查询订单
   * @param request
   * @param channel
   * @param type 通道
   * @param version
   * @param secretKey
   * @return
   */
  OrderInfoResponse queryOrder(OrderQueryRequest request, final String channel, final String type, String version, String secretKey);

  /**
   * 取消订单
   * @param request
   * @param channel 通道
   * @param type
   * @param version
   * @param secretKey
   * @return
   */
  BaseResponse cancelOrder(OrderQueryRequest request, final String channel, final String type, String version, String secretKey);

  /**
   * 司机位置查询接口
   * @param request
   * @param channel
   * @param type
   * @param version
   * @param secretKey
   * @return
   */
  BaseResponse queryDriverLocation(OrderQueryRequest request, String channel, String type, String version, String secretKey);
}
