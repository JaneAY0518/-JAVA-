package com.GK.Model;

public class Student {
	private int id;
	private String name;
	private int classId;
	private String password;
	private String sex;

	public void setid(int id) {
		this.id = id;
	}

	public int getid() {
		return id;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getname() {
		return name;
	}

	public void setclassId(int classId) {
		this.classId = classId;
	}

	public int getclassId() {
		return classId;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getpassword() {
		return password;
	}

	public void setsex(String sex) {
		this.sex = sex;
	}

	public String getsex() {
		return sex;
	}
}
