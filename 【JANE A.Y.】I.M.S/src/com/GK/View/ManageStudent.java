package com.GK.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.GK.Model.Student;
import com.GK.Model.StudentClass;
import com.GK.Util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageStudent extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudent frame = new ManageStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageStudent() {
		setClosable(true);
		setTitle("学生管理");
		setBounds(100, 100, 1072, 687);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("学生姓名");
		lblNewLabel.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\学生管理.png"));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(53, 51, 101, 45);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("所属班级");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级管理.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(421, 51, 101, 45);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(195, 58, 185, 29);
		getContentPane().add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(566, 59, 185, 29);
		getContentPane().add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 126, 981, 246);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5C5E\u73ED\u7EA7",
						"\u5B66\u751F\u6027\u522B", "\u767B\u5F55\u5BC6\u7801" }));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\u5B66\u751F\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(40, 423, 981, 181);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("学生性别");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\性别.png"));
		lblNewLabel_1_1_1.setBounds(25, 105, 147, 47);
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_1_1_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(167, 110, 62, 37);
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(234, 110, 62, 37);
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("保密");
		rdbtnNewRadioButton_1_1.setBounds(286, 110, 82, 37);
		rdbtnNewRadioButton_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(rdbtnNewRadioButton_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("登录密码");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\密码.png"));
		lblNewLabel_2_1.setBounds(393, 106, 101, 45);
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2 = new JLabel("学生姓名");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\学生管理.png"));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(25, 33, 101, 45);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("所属班级");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级管理.png"));
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(393, 33, 101, 45);
		panel.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 40, 185, 29);
		panel.add(textField_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(538, 41, 185, 29);
		panel.add(comboBox_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(538, 110, 185, 29);
		panel.add(textField_2);

		JButton btnNewButton_2 = new JButton("确认修改");
		btnNewButton_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_2.setBounds(786, 33, 135, 45);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("删除");
		btnNewButton_3.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\删除.png"));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_3.setBounds(786, 102, 135, 45);
		panel.add(btnNewButton_3);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ToDo Auto-generated method stub
				/*
				 * int row=table.getselectedRow(); if(row== -1){
				 * JOptionPane.showMessageDialog(ManageStudent.this,"请选中要修改的数据!"); return; }
				 * String studentName =textField_1.getText().toString(); String
				 * studentPassword=textField_2.getText().toString();
				 * if(StringUtil.isEmpty(studentName)) {
				 * JOptionPane.showMessageDialog(ManageStudent.this,"请填写学生姓名!"); return; }
				 * if(StringUtil.isEmpty(studentPassword)){
				 * JOptionPane.showMessageDialog(ManageStudent.this,"请填写密码!"); return; } Student
				 * student =new Student(); student.setname(studentName);
				 * student.setpassword(studentPassword); StudentClass
				 * sc=(StudentClass)comboBox.getSelectedItem(); student.setclassId(sc.getid());
				 * student.setId(Integer.parseInt(studentListTable.getValueAt(row,0).tostring)))
				 * ); if(editstudentSexManRadioButton.isSelected())student.setSex(
				 * editstudentSexManRadioButton,getText().tostring());
				 * if(editStudentSexFemalRadioButton.isSelected()student.setSex(
				 * editStudentSexFemalRadioButton.qetText().tostring());
				 * if(editstudentSexUnkonwRadioButton.isselected))student.setsex(
				 * editstudentSexUnkonwRadioButton.gettext0).tostring()): studentDao
				 * studentDao=newStudentDaol; if(studentDao.update(student)){
				 * JOptionPane.showMessageDialog(this，"更新成功!");}else
				 * JOptionPane.showMessageDialog(this，"更新失败!");
				 * 
				 * studentdao.closedaof); setTable(new Student());
				 */
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\搜索.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(822, 51, 135, 45);
		getContentPane().add(btnNewButton);

	}
}
