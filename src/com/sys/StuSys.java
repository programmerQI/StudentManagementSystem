package com.sys;

import java.sql.SQLException;

public class StuSys {
	private DBopt database;
	private MainWindow mainwindow;
	private AddStuDialog adddialog;
	private ModifyStuDialog modifydialog;
	private ControlAdapter adapter;
	
	public StuSys() {
		database = new DBopt();
		mainwindow = new MainWindow();
		adddialog = new AddStuDialog();
		modifydialog = new ModifyStuDialog();
		adapter = new ControlAdapter(database,mainwindow,adddialog,modifydialog);
		
		mainwindow.setAdapter(adapter);
		adddialog.setAdapter(adapter);
		modifydialog.setAdapter(adapter);
		try {
			adapter.setData();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		mainwindow.setVisible(true);
		System.out.println(mainwindow.getLocation().getX());
		System.out.println(mainwindow.getLocation().getY());
		
	}
	
	public static void main(String[] args) {
		
		StuSys sys = new StuSys();
		
	}
}
