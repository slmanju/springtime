package com.slmanju.oauthserver.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = { "", "/" })
    public Message home() {
        return new Message("Hello OAuth");
    }

    @GetMapping(value = { "/suser" })
    public Message suser() {
        return new Message("Hello User");
    }

    @GetMapping(value = { "/sadmin" })
    public Message sadmin() {
        return new Message("Hello Admin");
    }

    @Getter @Setter @AllArgsConstructor
    public static class Message {
        private String text;
    }

}
