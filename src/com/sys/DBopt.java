package com.sys;

import java.sql.SQLException;
import java.util.ArrayList;

public class DBopt extends DBMain<Student> {

	@Override
	public ArrayList<Student> getTable() throws ClassNotFoundException, SQLException {
		getPreparedStatement("select * from students");
		r = s.executeQuery();
		ArrayList<Student> l = new ArrayList<Student>();
		while(r.next()) {
			Student stu = resemble();
			l.add(stu);
		}
		release();
		return l;
	}

	@Override
	public Student getByPrimary(String key) throws ClassNotFoundException, SQLException {
		getPreparedStatement("select * from student where id = ?");
		s.setString(1, key);
		r=s.executeQuery();
		Student stu = null;
		while(r.next()) {
			stu = resemble();
		}
		release();
		return stu;
	}

	@Override
	public int addRow(Student obj) throws ClassNotFoundException, SQLException {
		getPreparedStatement("insert into students(stuId,stuName,stuSex,stuNation,stuEmail) values (?,?,?,?,?)");
		s.setString(1, obj.getStu_id());
		s.setString(2, obj.getStu_name());
		s.setString(3, obj.getStu_gender());
		s.setString(4, obj.getStu_nation());
		s.setString(5, obj.getStu_email());
		int res = s.executeUpdate();
		return res;
	}

	@Override
	public int modifyRow(String key, Student obj) throws ClassNotFoundException, SQLException {
		getPreparedStatement("update students set stuName=?,stuSex=?,stuNation=?,stuEmail=? where stuId = ?");
		s.setString(1, obj.getStu_name());
		s.setString(2, obj.getStu_gender());
		s.setString(3, obj.getStu_nation());
		s.setString(4, obj.getStu_email());
		s.setString(5, key);
		int res = s.executeUpdate();
		return res;
	}

	@Override
	public int deleteRow(String key) throws ClassNotFoundException, SQLException {
		getPreparedStatement("delete from students where id=?");
		s.setString(1, key);
		int res = s.executeUpdate();
		return res;
	}
	
	public Student resemble () throws SQLException {
		Student stu = new Student();
		stu.setStu_id(r.getString(1));
		stu.setStu_name(r.getString(2));
		stu.setStu_gender(r.getString(3));
		stu.setStu_nation(r.getString(4));
		stu.setStu_email(r.getString(5));
		return stu;
	}

}
