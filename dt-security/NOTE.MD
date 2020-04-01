# Spring Security

## 1.Spring Boot Auto Configuration

* Enable Spring Security's default configuration, which create a servlet `Filter` named 
`springSecurityFilterChain`.This bean is responsible for all the security within your application.
* Creates a `UserDetailService` bean with a username of a user and randomly generated password
that is logged on the console.
* Registers the `Filter` with a bean named `SpringSecurityFilterChain` with the Servlet container 
for every request.

## 2.Core Components

`SecurityContextHolder`：存储当前应用安全上下文的详细信息，提供对`SecurityContext`的访问

`SecurityContext`：持有`Authentication`

`Authentication`：保存主体

`GrantedAuthrity`：授权对象

`UserDetails`：主体

`UserDetailsService`：主体获取服务

## 3.Authentication



`Using generated security password: 5b9d48e6-3bd9-45dc-ae1b-b4a25764011e`

```
Creating filter chain: any request
org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@2a2ef072, 
org.springframework.security.web.context.SecurityContextPersistenceFilter@1894593a, 
org.springframework.security.web.header.HeaderWriterFilter@a0db585, 
org.springframework.security.web.csrf.CsrfFilter@1702830d, 
org.springframework.security.web.authentication.logout.LogoutFilter@7e744f43, 
org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@1e86a5a7, 
org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@52169758, 
org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@704641e3, 
org.springframework.security.web.authentication.www.BasicAuthenticationFilter@9fc9f91, 
org.springframework.security.web.savedrequest.RequestCacheAwareFilter@10823d72, 
org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@73010765, 
org.springframework.security.web.authentication.AnonymousAuthenticationFilter@2f00f851, 
org.springframework.security.web.session.SessionManagementFilter@3d37203b, 
org.springframework.security.web.access.ExceptionTranslationFilter@7c8d5312, 
org.springframework.security.web.access.intercept.FilterSecurityInterceptor@496a31da
```

