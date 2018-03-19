package com.sys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControlAdapter extends MouseAdapter implements ActionListener{
	
	private DBopt db;
	private MainWindow mw;
	private AddStuDialog ad;
	private ModifyStuDialog md;
	
	private Student currentSelected;

	public ControlAdapter(DBopt db, MainWindow mw, AddStuDialog ad, ModifyStuDialog md) {
		
		this.db = db;
		this.mw = mw;
		this.ad = ad;
		this.md = md;
		
		currentSelected=null;
	}
	
	public int setData() throws ClassNotFoundException, SQLException{
		return mw.setTableData(db.getTable());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if(com=="Add") {
			ad.setVisible(true);
			ad.setLocationRelativeTo(mw);
			ad.setAlwaysOnTop(true);
			System.out.println("Add");
		}else if(com=="Modify") {
			if(currentSelected==null) {
				JOptionPane.showMessageDialog(mw, "Please fist select the student that you want to modify!","Message",JOptionPane.ERROR_MESSAGE);
			}
			else {
				System.out.println("Modify:"+currentSelected.getStu_id());
				md.setJtf_id(currentSelected.getStu_id());
				md.setJtf_name(currentSelected.getStu_name());
				md.setJtf_gender(currentSelected.getStu_gender());
				md.setJtf_nation(currentSelected.getStu_nation());
				md.setJtf_email(currentSelected.getStu_email());
				md.setVisible(true);
				md.setLocationRelativeTo(mw);
				md.setAlwaysOnTop(true);
			}
		}else if(com=="Submit") {
			if(ad.isSubmited(e.getSource())) {
				int res=0;
				res = addNewStudent();
				System.out.println(res);
				ad.setVisible(false);
				ad.setAlwaysOnTop(false);
				if(res!=1) {
					JOptionPane.showMessageDialog(mw, "Failure!", "Message",JOptionPane.ERROR_MESSAGE);
				}else {
					System.out.println("ShowOptionPanel");
					JOptionPane.showMessageDialog(mw, "Succed", "Message",JOptionPane.INFORMATION_MESSAGE);
				}
				System.out.println("Addition Submited");
			}else if(md.isSubmited(e.getSource())) {
				
				System.out.println("Modification Submited");
			}
		}else if(com=="Delete") {
			if(currentSelected==null) {
				JOptionPane.showMessageDialog(mw, "Please fist select the student that you want to delete!","Message",JOptionPane.ERROR_MESSAGE);
			} else {
				int res = 0;
				res = JOptionPane.showConfirmDialog(mw, "Delete the imformation of the student-"+currentSelected.getStu_id()+"?", "Confirmation",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				System.out.println(res);
				if(res==0) {
					try {
						db.deleteRow(currentSelected.getStu_id());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
//		System.out.println("xxx");
//		System.out.println(arg0.getComponent().toString());
//		JTable jt = (JTable)arg0.getSource();
//		System.out.println(jt.getModel().getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));
//		System.out.println(jt.getSelectedRow());
//		System.out.println(jt.getSelectedColumn());
//		System.out.println(mw.getIdFromTable(jt.getSelectedRow()));
		JTable jt =(JTable)arg0.getSource();
		setCurrentSelected(mw.getIdFromTable(jt.getSelectedRow()));
		super.mouseClicked(arg0);
	}
	
	private int addNewStudent() {
		Student stu = new Student();
		String id = ad.getTextFromJtf_id();
		if(id==null) {
			return -1;
		}
		stu.setStu_id(id);
		String name = ad.getTextFromJtf_name();
		stu.setStu_name(name);
		String gender = ad.getTextFromJtf_gender();
		stu.setStu_gender(gender);
		String nation = ad.getTextFromJtf_nation();
		stu.setStu_nation(nation);
		String emial = ad.getTextFromJtf_email();
		stu.setStu_email(emial);
		
		int res=0;
		try {
			res = db.addRow(stu);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public void setCurrentSelected(Student stu) {
		currentSelected=stu;
	}
	
}



















