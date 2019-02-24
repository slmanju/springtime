package com.slmanju.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(com.slmanju.aop.pointcuts.LoggableAround)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String args = Arrays.toString(joinPoint.getArgs());
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        try {
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            String message = className + "." + methodName + "(" + args + ") : " + elapsedTime + "ms";
            System.out.println(message);
            return result;
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage() + " in " + className + "." + methodName + "(" + args + ")");
            throw e;
        }
    }

    @Before(value = "@annotation(com.slmanju.aop.pointcuts.LoggableBefore) && args(message, id)", argNames = "message,id")
    public void before(String message, Integer id) {
        System.out.println(":: logging method2 hiting the method ::");
        System.out.println(":: log method2 " + message + " " + id);
    }

    @AfterReturning(pointcut = "@annotation(com.slmanju.aop.pointcuts.LoggableAfter)", returning = "retVal")
    public void after(Object retVal) {
        System.out.println(":: logging method3 method returns ::");
        System.out.println(":: log method3 " + retVal);
    }

}
