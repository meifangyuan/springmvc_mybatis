/**  
* @Title: LogBean.java
* @Package com.org.meify.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月26日 下午2:13:45
* @version V1.0  
*/
package com.org.meify.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: LogBean
* @Description: 日志类
* @author meify
* @date 2017年7月26日 下午2:13:45
*
*/
@Data	
@NoArgsConstructor	// 生成无参构造函数
@AllArgsConstructor	// 生成全参数构造函数
public class LogBean {
	private int id;			
	private String description; 
	private String method;
	private String params;
	private String operator;		
	private String type;
	private String ip;
	private String exceptionCode;
	private String exceptionDetail;
	private Date time;
}
