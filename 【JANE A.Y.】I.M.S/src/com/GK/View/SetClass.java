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

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetClass extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetClass frame = new SetClass();
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
	public SetClass() {
		setClosable(true);
		setTitle("新建班级");
		setBounds(100, 100, 537, 542);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("班级名称");
		lblNewLabel.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级名称.png"));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 36, 111, 50);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(176, 44, 245, 31);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("班级信息");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级介绍.png"));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 105, 111, 50);
		getContentPane().add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(176, 115, 245, 219);
		getContentPane().add(textArea);

		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ClassName = textField.getText().toString();
				String ClassIntroduce = textArea.getText().toString();
				if (StringUtil.isEmpty(ClassName)) {
					JOptionPane.showMessageDialog(SetClass.this, "请填写班级名称!");
					return;
				}
				if (StringUtil.isEmpty(ClassIntroduce)) {
					JOptionPane.showMessageDialog(SetClass.this, "请填写班级介绍!");
					return;
				}
				StudentClass sc = new StudentClass();
				sc.setname(ClassName);
				sc.setinfo(ClassIntroduce);
				ClassDao studentDao = new ClassDao();
				if (studentDao.addClass(sc)) {
					JOptionPane.showMessageDialog(SetClass.this, "添加成功!");
				} else {
					JOptionPane.showMessageDialog(SetClass.this, "添加失败!");
				}
				resetValue(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\确认.png"));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.setBounds(47, 418, 135, 45);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\重置.png"));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton_1.setBounds(337, 418, 135, 45);
		getContentPane().add(btnNewButton_1);

	}

	protected void resetValue(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
