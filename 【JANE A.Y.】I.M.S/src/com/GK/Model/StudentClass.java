package com.GK.Model;

public class StudentClass {
	private int id;
	private String name;
	private String info;

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

	public void setinfo(String info) {
		this.info = info;
	}

	public String getinfo() {
		return info;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
