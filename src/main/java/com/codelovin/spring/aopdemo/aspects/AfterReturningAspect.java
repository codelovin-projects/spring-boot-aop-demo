package com.codelovin.spring.aopdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAspect {

	private Logger logger = Logger.getLogger(AfterReturningAspect.class.getName());
	
    @AfterReturning("execution(* com.codelovin.spring.aopdemo.CarService.storeCar(..))")
    public void normalCheck(JoinPoint joinPoint) {
    	String typeName = joinPoint.getSignature().getDeclaringType().getSimpleName();
    	logger.info(typeName + "." + joinPoint.getSignature().getName() + " is returned successfully");
    }
}
