package com.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpSession session = req.getSession();
		HttpServletResponse res = (HttpServletResponse) arg1;
		//模拟地址白名单
		if(req.getRequestURI().contains("index.jsp") || req.getRequestURI().contains("test.jsp") || req.getRequestURI().contains("testController") ||(req.getRequestURI().contains("loginController") && req.getQueryString().contains("doLogin"))){
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		if(req.getParameter("token")!= null && !req.getParameter("token").equals("")){
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		if(session.getAttribute("isLogin")!= null && (boolean)session.getAttribute("isLogin")){
			arg2.doFilter(arg0, arg1);
			return;
		}else {
			System.out.println("跳转至原系统登录页面");
			//res.sendRedirect("http://localhost:7088/fd-offline/loginController.do?login");
			res.sendRedirect("http://localhost:8095/springDemo/webpage/test.jsp");
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("系统启动时初始化filter");
	}

}
