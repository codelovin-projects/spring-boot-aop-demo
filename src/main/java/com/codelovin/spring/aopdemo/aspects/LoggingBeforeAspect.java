package com.codelovin.spring.aopdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingBeforeAspect {

	private Logger logger = Logger.getLogger(LoggingBeforeAspect.class.getName());
	
    @Before("execution(* com.codelovin.spring.aopdemo.CarService.*(..))")
    public void logBeforeCall(JoinPoint joinPoint) {
    	
    	String typeName = joinPoint.getSignature().getDeclaringType().getSimpleName();
    	
    	logger.info(typeName + "." + joinPoint.getSignature().getName() + " is being called");
    }
}
