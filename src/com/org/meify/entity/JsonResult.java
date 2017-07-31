/**  
* @Title: JsonResult.java
* @Package com.org.meify.entity
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月25日 下午5:46:14
* @version V1.0  
*/
package com.org.meify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: JsonResult
* @Description: 操作结果json类
* @author meify
* @date 2017年7月25日 下午5:46:14
*
*/
@Data	// 生成set get hashCode toString方法
@NoArgsConstructor	// 生成无参构造函数
@AllArgsConstructor	// 生成全参数构造函数
public class JsonResult {
	private boolean success;
	private String msg;
}
