package com.codelovin.spring.aopdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAfterAspect {

	private Logger logger = Logger.getLogger(LoggingAfterAspect.class.getName());
	
    @After("execution(* com.codelovin.spring.aopdemo.CarService.*(..))")
    public void logAfterCall(JoinPoint joinPoint) {
    	
    	String typeName = joinPoint.getSignature().getDeclaringType().getSimpleName();
    	
    	logger.info(typeName + "." + joinPoint.getSignature().getName() + " is completed.");
    }
}
