package com.breakpointresume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BreakPointResume {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//采用randomaccessfile 来模拟断点续传
		File source = new File("d://text.txt");
		File target = new File("e://text.txt");
		byte[] cache = new byte[1];
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos  = new FileOutputStream(target);
		int position = 0;
		try {
			while(fis.read(cache) != -1) {
				System.out.println(cache[0]);
				fos.write(cache);
				if(target.length() == 3) {
					position = 3;
					break;
				};
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			fos.close();
			fis.close();
		}
		
		Thread.sleep(10000);
		RandomAccessFile ri = new RandomAccessFile(source, "rw");
		RandomAccessFile ro = new RandomAccessFile(target, "rw");
		ri.seek(position);
		ro.seek(position);
		while (ri.read(cache)!= -1) {
			ro.write(cache);
		}
		ro.close();
		ri.close();
		
	}
}
