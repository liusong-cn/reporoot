package com.filerelated;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fileUploadController")
@Controller
public class FileUploadController {
	
	@RequestMapping(params = "fileUpload")
	public void fileUpload(HttpServletRequest req,HttpServletResponse res) throws IOException {
		byte[] cache = new byte[1024];
		
		InputStream in = req.getInputStream();
		BufferedInputStream bin = new BufferedInputStream(in);
		OutputStream out = new FileOutputStream(new File("e://testfileupload.txt"));
		int length = 0;
		while ((length = bin.read(cache)) != -1) {
			out.write(cache,0,length);
		}
		out.close();
		in.close();
	}
}
