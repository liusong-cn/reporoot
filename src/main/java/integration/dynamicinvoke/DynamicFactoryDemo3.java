package integration.dynamicinvoke;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class DynamicFactoryDemo3 {
	public static void main(String[] args) {
		JaxWsDynamicClientFactory dcf1 = JaxWsDynamicClientFactory.newInstance();
		String wsdlurl1 = "http://192.168.18.1:7088/fd-offline/support/testFileUpload?wsdl";
		String method1 = "testDynamicInvoke";
		//调用的方法若有命名空间则需要qname，否则不需要
		QName name1 = new QName("http://iface.wssupport.offline.glaway.com/", method1);
		Client client1 = dcf1.createClient(wsdlurl1);
		Object[] res1 = null;
		try {
			//需要本地化参数对象
			Object resume1 = Thread.currentThread().getContextClassLoader().loadClass("com.glaway.offline.wssupport.iface.SimpleResume").newInstance();
			Method m1 = resume1.getClass().getMethod("setFileName", String.class);
			Method m2 = resume1.getClass().getMethod("setSuffix", String.class);
			Method m3 = resume1.getClass().getMethod("setContent", Arrays.class);
			m1.invoke(resume1, "ceshiwenjian");
			m2.invoke(resume1, "txt");
			File file = new File("d://text.txt");
			long size = file.length();
			byte[] con = new byte[(int) size];
			FileInputStream fis = new FileInputStream(file);
			fis.read(con);
			fis.close();
			//m3.invoke(resume1, con);
			res1 = client1.invoke(name1, resume1);
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
