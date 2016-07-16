package com.mix.basic;

import java.util.Date;
/**
 * 对象基本属性
 * @author cowboy
 *
 */
public class BasicEntity {
	private long create_by;
	private Date create_date;
	private Long update_by;
	private Date update_date;
	private Long version;
	public long getCreate_by() {
		return create_by;
	}
	public void setCreate_by(long create_by) {
		this.create_by = create_by;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Long getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(Long update_by) {
		this.update_by = update_by;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
}
