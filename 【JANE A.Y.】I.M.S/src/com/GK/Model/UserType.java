package com.GK.Model;

public enum UserType {

	ADMIN("系统管理员", 0), TEACHER("教师", 1), STUDENT("学生", 3);

	private String name;
	private int index;

	private UserType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public void setName() {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setIndex() {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public String toString() {
		return this.name;
	}
}
