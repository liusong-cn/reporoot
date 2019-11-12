package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {
	public static void main(String[] args) {
		Socket socket;
		try {
			socket = new Socket("127.0.0.1",10000);
			//写入输出流
			OutputStream out = socket.getOutputStream();
			out.write("客户端消息已发出".getBytes());
			//接收输入
			InputStream in = socket.getInputStream();
			byte[] cache = new byte[1024];
			int length = in.read(cache);
			String income = new String(cache,0,length);
			System.out.println(income);
			
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
