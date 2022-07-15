package com.GK.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.GK.Util.Dbutil;

public class BaseDao {
	public Connection con = new Dbutil().getCon();

	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
