package cn.buk.api.jiubaiyou.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

class PriceResponseTest {

  @Test
  public void test() {
    final String jsonStr = "{\"MsgCode\":\"OK\",\"OtherPriceDetail\":{\"QueryResultList\":[{\"VehicleType\":1,\"Price\":188.64}]}}";

    PriceResponse obj = JSON.parseObject(jsonStr, PriceResponse.class);

    assertNotNull(obj);

    assertEquals("OK", obj.getMsgCode());
    assertEquals(null, obj.getMessage());
    assertEquals(null, obj.getPriceMark());

    assertNotNull(obj.getOtherPriceDetail());

    assertNotNull(obj.getOtherPriceDetail().getQueryResultList());
    assertEquals(1, obj.getOtherPriceDetail().getQueryResultList().size());
    assertEquals(1, obj.getOtherPriceDetail().getQueryResultList().get(0).getVehicleType());
    assertEquals(188.64, obj.getOtherPriceDetail().getQueryResultList().get(0).getPrice());
  }
}