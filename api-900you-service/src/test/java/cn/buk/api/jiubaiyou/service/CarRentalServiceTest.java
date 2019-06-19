package cn.buk.api.jiubaiyou.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import cn.buk.api.jiubaiyou.dto.BaseResponse;
import cn.buk.api.jiubaiyou.dto.OrderCreateRequest;
import cn.buk.api.jiubaiyou.dto.OrderCreateResponse;
import cn.buk.api.jiubaiyou.dto.OrderInfoResponse;
import cn.buk.api.jiubaiyou.dto.OrderQueryRequest;
import cn.buk.api.jiubaiyou.dto.PriceRequest;
import cn.buk.api.jiubaiyou.dto.PriceResponse;
import cn.buk.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class CarRentalServiceTest {

  private final String secretKey = "12345678";

  private CarRentalService service;

  //目前给的测试环境的
  private final String channel = "shangyou";
  private final String type = "p2p";
  private final String version = "1.0";

  //租车订单号
  private final String rentalOrderNo = "1234567890";


  @BeforeEach
  void setUp() {
    service = new CarRentalServiceImpl();
  }

  @Test
  void test_searchPrice() {
    PriceRequest priceRequest = new PriceRequest();
    priceRequest.setUseType(1);
    priceRequest.setPatternType(1);
    priceRequest.setFixedCode("PVG");
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
    assertEquals("5AD93BE3A5A984CB18D40412869B9B96", response.getPriceMark());
//    E45BAB29364A25EC18A88A87726A0F3D
    //D71831E120BCCAE5F283A19E50B1BB3B
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
    request.setOrderNo(rentalOrderNo);
    request.setVehicleType(1);

    request.setPrice(160.64);
    request.setPriceMark("TEST");

    request.setMobile("18888889999");

    //TODO 此处有些问题，目前传送的参数明显是错误的，但是系统返回了，明天问问什么含义

    OrderCreateResponse response = service.createOrder(request, channel, type, version, secretKey);

    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());
    assertEquals("OK", response.getMessage());
    assertEquals("8952875", response.getEtripOrderID());


  }

  @Test
  void test_queryOrder() {
    OrderQueryRequest request = new OrderQueryRequest();
    request.setThirdOrderId(rentalOrderNo);

    OrderInfoResponse response = service.queryOrder(request, channel, type, version, secretKey);
//
    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());
    assertEquals(3, response.getOrderStatus());
  }

  @Test
  void test_cancelOrder() {
    OrderQueryRequest request = new OrderQueryRequest();
    request.setThirdOrderId(rentalOrderNo);

    BaseResponse response = service.cancelOrder(request, channel, type, version, secretKey);
//
    assertNotNull(response);

    assertEquals("ERROR", response.getMsgCode());
    assertEquals("订单已取消", response.getMessage());
  }

  @Test
  void test_queryDriverLocation() {
    OrderQueryRequest request = new OrderQueryRequest();
    request.setEtripOrderId("8952875");

    BaseResponse response = service.queryDriverLocation(request, channel, type, version, secretKey);
//
    assertNotNull(response);

    assertEquals("ERROR", response.getMsgCode());
    assertEquals("订单已取消", response.getMessage());
  }

}