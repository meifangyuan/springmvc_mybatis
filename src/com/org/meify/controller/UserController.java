package com.org.meify.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.meify.entity.JsonResult;
import com.org.meify.entity.UserBean;
import com.org.meify.service.UserService;
 
/**
* @ClassName: UserController
* @Description: 用户管理
* @author fymei
* @date 2017年7月17日 下午3:52:14
*
*/ 
@Controller
public class UserController {
	
	@Autowired
	UserService userService; 

	/**
	* @Title: toIndex
	* @Description: 跳转到首页
	* @param @param request
	* @param @return    设定文件
	* @return String    返回类型
	* @throws
	*/ 
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping("/usermanager")
	public String toUserManager(HttpServletRequest request){
		return "/usermanager/userList";
	}
	
	@RequestMapping("/getAllUser")
	@ResponseBody
	public Map<String, Object> getAllUser(HttpServletRequest request, int page, int rows) {
		int startIndex = (page-1)*rows;
		List<UserBean> userList = userService.getAllUsers(startIndex, rows);
		long total = userService.getUserNumber();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", userList);
		map.put("total", total);
		
		return map;
	}
	
	@RequestMapping("/toAddUser")
	public String toAddUser(HttpServletRequest request){
		return "usermanager/addUser";
	}

	@RequestMapping("/saveUser")
	@ResponseBody
	public Object saveUser(UserBean user, HttpServletRequest request, HttpServletResponse response) throws Exception{
		JsonResult res = new JsonResult();
		try {
			userService.saveUser(user);
			res.setSuccess(true);
		} catch (Exception e) {
			res.setSuccess(false);
			res.setMsg("删除失败");
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Object deleteUser(int id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		JsonResult res = new JsonResult();
		try {
			userService.deleteUser(id);
			res.setSuccess(true);
		} catch (Exception e) {
			res.setSuccess(false);
			res.setMsg("删除失败");
			e.printStackTrace();
		}
		return res;
	}
	
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(int id, HttpServletRequest request){
		request.setAttribute("user", userService.getUserBeanById(id));
		return "usermanager/editUser";
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	public Object updateUser(UserBean user, HttpServletRequest request){
		JsonResult res = new JsonResult();
		try {
			userService.updateUser(user);
			res.setSuccess(true);
		} catch (Exception e) {
			res.setSuccess(false);
			res.setMsg("修改用户失败");
			e.printStackTrace();
		}
		return res;
	}

}
