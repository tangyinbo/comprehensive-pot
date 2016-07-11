package com.mix.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HelloCglibTestProxy implements MethodInterceptor{
	private HelloCglibTest helloCglibTest;
	
	public Object createProxy(HelloCglibTest helloCglibTest){
		this.helloCglibTest = helloCglibTest;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(helloCglibTest.getClass());
		enhancer.setCallback(this);
		enhancer.setClassLoader(helloCglibTest.getClass().getClassLoader());
		return enhancer.create();
	}
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println(method.getName());
		System.out.println("before invoke...");
		Object objs = methodProxy.invokeSuper(obj,args);
		System.out.println("after invoke...");
		return objs;
	}
}
