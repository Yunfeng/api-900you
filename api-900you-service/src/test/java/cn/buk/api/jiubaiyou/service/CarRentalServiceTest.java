package cn.buk.api.jiubaiyou.service;

import cn.buk.api.jiubaiyou.dto.PriceRequest;
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

    service.searchPrice(priceRequest, secretKey);
  }
}