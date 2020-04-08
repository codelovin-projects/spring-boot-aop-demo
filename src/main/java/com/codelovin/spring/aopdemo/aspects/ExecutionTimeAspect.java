package com.codelovin.spring.aopdemo.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class ExecutionTimeAspect {
 
    private Logger logger = Logger.getLogger(ExecutionTimeAspect.class.getName());
 
    @SuppressWarnings("rawtypes")
	@Around("execution(* com.codelovin.spring.aopdemo..*(..))")
    //@Around("execution(* com.codelovin.spring.aopdemo.CarService.*(..))")
    //@Around("execution(* com.codelovin.spring.aopdemo.CarRepository.*(..))")
    //@Around("execution(* com.codelovin.spring.aopdemo.CarController.*(..))")
    public Object findExecutionTimeOfAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
    {
        MethodSignature mSig = (MethodSignature) proceedingJoinPoint.getSignature();
          
        String className = mSig.getDeclaringType().getSimpleName();
        String methodName = mSig.getName();
        
        Class[] types = mSig.getParameterTypes();
        
        StringBuilder paramList = new StringBuilder("(");
        int numOfParams = types.length;
        for (int i = 0; i < numOfParams; i++) {
        	paramList.append(types[i].getSimpleName());
        	if (i < (numOfParams - 1)) {
        		paramList.append(",");
        	}
        }
        paramList.append(")");
          
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
  
        logger.info("Execution time of " + className + "." + methodName + paramList.toString() + " "
                            + "is " + stopWatch.getTotalTimeMillis() + " ms");
  
        return result;
    }
}
