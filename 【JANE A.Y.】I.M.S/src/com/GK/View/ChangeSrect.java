package com.GK.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.GK.Dao.AdminDao;
import com.GK.Dao.StudentDao;
import com.GK.Dao.TeacherDao;
import com.GK.Model.Admin;
import com.GK.Model.Student;
import com.GK.Model.Teacher;
import com.GK.Util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeSrect extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSrect frame = new ChangeSrect();
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
	public ChangeSrect() {
		setClosable(true);
		setTitle("修改密码");
		setBounds(100, 100, 561, 493);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("当前用户：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 44, 135, 38);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("原密码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(107, 109, 135, 38);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("新密码");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(107, 171, 135, 38);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("确定密码");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(84, 234, 135, 38);
		getContentPane().add(lblNewLabel_1_2);

		textField = new JTextField();
		textField.setBounds(200, 109, 189, 38);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(200, 171, 189, 38);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(200, 234, 189, 38);
		getContentPane().add(textField_2);

		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODo Auto-qenerated method stub
				String oldPassword = textField.getText().toString();
				String newPassword = textField_1.getText().toString();
				String conformPassword = textField_2.getText().toString();
				if (StringUtil.isEmpty(oldPassword)) {
					JOptionPane.showMessageDialog(ChangeSrect.this, "请填写旧密码!");
					return;
				}
				if (StringUtil.isEmpty(newPassword)) {
					JOptionPane.showMessageDialog(ChangeSrect.this, "请填写新密码!");
					return;
				}
				if (StringUtil.isEmpty(conformPassword)) {
					JOptionPane.showMessageDialog(ChangeSrect.this, "请确认新密码!");
					return;
				}

				if (!newPassword.equals(conformPassword)) {
					JOptionPane.showMessageDialog(ChangeSrect.this, "两次密码输入不一致!");
					return;
				}
				if ("系统管理员".equals(MainMenu.userType.getName())) {
					AdminDao adminDao = new AdminDao();
					Admin adminTmp = new Admin();
					Admin admin = (Admin) MainMenu.userObject;
					adminTmp.setname(admin.getname());
					adminTmp.setid(admin.getid());
					adminTmp.setpassword(oldPassword);
					JOptionPane.showMessageDialog(ChangeSrect.this, adminDao.editPassword(adminTmp, newPassword));
					adminDao.closeDao();
					return;
				}
				if ("学生".equals(MainMenu.userType.getName())) {
					StudentDao studentDao = new StudentDao();
					Student studentTmp = new Student();
					Student student = (Student) MainMenu.userObject;
					studentTmp.setname(student.getname());
					studentTmp.setpassword(oldPassword);
					studentTmp.setid(student.getid());
					JOptionPane.showMessageDialog(ChangeSrect.this, studentDao.editPassword(studentTmp, newPassword));
					studentDao.closeDao();
					return;
				}
				if ("教师".equals(MainMenu.userType.getName())) {
					TeacherDao teacherDao = new TeacherDao();
					Teacher teacherTmp = new Teacher();
					Teacher teacher = (Teacher) MainMenu.userObject;
					teacherTmp.setname(teacher.getname());
					teacherTmp.setpassword(oldPassword);
					teacherTmp.setid(teacher.getid());
					JOptionPane.showMessageDialog(ChangeSrect.this, teacherDao.editPassword(teacherTmp, newPassword));
					teacherDao.closeDao();
					return;
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(76, 364, 99, 38);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\重置.png"));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(348, 364, 99, 38);
		getContentPane().add(btnNewButton_1);

		JLabel currerntUserLabel_2 = new JLabel("");
		currerntUserLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		currerntUserLabel_2.setBounds(200, 44, 216, 38);
		getContentPane().add(currerntUserLabel_2);

		if ("系统管理员".equals(MainMenu.userType.getName())) {
			Admin admin = (Admin) MainMenu.userObject;
			currerntUserLabel_2.setText("【系统管理员】" + admin.getname());
		} else if ("学生".equals(MainMenu.userType.getName())) {
			Student student = (Student) MainMenu.userObject;
			currerntUserLabel_2.setText("【学生】" + student.getname());
		} else {
			Teacher teacher = (Teacher) MainMenu.userObject;
			currerntUserLabel_2.setText("【学生】" + teacher.getname());
		}

	}
}
