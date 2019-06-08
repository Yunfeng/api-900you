package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.PriceRequest;
import cn.buk.util.DateUtil;
import cn.buk.util.VerifyCodeUtil;
import com.alibaba.fastjson.JSON;

/**
 * @author yfdai
 * @date 2019-06-08
 */
public class CarRentalServiceImpl implements CarRentalService {

  @Override
  public void searchPrice(PriceRequest request, final String secretKey) {
    final String timestamp = DateUtil.formatDate(DateUtil.getCurDateTime(), "yyyyMMddHHmmss");
    final String vendorId = "13593";
    final String version = "1.0";
    final String channel = "OCH";

    final String jsonString = JSON.toJSONString(request);
    System.out.println(jsonString);

    final String temp = vendorId + version + channel + timestamp + secretKey + jsonString.length();
    System.out.println(temp);

    final String sign = VerifyCodeUtil.MD5(temp);
    System.out.println(sign);




//    final String API_URL = "http://api-emu.900etrip.com/JNT/1.0/" + timestamp + "/" + sign;
//    String temp = "VETECH" + businessNo + operateTime.replace(" ", "") + privateKey;
//    final String signKey = VerifyCodeUtil.MD5(temp);
//
//    List<NameValuePair> params = new ArrayList<>();
//    params.add(new BasicNameValuePair("businessNo", businessNo));
//    params.add(new BasicNameValuePair("signKey", signKey));
//    params.add(new BasicNameValuePair("operateTime", operateTime.replace(" ", "")));
//    params.add(new BasicNameValuePair("exporttype", exportType));
//
//    //调用接口，返回XML字符串
//    final String xml = HttpUtil.getUrl(API_URL + "?", params);
//
//    if (xml != null) {
//
//      if (EXPORT_TYPE_ADD.equalsIgnoreCase(exportType)) {
////                System.out.println(xml);
//      }
//
//      //转化为对应的对象
//      XStream xs = BaseFactory.createXStream(true);
//      xs.processAnnotations(PolicyResponse.class);
//
//      return (PolicyResponse) xs.fromXML(xml);
//    } else {
//      return null;
//    }
  }
}
