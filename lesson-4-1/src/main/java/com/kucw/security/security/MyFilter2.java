package com.kucw.security.security;

import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFilter2 extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    System.out.println("執行 MyFilter 2");
    String url = request.getRequestURI();

    if (url.equals("/hello")) {
      System.out.println("path = hello 通過");
      filterChain.doFilter(request, response);
    } else {
      System.out.println("path 不是 hello");
      response.setStatus(500);
    }
  }
}
