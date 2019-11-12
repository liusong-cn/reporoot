package com.learning.test.charpter15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied) {
		// TODO Auto-generated constructor stub
		this.proxied =  proxied;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		//此处传进来proxy是因为一般需要代理对象做额外的事情
		System.out.println(proxy.getClass());
		//调用被代理对象的方法执行被代理对象的本身任务
		return method.invoke(proxied, args);
	}

}
