package cn.buk.api.jiubaiyou.util;

import org.junit.jupiter.api.Test;

class HexUtilTest {

  @Test
  public void test() {
    String str = "test";
    System.out.println("test string : "+str);

    String hexEncode = HexUtil.encode(str.getBytes());
    System.out.println("HexUtil.encode Result : "+hexEncode);

    byte[] bytes = HexUtil.decode(hexEncode);
    System.out.println("HexUtil.decode Result : "+new String(bytes));


  }
}