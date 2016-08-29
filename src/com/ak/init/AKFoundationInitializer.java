package com.ak.init;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ak.security.SecurityConfiguration;

public class AKFoundationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	
  
    @Override
    protected Class<?>[] getRootConfigClasses() {
    	System.out.println("inside the root config");
        return new Class[] { WebAppConfig.class,SecurityConfiguration.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
    	//return new Class<?>[] {WebAppConfig.class, SecurityConfig.class};
    	return null;
    }
   
    @Override
    protected String[] getServletMappings() {
    	System.out.println("inside the servlet mapping");

        return new String[] { "/" };
    }
     
  /*  @Override
    protected Filter[] getServletFilters() {
    	System.out.println("inside the filetsr");

        Filter [] singleton = { new CORSFilter() };
        return singleton;
    }
    
    
    
  */
    
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }
 
    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }
 
    private static final String LOCATION = "/Users/gdharumar/Documents/Personal/"; // Temporary location where files will be stored
 
    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
                                                        // Beyond that size spring will throw exception.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
     
    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk


}
  

