package com.mix.jdbctemplate;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-core.xml"})
public class JDBCTemplateTest extends TestCase{
	@Resource
	public UserDao userDao;
	@Test
	public void test1(){
		System.out.println(userDao.getUsers());
	}
	
	@Test
	public void test2(){
		userDao.updateUserName(2L, "8cc");
	}
	
	
	
	@org.junit.Before
	public void setUp(){
		System.out.println("before");
	}
	@After
	public void tearDown(){
		System.out.println("after");
	}
	
}
