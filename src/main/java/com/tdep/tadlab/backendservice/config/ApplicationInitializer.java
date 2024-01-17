package com.tdep.tadlab.backendservice.config;


import jakarta.servlet.ServletContext;

import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext container) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.setConfigLocation("com.tdep.tadlab.backendservice.config");

    container.addListener(new ContextLoaderListener(context));

    ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));

    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
