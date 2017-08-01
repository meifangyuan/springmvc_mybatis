/**  
* @Title: EmailQueryBean.java
* @Package com.org.meify.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年8月1日 上午11:21:47
* @version V1.0  
*/
package com.org.meify.entity;

import java.util.Date;

import lombok.Data;

/**
* @ClassName: EmailQueryBean
* @Description: TODO(这里用一句话描述这个类的作用)
* @author meify
* @date 2017年8月1日 上午11:21:47
*
*/
@Data
public class EmailQueryBean {
	private String from;
	private String to;
	private Date startTime;
	private Date endTime;
	private int startIndex;
	private int pageSize;
}
