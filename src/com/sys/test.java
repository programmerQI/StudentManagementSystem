package com.sys;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class test {
	
//	public static String INSERT = "insert students(stuId,stuName,stuSex,stuNation,stuEmail) value(?,?,?,?,?)";
	
	
	
	
	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			try {
//				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mybase1", "root", "xiaofa7985");
//				System.out.println("Conection Seccess!");
//				java.sql.PreparedStatement ps = con.prepareStatement(INSERT);
//				ps.setString(1, "12345");
//				ps.setString(2, "QIWANG");
//				ps.setString(3, "male");
//				ps.setString(4, "China");
//				ps.setString(5, "wangqimail@gmail.com");
//				ps.executeUpdate();
//				ps.close();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JOptionPane.showMessageDialog(null, "Wrong", "Hello", 1);
		
	JFrame jf = new JFrame("Test");
    STableModel tm = new STableModel();
	JTable jt = new JTable(tm);
    JScrollPane jsp = new JScrollPane(jt);
	jf.setSize(800, 800);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
	jf.add(jsp);
	}
}
