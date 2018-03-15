package com.sys;


import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddStuDialog extends JDialog{

	/**
	 * This is a Dialog 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int DIALOG_WIDTH = 300;
	private static int DIALOG_HEIGHT = 200;
	
	private ControlAdapter adapter;
	
	private GridLayout gly;
	
	private JLabel jl_id;
	private JLabel jl_name;
	private JLabel jl_gender;
	private JLabel jl_nation;
	private JLabel jl_email;
	
	private JTextField jtf_id;
	private JTextField jtf_name;
	private JTextField jtf_gender;
	private JTextField jtf_nation;
	private JTextField jtf_email;
	
	private JButton jb_submit;
	private JButton jb_cancel;
	
	public AddStuDialog() {
		this.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		this.setTitle("Add New Student");
		
		gly = new GridLayout(6, 2);
		this.setLayout(gly);
		
		jl_id = new JLabel("Student ID");
		jl_name = new JLabel("Name");
		jl_gender = new JLabel("Gender");
		jl_nation = new JLabel("Nation");
		jl_email = new JLabel("Email");
		
		jtf_id = new JTextField();
		jtf_name = new JTextField();
		jtf_gender = new JTextField();
		jtf_nation = new JTextField();
		jtf_email = new JTextField();
		
		jb_submit = new JButton("Submit");
		jb_cancel = new JButton("Cancel");
		
		this.add(jl_id);
		this.add(jtf_id);
		this.add(jl_name);
		this.add(jtf_name);
		this.add(jl_gender);
		this.add(jtf_gender);
		this.add(jl_nation);
		this.add(jtf_nation);
		this.add(jl_email);
		this.add(jtf_email);
		this.add(jb_submit);
		this.add(jb_cancel);
		
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}
	
	public void setAdapter(ControlAdapter a) {
		this.adapter=a;
		jb_submit.addActionListener(adapter);
		jb_cancel.addActionListener(adapter);
	}
	
	public boolean isSubmited(Object obj) {
		if(obj.equals(jb_submit)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isCanceled(Object obj) {
		if(obj.equals(jb_cancel)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getTextFromJtf_id() {
		return jtf_id.getText();
	}


	public String getTextFromJtf_name() {
		return jtf_name.getText();
	}


	public String getTextFromJtf_gender() {
		return jtf_gender.getText();
	}


	public String getTextFromJtf_nation() {
		return jtf_nation.getText();
	}


	public String getTextFromJtf_email() {
		return jtf_email.getText();
	}


	

}
