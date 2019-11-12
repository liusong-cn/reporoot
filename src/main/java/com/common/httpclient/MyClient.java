package com.common.httpclient;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class MyClient {
	
	public void connection(){
		HttpClient client = new HttpClient();
		HttpMethod method = new PostMethod("http://localhost:8095/springDemo/testController.do?goPage&param=1");
		int statusCode;
		try {
			statusCode = client.executeMethod(method);
			if(statusCode == 200){
				String s = method.getResponseBodyAsString();
				System.out.println(s);
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			method.releaseConnection();
		}
	}
	
	public static void main(String[] args) {
		new MyClient().connection();
	}
}
