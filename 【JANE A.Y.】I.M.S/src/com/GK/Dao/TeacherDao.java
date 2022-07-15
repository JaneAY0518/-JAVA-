package com.GK.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.GK.Model.Admin;
import com.GK.Model.StudentClass;
import com.GK.Model.Teacher;
import com.GK.Util.StringUtil;

public class TeacherDao extends BaseDao {
	public boolean addTeacher(Teacher teacher) {
		String sql = "insert into s_teacher values(null,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getname());
			preparedStatement.setString(2, teacher.getsex());
			preparedStatement.setString(3, teacher.gettitle());
			preparedStatement.setInt(4, teacher.getage());
			preparedStatement.setString(5, teacher.getpassword());
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Teacher> getTeacherList(Teacher teacher) {
		List<Teacher> retList = new ArrayList<Teacher>();
		StringBuffer sqlString = new StringBuffer("select * from s_teacher");
		if (!StringUtil.isEmpty(teacher.getname())) {
			sqlString.append("where name like '%" + teacher.getname() + "%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()) {
				Teacher t = new Teacher();
				t.setid(executeQuery.getInt("Id"));
				t.setname(executeQuery.getString("name"));
				t.setsex(executeQuery.getString("sex"));
				t.settitle(executeQuery.getString("title"));
				t.setage(executeQuery.getInt("age"));
				t.setpassword(executeQuery.getString("password"));
				retList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}

	public boolean delete(int id) {
		String sql = "delete from s_teacher where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Teacher teacher) {
		String sql = "update s_teacher set name=?,sex=?,title=?,age=?,password=? where id=?";
		try {
			PreparedStatement PreparedStatement = con.prepareStatement(sql);
			PreparedStatement.setString(1, teacher.getname());
			PreparedStatement.setString(2, teacher.getsex());
			PreparedStatement.setString(3, teacher.gettitle());
			PreparedStatement.setInt(4, teacher.getage());
			PreparedStatement.setString(5, teacher.getpassword());
			PreparedStatement.setInt(6, teacher.getid());
			if (PreparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Teacher login(Teacher teacher) {
		String sql = "select * from s_teacher where name=? and password=?";
		Teacher teacherRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, teacher.getname());
			prst.setString(2, teacher.getpassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				teacherRst = new Teacher();
				teacherRst.setid(executeQuery.getInt("id"));
				teacherRst.setname(executeQuery.getString("name"));
				teacherRst.setpassword(executeQuery.getString("password"));
				teacherRst.setsex(executeQuery.getString("sex"));
				teacherRst.setage(executeQuery.getInt("age"));
				teacherRst.settitle(executeQuery.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherRst;
	}

	public String editPassword(Teacher teacher, String newPassword) {
		String sql = "select * from s_teacher where id=? and passsword=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, teacher.getid());
			prst.setString(1, teacher.getpassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				String retString = "旧密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String retString = "修改失败";
		String sqlString = "Update s_admin set password=? and where id=?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if (rst > 0) {
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retString;
	}

}
