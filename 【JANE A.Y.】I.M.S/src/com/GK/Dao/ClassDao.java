package com.GK.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.GK.Model.StudentClass;
import com.GK.Util.StringUtil;

public class ClassDao extends BaseDao {
	public boolean addClass(StudentClass scl) {
		String sql = "insert into s_class values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, scl.getname());
			preparedStatement.setString(2, scl.getinfo());
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<StudentClass> getClassList(StudentClass studentClass) {
		List<StudentClass> retList = new ArrayList<StudentClass>();
		String sqlString = "select * from s_class";
		if (!StringUtil.isEmpty(studentClass.getname())) {
			sqlString += "where name like '%" + studentClass.getname() + "%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()) {
				StudentClass sc = new StudentClass();
				sc.setid(executeQuery.getInt("Id"));
				sc.setname(executeQuery.getString("name"));
				sc.setinfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}

	public boolean delete(int id) {
		String sql = "delete froms_class where id=?";
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

	public boolean update(StudentClass sc) {
		String sql = "update s_class set name=?,info=? where id=?";
		try {
			PreparedStatement PreparedStatement = con.prepareStatement(sql);
			PreparedStatement.setString(1, sc.getname());
			PreparedStatement.setString(2, sc.getinfo());
			PreparedStatement.setInt(1, sc.getid());
			if (PreparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
