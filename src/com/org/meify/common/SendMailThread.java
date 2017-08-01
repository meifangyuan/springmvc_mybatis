/**  
* @Title: SendMailThread.java
* @Package com.org.meify.mail
* @Description: TODO(用一句话描述该文件做什么)
* @author meify  
* @date 2017年7月31日 下午7:38:42
* @version V1.0  
*/
package com.org.meify.common;

import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.Callable;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
* @ClassName: SendMailThread
* @Description: 发送邮件线程
* @author meify
* @date 2017年7月31日 下午7:38:42
*
*/
public class SendMailThread implements Callable<String>{
	private String host;		// 邮箱服务器
	private String fromUser;	// 发件人邮箱
	private String passwd;		// 发件人密码
	private String toUser;		// 收件人
	private String subject;		// 主题
	private String messageText;	// 正文
	private String messageType;	// 邮件类型
	
	public void setSendConfig(String host, String from, String passwd) {
		this.host = host;
		this.fromUser = from;
		this.passwd = passwd;
	}
	
	public void setMessageInfo(String to, String subject, String messageText, String messageType) {
		this.toUser = to;
		this.subject = subject;
		this.messageText = messageText;
		this.messageType = messageType;
	}
	
	@SuppressWarnings("static-access")
	public boolean sendMail() {
		try {
			//1、构建session对象
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", this.host);
			props.setProperty("mail.smtp.port", "25");
			props.put("mail.smtp.auth", "true");	// 进行安全认证
			props.put("mail.smtp.starttls.enable","true");//使用 STARTTLS安全连接  
			
			Session mailSession = Session.getInstance(props,new MyAuthenticator(this.fromUser, this.passwd));
			
			//2、编写邮件内容
			MimeMessage message = new MimeMessage(mailSession);  
			InternetAddress fromAddress = new InternetAddress(this.fromUser);  
			InternetAddress toAddress = new InternetAddress(this.toUser);  
			message.setFrom(fromAddress);  
			message.addRecipient(RecipientType.TO, toAddress);  
			message.setSentDate(Calendar.getInstance().getTime());  
			message.setSubject(this.subject);  
			message.setContent(this.messageText, this.messageType); 
			
			// 3、发送邮件
			Transport transport = mailSession.getTransport("smtp");  
			transport.connect(this.host, this.fromUser, this.passwd);  
			transport.send(message, message.getRecipients(RecipientType.TO));
			return true;
		} catch (Exception e) {
			System.out.println("发送邮件出现异常");
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public String call() throws Exception {
		try {
			// 发送邮件
			sendMail();
			return Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAIL;
		}  
	}

}

class MyAuthenticator extends Authenticator{  
    String userName="";  
    String password="";  
    public MyAuthenticator(){  
          
    }  
    public MyAuthenticator(String userName,String password){  
        this.userName=userName;  
        this.password=password;  
    }  
     protected PasswordAuthentication getPasswordAuthentication(){     
        return new PasswordAuthentication(userName, password);     
     }   
} 
