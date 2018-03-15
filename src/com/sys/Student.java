package com.sys;

/**
 * This is the class for a student
 * */
public class Student {
	
	private String stu_id;//primary key
	private String stu_name;//not null;
	private String stu_gender;
	private String stu_nation;
	private String stu_email;
	
	public Student() {
		stu_id=null;
		stu_name=null;
		stu_gender=null;
		stu_nation=null;
		stu_email=null;
	}
	
	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_gender() {
		return stu_gender;
	}

	public void setStu_gender(String stu_gender) {
		this.stu_gender = stu_gender;
	}

	public String getStu_nation() {
		return stu_nation;
	}

	public void setStu_nation(String stu_nation) {
		this.stu_nation = stu_nation;
	}

	public String getStu_email() {
		return stu_email;
	}

	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}

}
