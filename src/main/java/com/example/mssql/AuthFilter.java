package com.example.mssql;

import com.example.mssql.domain.User;
import org.apache.catalina.Session;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Order(1)
public class AuthFilter implements Filter {


    String password;
    String usrname;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        RequestDispatcher rdObj = null;


        HttpServletRequest request = (HttpServletRequest) servletRequest;

        User user = new User();

            if(request.getMethod().equals("GET")){
                System.out.println("you are not logged");

               filterChain.doFilter(servletRequest, servletResponse);



            }else if(request.getMethod().equals("POST")) {
            System.out.println("post");
            System.out.println(usrname = servletRequest.getParameter("username"));
            if (servletRequest.getParameter("username").equals("Admin")) {

                System.out.println("you are logged");
                request.getSession().setAttribute("LOGGED_USER", user);
                rdObj = servletRequest.getRequestDispatcher("/index");


                rdObj.include(servletRequest, servletResponse);

            }
        }

    }

    @Override
    public void destroy() {

    }
}
