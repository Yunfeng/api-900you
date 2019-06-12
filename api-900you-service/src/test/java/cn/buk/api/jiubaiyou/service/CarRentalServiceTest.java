package cn.buk.api.jiubaiyou.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import cn.buk.api.jiubaiyou.dto.OrderCreateRequest;
import cn.buk.api.jiubaiyou.dto.OrderQueryRequest;
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
  void test_searchPrice() {
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

    assertEquals("OK", response.getMsgCode());
  }

  @Test
  void test_createOrder() {
    OrderCreateRequest request = new OrderCreateRequest();
    request.setUseType(1);
    request.setPatternType(1);
    request.setFixedCode("SHA");
    request.setCityCode("2");

    request.setDuseLocationAddress("静安寺");
    request.setDuseLocationLongitude("121.145117");
    request.setDuseLocationLatitude("31.321557");

    request.setAuseLocationAddress("虹桥国际机场T1航站楼");
    request.setAuseLocationLongitude("121.339766");
    request.setAuseLocationLatitude("31.196099");

    request.setUseTime(DateUtil.addDays(DateUtil.getCurDateTime(), 1));
//    request.setOrderId("ABCDEFG");
    request.setOrderId(12345679l);
    request.setVehicleType(1);

    request.setMobile("18888889999");

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

    //TODO 此处有些问题，目前传送的参数明显是错误的，但是系统返回了，明天问问什么含义

    PriceResponse response = service.createOrder(request, vendorId, channel, version, secretKey);

    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());

//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
  }

  @Test
  void test_queryOrder() {
    final String vendorId = "";
    final String version = "1.0";
    //目前给的测试环境的
    final String channel = "2019167";

    OrderQueryRequest request = new OrderQueryRequest();
    request.setOrderID(9630898);


    PriceResponse response = service.queryOrder(request, vendorId, channel, version, secretKey);
//
    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());

//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
  }

}