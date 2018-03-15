package com.sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DBMain<E> {
	protected Connection c;
	protected PreparedStatement s;
	protected ResultSet r;

	protected void getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Mybase1", "root", "wq1234");
		s = c.prepareStatement(sql);
	}

	protected void release() throws SQLException {
		if (r != null)
			r.close();
		if (s != null)
			s.close();
		if (c != null)
			c.close();
	}

	public abstract ArrayList<E> getTable() throws ClassNotFoundException, SQLException;
	public abstract E getByPrimary(String key) throws ClassNotFoundException, SQLException;
	public abstract int addRow(E obj) throws ClassNotFoundException, SQLException;
	public abstract int modifyRow(String key, E obj) throws ClassNotFoundException, SQLException;
	public abstract int deleteRow(String key) throws ClassNotFoundException, SQLException;

}
