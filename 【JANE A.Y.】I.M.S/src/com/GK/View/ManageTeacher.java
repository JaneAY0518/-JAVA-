package com.GK.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class ManageTeacher extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
	public ManageTeacher() {
		setClosable(true);
		setTitle("学生管理");
		setBounds(100, 100, 886, 663);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("教师姓名");
		lblNewLabel.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\老师.png"));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(110, 27, 101, 45);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(252, 34, 185, 30);
		getContentPane().add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 103, 772, 212);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u6559\u5E08\u7F16\u53F7", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B",
						"\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5F55\u5BC6\u7801" }));
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(52, 359, 772, 239);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("确认修改");
		btnNewButton_1.setBounds(786, 33, 185, 45);
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 25));
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("删除学生");
		btnNewButton_1_1.setBounds(786, 105, 185, 45);
		btnNewButton_1_1.setFont(new Font("宋体", Font.BOLD, 25));
		panel.add(btnNewButton_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("教师性别");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\性别.png"));
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(23, 103, 147, 47);
		panel.add(lblNewLabel_1_1_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(165, 108, 82, 37);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(272, 108, 82, 37);
		panel.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel_2 = new JLabel("教师职称");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\职称评定.png"));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(398, 34, 147, 47);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("教师年龄");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\年龄.png"));
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(398, 106, 147, 47);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("登录密码");
		lblNewLabel_1_1_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\修改密码.png"));
		lblNewLabel_1_1_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(23, 176, 147, 47);
		panel.add(lblNewLabel_1_1_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(165, 184, 185, 30);
		panel.add(passwordField);

		JLabel lblNewLabel_1 = new JLabel("教师姓名");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\老师.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(23, 33, 101, 45);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 40, 185, 30);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(520, 40, 185, 30);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(520, 115, 185, 30);
		panel.add(textField_3);

		JButton btnNewButton_2 = new JButton("确认修改");
		btnNewButton_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_2.setBounds(398, 169, 135, 45);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("删除");
		btnNewButton_3.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\删除.png"));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_3.setBounds(569, 169, 135, 45);
		panel.add(btnNewButton_3);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\搜索.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(572, 27, 135, 45);
		getContentPane().add(btnNewButton);

	}
}
