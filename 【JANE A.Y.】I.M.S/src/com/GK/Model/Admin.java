package com.GK.Model;

public class Admin {
	private int id;
	private String name;
	private String password;
	private String createDate;

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

	public void setpassword(String password) {
		this.password = password;
	}

	public String getpassword() {
		return password;
	}

	public void setcreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getcreateDate() {
		return createDate;
	}

}
