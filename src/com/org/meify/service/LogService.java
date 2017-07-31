/**  
* @Title: LogService.java
* @Package com.org.meify.service
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月26日 下午2:23:06
* @version V1.0  
*/
package com.org.meify.service;

import java.util.List;

import com.org.meify.entity.LogBean;
import com.org.meify.entity.LogQueryBean;

/**
* @ClassName: LogService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author meify
* @date 2017年7月26日 下午2:23:06
*
*/
public interface LogService {

	public void saveLog(LogBean log);
	
	List<LogBean> selectByCondition(LogQueryBean logQuery);	
	
	long getNumberByCondition(LogQueryBean logQuery);
}
