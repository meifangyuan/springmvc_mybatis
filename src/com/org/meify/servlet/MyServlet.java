/**  
* @Title: MyServlet.java
* @Package com.org.meify.servlet
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月21日 下午2:05:13
* @version V1.0  
*/
package com.org.meify.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: MyServlet
* @Description: TODO(这里用一句话描述这个类的作用)
* @author meify
* @date 2017年7月21日 下午2:05:13
*
*/
public class MyServlet extends HttpServlet{

	private static final long serialVersionUID = -5269363290178556745L;
	
	private int i=0;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("my servlet init()....");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test-doGet()....");
		i++;
		try {
			PrintWriter out = response.getWriter();
			out.write("success===" + i);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test-doPost()....");
		doGet(request, response);
	}
	
	public void destroyed() {
		
	}

}
