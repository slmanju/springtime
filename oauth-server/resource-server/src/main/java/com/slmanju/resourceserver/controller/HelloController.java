package com.slmanju.resourceserver.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = { "", "/" })
    public Message home() {
        return new Message("Hello OAuth Resource Server");
    }

    @GetMapping(value = { "/suser" })
    public Message suser() {
        return new Message("Hello User Resource Server");
    }

    @GetMapping(value = { "/sadmin" })
    public Message sadmin() {
        return new Message("Hello Admin Resource Server");
    }

    @Getter @Setter @AllArgsConstructor
    public static class Message {
        private String text;
    }

}
