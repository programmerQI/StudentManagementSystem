package com.sys;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class STableModel extends AbstractTableModel{
	
	private String[] columnNames = {"StudentID","Name","Gender","Nation","Mail"};
	private Vector<Vector<String>> data = new Vector<Vector<String>>();
	
	public int setTableData(ArrayList<Student> l) {
		if(l==null) {
			return -1;
		}
		int i=0;
		for(;i<l.size();i++) {
			Student stu = l.get(i);
			Vector<String> v = new Vector<String>();
			v.add(stu.getStu_id());
			v.add(stu.getStu_name());
			v.add(stu.getStu_gender());
			v.add(stu.getStu_nation());
			v.add(stu.getStu_email());
			data.add(v);
		}
		return i;
	}
	
	public Student getIdFromTable(int row) {
		Vector<String> d= data.get(row);
		Student stu =new Student();
		stu.setStu_id(d.get(0));
		stu.setStu_name(d.get(1));
		stu.setStu_gender(d.get(2));
		stu.setStu_nation(d.get(3));
		stu.setStu_email(d.get(4));
		
		return stu;
	}
	
	@Override
	public String getColumnName(int y) {
		return columnNames[y];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int y, int x) {
		return data.get(y).get(x);
	}
	
	@Override
	public boolean isCellEditable(int y, int x) {
		return false;
	}
	
	
}
