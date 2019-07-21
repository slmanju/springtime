package com.slmanju.springbootdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = { "", "/"})
    public String index() {
        return "Welcome to spring boot docker integration";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello world";
    }

}
