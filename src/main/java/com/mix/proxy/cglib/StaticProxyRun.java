package com.mix.proxy.cglib;

public class StaticProxyRun {
	public static void main(String[] args) {
		HelloCglibTest t = new HelloCglibTest();
		HelloCglibTestProxy tp = new HelloCglibTestProxy();
		t = (HelloCglibTest) tp.createProxy(t);
		t.sayHello();
	}
}
