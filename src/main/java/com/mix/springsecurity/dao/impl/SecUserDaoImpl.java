package com.mix.springsecurity.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mix.basic.BaseDao;
import com.mix.springsecurity.dao.SecUserDao;
import com.mix.system.domain.Role;
import com.mix.system.domain.SecRole;
import com.mix.system.domain.User;

@Repository
public class SecUserDaoImpl extends BaseDao implements SecUserDao{

	@Override
	public User getUser(String username) {
		String sql = "select user_id,us.username,us.password,us.status from T_SEC_USER us where us.username = ?";
		List<User> users = this.jdbcTemplate.query(sql, new Object[]{username}, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getLong("USER_ID"),rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getString("STATUS"));
			}});
		if(users != null && users.size()>0){
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<SecRole> getCurrentUserRoles(Long userId) {
		String sql = "select r.role_id,r.role_name,r.role_desc,r.status from t_sec_user_role sr inner join t_sec_role r on sr.role_id = r.role_id where sr.user_id = ?";
		List<SecRole> roles = this.jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<SecRole>(){
			@Override
			public SecRole mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new SecRole(rs.getLong("ROLE_ID"),rs.getString("role_name"),rs.getString("role_desc"),rs.getString("status"));
			}});
		return roles;
	}

	@Override
	public List<Map<String, String>> getAllResourceUrlMapping() {
		String sql = 
					"select r.res_url,rl.role_name\n" +
					"  from t_sec_resc r\n" + 
					" inner join t_sec_resc_role sr\n" + 
					"    on r.resc_id = sr.resc_id\n" + 
					" inner join t_sec_role rl\n" + 
					"    on sr.role_id = rl.role_id";
		List<Map<String,String>> resourceRoleMapping = this.jdbcTemplate.query(sql, new RowMapper<Map<String,String>>(){

			@Override
			public Map<String, String> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Map<String,String> urlRoleMap = new HashMap<String,String>();
				urlRoleMap.put(rs.getString("RES_URL"), rs.getString("ROLE_NAME"));
				return urlRoleMap;
			}});
		return resourceRoleMapping;
	}

	@Override
	public List<Role> getAllRoles() {
		String sql = "select role_name from t_sec_role";
		List<Role> roles =  this.jdbcTemplate.query(sql,new RowMapper<Role>(){
			@Override
			public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Role(rs.getString("role_name"));
			}});
		return roles;
	}

}
