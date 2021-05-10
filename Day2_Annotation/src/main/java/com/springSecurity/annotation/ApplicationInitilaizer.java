package com.springSecurity.annotation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.springSecurity.annotation.config.ApplicationConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitilaizer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
       AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfiguration.class);
        context.setServletContext(sc);
        ServletRegistration.Dynamic servlet = sc.addServlet("dispacher" , new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
    
}
