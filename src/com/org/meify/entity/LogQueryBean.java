/**  
* @Title: LogQueryBean.java
* @Package com.org.meify.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月27日 下午1:05:30
* @version V1.0  
*/
package com.org.meify.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: LogQueryBean
* @Description: 日志查询类
* @author meify
* @date 2017年7月27日 下午1:05:30
*
*/
@Data	// 生成set get hashCode toString方法
@NoArgsConstructor	// 生成无参构造函数
@AllArgsConstructor	// 生成全参数构造函数
public class LogQueryBean {
	private String type;
	private Date startTime;
	private Date endTime;
	private int startIndex;
	private int pageSize;
	
	
}
