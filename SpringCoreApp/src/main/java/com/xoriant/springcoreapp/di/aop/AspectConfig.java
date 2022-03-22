package com.xoriant.springcoreapp.di.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectConfig {
	
	//This method to execute before get account number
	//@Before("getAccountCall()")
	public void callBeforeGetAccountNumber(JoinPoint joinPoint) {
		System.out.println("Aspect callBeforeGetAccountNumber "+joinPoint.getSignature());
		Account account =(Account)joinPoint.getTarget();
		System.out.println("Aspect callBeforeGetAccountNumber "+account);
	}
	
	//This method to execute before get account number
	//@After("getAccountCall()")
	public void callAfterGetAccountNumber() {
			System.out.println("Aspect callAfterGetAccountNumber");
	}
	
	//@Before("execution(* *get*())")
	public void callBeforeAnyGetReturntypeInt() {
		System.out.println("Aspect callBeforeAnyGetReturntypeInt");
}
	
	//@Pointcut("execution(* *get*())")
	public void getAccountCall() {}
	
	//@Around("execution(* *get*())")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		
		System.out.println("Before any Get Call Around Advice");
		
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		System.out.println("After any Get Call Around Advice");
	}
	
	//@AfterReturning(pointcut = "execution(* *get*())", returning = "someValue")
	public void afterReturningAdvice(Object someValue) {
		
		System.out.println("After Returing advice and The returned value for each Get call "+someValue);
	}
	
	//@AfterThrowing(pointcut = "execution(* *com.xoriant.springcore.di.aop.Address.get*())", throwing = "ex")
	public void afterThrowingAdvice(Exception ex) {
		System.out.println("After Throwing Advice with exception "+ex);
	}
	
	@Before("@annotation(MyAnnotation)")
	public void customAnnotationAspectCall() {
		System.out.println("Custom Annotation Aspect called");
	}

}







