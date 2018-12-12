package com.example.mssql.SecurityFilters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/start/*")
public class CustomFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher rdObj = null;


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getSession().getAttribute("LOGGED_USER") != null){

            rdObj = servletRequest.getRequestDispatcher("/start");
            rdObj.forward(servletRequest, servletResponse);
        }else {
            response.sendRedirect("/index");
           // rdObj = servletRequest.getRequestDispatcher("/index");
           // rdObj.forward(servletRequest, servletResponse);

        }

        //call next filter in the filter chain
       //filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
