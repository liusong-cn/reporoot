package integration.dynamicinvoke;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

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

public class DynamicFactoryDemo {
	public static void main(String[] args) {
		QName serviceName = new QName("http://iface.wssupport.offline.glaway.com/","FileSupportImplService");
		// 利用cxf动态工厂以及反射生成javabean
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		String wsdlurl = "http://192.168.18.1:7088/fd-offline/support/testFileUpload?wsdl";
		//Client client = factory.createClient(wsdlurl);
		Client client = factory.createClient(wsdlurl,serviceName);
		ClientImpl c = (ClientImpl) client;
		Endpoint endpoint = c.getEndpoint();
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		QName bindingName = new QName("http://iface.wssupport.offline.glaway.com/", "FileSupportImplService");
		// BindingInfo bindingInfo = serviceInfo.getBinding(bindingName);
		BindingInfo bindingInfo = endpoint.getEndpointInfo().getBinding();
		// QName qname = new QName("http://iface.wssupport.offline.glaway.com/",
		// "uploadFile");
		QName qname = new QName("http://iface.wssupport.offline.glaway.com/", "testDynamicInvoke");
		BindingOperationInfo operaInfo = bindingInfo.getOperation(qname);
		BindingMessageInfo inputMessageInfo = operaInfo.getInput();
		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
		MessagePartInfo partInfo = parts.get(0);
		Class<?> partClass = partInfo.getTypeClass();
		System.out.println(partClass);
		for (Field field : Arrays.asList(partClass.getDeclaredFields())) {
			System.out.println(field);
		}
		Object[] res = null;
		try {
			Object inputObject = partClass.newInstance();

			/*
			 * PropertyDescriptor partDescriptor1 = new PropertyDescriptor("otherParam",
			 * partClass); Method otherParamSet = partDescriptor1.getWriteMethod();
			 * otherParamSet.invoke(inputObject, "hello");
			 * 
			 * PropertyDescriptor partDescriptor2 = new PropertyDescriptor("resume",
			 * partClass); Method resumeSet = partDescriptor2.getWriteMethod(); Resume r =
			 * new Resume(); r.setCandidateName("hello"); r.setResumeFileType("txt");
			 * r.setResume(new DataHandler(new FileDataSource(new File("d://text.txt"))));
			 * resumeSet.invoke(inputObject, r);
			 */
			PropertyDescriptor partDescriptor1 = new PropertyDescriptor("sResume.fileName", partClass);
			partDescriptor1.getWriteMethod().invoke(inputObject, "useSimpleResume");
			
			PropertyDescriptor partDescriptor2 = new PropertyDescriptor("suffix", partClass);
			partDescriptor2.getWriteMethod().invoke(inputObject, "txt");
			
			PropertyDescriptor partDescriptor3 = new PropertyDescriptor("content", partClass);
			File file = new File("d://text.txt");
			long size = file.length();
			byte[] con = new byte[(int) size];
			FileInputStream fis = new FileInputStream(file);
			fis.read(con);
			fis.close();
			partDescriptor3.getWriteMethod().invoke(inputObject, con);
			
			res = client.invoke(qname, inputObject);
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
