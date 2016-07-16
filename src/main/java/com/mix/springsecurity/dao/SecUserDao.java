package com.mix.springsecurity.dao;

import java.util.List;
import java.util.Map;

import com.mix.system.domain.Role;
import com.mix.system.domain.SecRole;
import com.mix.system.domain.User;

/**
 * Spring Security 使用
 * @author cowboy
 *
 */
public interface SecUserDao {
	/**
	 * 获取用户信息
	 * @param username
	 * @return
	 */
	User getUser(String username);
	/**
	 * 获取当前用户角色
	 * @param userId
	 * @return
	 */
	List<SecRole> getCurrentUserRoles(Long userId);
	/**
	 * 获取资源和权限映射
	 * @return
	 */
	List<Map<String, String>> getAllResourceUrlMapping();
	/**
	 * 获取所有角色数据
	 * @return
	 */
	List<Role> getAllRoles();

}
