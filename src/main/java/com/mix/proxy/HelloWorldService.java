package com.mix.proxy;

public class HelloWorldService implements HelloWorldServiceI{
	@Override
	public void sayHello(){
		System.out.println("hello tangyinbo proxy");
	}
}
