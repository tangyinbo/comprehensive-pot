package com.mix.system.domain;

import java.util.Date;

import com.mix.basic.BasicEntity;

/**
 * 系统用户
 * 
 * @author cowboy
 * 
 */
public class User extends BasicEntity{
	private Long userId;
	private String username;
	private String password;
	private String mobileTelephone;
	private String email;
	private String addr;
	private String nationality;
	private String sex;
	private Date birthdate;
	private String credentials_type;
	private String credentials_number;
	private String status;
	private long lv;
	private String descn;
	private String name;
	public User(Long userId,String username, String password, String status) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileTelephone() {
		return mobileTelephone;
	}
	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getCredentials_type() {
		return credentials_type;
	}
	public void setCredentials_type(String credentials_type) {
		this.credentials_type = credentials_type;
	}
	public String getCredentials_number() {
		return credentials_number;
	}
	public void setCredentials_number(String credentials_number) {
		this.credentials_number = credentials_number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getLv() {
		return lv;
	}
	public void setLv(long lv) {
		this.lv = lv;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
