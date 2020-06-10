package com.interceptor;

import com.common.util.ApplicationContextUtil;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author: ls
 * @date: 2020/5/22 0022 10:46
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String userName = AssertionHolder.getAssertion().getPrincipal().getName();
//        System.out.println(userName);
//        String[] beanNames = ApplicationContextUtil.getContext().getBeanDefinitionNames();
//        Arrays.asList(beanNames).forEach(System.out::println);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
