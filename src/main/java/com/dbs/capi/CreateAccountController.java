package com.dbs.capi;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountController extends FatJarRouter  {

	@Override
    public void configure() throws Exception {
        
        from("direct:getPersons")
        	.transform()
        		.simple("Hello World!");
        	
        
    }
}
