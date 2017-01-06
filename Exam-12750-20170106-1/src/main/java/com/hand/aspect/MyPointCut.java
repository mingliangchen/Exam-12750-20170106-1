package com.hand.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect  
@Component
public class MyPointCut {
	
	
	@Pointcut("execution(* com.hand.service.*.*(..))")
	//@Pointcut(value="")
	public void mp(){}
	
	@Pointcut("execution(* com.hand.service..*.update(..))")
	//@Pointcut(value="")
	public void mp123(){}
	
	
	//@Before(value="mp()")
	public void before(){
		System.out.println("调用了before 方法");
	}
	
	//@After(value="mp()")
	public void after(){
		System.out.println("调用了after方法 ");
	}
	 @Around(value="mp()")    
	    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {    
	        long begin = System.currentTimeMillis();  
	        Object o = pjp.proceed();    
	        long end = System.currentTimeMillis();  
	        System.out.println("方法运行时间："+(end-begin) );
	        return o;    
	    }
	//@AfterReturning(value="mp()")
	public void afterReturning(){
		System.out.println("调用了afterReturning 方法");
	}
	

}
