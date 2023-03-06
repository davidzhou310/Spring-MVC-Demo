package com.web.todo;

import java.util.Date;

import javax.validation.constraints.Size;

public class todo {
	
	private int id;
	private String User;
	
	//add validation
	@Size(min = 1, message = "Enter at least 6 characters")
	private String desc;
	
	private Date targetDate;
	private boolean isdone;
	
	public todo() {
	}
	
	public todo(int id, String user, String desc, Date targetDate, boolean isdone) {
		super();
		this.id = id;
		this.User = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isdone = isdone;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isIsdone() {
		return isdone;
	}
	public void setIsdone(boolean isdone) {
		this.isdone = isdone;
	}
	@Override
	public String toString() {
		return String.format("ToString - todo [id=%s, User=%s, desc=%s, isdone=%s]", id, User, desc, isdone);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		todo other = (todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
