package com.shijihui.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanUtils {
	private static ApplicationContext cxt;

	static  {
		cxt = new ClassPathXmlApplicationContext("applicationContext*.xml");
	}

	public static Object getBean(String beanId) {
		return cxt.getBean(beanId);

	}

}