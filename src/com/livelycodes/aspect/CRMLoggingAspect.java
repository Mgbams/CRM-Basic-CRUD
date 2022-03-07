package com.livelycodes.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {

	// Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// Setup pointcut declarations
	@Pointcut("execution(* com.livelycodes.controller.*.*(..))")
	private void forControllerPackage() {
	}

	// Do the same for service and dao package
	@Pointcut("execution(* com.livelycodes.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.livelycodes.service.*.*(..))")
	private void forServicePackage() {
	}

	// Combine them for the app flow
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {
	}

	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display method that we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @Before: calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop through and display the arguments
		for (Object tempArg : args) {
			myLogger.info("======>> argument: " + tempArg);
		}
	}

	// Add @AfterRunning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method that we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @AfterReturning: from method: " + theMethod);
		
		// display data returned
		myLogger.info("======>> Result: " + theResult);
	}
}
