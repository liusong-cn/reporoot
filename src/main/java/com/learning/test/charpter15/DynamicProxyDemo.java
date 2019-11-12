package com.learning.test.charpter15;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
	
	public static void main(String[] args) {
		
		RealObject ro = new RealObject();
		//动态代理不需要代理对象直接重写被代理对象所实现的接口
		//而是在动态代理处理器上做了处理，这样每个被代理的对象通过动态代理处理器都可以做额外的事情
		//继而在生成的动态代理对象上调用原接口的方法时都会转为调用处理器所实现的方法
		Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[] {Interface.class}, new DynamicProxyHandler(ro));
		proxy.doOtherthing();
		proxy.doOtherthing();
	}
}
