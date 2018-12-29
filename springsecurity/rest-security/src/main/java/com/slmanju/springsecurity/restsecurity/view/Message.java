package com.slmanju.springsecurity.restsecurity.view;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data @AllArgsConstructor
public class Message {

    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
