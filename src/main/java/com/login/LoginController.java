package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/loginController")
public class LoginController {
	
	@RequestMapping(params = "validateLogin")
	public ModelAndView validateLogin(HttpServletRequest req,HttpServletResponse res){
		String token = req.getParameter("token");
		if(token != "" && token != null){
			/* //req.getSession().getAttribute(token);
			try {
				res.sendRedirect("http://localhost:7088/fd-offline/schemeBaseController.do?goPage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			/*try {
				PrintWriter pw = res.getWriter();
				pw.write((String)req.getSession().getAttribute(token));
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				
			}*/
			
			
		}
		return new ModelAndView("datagrid/datagrid");
	}

	/**
	 * 测试jrebel时使用
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "goTest")
	public ModelAndView goTest(HttpServletRequest req){
		return new ModelAndView("com/common/mix");
	}
	
	@RequestMapping(params = "doLogin")
	public void doLogin(HttpServletRequest req,HttpServletResponse res){
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		//假设用户名和密码都正确,并进行下一步操作
		String token = UUID.randomUUID().toString();
		req.getSession().setAttribute(token, "true");
		req.getSession().setAttribute("isLogin", true);
		try {
			PrintWriter pw = res.getWriter();
			res.setCharacterEncoding("UTF-8");
			res.setHeader("Cache-Control", "no-store");
			res.setContentType("application/json");
			res.setHeader("Cache-Control", "no-store");
			pw.write("{\"success\":\"true\",\"token\":\"" + token + "\"}");
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 此种方式以string形式返回ajax请求的响应体，且响应体为文本
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "testXMLRequest")
	@ResponseBody
	public String testXMLRequest(HttpServletRequest req) {
		return "hello";
		
	}
	
}
