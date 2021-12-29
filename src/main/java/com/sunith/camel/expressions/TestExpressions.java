package com.sunith.camel.expressions;

import org.apache.camel.Exchange;
import org.apache.camel.Expression;

public class TestExpressions implements Expression {

    @Override
    public <T> T evaluate(Exchange exchange, Class<T> type) {
        String body = exchange.getIn().getBody(String.class);
        return (T)("body is:"+body);
    }
}
