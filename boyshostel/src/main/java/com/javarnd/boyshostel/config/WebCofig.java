package com.javarnd.boyshostel.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebCofig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(CustomDispatcherConfig.class);


        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ApplicationConfiguration.class);
        
		applicationContext.setServletContext(servletContext);

		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(applicationContext);
		
		servletContext.addListener(contextLoaderListener);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", dispatcherServlet);
		
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.addMapping("/");

	}

}
