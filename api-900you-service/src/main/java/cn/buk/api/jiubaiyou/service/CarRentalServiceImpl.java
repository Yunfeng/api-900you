package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.BaseResponse;
import cn.buk.api.jiubaiyou.dto.OrderCreateRequest;
import cn.buk.api.jiubaiyou.dto.OrderCreateResponse;
import cn.buk.api.jiubaiyou.dto.OrderInfoResponse;
import cn.buk.api.jiubaiyou.dto.OrderQueryRequest;
import cn.buk.api.jiubaiyou.dto.PriceRequest;
import cn.buk.api.jiubaiyou.dto.PriceResponse;
import cn.buk.api.jiubaiyou.util.DESUtil;
import cn.buk.api.jiubaiyou.util.HttpUtil;
import cn.buk.util.DateUtil;
import cn.buk.util.VerifyCodeUtil;
import com.alibaba.fastjson.JSON;

/**
 * @author yfdai
 * @date 2019-06-08
 */
public class CarRentalServiceImpl implements CarRentalService {

  @Override
  public PriceResponse searchPrice(PriceRequest request, final String channel, final String type,
      final String version, final String secretKey) {

    final String content = JSON.toJSONString(request);

    String responseStr = execApiRequest("productquery", content, channel, type, version, secretKey);

    return JSON.parseObject(responseStr, PriceResponse.class);
  }

  @Override
  public OrderCreateResponse createOrder(OrderCreateRequest request, String channel, String type,
      String version, String secretKey) {

    final String content = JSON.toJSONString(request);

    String responseStr = execApiRequest("ordercreate", content, channel, type, version, secretKey);

    return JSON.parseObject(responseStr, OrderCreateResponse.class);
  }

  @Override
  public OrderInfoResponse queryOrder(OrderQueryRequest request, final String channel, final String type,
      String version, String secretKey) {
    final String content = JSON.toJSONString(request);

    String responseStr = execApiRequest("orderquery", content, channel, type, version, secretKey);

    return JSON.parseObject(responseStr, OrderInfoResponse.class);
  }

  /**
   * 取消订单
   * @param request
   * @param channel
   * @param type
   * @param version
   * @param secretKey
   * @return
   */
  @Override
  public BaseResponse cancelOrder(OrderQueryRequest request, String channel,
      String type, String version, String secretKey) {
    final String content = JSON.toJSONString(request);

    String responseStr = execApiRequest("ordercancel", content, channel, type, version, secretKey);

    return JSON.parseObject(responseStr, BaseResponse.class);
  }

  @Override
  public BaseResponse queryDriverLocation(OrderQueryRequest request, String channel, String type,
      String version, String secretKey) {
    final String content = JSON.toJSONString(request);

    String responseStr = execApiRequest("querydriverlocation", content, channel, type, version, secretKey);

    return JSON.parseObject(responseStr, BaseResponse.class);
  }

  private String execApiRequest(final String apiName, final String content, final String channel, final String type, final String version, final String secretKey) {
    final String timestamp = DateUtil.formatDate(DateUtil.getCurDateTime(), "yyyyMMddHHmmss");

    System.out.println("消息体明文：" + content);

    final String encryptedBody;
    try {
      encryptedBody = DESUtil.encryptDES(content, secretKey);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
//    System.out.println("消息体密文：" + encryptedBody);

    final String temp = version  + timestamp + secretKey + encryptedBody.length();
//    System.out.println("拼接内容: " + temp);


    //    MD5 签名将供应商 Id、请求时间戳、加密密钥、消息体长度字符串拼接之后 MD5 加密Auth =MD5(VendorID+TimeStamp+SecrectKey+{Envelope加密后内容}.Lenth) 转换为小写字符
    final String sign = VerifyCodeUtil.MD5(temp);
//    System.out.println(sign);


    final String API_URL = "http://api-emu.900etrip.com/" + channel + "/" + type + "/" + apiName + "/" + version + "/" + timestamp + "/" + sign;
//    System.out.println(API_URL);

    //调用接口
    final String result = HttpUtil.postUrl(API_URL, encryptedBody);
    System.out.println(result);

    return result;
  }
}
