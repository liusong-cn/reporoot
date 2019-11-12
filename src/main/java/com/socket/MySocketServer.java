package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10000);
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			byte[] b = new byte[1024];
			int length = in.read(b);
			String msg = new String(b,0,length);
			System.out.println(msg);
			
			OutputStream out = socket.getOutputStream();
			out.write("服务器已发送消息1".getBytes());
			
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
