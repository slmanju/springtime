package com.slmanju.aop.config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SendEmailAspect {

    @AfterReturning(pointcut = "@annotation(com.slmanju.aop.config.SendEmail)", returning = "result")
    public void sendEmail(Object result) {
        System.out.println("+--------------------------------------------+");
        System.out.println("+-- sending email with result " + result);
        System.out.println("+--------------------------------------------+");
    }

}
