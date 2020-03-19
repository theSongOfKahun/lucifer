package cn.kahun.dt.security;

import org.junit.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author libo
 * @date 2020/3/9 22:11
 * @description 记得写注释
 */
public class SecurityContextHolderTest {

  @Test
  public void testSet(){

    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

    Authentication authentication = new TestingAuthenticationToken("username","password","ROLE_USER");

    securityContext.setAuthentication(authentication);

    SecurityContextHolder.setContext(securityContext);

  }

}
