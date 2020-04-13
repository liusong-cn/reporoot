package com.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext application;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		if(arg0 != null){
			this.application = arg0;
			System.out.println("初始化应用上下文");
		}else{
			System.out.println("初始化应用上下文失败");
		}
	}

	public static ApplicationContext getContext(){return application;}
	
	/**
	 * <T>标记该方法是一个泛型方法，没有则不能使用泛型作为返回类型
	 * 目前还不理解T如何自动装箱成为需要的类型，待研究
	 * @param beanName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		 return (T)application.getBean(beanName);
	}
	
}
