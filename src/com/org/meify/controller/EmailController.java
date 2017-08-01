package com.org.meify.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.meify.common.Constants;
import com.org.meify.common.SendMailThread;
import com.org.meify.entity.EmailBean;
import com.org.meify.entity.EmailQueryBean;
import com.org.meify.entity.LogBean;
import com.org.meify.entity.UserBean;
import com.org.meify.service.EmailService;
import com.org.meify.service.UserService;

@Controller
public class EmailController {

	@Autowired
	UserService userService;

	@Autowired
	EmailService emailService;

	@RequestMapping("/toSendEmail")
	public String toSendEmail(HttpServletRequest request) {
		return "/emailmanager/sendEmail";
	}

	@RequestMapping("/sendEmail")
	@ResponseBody
	public Object sendEmail(HttpServletRequest request, String ids, String title, String content) {
		try {
			System.out.println(ids + "===" + title + "====" + content);
			String[] idArr = ids.split(",");
			ExecutorService executor = Executors.newCachedThreadPool();
			Map<String, Future<String>> map = new HashMap<String, Future<String>>();
			for (String id : idArr) {
				UserBean user = userService.getUserBeanById(Integer.valueOf(id));
				String email = user.getEmail();
				if (email != null) {
					// 发送邮件
					SendMailThread sendThread = new SendMailThread();
					sendThread.setSendConfig(Constants.EMAIL_HOST, Constants.EMAI_SENDUSER, Constants.EMAIL_PASSWD);
					sendThread.setMessageInfo(email, title, content, Constants.EMAIL_MESSAGETYPE);
					Future<String> res = executor.submit(sendThread);
					map.put(email, res);
				}
			}
			executor.shutdown();
			while (true) { // 任务全部执行完毕
				if (executor.isTerminated()) {
					Iterator<Entry<String, Future<String>>> iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry<String, Future<String>> entry = iter.next();
						String toAddress = entry.getKey();
						Future<String> future = entry.getValue();
						String sendResult = future.get();
						if (sendResult.equals(Constants.SUCCESS)) {
							System.out.println("发送邮件至" + toAddress + "成功");
						} else {
							System.out.println("发送邮件至" + toAddress + "失败");
						}
						EmailBean email = new EmailBean();
						email.setFrom(Constants.EMAI_SENDUSER);
						email.setTo(toAddress);
						email.setSubject(title);
						email.setContent(content);
						email.setTime(new Date());
						email.setSuccess(sendResult.equals(Constants.SUCCESS) ? true : false);
						emailService.saveEmail(email);
					}
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("发送邮件出现异常");
			e.printStackTrace();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("msg", "操作成功");

		return map;
	}

	@RequestMapping("/toHistoryEmail")
	public String toUserManager(HttpServletRequest request) {
		return "/emailmanager/emailList";
	}

	@RequestMapping("/getEmailByCondition")
	@ResponseBody
	public Map<String, Object> getEmailByCondition(HttpServletRequest request, Date startTime, Date endTime,int page, int rows) {
		int startIndex = (page-1)*rows;
		EmailQueryBean emailQuery = new EmailQueryBean();
		emailQuery.setStartIndex(startIndex);
		emailQuery.setPageSize(rows);
		emailQuery.setStartTime(startTime);
		emailQuery.setEndTime(endTime);
		
		List<EmailBean> emailList = emailService.selectByCondition(emailQuery);
		long total = emailService.getNumberByCondition(emailQuery);
		System.out.println(total);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", emailList);
		map.put("total", total);
		
		return map;
	}

}
