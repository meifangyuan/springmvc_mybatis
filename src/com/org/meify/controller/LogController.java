/**  
* @Title: LogController.java
* @Package com.org.meify.controller
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月26日 下午5:59:50
* @version V1.0  
*/
package com.org.meify.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.meify.entity.LogBean;
import com.org.meify.entity.LogQueryBean;
import com.org.meify.service.LogService;

/**
* @ClassName: LogController
* @Description: 日志查询控制层
* @author meify
* @date 2017年7月26日 下午5:59:50
*
*/

@Controller
public class LogController {

	@Autowired
	private LogService logService;
	
	@RequestMapping("/logmanager")
	public String toLogManager(HttpServletRequest request){
		return "/system/logList";
	}
	
	@RequestMapping("/getLogByCondition")
	@ResponseBody
	public Map<String, Object> getLogByCondition(HttpServletRequest request, Date startTime, Date endTime,int page, int rows) {
		int startIndex = (page-1)*rows;
		LogQueryBean logQuery = new LogQueryBean();
		logQuery.setStartIndex(startIndex);
		logQuery.setPageSize(rows);
		logQuery.setStartTime(startTime);
		logQuery.setEndTime(endTime);
		
		List<LogBean> logList = logService.selectByCondition(logQuery);
		long total = logService.getNumberByCondition(logQuery);
		System.out.println(total);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", logList);
		map.put("total", total);
		
		return map;
	}

}
