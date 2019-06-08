package cn.buk.api.jiubaiyou.dto;

import static org.junit.jupiter.api.Assertions.*;

import cn.buk.util.DateUtil;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

class PriceRequestTest {

  @Test
  public void test() {
    final String jsonStr = "{\"UseType\":1,\"PatternType\":1,\"VehicleTypeList\":[51],\"DuseLocation\":{\"Address\":\"樟宜机场\",\"DetailAddress\":\"樟宜机场\",\"Longitude\":103.991531,\"Latitude\":1.36442},\"AuseLocation\":{\"Address\":\"新加坡洲际酒店(Intercontinental Singapore)\",\"DetailAddress\":\"80Mid dleRd\",\"Longitude\":103.85626,\"Latitude\":1.297311},\"UseTime\":\"2016-04-05 23:05\",\"FixedCode\":\"SIN\"}";

    PriceRequest obj = JSON.parseObject(jsonStr, PriceRequest.class);

    assertNotNull(obj);

    assertEquals(1, obj.getUseType());
    assertEquals(1, obj.getPatternType());
    assertEquals(1, obj.getVehicleTypes().length);
    assertEquals(51, obj.getVehicleTypes()[0]);
    assertEquals("2016-04-05 23:05", DateUtil.formatDate(obj.getUseTime(), "yyyy-MM-dd HH:mm"));
    assertEquals("SIN", obj.getFixedCode());


    assertNotNull(obj.getDuseLocation());
    Location d = obj.getDuseLocation();
    assertEquals("樟宜机场", d.getAddress());
    assertEquals("樟宜机场", d.getDetailAddress());
    assertEquals(103.991531, d.getLongitude());
    assertEquals(1.36442, d.getLatitude());


    assertNotNull(obj.getAuseLocation());
    Location a = obj.getAuseLocation();
    assertEquals("新加坡洲际酒店(Intercontinental Singapore)", a.getAddress());
    assertEquals("80Mid dleRd", a.getDetailAddress());
    assertEquals(103.85626, a.getLongitude());
    assertEquals(1.297311, a.getLatitude());



  }
}