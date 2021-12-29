package com.sunith.web.controller;

import com.sunith.web.service.ReadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data")
public class MyController {

    @Autowired
    ReadDataService readService;

    @GetMapping("read")
    public String getData(){
        return readService.readData();
    }
}
