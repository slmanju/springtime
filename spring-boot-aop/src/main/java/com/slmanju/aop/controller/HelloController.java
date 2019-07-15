package com.slmanju.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slmanju.aop.config.SendEmailPointCut;
import com.slmanju.aop.service.HelloService;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/api1")
    public String api1() {
        helloService.method1("Hello", "World");
        return "api1";
    }

    @SendEmailPointCut
    @GetMapping("/api2")
    public String api2() {
        helloService.method2();
        return "api2";
    }

    @SendEmailPointCut
    @GetMapping("/api3")
    public String api3() {
        helloService.method1("Hello", "World");
        return "api3";
    }

}
