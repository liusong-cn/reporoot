package com.glaway.offline.wssupport.iface;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class MyTest {
	public static void main(String[] args) {
		//基于jax-ws的动态代理方式，参考官方文档
		JaxWsDynamicClientFactory dcf1 = JaxWsDynamicClientFactory.newInstance();
		String wsdlurl1 = "http://192.168.18.1:7088/fd-offline/support/testFileUpload?wsdl";
		String method1 = "uploadFile";
		//调用的方法若有命名空间则需要qname，否则不需要
		QName name1 = new QName("http://iface.wssupport.offline.glaway.com/", method1);
		Client client1 = dcf1.createClient(wsdlurl1);
		Object[] res1 = null;
		try {
			Object resume1 = Thread.currentThread().getContextClassLoader().loadClass("com.glaway.offline.wssupport.iface").newInstance();
			Method m1 = resume1.getClass().getMethod("setCandidateName", String.class);
			Method m2 = resume1.getClass().getMethod("setResumeFileType", String.class);
			Method m3 = resume1.getClass().getMethod("setResume", DataHandler.class);
			m1.invoke(resume1, "ceshiwenjian");
			m2.invoke(resume1, "txt");
			m3.invoke(resume1, new DataHandler(new FileDataSource(new File("d://text.txt"))));
			res1 = client1.invoke(name1, resume1,"hello");
			System.out.println(res1[0]);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
