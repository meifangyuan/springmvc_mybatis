package com.org.meify.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
* @ClassName: UserBean
* @Description: 用户实体类
* @author meify
* @date 2017年7月19日 下午1:55:24
*
*/ 
@Data	// 生成set get hashCode toString方法
@NoArgsConstructor	// 生成无参构造函数
@AllArgsConstructor	// 生成全参数构造函数
public class UserBean {

	private Integer id;
	private String userName;
	private String passwd;
	private Integer sex;
	private Integer age;
	private String email;

}
