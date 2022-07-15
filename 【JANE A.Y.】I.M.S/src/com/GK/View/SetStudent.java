package com.GK.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.GK.Dao.ClassDao;
import com.GK.Dao.StudentDao;
import com.GK.Model.Student;
import com.GK.Model.StudentClass;
import com.GK.Util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class SetStudent extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_2;
	private JComboBox comboBox;
	private ButtonGroup sexButtonGroup;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_1_1;

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
	public SetStudent() {
		setClosable(true);
		setTitle("新建学生");
		setBounds(100, 100, 628, 538);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("学生姓名");
		lblNewLabel.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\学生管理.png"));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(81, 61, 147, 47);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(223, 65, 297, 37);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("所属班级");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级名称.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(81, 149, 147, 47);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("登录密码");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\password.png"));
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(81, 233, 147, 47);
		getContentPane().add(lblNewLabel_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 237, 297, 37);
		getContentPane().add(textField_2);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(223, 149, 297, 37);
		getContentPane().add(comboBox);

		JLabel lblNewLabel_1_1_1 = new JLabel("学生性别");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\性别.png"));
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(81, 320, 147, 47);
		getContentPane().add(lblNewLabel_1_1_1);

		rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(223, 325, 82, 37);
		getContentPane().add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(330, 325, 82, 37);
		getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("保密");
		rdbtnNewRadioButton_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		rdbtnNewRadioButton_1_1.setBounds(438, 325, 82, 37);
		getContentPane().add(rdbtnNewRadioButton_1_1);

		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// toDo Auto-generated method stub
				String studentName = textField.getText().toString();
				String studentPassword = textField_2.getText().toString();
				if (StringUtil.isEmpty(studentName)) {
					JOptionPane.showMessageDialog(SetStudent.this, "请填写学生姓名!");
					return;
				}
				if (StringUtil.isEmpty(studentPassword)) {
					JOptionPane.showMessageDialog(SetStudent.this, "请填写密码!");
					return;
				}
				StudentClass sc = (StudentClass) comboBox.getSelectedItem();
				String sex = rdbtnNewRadioButton.isSelected() ? rdbtnNewRadioButton.getText()
						: (rdbtnNewRadioButton_1.isSelected() ? rdbtnNewRadioButton_1.getText()
								: rdbtnNewRadioButton_1_1.getText());
				Student student = new Student();
				student.setname(studentName);
				student.setclassId(sc.getid());
				student.setpassword(studentPassword);
				student.setsex(sex);
				System.out.println("..");
				StudentDao studentDao = new StudentDao();
				if (studentDao.addStudent(student)) {
					JOptionPane.showMessageDialog(SetStudent.this, "添加成功!");
				} else {
					JOptionPane.showMessageDialog(SetStudent.this, "添加失败!");
				}
				resetValue(arg0);
			}

		});
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(81, 414, 115, 47);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\重置.png"));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(405, 414, 115, 47);
		getContentPane().add(btnNewButton_1);

		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(rdbtnNewRadioButton);
		sexButtonGroup.add(rdbtnNewRadioButton_1);
		sexButtonGroup.add(rdbtnNewRadioButton_1_1);
		setStudentClassInfo();
	}

	protected void resetValue(ActionEvent arg0) {
		// TODO Auto-generated method stub
		textField.setText("");
		textField_2.setText("");
		comboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		rdbtnNewRadioButton.setSelected(true);
	}

	private void setStudentClassInfo() {
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(new StudentClass());
		for (StudentClass sc : classList) {
			comboBox.addItem(sc);
		}
		classDao.closeDao();
	}
}
