package com.mix.aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-core.xml"})
public class AspectTest {
	@Resource
	private TestAspectService testAspectService;
	
	@Test
	public void test1(){
		testAspectService.hello();
	}
}
