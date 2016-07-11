package com.cowboy.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class DataSourceTest {
	public static void main(String[] args) throws BeansException, SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-core.xml");
		Connection conn = ((DruidDataSource)context.getBean("druidDataSource")).getConnection();	
		DatabaseMetaData md = conn.getMetaData();
		
	}
}
