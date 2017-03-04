package com.dbs.capi;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends FatJarRouter  {

	@Override
    public void configure() throws Exception {
        from("timer:foo")
          .to("log:bar");
    }
}
