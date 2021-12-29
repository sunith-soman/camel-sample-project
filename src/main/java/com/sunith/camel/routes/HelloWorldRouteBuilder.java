package com.sunith.camel.routes;

import com.sunith.camel.expressions.TestExpressions;
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

        from("file:/Users/sunith/tech/data?noop=true")
                .transform(new TestExpressions())
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println(exchange.getIn().getBody(String.class));
                    }
                })
                .pollEnrich()
        .end();
    }
}
