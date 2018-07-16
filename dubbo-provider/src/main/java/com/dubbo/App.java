package com.dubbo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static final Log log = LogFactory.getLog(App.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","provider.xml"});
			context.start();
			log.info("provider starts successfully...");
		} catch (BeansException e) {
			e.printStackTrace();
			log.error("provider starts error:" + e.getMessage());
			if(context != null){
				context.close();
			}
		}

		synchronized (App.class) {
			while (true) {
				try {
					App.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:", e);
					log.info(e);
				}
			}
		}
	}
}
