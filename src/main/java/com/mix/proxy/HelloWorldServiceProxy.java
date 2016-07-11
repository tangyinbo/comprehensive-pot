package com.mix.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldServiceProxy implements InvocationHandler{
	private HelloWorldServiceI service;
	
	public HelloWorldServiceProxy(HelloWorldServiceI service) {
		super();
		this.service = service;
	}

	public HelloWorldServiceProxy() {
		super();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before....");
		Object result = method.invoke(service, args);
		System.out.println("after....");
		return result;
	}

}
