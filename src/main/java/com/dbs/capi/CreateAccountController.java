package com.dbs.capi;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.restlet.RestletComponent;
import org.apache.camel.spring.boot.FatJarRouter;
import org.restlet.Component;
import org.restlet.ext.spring.SpringServerServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreateAccountController extends FatJarRouter  {

	@Override
    public void configure() throws Exception {
		intercept().to("log:intercepted hello");
        
		restConfiguration().component("restlet");
    	
        rest("/hello").get().to("direct:hello");
        
        from("direct:hello").transform().simple("Hello World!");
        
        from("direct:getPersons")
        	.transform()
        	.simple("Hello World!")
        		.to("log:bar");
        	
        /*
        from("timer:bar")
        	.transform()
        	.simple("Hello World! timer")
        		.to("direct:getPersons");
        */
    }
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
	    	
		SpringServerServlet serverServlet = new SpringServerServlet();
	    ServletRegistrationBean regBean = new ServletRegistrationBean( serverServlet, "/api/*");
	    	
	    Map<String,String> params = new HashMap<String,String>();
	    	
	    params.put("org.restlet.component", "restletComponent");
	    	
	    regBean.setInitParameters(params);
	    	
	    return regBean;
	}
	    
	    
	    @Bean
	    public Component restletComponent() {
	    	return new Component();
	    }
	    
	    @Bean
	    public RestletComponent restletComponentService() {
	    	return new RestletComponent(restletComponent());
	    }
}
