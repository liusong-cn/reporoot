package com.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: ls
 * @date: 2020/4/13 0013 10:39
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //super.doGet(req, resp);
        String s = req.getRequestURI();
        System.out.println(s);
        resp.sendRedirect("/spring/index.jsp");
    }
}
