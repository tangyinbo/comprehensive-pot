package com.mix.jdbctemplate;

import org.springframework.stereotype.Repository;

import com.mix.basic.BaseDao;

@Repository
public class BBDao extends BaseDao{
	public void doNtTest(){
		String sql = "update cowbt t set t.name = '123' where t.id = 3";
		int effectRows = this.jdbcTemplate.update(sql);
		System.out.println("effectRows=>"+effectRows);
	}
}
