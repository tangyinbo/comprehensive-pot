package com.mix.system.domain;

public class Role {
	private long  roleIDd;
	private String  roleName;
	private String roleDesc;
	private String status;
	private String roleType;
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getRoleIDd() {
		return roleIDd;
	}
	public void setRoleIDd(long roleIDd) {
		this.roleIDd = roleIDd;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
}
