package com.sys;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

public class MainWindow extends JFrame {
	
	/**
	 * This is the main frame.)
	 */
	private static final long serialVersionUID = 1L;
	
	private static int MAINFRAME_WIDTH = 1000;
	private static int MAINFRAME_HEIGHT = 600;
	
	private Dimension dm;
	
	private ControlAdapter adapter;
	
	private BorderLayout bly;
	private GridLayout gly;
	
	private JPanel jp1;
	private JPanel jp2;
	
	private JTextField jt_search;
	private JButton jb_search;
	private JButton jb_add;
	private JButton jb_delete;
	private JButton jb_modify;
	
	private JScrollPane jp;
	private JTable jt;
	private static String[] COLUMNNAME= {"StudentID","Name","Gender","Nation","Mail"};
	private Vector<Vector<String>> data;
	
	class TModel extends AbstractTableModel{
		
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
			return COLUMNNAME[y];
		}

		@Override
		public int getColumnCount() {
			return COLUMNNAME.length;
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

	private TModel tm;

	@SuppressWarnings("serial")
	public MainWindow() {
		super();

		dm = new Dimension();
		dm.width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		dm.height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		System.out.println(dm.width);
		System.out.println(dm.height);
		
		this.setSize(MAINFRAME_WIDTH, MAINFRAME_HEIGHT);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocation((dm.width-MAINFRAME_WIDTH)/2, (dm.height-MAINFRAME_HEIGHT)/2);
		
		tm = new TModel();
		jt = new JTable(tm);
		jp = new JScrollPane(jt);
		
//		columnNames = new Vector<String>();
//		columnNames.add("Student_ID");
//		columnNames.add("Name");
//		columnNames.add("Gender");
//		columnNames.add("Nation");
//		columnNames.add("Email");
//		rowData = new Vector<Vector<String>>();
//		tm = new DefaultTableModel(rowData, columnNames) {
//			
//			public boolean isCellEditable(int arg0, int arg1) {
//				return false;
//			}
//		};
//		jt = new JTable(rowData,columnNames) {
//			
//			@Override
//			public boolean isCellEditable(int arg0, int arg1) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};
//		jp = new JScrollPane(jt);
//		
		
		jp1 = new JPanel();
		gly = new GridLayout();
		jp1.setLayout(gly);
		jt_search = new JTextField();
		jb_search = new JButton("Search");
		jp1.add(jt_search);
		jp1.add(jb_search);
		
		
		jp2 = new JPanel();
		jp2.setLayout(gly);
		jb_add = new JButton("Add");
		jb_delete = new JButton("Delete");
		jb_modify = new JButton("Modify");
		jp2.add(jb_add);
		jp2.add(jb_delete);
		jp2.add(jb_modify);
		
		bly = new BorderLayout();
		this.setLayout(bly);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);
	}
	
	public int setTableData(ArrayList<Student> l) {
		if(l==null) {
			return -1;
		}
		tm.data.clear();
		int i=0;
		for(;i<l.size();i++) {
			Student stu = l.get(i);
			Vector<String> v = new Vector<String>();
			v.add(stu.getStu_id());
			v.add(stu.getStu_name());
			v.add(stu.getStu_gender());
			v.add(stu.getStu_nation());
			v.add(stu.getStu_email());
			tm.data.add(v);
		}
		tm.fireTableDataChanged();
		return i;
	}
	
	public Student getIdFromTable(int row) {
		Vector<String> d = tm.data.get(row);
		Student stu =new Student();
		
		stu.setStu_id(d.get(0));
		stu.setStu_name(d.get(1));
		stu.setStu_gender(d.get(2));
		stu.setStu_nation(d.get(3));
		stu.setStu_email(d.get(4));
		
		return stu;
	}
	
	public void setAdapter(ControlAdapter a) {
		this.adapter=a;
		jb_add.addActionListener(adapter);
		
		jb_delete.addActionListener(adapter);
		jb_modify.addActionListener(adapter);
		jb_search.addActionListener(adapter);
		jt.addMouseListener(adapter);
	}
	
}
