package cn.buk.api.jiubaiyou.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import cn.buk.api.jiubaiyou.dto.PriceRequest;
import cn.buk.api.jiubaiyou.dto.PriceResponse;
import cn.buk.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarRentalServiceTest {

  private final String secretKey = "12345678";

  private CarRentalService service;

  @BeforeEach
  void setUp() {
    service = new CarRentalServiceImpl();
  }

  @Test
  void searchPrice() {

    PriceRequest priceRequest = new PriceRequest();
    priceRequest.setUseType(1);
    priceRequest.setPatternType(1);
    priceRequest.setFixedCode("SHA");
    priceRequest.setCityCode("2");

    priceRequest.setDuseLocationAddress("静安寺");
    priceRequest.setDuseLocationLongitude("121.145117");
    priceRequest.setDuseLocationLatitude("31.321557");

    priceRequest.setAuseLocationAddress("虹桥国际机场T1航站楼");
    priceRequest.setAuseLocationLongitude("121.339766");
    priceRequest.setAuseLocationLatitude("31.196099");

    priceRequest.setUseTime(DateUtil.getCurDateTime());

//    测试环境
//    VendorID：为空
//    Version：1.0
//    Channel: 为空
//    TimeStamp：当前时间
//    secrect Key: 12345678  （测试环境固定为12345678）

    final String vendorId = "";
    final String version = "1.0";
    //目前给的测试环境的
    final String channel = "2019167";


    PriceResponse response = service.searchPrice(priceRequest, vendorId, channel, version, secretKey);

    assertNotNull(response);
  }
}