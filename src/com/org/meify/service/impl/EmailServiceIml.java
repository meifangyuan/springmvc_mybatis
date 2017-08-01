package com.org.meify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.meify.dao.EmailDao;
import com.org.meify.entity.EmailBean;
import com.org.meify.entity.EmailQueryBean;
import com.org.meify.service.EmailService;

@Service
@Transactional
public class EmailServiceIml implements EmailService{
	@Autowired
	private EmailDao emailDao;

	@Override
	public void saveEmail(EmailBean email) {
		emailDao.insertEmail(email);
	}

	@Override
	public List<EmailBean> selectByCondition(EmailQueryBean emailQuery) {
		return emailDao.selectByCondition(emailQuery);
	}


	@Override
	public long getNumberByCondition(EmailQueryBean emailQuery) {
		return emailDao.getNumberByCondition(emailQuery);
	}




}
