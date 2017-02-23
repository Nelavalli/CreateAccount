package com.dbs.capi;

import org.apache.camel.builder.RouteBuilder;

public class MyRoute extends RouteBuilder {

	@Override
    public void configure() throws Exception {
        from("timer:foo")
          .to("log:bar");
    }
}
