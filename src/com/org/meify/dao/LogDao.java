/**  
* @Title: LogDao.java
* @Package com.org.meify.dao
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月26日 下午2:18:06
* @version V1.0  
*/
package com.org.meify.dao;

import java.util.List;

import com.org.meify.entity.LogBean;
import com.org.meify.entity.LogQueryBean;

/**
* @ClassName: LogDao
* @Description: 日志接口
* @author meify
* @date 2017年7月26日 下午2:18:06
*
*/
public interface LogDao {
	
	void insertLog(LogBean log);
	
	List<LogBean> selectByCondition(LogQueryBean queryBean);	
	
	long getNumberByCondition(LogQueryBean queryBean);
	
}
