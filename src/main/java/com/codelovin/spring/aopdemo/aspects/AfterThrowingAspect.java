package com.codelovin.spring.aopdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspect {

	private Logger logger = Logger.getLogger(AfterThrowingAspect.class.getName());
	
    @AfterThrowing(pointcut = "execution(* com.codelovin.spring.aopdemo.CarService.storeCar(..))", throwing = "ex")
    public void afterTrowing(IllegalArgumentException ex) {
    	logger.info("AfterThrowingAspect: " + ex.getMessage());
    }
}
