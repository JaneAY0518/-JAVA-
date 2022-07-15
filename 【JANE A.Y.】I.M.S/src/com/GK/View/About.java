package com.GK.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JFrame;

public class About extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 20));
		setTitle("关于我们");
		setBounds(100, 100, 624, 325);

		JLabel lblNewLabel = new JLabel("您好！欢迎使用本信息管理系统！");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

	}

}
