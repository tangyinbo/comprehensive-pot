package com.mix.springsecurity.authorization;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.web.FilterInvocation;

public class SecSecurityInterceptor extends AbstractSecurityInterceptor {
	
	private SecurityMetadataSource securityMetadataSource;

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return null;
	}

}