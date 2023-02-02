package com.cjc.co.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		
		AnnotationConfigWebApplicationContext acwc = new AnnotationConfigWebApplicationContext();		
		acwc.register(AppConfig.class);
		
//		context --> for whole project
//		config --> for ..???
		
		acwc.setServletContext(sc);
		
		ServletRegistration.Dynamic sDynamic = sc.addServlet("dispatcher", new DispatcherServlet(acwc));
		sDynamic.addMapping("/");
	}
}
