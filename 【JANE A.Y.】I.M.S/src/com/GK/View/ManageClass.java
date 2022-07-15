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

import com.GK.Model.Student;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ManageClass extends JInternalFrame {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
	public ManageClass() {
		setClosable(true);
		setTitle("学生管理");
		setBounds(100, 100, 886, 663);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("班级名称");
		lblNewLabel.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级名称.png"));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(110, 27, 101, 45);
		getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 103, 772, 212);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u73ED\u7EA7\u7F16\u53F7",
				"\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD" }) {
			boolean[] columnEditables = new boolean[] { true, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\u5B66\u751F\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		panel.setBounds(52, 359, 772, 263);
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

		JLabel lblNewLabel_1_1 = new JLabel("班级信息");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级介绍.png"));
		lblNewLabel_1_1.setBounds(65, 102, 111, 50);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel_1_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(215, 112, 185, 124);
		panel.add(textArea);

		JLabel lblNewLabel_1 = new JLabel("班级名称");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级名称.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(65, 33, 101, 45);
		panel.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(215, 35, 185, 32);
		panel.add(textField_1);

		JButton btnNewButton_2 = new JButton("确认修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_2.setBounds(520, 33, 135, 45);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("删除");
		btnNewButton_3.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\系统设置.png"));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_3.setBounds(520, 120, 135, 45);
		panel.add(btnNewButton_3);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(260, 29, 185, 32);
		getContentPane().add(textField);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\搜索.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(572, 27, 135, 45);
		getContentPane().add(btnNewButton);

		// setstudentclassInfo();
		// setTable(new Student());
		// setAuthority();
	}
}
