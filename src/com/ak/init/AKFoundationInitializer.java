package com.ak.init;

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

}
  

