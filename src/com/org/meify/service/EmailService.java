package com.org.meify.service;

import java.util.List;

import com.org.meify.entity.EmailBean;
import com.org.meify.entity.EmailQueryBean;

public interface EmailService {
	
	void saveEmail(EmailBean email);

	List<EmailBean> selectByCondition(EmailQueryBean emailQuery);	
	
	long getNumberByCondition(EmailQueryBean emailQuery);
	
}
