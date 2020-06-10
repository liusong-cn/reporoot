package com.filter;

import org.jasig.cas.client.util.AssertionHolder;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: ls
 * @date: 2020/5/24 0024 23:11
 */
public class CasFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userName = AssertionHolder.getAssertion().getPrincipal().getName();
        System.out.println(userName);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
