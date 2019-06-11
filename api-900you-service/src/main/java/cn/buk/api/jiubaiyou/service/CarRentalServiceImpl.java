package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.PriceRequest;
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
  public void searchPrice(PriceRequest request, final String vendorId, final String channel,
      final String version, final String secretKey) {

    System.out.println("vendorId: " + vendorId);

    final String timestamp = DateUtil.formatDate(DateUtil.getCurDateTime(), "yyyyMMddHHmmss");
    System.out.println("timestamp: " + timestamp);

    final String jsonString = JSON.toJSONString(request);
//    final String jsonString = "{\"UseType\":1,\"PatternType\":1,\"CityCode\":\"2\",\"VehicleTypeList\":[1,2,3],\"DuseLocationLongitude\":\"121.145117\",\"DuseLocationLatitude\":\"31.321557\",\"AuseLocationAddress\":\"虹桥国际机场T1航站楼\",\"AuseLocationLongitude\":\"121.339766\",\"AuseLocationLatitude\":\"31.196099\",\"UseTime\":\"201906110900\",\"FixedCode\":\"SHA\",\"FromType\":0}";

    System.out.println("消息体明文：" + jsonString);

    final String encryptedBody;
    try {
      encryptedBody = DESUtil.encryptDES(jsonString, secretKey);
//      encryptedBody = "C556A38F5790A1D1EE462A6B1A35681234D2D645124A07D14BFA4B2EC2FDD9F8D9F34368B9E1DC55783DB75BDE31530214E272F881FDC9357AED34CF3FEFD97C34E40DDF2FBF7EFC2896A9F65B8F59BDFF9D4F74B92B15EB575FE9A2C4DA6D2947726737C28854FAEF19769DB7BAAA22E33ED1079A4A25D6D7DE39EF45486CD484233041D93BA930D8999605590D7D2FEA6F9E8E10B7799E13829F696C7D84E55026D12C24431B8B338569063C769877C25F10982E888834EE9FBB8F228FFFC2E10177E74940EC21BD6E7FD40B09401DE6A3FAE05D8D2EBBFEDD3887A5ECC400050F082EC02216459DF0D77423786C4E65FB174ADDB381C14D912541A742F2C2EC69D2EDC6DD7C01E774FEED7497CFC86DA3D008FC60B272051258A91028DACF5AF6608E009AC73747219666CE61026D8A4EC084E326637FB3BE8CED5A8DCAFE4BDF69F1377ED4F0";
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
    System.out.println("消息体密文：" + encryptedBody);

    final String temp = version  + timestamp + secretKey + encryptedBody.length();
    System.out.println("拼接内容: " + temp);


    //    MD5 签名将供应商 Id、请求时间戳、加密密钥、消息体长度字符串拼接之后 MD5 加密Auth =MD5(VendorID+TimeStamp+SecrectKey+{Envelope加密后内容}.Lenth) 转换为小写字符
    final String sign = VerifyCodeUtil.MD5(temp);
    System.out.println(sign);


//    http://api-emu.900etrip.com/openapi/shangyou/2019167/productquery/1.0/201906111403/af80dd4ae1736a54db28d18ab7f7433c

    final String API_URL = "http://api-emu.900etrip.com/openapi/shangyou/" + channel + "/productquery/" + version + "/" + timestamp + "/" + sign;

//    final String API_URL = "http://api-emu.900etrip.com/openapi/shangyou/2019167/productquery/1.0/201906111403/af80dd4ae1736a54db28d18ab7f7433c";
//                            http://api-emu.900etrip.com/openapi/shangyou/2019167/productquery/1.0/201906111403/af80dd4ae1736a54db28d18ab7f7433c
    System.out.println(API_URL);

    //调用接
    final String xml = HttpUtil.postUrl(API_URL, encryptedBody);
//    final String xml = HttpUtil.getUrl(API_URL, null);

    System.out.println(xml);


  }
}
