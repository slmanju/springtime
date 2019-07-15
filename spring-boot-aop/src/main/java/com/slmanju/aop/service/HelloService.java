package com.slmanju.aop.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public void method1(String msg1, String msg2) {
        System.out.println(msg1 + " " + msg2);
    }

    public void method2() {
        System.out.println("method2");
    }

}
