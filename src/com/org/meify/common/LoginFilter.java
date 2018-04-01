package com.org.meify.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	private FilterConfig config = null;
	

    public LoginFilter() {
    	System.out.println("LoginFilter过滤器被创建......");
    }

	public void destroy() {
		System.out.println("LoginFilter过滤器被销毁......");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String url = httpRequest.getRequestURI();
		System.out.println("request url===" + url);
		
		String exceptUrl = config.getInitParameter("exceptUrls");
		
		throw new BussinessException("故意抛出的异常");
		
		if(!url.contains("toLogin") && !url.contains("login")) {
			System.out.println("非放行url, 检查是否已登录");
			HttpSession session = httpRequest.getSession();
			if(session.getAttribute("user") == null) {
				System.out.println("用户尚未登录");
				httpRequest.setAttribute("message", "尚未登录");
				httpRequest.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
			} else {
				System.out.println("用户已登录");
				chain.doFilter(request, response);
			}
		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter过滤器初始化.......");
		this.config = fConfig;
	}

}
