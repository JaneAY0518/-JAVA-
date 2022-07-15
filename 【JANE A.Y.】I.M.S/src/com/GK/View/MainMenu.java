package com.GK.View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.GK.Model.UserType;

import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuItem;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Component;

public class MainMenu extends JFrame {
	private static final Component SetStudent = null;
	JDesktopPane desktopPane;// 定义一个对象
	private JPanel contentPane;
	public static UserType userType;
	public static Object userObject;// 定义object因为有三个对象
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_4;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MainMenu frame = new MainMenu();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public MainMenu(UserType userType, Object userObject) {
		this.userType = userType;
		this.userObject = userObject;

		setTitle("菜单主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 737);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("系统");
		mnNewMenu.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\系统设置.png"));
		mnNewMenu.setFont(new Font("宋体", Font.BOLD, 25));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改密码");
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\密码.png"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeSrect CS = new ChangeSrect();
				CS.setVisible(true);
				desktopPane.add(CS);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("退出系统");
		mntmNewMenuItem_3.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\退出.png"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("学生");
		mnNewMenu_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\学生管理.png"));
		mnNewMenu_1.setFont(new Font("宋体", Font.BOLD, 25));
		menuBar.add(mnNewMenu_1);

		mntmNewMenuItem = new JMenuItem("新建学生");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\添加.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetStudent SS = new SetStudent();
				SS.setVisible(true);
				desktopPane.add(SS);
			}
		});
		mntmNewMenuItem.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("学生管理");
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\学生管理.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageStudent MS = new ManageStudent();
				MS.setVisible(true);
				desktopPane.add(MS);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("教师");
		mnNewMenu_2.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\老师.png"));
		mnNewMenu_2.setFont(new Font("宋体", Font.BOLD, 25));
		menuBar.add(mnNewMenu_2);

		mntmNewMenuItem_4 = new JMenuItem("新建教师");
		mntmNewMenuItem_4.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\添加.png"));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetTeacher ST = new SetTeacher();
				ST.setVisible(true);
				desktopPane.add(ST);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_2.add(mntmNewMenuItem_4);

		mntmNewMenuItem_5 = new JMenuItem("管理教师");
		mntmNewMenuItem_5.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\老师.png"));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageTeacher MT = new ManageTeacher();
				MT.setVisible(true);
				desktopPane.add(MT);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_2.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_3 = new JMenu("班级");
		mnNewMenu_3.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级管理.png"));
		mnNewMenu_3.setFont(new Font("宋体", Font.BOLD, 25));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("新建班级");
		mntmNewMenuItem_6.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\添加.png"));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SetClass SC = new SetClass();
				SC.setVisible(true);
				desktopPane.add(SC);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_3.add(mntmNewMenuItem_6);

		mntmNewMenuItem_7 = new JMenuItem("班级管理");
		mntmNewMenuItem_7.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\班级管理.png"));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageClass MC = new ManageClass();
				MC.setVisible(true);
				desktopPane.add(MC);
			}
		});
		mntmNewMenuItem_7.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_3.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_4 = new JMenu("帮助");
		mnNewMenu_4.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\帮助.png"));
		mnNewMenu_4.setFont(new Font("宋体", Font.BOLD, 25));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("关于我们");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About A = new About();
				A.setVisible(true);
				desktopPane.add(A);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon("D:\\学院班级文件汇总\\JAVA校企\\images\\关于我们.png"));
		mntmNewMenuItem_8.setFont(new Font("宋体", Font.PLAIN, 23));
		mnNewMenu_4.add(mntmNewMenuItem_8);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		setAuthority();
	}

	private void setAuthority() {
		if ("学生".equals(userType.getName())) {
			mntmNewMenuItem.setEnabled(false);
			mntmNewMenuItem_7.setEnabled(false);
			mntmNewMenuItem_5.setEnabled(false);
		}
		if ("教师".equals(userType.getName())) {
			mntmNewMenuItem_4.setEnabled(false);
		}
	}

}
