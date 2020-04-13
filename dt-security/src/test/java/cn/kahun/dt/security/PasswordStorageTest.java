package cn.kahun.dt.security;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author libo
 * @date 2020/3/9 21:02
 * @description 记得写注释
 */
public class PasswordStorageTest {

  @Test
  public void testPasswordEncoder(){

    String rawPassword = "123456q";

    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    String password = passwordEncoder.encode(rawPassword);

    System.out.println(password);

    System.out.println(passwordEncoder.matches(rawPassword,password));

  }

}
