package com.mix.proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
	public static void main(String[] args) {
		HelloWorldServiceI service = new HelloWorldService();
		HelloWorldServiceProxy proxy = new HelloWorldServiceProxy(service);
		service = (HelloWorldServiceI) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), service.getClass().getInterfaces(), proxy);
		service.sayHello();
	}
}
