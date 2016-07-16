package com.mix.system.domain;

import com.mix.basic.BasicEntity;

/**
 * 角色
 * @author cowboy
 *
 */
public class SecRole extends BasicEntity{
	  private Long roleId;
	  private String roleName;
	  private String roleDesc;
	  private String status;
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
	public SecRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SecRole(Long roleId, String roleName, String roleDesc, String status) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.status = status;
	}

}
