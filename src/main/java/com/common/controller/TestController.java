package com.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.common.test.People;
import com.common.util.ApplicationContextUtil;
import com.run.IProxy;
import com.run.IRun;
import com.run.Logger;
import com.run.MyRun;

@Controller
@RequestMapping("/testController")
public class TestController {
	
	/*@Autowired
	private IRun myRun;*/
	
	//@Autowired
	//private IProxy myProxy;

	/**
	 * 测试注解功能是否生效
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(params="goPage")
	public ModelAndView goPage(HttpServletRequest req, HttpServletResponse res){
		String param = req.getParameter("param");
		String url = "";
		if(StringUtils.isEmpty(param)){
			url = "test";
		}else{
			url = "com/common/mix";
		}
		
		People p = ApplicationContextUtil.getBean("people");
		p.eat();
	//System.out.println(ApplicationContextUtil.getBean("myRun").getClass());
		//IRun run = ApplicationContextUtil.getBean("myRun");
		//myProxy.doProxy();
		
		return new ModelAndView(url);
	}
	
	@ResponseBody
	@RequestMapping(params = "doSessionTest")
	public void doSessionTest(HttpServletRequest req, HttpServletResponse res){
		String sessionId = req.getSession().getId();
		
	}
}
