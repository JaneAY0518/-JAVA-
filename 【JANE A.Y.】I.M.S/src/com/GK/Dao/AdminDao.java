package com.GK.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.GK.Model.Admin;
import com.GK.Model.StudentClass;

public class AdminDao extends BaseDao {
	public Admin login(Admin admin) {
		String sql = "select * from s_admin where name=? and password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, admin.getname());
			prst.setString(2, admin.getpassword());
			ResultSet executeQuery = prst.executeQuery();
			if (executeQuery.next()) {
				adminRst = new Admin();
				adminRst.setid(executeQuery.getInt("id"));
				adminRst.setname(executeQuery.getString("name"));
				adminRst.setpassword(executeQuery.getString("password"));
				adminRst.setcreateDate(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adminRst;
	}

	public String editPassword(Admin admin, String newPassword) {
		String sql = "select * from s_admin where id=? and passsword=?";
		PreparedStatement prst = null;
		int id = admin.getid();
		try {
			prst = con.prepareStatement(sql);
			//
			System.out.println(admin.getid());
			System.out.println(admin.getpassword());

			prst.setInt(1, admin.getid());
			prst.setString(2, admin.getpassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next()) {
				String retString = "旧密码错误！";
				return retString;
			}
			//
			System.out.println(id);
			id = executeQuery.getInt("id");
			//
			System.out.println(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String retString = "修改失败";
		String sqlString = "Update s_admin set password=?  where id=?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			//
			System.out.println(newPassword);
			System.out.println(id);
			int rst = prst.executeUpdate();
			if (rst > 0) {
				retString = "密码修改成功！";
			} else {
				System.out.println("rst=" + rst);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retString;
	}

}
