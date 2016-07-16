package com.mix.springsecurity.authorization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import com.mix.springsecurity.service.SecUserService;
import com.mix.system.domain.Role;

/**
 * 初始化资源角色映射关系
 * @author cowboy
 *
 */
public class SecFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	/* 保存资源和权限的对应关系 key-资源url value-权限 */
	private final Map<String, Collection<ConfigAttribute>> relationMap;

	private List<String> noContralUrls;
	/**
	 * 公共资源扩展接口
	 */
	private SecPublicResource secPublicResource;
	
	private SecUserService secUserService;

	/**
	 * 类初始化的时候初始化资源
	 */
	public SecFilterInvocationSecurityMetadataSource(SecUserService secUserService) {
		this.secUserService = secUserService;
		// 初始化资源权限描述
		relationMap = initAllResourcesRoleRel();

	}

	/**
	 * 初始化资源角色关系,用于在访问时查看资源需要那些权限
	 * @return
	 */
	private Map<String, Collection<ConfigAttribute>> initAllResourcesRoleRel() {
		// 初始化所有的资源和权限的对应关系
		List<Map<String, String>> resourceUrlMapping = secUserService.getAllResourceUrlMapping();
		Map<String, Collection<ConfigAttribute>> relationMap = new HashMap<String, Collection<ConfigAttribute>>();
		if (resourceUrlMapping != null && resourceUrlMapping.size() > 0) {
			for (Map<String, String> rm : resourceUrlMapping) {
				for (Iterator<Map.Entry<String, String>> it = rm.entrySet()
						.iterator(); it.hasNext();) {
					Map.Entry<String, String> en = it.next();
					Collection<ConfigAttribute> _roles = relationMap.get(en
							.getKey());
					if (_roles == null) {
						_roles = new HashSet<ConfigAttribute>();
						relationMap.put(en.getKey(), _roles);
					}
					_roles.add(new SecurityConfig(en.getValue()));
					break;
				}
			}
		}
		
		// start 公共资源,所有角色具有权限访问**********************************************
		List<String> _publicUrls = new ArrayList<String>();
		//拓展接口资源
		if (secPublicResource != null) {
			List<String> _publicUrls2 = secPublicResource.getPublicRrls();
			if (_publicUrls2 != null) {
				_publicUrls.addAll(_publicUrls2);
			}
		}

		//静态配置资源
		if (noContralUrls != null) {
			_publicUrls.addAll(noContralUrls);
		}
		if (_publicUrls != null && _publicUrls.size() > 0) {
			List<Role> roles = secUserService.getAllRoles();
			if (roles != null && roles.size()>0) {
				for (String pubUrl : _publicUrls) {
					for (Role r : roles) {
						Collection<ConfigAttribute> _roles = relationMap
								.get(pubUrl);
						if (_roles == null) {
							_roles = new HashSet<ConfigAttribute>();
							relationMap.put(pubUrl, _roles);
						}
						_roles.add(new SecurityConfig(r.getRoleName()));
					}
				}
			}
		}
		// end 公共资源,所有角色具有权限访问**********************************************

		return relationMap;
	}

	/**
	 * 用于匹配资源描述符
	 */
	private AntPathMatcher urlMatcher = new AntPathMatcher();

	/**
	 * 获取当前的请求资源描述符对应的所需要的权限
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		// 获取请求的url地址
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		// 获取请求的资源路径
		if (requestUrl.indexOf("?") != -1) {
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		if (relationMap.containsKey(requestUrl)) {
			return relationMap.get(requestUrl);
		} else {
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
			configAttributes.add(new SecurityConfig("ROLE_NO_USER"));
			return configAttributes;
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

}
