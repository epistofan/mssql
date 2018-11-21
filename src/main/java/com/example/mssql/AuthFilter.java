package com.example.mssql;

import org.apache.catalina.Session;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Order(1)
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher rdObj = null;


        HttpServletRequest request = (HttpServletRequest) servletRequest;
       if((request.getSession().getAttribute("LOGGED_USER"))== null){

          System.out.println("you are not logged");
           System.out.println(servletRequest.getLocale());
           rdObj = servletRequest.getRequestDispatcher("/login");
           rdObj.include(servletRequest, servletResponse);
       }else{
           System.out.println("you are logged");
           rdObj = servletRequest.getRequestDispatcher("/main");
           rdObj.include(servletRequest, servletResponse);
       }

        //call next filter in the filter chain
      // filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
