package cn.buk.api.jiubaiyou.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

class OrderCreateResponseTest {

  @Test
  public void test() {
    final String jsonStr = "{\"ServiceOrderId\":\"9630898\",\"MsgCode\":\"OK\",\"Message\":\"OK\"}";

    OrderCreateResponse response = JSON.parseObject(jsonStr, OrderCreateResponse.class);

    assertNotNull(response);

    assertEquals("OK", response.getMsgCode());
    assertEquals("OK", response.getMessage());
    assertEquals("9630898", response.getServiceOrderId());
  }
}