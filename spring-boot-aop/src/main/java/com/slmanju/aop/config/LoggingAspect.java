package com.slmanju.aop.config;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.slmanju.aop.service..*.*(..))")
    private void allServices() {
    }

    @Around("allServices()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String args = Arrays.toString(joinPoint.getArgs());
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        try {
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            String message = className + "." + methodName + "(" + args + ") : " + elapsedTime + "ms";
            LOGGER.info(message);
            return result;
        } catch (Exception exception) {
            LOGGER.error(
                    "Exception " + exception.getMessage() + " in " + className + "." + methodName + "(" + args + ")");
            throw exception;
        }
    }

}
