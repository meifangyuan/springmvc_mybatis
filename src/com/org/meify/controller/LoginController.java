/**  
* @Title: LoginController.java
* @Package com.org.meify.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月25日 下午2:10:05
* @version V1.0  
*/
package com.org.meify.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.meify.entity.UserBean;
import com.org.meify.service.UserService;

/**
* @ClassName: LoginController
* @Description: 用户登录控制器
* @author meify
* @date 2017年7月25日 下午2:10:05
*
*/
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	/**
	* @Title: toLogin
	* @Description: 跳转至用户登录界面
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping("/toLogin")
	public String toLogin(HttpServletRequest request) {
		return "login";
	}
	
	/**
	* @Title: login
	* @Description: 用户登录
	* @param @param userName
	* @param @param passwd
	* @param @param view
	* @param @param request
	* @param @return    设定文件
	* @return ModelAndView    返回类型
	* @throws
	*/ 
	@RequestMapping("/login")
	public ModelAndView login(String userName, String passwd, ModelAndView view, HttpServletRequest request) {

		UserBean user = userService.getUserByName(userName);
		if(user == null) {
			view.addObject("message", "用户名不存在！");
			view.setViewName("login");
			return view;
		}
		
		if(!user.getPasswd().equals(passwd)) {
			view.addObject("message", "密码错误，请重新输入！");
			view.setViewName("login");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			view.setViewName("index");
		}
		
		return view;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		return "login";
	}
	
	/**
	* @Title: toResetPasswd
	* @Description: 跳转至重置密码界面
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping("/toResetPasswd")
	public String toResetPasswd(HttpServletRequest request) {
		return "system/passwd";
	}
	
	/**
	* @Title: resetPasswd
	* @Description: 重置密码
	* @param @param request
	* @param @param view
	* @param @param oldPasswd
	* @param @param newPasswd
	* @param @return    设定文件
	* @return ModelAndView    返回类型
	* @throws
	*/ 
	@RequestMapping("/resetPasswd")
	public ModelAndView resetPasswd(HttpServletRequest request, ModelAndView view, String oldPasswd, String newPasswd) {
		
		HttpSession session = request.getSession();
		UserBean loginUser = (UserBean) session.getAttribute("user");
		
		if(newPasswd.equals(oldPasswd)) {
			view.addObject("message", "新密码与旧密码重复");
			view.setViewName("system/passwd");
			return view;
		}
		
		if(!loginUser.getPasswd().equals(oldPasswd)) {
			view.addObject("message", "旧密码不正确");
			view.setViewName("system/passwd");
			return view;
		}
		
		try {
			userService.modifyPasswd(loginUser.getId(), newPasswd);
			view.setViewName("common/success");
		} catch (Exception e) {
			view.addObject("message", "修改密码失败");
			view.setViewName("system/passwd");
			e.printStackTrace();
		}
		return view;
	}
}
