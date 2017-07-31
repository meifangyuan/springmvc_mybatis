/**  
* @Title: LogServiceImpl.java
* @Package com.org.meify.service.impl
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月26日 下午2:24:07
* @version V1.0  
*/
package com.org.meify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.meify.dao.LogDao;
import com.org.meify.entity.LogBean;
import com.org.meify.entity.LogQueryBean;
import com.org.meify.service.LogService;

/**
* @ClassName: LogServiceImpl
* @Description: 日志业务类
* @author meify
* @date 2017年7月26日 下午2:24:07
*
*/
@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;
	
	@Override
	public void saveLog(LogBean log) {
		logDao.insertLog(log);
	}


	@Override
	public List<LogBean> selectByCondition(LogQueryBean logQuery) {
		return logDao.selectByCondition(logQuery);
	}

	@Override
	public long getNumberByCondition(LogQueryBean logQuery) {
		return logDao.getNumberByCondition(logQuery);
	}






}
