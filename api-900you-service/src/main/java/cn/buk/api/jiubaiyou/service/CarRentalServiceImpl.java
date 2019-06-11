package cn.buk.api.jiubaiyou.service;

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
  public PriceResponse searchPrice(PriceRequest request, final String vendorId, final String channel,
      final String version, final String secretKey) {

    final String content = JSON.toJSONString(request);

    String responseStr = execApiRequest("productquery", content, vendorId, channel, version, secretKey);

    return JSON.parseObject(responseStr, PriceResponse.class);
  }

  @Override
  public PriceResponse createOrder(PriceRequest request, String vendorId, String channel,
      String version, String secretKey) {
    System.out.println("vendorId: " + vendorId);

    final String timestamp = DateUtil.formatDate(DateUtil.getCurDateTime(), "yyyyMMddHHmmss");
    System.out.println("timestamp: " + timestamp);

    final String jsonString = JSON.toJSONString(request);
    System.out.println("消息体明文：" + jsonString);

    final String encryptedBody;
    try {
      encryptedBody = DESUtil.encryptDES(jsonString, secretKey);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    System.out.println("消息体密文：" + encryptedBody);

    final String temp = version  + timestamp + secretKey + encryptedBody.length();
    System.out.println("拼接内容: " + temp);


    //    MD5 签名将供应商 Id、请求时间戳、加密密钥、消息体长度字符串拼接之后 MD5 加密Auth =MD5(VendorID+TimeStamp+SecrectKey+{Envelope加密后内容}.Lenth) 转换为小写字符
    final String sign = VerifyCodeUtil.MD5(temp);
    System.out.println(sign);


    final String API_URL = "http://api-emu.900etrip.com/openapi/shangyou/" + channel + "/ordercreate/" + version + "/" + timestamp + "/" + sign;
    System.out.println(API_URL);

    //调用接
    final String result = HttpUtil.postUrl(API_URL, encryptedBody);
    System.out.println(result);

    return JSON.parseObject(result, PriceResponse.class);
  }

  @Override
  public PriceResponse queryOrder(OrderQueryRequest request, String vendorId, String channel,
      String version, String secretKey) {
    System.out.println("vendorId: " + vendorId);

    final String timestamp = DateUtil.formatDate(DateUtil.getCurDateTime(), "yyyyMMddHHmmss");
    System.out.println("timestamp: " + timestamp);

    final String jsonString = JSON.toJSONString(request);
    System.out.println("消息体明文：" + jsonString);

    final String encryptedBody;
    try {
      encryptedBody = DESUtil.encryptDES(jsonString, secretKey);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    System.out.println("消息体密文：" + encryptedBody);

    final String temp = version  + timestamp + secretKey + encryptedBody.length();
    System.out.println("拼接内容: " + temp);


    //    MD5 签名将供应商 Id、请求时间戳、加密密钥、消息体长度字符串拼接之后 MD5 加密Auth =MD5(VendorID+TimeStamp+SecrectKey+{Envelope加密后内容}.Lenth) 转换为小写字符
    final String sign = VerifyCodeUtil.MD5(temp);
    System.out.println(sign);


    final String API_URL = "http://api-emu.900etrip.com/openapi/shangyou/" + channel + "/orderquery/" + version + "/" + timestamp + "/" + sign;
    System.out.println(API_URL);

    //调用接
    final String result = HttpUtil.postUrl(API_URL, encryptedBody);
    System.out.println(result);

    return JSON.parseObject(result, PriceResponse.class);
  }

  private String execApiRequest(final String apiName, final String content, final String vendorId, final String channel, final String version, final String secretKey) {
    System.out.println("vendorId: " + vendorId);
    final String timestamp = DateUtil.formatDate(DateUtil.getCurDateTime(), "yyyyMMddHHmmss");
    System.out.println("timestamp: " + timestamp);

    System.out.println("消息体明文：" + content);

    final String encryptedBody;
    try {
      encryptedBody = DESUtil.encryptDES(content, secretKey);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    System.out.println("消息体密文：" + encryptedBody);

    final String temp = version  + timestamp + secretKey + encryptedBody.length();
    System.out.println("拼接内容: " + temp);


    //    MD5 签名将供应商 Id、请求时间戳、加密密钥、消息体长度字符串拼接之后 MD5 加密Auth =MD5(VendorID+TimeStamp+SecrectKey+{Envelope加密后内容}.Lenth) 转换为小写字符
    final String sign = VerifyCodeUtil.MD5(temp);
    System.out.println(sign);


    final String API_URL = "http://api-emu.900etrip.com/openapi/shangyou/" + channel + "/" + apiName + "/" + version + "/" + timestamp + "/" + sign;
    System.out.println(API_URL);

    //调用接
    final String result = HttpUtil.postUrl(API_URL, encryptedBody);
    System.out.println(result);

    return result;
  }
}
