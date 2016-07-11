package com.mix.digist;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	/**
	 * @Fields encryptPropNames : 需要加密的字段
	 */
	private String[] encryptPropNames;

	public String[] getEncryptPropNames() {
		return encryptPropNames;
	}

	public void setEncryptPropNames(String[] encryptPropNames) {
		this.encryptPropNames = encryptPropNames;
	}

	@Override
	protected String convertProperty(String key,String value) {
		System.out.println(key+"====>:"+value);
		//解密
		return value;
	}

	/**
	 * @Title: 校验
	 * @Description: 判断是否是加密的属性
	 * @param propertyName
	 *            属性名字
	 * @return boolean
	 * @throws
	 */
	private boolean isEncryptProp(String propertyName) {
		for (String encryptPropName : encryptPropNames) {
			if (encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}
