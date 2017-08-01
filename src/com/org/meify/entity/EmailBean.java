/**  
* @Title: MessageBean.java
* @Package com.org.meify.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月31日 下午3:11:37
* @version V1.0  
*/
package com.org.meify.entity;

import java.util.Date;

import lombok.Data;

@Data
public class EmailBean {
	private int id;
	private String from;
	private String to;
	private String subject;
	private String content;
	private Date time;
	private boolean success;
}
