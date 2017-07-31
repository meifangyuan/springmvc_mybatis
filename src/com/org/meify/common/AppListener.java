package com.org.meify.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {


    public AppListener() {
    	
    }


    public void contextDestroyed(ServletContextEvent arg0)  {
    	System.out.println("App 销毁......");
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("App 初始化......");
    }
	
}
