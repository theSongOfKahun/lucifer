package cn.kahun.sa.framework.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @create: 2020/4/7 4:11 下午
 * @author: liboah
 * @description: 记得写注释。。。
 **/
@DisplayName("a special test case")
public class DisplayNameTest {

  @Test
  @DisplayName("Custom test name containing spaces")
  void testWithDisplayNameContainingSpaces() {
  }

  @Test
  @DisplayName("╯°□°）╯")
  void testWithDisplayNameContainingSpecialCharacters() {
  }

  @Test
  @DisplayName("😱")
  void testWithDisplayNameContainingEmoji() {
  }


}
