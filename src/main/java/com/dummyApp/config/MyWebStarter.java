package com.dummyApp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebStarter extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // No root configuration for this example
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class}; // Specify your configuration class
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Map the DispatcherServlet to /
    }
}
