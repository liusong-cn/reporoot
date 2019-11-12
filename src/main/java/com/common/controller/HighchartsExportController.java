package com.common.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
//import org.apache.fop.svg.PDFTranscoder;




/**
 * highcharts导出统计图地址
 *
 */
@Controller
@RequestMapping("/highchartsExportController")
public class HighchartsExportController {


	@RequestMapping(params = "doExport")
	public void doExport(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sessionId = request.getSession().getId();
		request.setCharacterEncoding("utf-8");
		String type = (String) request.getSession().getAttribute("type");
		String svg = (String) request.getSession().getAttribute("svg");
		

		ServletOutputStream out = response.getOutputStream();

		if (null != type && null != svg) {

			svg = svg.replaceAll(":rect", "rect");

			String ext = "";

			Transcoder t = null;

			if (type.equals("image/png")) {

				ext = "png";

				t = new PNGTranscoder();

			} else if (type.equals("image/jpeg")) {

				ext = "jpg";

				t = new JPEGTranscoder();

			} /*else if (type.equals("application/pdf")) {

				ext = "pdf";

				t = new PDFTranscoder();

			} */else if (type.equals("image/svg+xml")) {

				ext = "svg";

			}

			response.addHeader("Content-Disposition",
					"attachment; filename=chart." + ext);
			response.addHeader("Content-Type", type);

			if (null != t) {

				TranscoderInput input = new TranscoderInput(new StringReader(
						svg));

				TranscoderOutput output = new TranscoderOutput(out);

				try {

					t.transcode(input, output);

				} catch (TranscoderException e) {

					out.print("Problem transcoding stream. See the web logs for more details.");

					e.printStackTrace();

				}

			} else if (ext == "svg") {

				out.print(svg);

			} else {

				out.print("Invalid type: " + type);

			}

		} else {

			response.addHeader("Content-Type", "text/html");

			out.println("Usage:\n\tParameter [svg]: The DOM Element to be converted.\n\tParameter [type]: The destination MIME type for the elment to be transcoded.");

		}

		out.flush();

		out.close();
	}
	
	@RequestMapping(params = "SvgCache")
	public void SvgCache(HttpServletRequest req, HttpServletResponse res){
		String svg = req.getParameter("svg");
		String type = req.getParameter("type");
		req.getSession().setAttribute("svg", svg);
		req.getSession().setAttribute("type", type);
		try
	    {
	     
	      PrintWriter pw = res.getWriter();
	      res.setContentType("application/json");
	      res.setHeader("Cache-Control", "no-store");
	      pw.write("{\"success\": true}");
	      pw.flush();
	      pw.close();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
		
	}

	
}
