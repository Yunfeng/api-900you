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

  //目前给的测试环境的
  private final String channel = "shangyou";
  private final String type = "p2p";
  private final String version = "1.0";


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


    PriceResponse response = service.searchPrice(priceRequest, channel, type, version, secretKey);

    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());
  }

  @Test
  void test_createOrder() {
    OrderCreateRequest request = new OrderCreateRequest();
    request.setUseType(1);
    request.setPatternType(2);
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
    request.setOrderNo("12345679");
    request.setVehicleType(1);

    request.setPrice(160.64);

    request.setMobile("18888889999");

    //TODO 此处有些问题，目前传送的参数明显是错误的，但是系统返回了，明天问问什么含义

    PriceResponse response = service.createOrder(request, channel, type, version, secretKey);

    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());

//    {"EtripOrderId":"3373768","MsgCode":"OK","Message":"OK"}
  }

  @Test
  void test_queryOrder() {
    OrderQueryRequest request = new OrderQueryRequest();
    request.setThirdOrderId("12345679");


    PriceResponse response = service.queryOrder(request, channel, type, version, secretKey);
//
    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());

//    {"ServiceOrderId":"9630898","MsgCode":"OK","Message":"OK"}
  }

}