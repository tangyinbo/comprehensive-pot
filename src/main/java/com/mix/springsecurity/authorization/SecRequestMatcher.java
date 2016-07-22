package com.mix.springsecurity.authorization;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

public class SecRequestMatcher implements RequestMatcher {
	private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.web.util.matcher.RequestMatcher#matches(javax.
	 * servlet.http.HttpServletRequest)
	 */
	public boolean matches(HttpServletRequest request) {
		return false;
	}
}
