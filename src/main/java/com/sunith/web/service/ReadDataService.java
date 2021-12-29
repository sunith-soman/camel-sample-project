package com.sunith.web.service;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadDataService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public String readData(){
        return producerTemplate.requestBody("direct:helloWorld","hello",String.class);
    }
}
