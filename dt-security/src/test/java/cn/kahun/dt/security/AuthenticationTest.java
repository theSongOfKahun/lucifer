package cn.kahun.dt.security;

import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationTest {

  @Test
  public void testSecurityContextHolder(){

    SecurityContext context = SecurityContextHolder.createEmptyContext();

    Authentication authentication = new TestingAuthenticationToken("username","password","ROLE_USER");

    context.setAuthentication(authentication);

    SecurityContextHolder.setContext(context);

  }

  @Test
  public void testAccessCurrentAuthenticatedUser(){

    SecurityContext securityContext = SecurityContextHolder.getContext();

    Authentication authentication = securityContext.getAuthentication();

    String username = authentication.getName();
    Object principal = authentication.getPrincipal();

    Collection<? extends GrantedAuthority> grantedAuthorityCollection = authentication.getAuthorities();
  }

}
