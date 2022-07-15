package com.GK.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.GK.Model.Student;
import com.GK.Model.Teacher;
import com.GK.Util.StringUtil;

public class StudentDao extends BaseDao {
	public boolean addStudent(Student student) {
		String sql = "insert into s_student values(null,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getname());
			preparedStatement.setInt(2, student.getclassId());
			preparedStatement.setString(3, student.getsex());
			preparedStatement.setString(4, student.getpassword());
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Student> getTeacherList(Student student) {
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from s_student");
		if (!StringUtil.isEmpty(student.getname())) {
			sqlString.append("where name like '%" + student.getname() + "%'");
		}
		try {
			PreparedStatement preparedStatement = con
					.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()) {
				Student t = new Student();
				t.setid(executeQuery.getInt("Id"));
				t.setname(executeQuery.getString("name"));
				t.setclassId(executeQuery.getInt("classId"));
				t.setsex(executeQuery.getString("sex"));
				t.setpassword(executeQuery.getString("password"));
				retList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}

	public boolean delete(int id) {
		String sql = "delete from s_student where id=?";
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

	public boolean update(Student student) {
		String sql = "update s_student set name=?,classId=?,sex=?,password=? where id=?";
		try {
			PreparedStatement PreparedStatement = con.prepareStatement(sql);
			PreparedStatement.setString(1, student.getname());
			PreparedStatement.setInt(2, student.getclassId());
			PreparedStatement.setString(3, student.getsex());
			PreparedStatement.setString(5, student.getpassword());
			PreparedStatement.setInt(6, student.getid());
			if (PreparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Student login(Student student) {
		String sql = "select * from s_student where name=? and password=?";
		Student studentRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, student.getname());
			prst.setString(2, student.getpassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				studentRst = new Student();
				studentRst.setid(executeQuery.getInt("id"));
				studentRst.setclassId(executeQuery.getInt("classId"));
				studentRst.setname(executeQuery.getString("name"));
				studentRst.setpassword(executeQuery.getString("password"));
				studentRst.setsex(executeQuery.getString("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentRst;
	}

	public String editPassword(Student student, String newPassword) {
		String sql = "select * from s_teacher where id=? and passsword=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, student.getid());
			prst.setString(1, student.getpassword());
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
