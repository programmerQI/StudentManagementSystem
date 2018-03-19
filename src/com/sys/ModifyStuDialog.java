package com.sys;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ModifyStuDialog extends JDialog {

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

	private JLabel jtf_id;
	private JTextField jtf_name;
	private JTextField jtf_gender;
	private JTextField jtf_nation;
	private JTextField jtf_email;

	private JButton jb_submit;
	private JButton jb_cancel;

	public ModifyStuDialog() {
		
		this.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		this.setTitle("Modify Student Information");

		gly = new GridLayout(6, 2);
		this.setLayout(gly);

		jl_id = new JLabel("Student ID");
		jl_name = new JLabel("Name");
		jl_gender = new JLabel("Gender");
		jl_nation = new JLabel("Nation");
		jl_email = new JLabel("Email");

		jtf_id = new JLabel("NULL");
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
	
	public void reset() {
		jtf_id.setText("");
		jtf_name.setText("");
		jtf_gender.setText("");
		jtf_nation.setText("");
		jtf_email.setText("");
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
	
	public JLabel getJtf_id() {
		return jtf_id;
	}



	public void setJtf_id(String jtf_id) {
		this.jtf_id.setText(jtf_id);
	}



	public JTextField getJtf_name() {
		return jtf_name;
	}



	public void setJtf_name(String jtf_name) {
		this.jtf_name.setText(jtf_name);;
	}



	public JTextField getJtf_gender() {
		return jtf_gender;
	}



	public void setJtf_gender(String jtf_gender) {
		this.jtf_gender.setText(jtf_gender);;
	}



	public JTextField getJtf_nation() {
		return jtf_nation;
	}



	public void setJtf_nation(String jtf_nation) {
		this.jtf_nation.setText(jtf_nation);;
	}


	public JTextField getJtf_email() {
		return jtf_email;
	}

	public void setJtf_email(String jtf_email) {
		this.jtf_email.setText(jtf_email);;
	}


}
