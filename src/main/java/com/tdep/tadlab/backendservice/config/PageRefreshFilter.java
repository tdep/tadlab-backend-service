//package com.tdep.tadlab.backendservice.config;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PageRefreshFilter implements Filter {
//  private static final String PAGE = "/pagerefresh/pagerefresh.html";
//  @Override
//  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//    doFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
//  }
//  private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//    String path = request.getServletPath();
//    if ("/".equals(path) || path.contains(".") || path.contains("tdep")) {
//      chain.doFilter(request, response);
//    } else {
//      request.getRequestDispatcher(PAGE).forward(request, response);
//    }
//  }
//}
