package com.mix.springsecurity.service;

import java.util.List;
import java.util.Map;

import com.mix.system.domain.Role;
import com.mix.system.domain.SecRole;
import com.mix.system.domain.User;

/**
 * Spring security 使用
 * @author cowboy
 *
 */
public interface SecUserService {
	/**
	 * 根据根据用户名获取用户信息
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
	 * 获取资源URL权限映射
	 * @return
	 */
	List<Map<String, String>> getAllResourceUrlMapping();
	/**
	 * 获取用户所有角色
	 * @return
	 */
	List<Role> getAllRoles();

}
