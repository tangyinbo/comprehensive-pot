package com.mix.basic;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleConnection;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

public class VPdDataSource extends DruidDataSource implements BasicDataSource{
	@Override
	public DruidPooledConnection getConnection() throws SQLException {
		return super.getConnection();
	}
	
	
}
