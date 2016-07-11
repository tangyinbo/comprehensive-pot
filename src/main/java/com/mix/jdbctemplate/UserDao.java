package com.mix.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mix.basic.BaseDao;
import com.mix.springmvc.domain.Cowbt;

@Repository
public class UserDao extends BaseDao{
	@Autowired
	private BBDao bbDao;
	
	public List<Cowbt> getUsers(){
		return this.jdbcTemplate.query("select * from cowbt",new Object[]{}, new RowMapper<Cowbt>(){
			@Override
			public Cowbt mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cowbt temp = new Cowbt();
				temp.setName(rs.getString("name"));
				return temp;
			}});
	}
	
	public void updateUserName(Long userId,String userName){
		String sql = "update cowbt t set t.name = ? where t.id = ?";
		int effectRows = this.jdbcTemplate.update(sql,userName,userId);
		System.out.println("effectRows:"+effectRows);
		bbDao.doNtTest();
		int a = 1/0;
		System.out.println("..........................."+effectRows);
	}
	

}
