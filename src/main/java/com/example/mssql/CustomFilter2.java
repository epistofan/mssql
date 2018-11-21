package com.example.mssql;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(2)
public class CustomFilter2 implements Filter {
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
