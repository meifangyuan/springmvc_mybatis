package com.org.meify.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("session被创建......");
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("session被销毁......");
    }
	
}
