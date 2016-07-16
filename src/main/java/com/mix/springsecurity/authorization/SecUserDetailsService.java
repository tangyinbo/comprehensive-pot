package com.mix.springsecurity.authorization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mix.springsecurity.service.SecUserService;
import com.mix.system.domain.SecRole;
import com.mix.system.domain.User;
/**
 * spring security 获取用户基本权限信息
 * @author cowboy
 *
 */
public class SecUserDetailsService implements UserDetailsService {
    @Autowired
	private SecUserService secUserService;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		/**
		 * 获取当前登录用户的基本信息
		 */
		User currentUser = secUserService.getUser(username);
		if (currentUser == null) {
			throw new UsernameNotFoundException("帐号或密码错误");
		}
		/**
		 * 获取登录用户的权限信息
		 */
		List<SecRole> roles = secUserService.getCurrentUserRoles(currentUser.getUserId());
		Set<GrantedAuthority> grantedRoleAuthoritys = new HashSet<GrantedAuthority>();
		if(roles != null){
			for(SecRole role:roles){
				grantedRoleAuthoritys.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
		}
		/**
		 *返回用户的信息
		 */
		return new org.springframework.security.core.userdetails.User(currentUser.getUsername(),
																	  currentUser.getPassword(), 
																	  true, 
																	  true,
																	  true, 
																	  true, 
																	  grantedRoleAuthoritys);
	}

}
