package integration.dynamicinvoke;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ls
 * @date: 2020/4/16 0016 10:55
 */
public class DynamicInvoke {
    public static void main(String[] args) throws Exception {

        String json = "[{\"name\": \"测试任务\",\"taskType1\": \"任务大类\",\"taskType2\": \"任务小类\",\"startTime\": \"2020-02-20\",\"endTime\": \"2020-02-20\",\"assigner\": \"xialn\",\"projectCode\":\"001\",\"state\":\"开工\",\"requirement\":\"没有要求\",\"owner\": \"xialn\",\"taskLevel\": \"一般\",\"monitorLevel\": \"一般\",\"taskId\": \"002\",\"pid\": \"001\",\"inputs\": [{\"id\": \"001\",\"name\": \"输入物1\"}]";
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://192.168.43.1:8080/fd_offline/support/syncProjectInfo?wsdl");
        try {
            Object[] res = client.invoke("synchronizeProject",json);
            System.out.println(res[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }


//		try {
//			Service service = new Service();
//			Call call = (Call) service.createCall();
//			call.setTargetEndpointAddress(new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx"));
//			call.setOperationName(new QName("http://WebXml.com.cn/","getWeatherbyCityName"));
//			call.setUseSOAPAction(true);
//			call.setSOAPActionURI("http://WebXml.com.cn/getWeatherbyCityName");
//			call.addParameter(new QName("http://WebXml.com.cn/", "theCityName"),XMLType.SOAP_STRING,ParameterMode.IN);
//			call.setReturnType(XMLType.SOAP_VECTOR);
//			System.out.println(call.invoke(new Object[]{"广州"}));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

    }
}
