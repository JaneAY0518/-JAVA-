package com.GK.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SetTeacher extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetStudent frame = new SetStudent();
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
	public SetTeacher() {
		setClosable(true);
		setTitle("新建教师");
		setBounds(100, 100, 624, 578);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("教师姓名");
		lblNewLabel.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\老师.png"));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(81, 61, 147, 47);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(223, 65, 297, 37);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("登录密码");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\password.png"));
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(81, 345, 147, 47);
		getContentPane().add(lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 349, 297, 37);
		getContentPane().add(textField_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("教师性别");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\性别.png"));
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(81, 138, 147, 47);
		getContentPane().add(lblNewLabel_1_1_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(223, 143, 82, 37);
		getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(330, 143, 82, 37);
		getContentPane().add(rdbtnNewRadioButton_1);

		JButton btnNewButton = new JButton("确认");
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(81, 458, 111, 47);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\重置.png"));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(415, 458, 105, 47);
		getContentPane().add(btnNewButton_1);

		ButtonGroup k = new ButtonGroup();
		k.add(rdbtnNewRadioButton);
		k.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_2 = new JLabel("教师职称");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\职称评定.png"));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(81, 206, 147, 47);
		getContentPane().add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 210, 297, 37);
		getContentPane().add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("教师年龄");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\年龄.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(81, 273, 147, 47);
		getContentPane().add(lblNewLabel_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(223, 277, 297, 37);
		getContentPane().add(textField_3);
	}
}
