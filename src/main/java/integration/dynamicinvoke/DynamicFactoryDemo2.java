package integration.dynamicinvoke;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.ServiceInfo;

public class DynamicFactoryDemo2 {
	public static void main(String[] args) {
		// 利用cxf动态工厂以及反射生成javabean,目前对于参数对象本身的属性中含有非基本类型时测试不通过
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		String wsdlurl = "http://192.168.18.1:7088/fd-offline/support/testFileUpload?wsdl";
		QName serviceName = new QName("http://iface.wssupport.offline.glaway.com/", "FileSupportImplService");
		Client client = factory.createClient(wsdlurl,serviceName);
		ClientImpl c = (ClientImpl) client;
		Endpoint endpoint = c.getEndpoint();
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		QName bn = new QName("http://iface.wssupport.offline.glaway.com/", "FileSupportImplServiceSoapBinding");
	    BindingInfo bindingInfo = serviceInfo.getBinding(bn);
		//BindingInfo bindingInfo = endpoint.getEndpointInfo().getBinding();
		QName oname = new QName("http://iface.wssupport.offline.glaway.com/", "testDynamicInvoke");
		BindingOperationInfo operaInfo = bindingInfo.getOperation(oname);
		BindingMessageInfo inputMessageInfo = operaInfo.getInput();
		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
		MessagePartInfo partInfo = parts.get(0);
		Class<?> partClass = partInfo.getTypeClass();
		/*
		 * System.out.println(partClass); for (Field field :
		 * Arrays.asList(partClass.getDeclaredFields())) { System.out.println(field);
		 * for (Field f : field.getType().getDeclaredFields()) { System.out.println(f);
		 * } }
		 */
		Class<?> innerPartClass = partClass.getDeclaredFields()[0].getType();
		Object[] res = null;
		try {
			Object inputObject = partClass.newInstance();
			Object innerInputObject = innerPartClass.newInstance();

			PropertyDescriptor partDescriptor1 = new PropertyDescriptor("fileName", innerPartClass);
			Method fileNameSet = partDescriptor1.getWriteMethod();
			fileNameSet.invoke(innerInputObject, "hello");

			PropertyDescriptor partDescriptor2 = new PropertyDescriptor("suffix", innerPartClass);
			Method suffixSet = partDescriptor2.getWriteMethod();
			suffixSet.invoke(innerInputObject, "txt");
			
			PropertyDescriptor partDescriptor3 = new PropertyDescriptor("content", innerPartClass);
			Method contentSet = partDescriptor3.getWriteMethod();
			File file = new File("d://text.txt");
			long size = file.length();
			byte[] con = new byte[(int) size];
			FileInputStream fis = new FileInputStream(file);
			fis.read(con);
			fis.close();
			contentSet.invoke(innerInputObject,con );
			
			PropertyDescriptor partDescriptor4 = new PropertyDescriptor("sResume", partClass);
			Method sResumeSet = partDescriptor4.getWriteMethod();
			sResumeSet.invoke(inputObject, innerInputObject);
			
			res = client.invoke(oname, innerInputObject);
			System.out.println(res[0]);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
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
