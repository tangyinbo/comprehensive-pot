package com.mix.springmvc.comvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.mix.springmvc.domain.PhoneNumberModel;

public class StringToPhoneNumberConverter implements Converter<String, PhoneNumberModel>{
	Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");

	@Override
	public PhoneNumberModel convert(String source) {
		if (!StringUtils.hasLength(source)) {
			// �����sourceΪ�շ���null
			return null;
		}
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches()) {
			// �����ƥ�����ת��
			PhoneNumberModel phoneNumber = new PhoneNumberModel();
			phoneNumber.setAreaCode(matcher.group(1));
			phoneNumber.setPhoneNumber(matcher.group(2));
			return phoneNumber;
		} else {
			// �������ƥ��ת��ʧ��
			throw new IllegalArgumentException(String.format(
					" ����ת��ʧ�ܣ� ��Ҫ��ʽ[010-12345678]������ʽ��[%s]", source));
		}
	}
}
