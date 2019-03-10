package com.slmanju.springsecurity.restsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slmanju.springsecurity.restsecurity.config.UserPrincipal;
import com.slmanju.springsecurity.restsecurity.view.Message;

@RestController
public class HomeController {

    @GetMapping("/")
    public Message home() {
        return new Message("Hello world! This is the home page");
    }

    @GetMapping("/hello")
    public Message hello() {
        return new Message("Hello World");
    }

    @GetMapping("/me")
    public UserPrincipal me() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
