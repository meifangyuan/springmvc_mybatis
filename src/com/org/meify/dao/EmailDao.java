package com.org.meify.dao;
import java.util.List;

import com.org.meify.entity.EmailBean;
import com.org.meify.entity.EmailQueryBean;


public interface EmailDao {

	void insertEmail(EmailBean email);
	
	List<EmailBean> selectByCondition(EmailQueryBean queryBean);	
	
	long getNumberByCondition(EmailQueryBean queryBean);
	
}
