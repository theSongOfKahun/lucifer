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

