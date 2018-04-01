package com.org.meify.common;

import lombok.Data;

/**
* @ClassName: BussinessException
* @Description: 自定义异常类
* @author meify
* @date 2018年4月1日 下午10:40:12
*
*/
@Data
public class BussinessException extends Exception {
	
	private static final long serialVersionUID = -100089630572738003L;
	
	private int bizCode;	// 业务代码
	private String bizType;	// 业务类型
	private String message;	// 异常信息
	
	public BussinessException(String message) {
		this.message = message;
	}
	
	public BussinessException(int bizCode, String message) {
		this.bizCode = bizCode;
		this.message = message;
	}
	
	public BussinessException(String bizType, String message) {
		this.bizType = bizType;
		this.message = message;
	}
	
	public BussinessException(int bizCode, String bizType, String message) {
		this.bizType = bizType;
		this.message = message;
	}
	
	
}
