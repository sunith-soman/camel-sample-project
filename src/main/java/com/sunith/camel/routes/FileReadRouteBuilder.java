package com.sunith.camel.routes;

import com.sunith.camel.expressions.TransformExpressions;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileReadRouteBuilder extends RouteBuilder {

    @Autowired
    TransformExpressions transformExpressions;

    @Override
    public void configure() throws Exception {

        from("file:/Users/sunith/tech/data?noop=true")
            .transform(transformExpressions)
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    System.out.println(exchange.getIn().getBody(String.class));
                }
            })
        .end();
    }
}
