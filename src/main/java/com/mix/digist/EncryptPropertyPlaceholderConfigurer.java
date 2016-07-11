package com.mix.digist;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	/**
	 * @Fields encryptPropNames : ��Ҫ���ܵ��ֶ�
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
		//����
		return value;
	}

	/**
	 * @Title: У��
	 * @Description: �ж��Ƿ��Ǽ��ܵ�����
	 * @param propertyName
	 *            ��������
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
