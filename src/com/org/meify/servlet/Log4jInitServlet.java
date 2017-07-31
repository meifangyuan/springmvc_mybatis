/**  
* @Title: Log4jInitServlet.java
* @Package com.org.meify.servlet
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月17日 下午7:37:22
* @version V1.0  
*/
package com.org.meify.servlet;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * @ClassName: Log4jInitServlet
 * @Description: 日志管理
 * @author meify
 * @date 2017年7月17日 下午7:37:22
 *
 */
public class Log4jInitServlet extends HttpServlet {

	private static final long serialVersionUID = -5054495915215920143L;

	public void init(ServletConfig config) throws ServletException {
		
		String log4jLocation = config.getInitParameter("log4j-init-location");

		if (log4jLocation == null) {
			System.out.println("log4j执行默认配置");
			BasicConfigurator.configure();
		} else {
			String webAppPath = config.getServletContext().getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			System.out.println("log4jProp::"+log4jProp);
			File file = new File(log4jProp);
			if (file.exists()) {
				System.out.println("log4j加载properties配置文件配置");
				PropertyConfigurator.configure(log4jProp);
			} else {
				BasicConfigurator.configure();
			}
		}
		super.init(config);
	}

}
