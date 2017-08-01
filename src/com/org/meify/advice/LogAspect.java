/**  
* @Title: LogAspect.java
* @Package com.org.meify.common
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月26日 下午2:43:15
* @version V1.0  
*/
package com.org.meify.advice;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.org.meify.entity.LogBean;
import com.org.meify.entity.UserBean;
import com.org.meify.service.LogService;

/**
* @ClassName: LogAspect
* @Description: 日志切面类
* @author meify
* @date 2017年7月26日 下午2:43:15
*
*/
@Aspect
public class LogAspect {
	
	@Autowired
	private LogService logService;
	
    /**
    * @Title: controllerAspect
    * @Description: 定义切点
    * @param     设定文件
    * @return void    返回类型
    * @throws
    */ 
    @Pointcut("execution(* com.org.meify.controller.LoginController.*(..))"
    		+ "||execution(* com.org.meify.controller.UserController.*(..))"
    		+ "||execution(* com.org.meify.controller.MultipartFileController.*(..))")
    public void controllerAspect() { 
    	
    } 
	
	/**
	* @Title: before
	* @Description: 前置增强
	* @param @param point    连接点，即增强注入的地方
	* @return void    返回类型
	* @throws
	*/ 
	@Before("controllerAspect()")
	public void before(JoinPoint point) {
		
	}
	
	/**
	* @Title: after
	* @Description:后置增强（无论目标方法执行成功还是失败）
	* @param @param point    连接点
	* @return void    返回类型
	* @throws
	*/ 
	@After("controllerAspect()")
	public void after(JoinPoint point) {
//		System.out.println("service方法执行后（可能执行失败，未正常返回）");
		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
         HttpSession session = request.getSession();
         
         //读取session中的用户  
         String operator = "";
         if(session.getAttribute("user") != null) {
             UserBean loginUser=(UserBean)session.getAttribute("user");
             operator = loginUser.getUserName();
         }
        
        String targetName = point.getTarget().getClass().getName();  
        String methodName = point.getSignature().getName();  
        Object[] arguments = point.getArgs(); 
        StringBuffer sb = new StringBuffer();
        String params = sb.toString();
        
        String operationType = "";
        String operationName = "";
        String type = "INFO";
        String ip = request.getRemoteAddr();
        String exceptionCode = null;
        String exceptionDetail = null;
        Date time = new Date();
        
        LogBean log = new LogBean();
        log.setDescription(targetName);
        log.setMethod(methodName);
        log.setParams(params);
        log.setOperator(operator);
        log.setType(type);
        log.setIp(ip);
        log.setExceptionCode(exceptionCode);
        log.setExceptionDetail(exceptionDetail);
        log.setTime(time);
        logService.saveLog(log);
	}
	

	/**
	* @Title: afterReturning
	* @Description: 后置增强（目标方法执行成功）
	* @param     设定文件
	* @return void    返回类型
	* @throws
	*/ 
	@AfterReturning("controllerAspect()")
	public void afterReturning() {
//		System.out.println("service方法执行完成后（执行成功，有返回值）");
	}
	
	/**
	* @Title: afterThrowing
	* @Description: 异常切入点
	* @param  point
	* @param  ex    设定文件
	* @return void    返回类型
	* @throws
	*/ 
	@AfterThrowing(throwing="e", pointcut="controllerAspect()")
	public void afterThrowing(JoinPoint point, Throwable e) {
		 HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
         HttpSession session = request.getSession();
         
         //读取session中的用户  
         UserBean loginUser=(UserBean)session.getAttribute("user");
         String operator = loginUser==null? "":loginUser.getUserName();

        
        String targetName = point.getTarget().getClass().getName();  
        String methodName = point.getSignature().getName();  
        Object[] arguments = point.getArgs(); 
        
        StringBuffer sb = new StringBuffer();
//        if(arguments.length>0) {
//            for(Object obj : arguments) {
//            	sb.append(obj.toString());
//            }
//        }
        String params = sb.toString();
        
        String operationType = "";
        String operationName = "";
        String type = "ERROR";
        String ip = request.getRemoteAddr();
        String exceptionCode = e.getClass().getName();
        String exceptionDetail = e.getMessage();
        Date time = new Date();
        
        LogBean log = new LogBean();
        log.setDescription(targetName);
        log.setMethod(methodName);
        log.setParams(params);
        log.setOperator(operator);
        log.setType(type);
        log.setIp(ip);
        log.setExceptionCode(exceptionCode);
        log.setExceptionDetail(exceptionDetail);
        log.setTime(time);
        logService.saveLog(log);

	}
	
	/**
	* @Title: around
	* @Description: 环绕增强，可自定义前置还是后置
	* @param @param point
	* @param @return
	* @param @throws Throwable    设定文件
	* @return Object    返回类型
	* @throws
	*/ 
	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint point) throws Throwable{
        return point.proceed();
	}
	
}
