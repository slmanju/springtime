package com.manjula.crud.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.manjula.crud.service..*.*(..))")
    protected void service() {}

    @Around("service()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String args = Arrays.toString(joinPoint.getArgs());
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        try {
            Object result = joinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - start;
            String message = className + "." + methodName + "(" + args + ") : " + elapsedTime + "ms";
            if (logger.isDebugEnabled()) {
                logger.debug(message);
            } else {
                logger.info(message);
            }
            return result;
        } catch (Exception e) {
            logger.error("Exception " + e.getMessage() + " in " + className + "." + methodName + "(" + args + ")");
            throw e;
        }
    }

}
