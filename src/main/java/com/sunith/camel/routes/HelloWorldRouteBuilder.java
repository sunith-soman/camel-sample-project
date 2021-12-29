package com.sunith.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:helloWorld")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setBody("Hello World");
                    }
                })
        .end();
    }
}
