package com.slmanju.aop.service;

import com.slmanju.aop.pointcuts.LoggableAfter;
import com.slmanju.aop.pointcuts.LoggableAround;
import com.slmanju.aop.pointcuts.LoggableBefore;
import org.springframework.stereotype.Component;

@Component
public class DemoService {

    @LoggableAround
    public void method1() throws InterruptedException {
        System.out.println("hello from method1");
        Thread.sleep(1000);
//        throw new NullPointerException("hah haa");
    }

    @LoggableBefore
    public void method2(String message, Integer id) {
        System.out.println("hello from method2");
        System.out.println(message + " " + id);
    }

    @LoggableAfter
    public String method3() {
        return "Hello from method3";
    }

}
