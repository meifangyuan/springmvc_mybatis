package com.org.meify.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @ClassName: GlobalExceptionHandler
* @Description: 统一异常处理类
* @author meify
* @date 2018年4月1日 下午10:44:41
*
*/
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final String ERROR_KEY = "errInfo";
	
	@ExceptionHandler(BussinessException.class)
	@ResponseBody
	public void handleBizException(HttpServletRequest request, Exception ex) {
		request.getSession().setAttribute(ERROR_KEY, ex.getMessage());
	}

}
 