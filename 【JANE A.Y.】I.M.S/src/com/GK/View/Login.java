package com.GK.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.InputMethodListener;
import java.util.Scanner;
import java.awt.event.InputMethodEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.GK.Dao.AdminDao;
import com.GK.Dao.StudentDao;
import com.GK.Dao.TeacherDao;
import com.GK.Model.Admin;
import com.GK.Model.Student;
import com.GK.Model.Teacher;
import com.GK.Model.UserType;
import com.GK.Util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	Scanner sc = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("信息管理系统");
		lblNewLabel.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 40));

		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\用户名.png"));
		lblNewLabel_1.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 25));

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				String Username;
				Username = sc.next();
				//
			}
		});
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("密  码");
		lblNewLabel_1_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\密码.png"));
		lblNewLabel_1_1.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		lblNewLabel_1_1.setFont(new Font("宋体", Font.BOLD, 25));

		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		passwordField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});

		JLabel lblNewLabel_1_2 = new JLabel("角色选择");
		lblNewLabel_1_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\userType.png"));
		lblNewLabel_1_2.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		lblNewLabel_1_2.setFont(new Font("宋体", Font.BOLD, 25));

		JButton btnNewButton = new JButton("清除");
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\删除.png"));
		btnNewButton.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\登录.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = textField.getText().toString();
				String password = passwordField.getText().toString();
				UserType selectedItem = (UserType) comboBox.getSelectedItem();
				if (StringUtil.isEmpty(userName)) {
					JOptionPane.showMessageDialog(Login.this, "用户名不能为空!");
					return;
				}
				if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(Login.this, "密码不能为空!");
					return;
				}

				Admin admin = null;
				if ("系统管理员".equals(selectedItem.getName())) {
					AdminDao adminDao = new AdminDao();
					Admin adminTmp = new Admin();
					adminTmp.setname(userName);
					adminTmp.setpassword(password);
					admin = adminDao.login(adminTmp);
					adminDao.closeDao();
					if (admin == null) {
						JOptionPane.showMessageDialog(Login.this, "用户名或密码错误!");
						return;
					}
					JOptionPane.showMessageDialog(Login.this,
							"欢迎【" + selectedItem.getName() + "】:" + admin.getname() + "登录本系统!");
					Login.this.dispose();
					new MainMenu(selectedItem, admin).setVisible(true);
				} else if ("教师".equals(selectedItem.getName())) {
					// 教师登录
					Teacher teacher = null;
					TeacherDao teacherDao = new TeacherDao();
					Teacher teacherTmp = new Teacher();
					teacherTmp.setname(userName);
					teacherTmp.setpassword(password);
					teacher = teacherDao.login(teacherTmp);
					teacherDao.closeDao();
					if (teacher == null) {
						JOptionPane.showMessageDialog(Login.this, "用户名或密码错误!");
						return;
					}
					JOptionPane.showMessageDialog(Login.this,
							"欢迎【" + selectedItem.getName() + "】:" + teacher.getname() + "登录本系统!");
					Login.this.dispose();
					new MainMenu(selectedItem, teacher).setVisible(true);
				} else {
					// 学生登录
					Student student = null;
					StudentDao studentDao = new StudentDao();
					Student studentTmp = new Student();
					studentTmp.setname(userName);
					studentTmp.setpassword(password);
					student = studentDao.login(studentTmp);
					studentDao.closeDao();
					if (student == null) {
						JOptionPane.showMessageDialog(Login.this, "用户名或密码错误!");
						return;
					}
					JOptionPane.showMessageDialog(Login.this,
							"欢迎【" + selectedItem.getName() + " :" + student.getname() + "登录本系统!");
					Login.this.dispose();
					new MainMenu(selectedItem, student).setVisible(true);
				}
			}
		});
		btnNewButton_1.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));

		comboBox.setFont(new Font("宋体", Font.PLAIN, 25));
		comboBox.setModel(new DefaultComboBoxModel(UserType.values()));
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(173).addComponent(lblNewLabel,
								GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(152).addGroup(groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(groupLayout.createSequentialGroup().addGap(4)
																.addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
																		168, GroupLayout.PREFERRED_SIZE))
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 131,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField,
														GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(100)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE)
										.addGap(179).addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131,
												GroupLayout.PREFERRED_SIZE))))
				.addGap(139)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(29)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE).addGap(35)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
				.addGap(9)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGap(34)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGap(62)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))));
		contentPane.setLayout(groupLayout);
	}
}
