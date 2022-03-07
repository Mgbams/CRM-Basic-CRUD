package com.livelycodes.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// Setup pointcut declarations
	@Pointcut("execution(* com.livelycodes.controller.*.*.(..))")
	private void forControllerPackage() {
	}

	// Do the same for service and dao package
	@Pointcut("execution(* com.livelycodes.dao.*.*.(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.livelycodes.service.*.*.(..))")
	private void forServicePackage() {
	}
	
	// Combine them for the app flow
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void appFlow() {}
	
	// Add @Before advice

	// Add @AfterRunning advice
}
