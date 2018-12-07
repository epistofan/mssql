package com.example.mssql.SecurityFilters;

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


        if(request.getSession().getAttribute("LOGGED_USER") != null){
            rdObj = servletRequest.getRequestDispatcher("start");
            rdObj.include(servletRequest, servletResponse);
        }else { rdObj = servletRequest.getRequestDispatcher("index");
            rdObj.include(servletRequest, servletResponse);

        }

        //call next filter in the filter chain
       // filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
