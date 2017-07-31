/**  
* @Title: LoginInterceptor.java
* @Package com.org.meify.interceptor
* @Description: TODO(用一句话描述该文件做什么)
* @author fymei  
* @date 2017年7月17日 下午6:07:01
* @version V1.0  
*/
package com.org.meify.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.org.meify.entity.UserBean;

/**
* @ClassName: LoginInterceptor
* @Description: 登录拦截器，拦截未登录用户直接访问url
* @author fymei
* @date 2017年7月17日 下午6:07:01
*
*/
public class LoginInterceptor implements HandlerInterceptor{
	
	private static final String[] IGNORE_URL = {"/toLogin"}; 

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("loginIntercetion:afterCompletion()....");

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("login interception:preHandle()....");
		
		String servletPath = request.getServletPath();
		System.out.println("request url====" + servletPath);
		
		if(!servletPath.contains("toLogin") && !servletPath.contains("login")) {
			HttpSession session = request.getSession();
			UserBean loginUser = (UserBean)session.getAttribute("user");
			if(loginUser == null) {
				System.out.println("用户尚未登录");
				request.getRequestDispatcher("toLogin").forward(request, response);
				return false;
			} else {
				System.out.println("用户已登录");
				System.out.println(loginUser.getUserName());
			}
		}
		
		return true;
	}
}
