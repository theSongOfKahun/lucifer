package cn.kahun.dt.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author libo
 * @date 2020/3/9 21:02
 * @description 记得写注释
 */
public class PasswordEncodingTest {

  private String rawPassword = "123456q";

  private PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

  @Test
  public void testPasswordEncoder(){


    String password = delegatingPasswordEncoder.encode(rawPassword);

    System.out.println(password);

    Assertions.assertTrue(delegatingPasswordEncoder.matches(rawPassword,password));

  }

  @Test
  public void testSHA256(){

    String encodedAlgorithm = "SHA-256";

    String encoderId = "{"+encodedAlgorithm+"}";

    PasswordEncoder sha256PasswordEncoder = new MessageDigestPasswordEncoder(encodedAlgorithm);

    String encodedPassword = sha256PasswordEncoder.encode(rawPassword);

    System.out.println(encodedPassword);

    Assertions.assertTrue(delegatingPasswordEncoder.matches(rawPassword,encoderId + encodedPassword));

  }

}
