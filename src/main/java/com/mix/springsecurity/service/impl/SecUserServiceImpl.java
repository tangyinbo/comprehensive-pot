package com.mix.springsecurity.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mix.springsecurity.dao.SecUserDao;
import com.mix.springsecurity.service.SecUserService;
import com.mix.system.domain.Role;
import com.mix.system.domain.SecRole;
import com.mix.system.domain.User;

public class SecUserServiceImpl implements SecUserService{
	@Autowired
	private SecUserDao secUserDao;
	
	@Override
	public User getUser(String username) {
		return secUserDao.getUser(username);
	}

	@Override
	public List<SecRole> getCurrentUserRoles(Long userId) {
		return secUserDao.getCurrentUserRoles(userId);
	}

	@Override
	public List<Map<String, String>> getAllResourceUrlMapping() {
		return secUserDao.getAllResourceUrlMapping();
	}

	@Override
	public List<Role> getAllRoles() {
		return secUserDao.getAllRoles();
	}

}
