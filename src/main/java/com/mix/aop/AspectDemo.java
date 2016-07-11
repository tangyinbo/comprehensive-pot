package com.mix.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {
	@Pointcut(value="execution(* com.mix.aop.*Service.*(..))")
	public void testHello(){}
	
	@Before(value="testHello()")
	public void before(){
		System.out.println("before");
	}
	
}
