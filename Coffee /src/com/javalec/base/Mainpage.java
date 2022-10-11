package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mainpage {

	private JFrame frmMain;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblHomebtn;
	private JLabel lblLikebtn;
	private JLabel lblOrderbtn;
	private JLabel lblCartbtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage window = new Mainpage();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setTitle("Main");
		frmMain.setBounds(700, 100, 375, 812);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		frmMain.getContentPane().add(getLblNewLabel_1());
		frmMain.getContentPane().add(getLblHomebtn());
		frmMain.getContentPane().add(getLblLikebtn());
		frmMain.getContentPane().add(getLblOrderbtn());
		frmMain.getContentPane().add(getLblCartbtn());
		frmMain.getContentPane().add(getLblNewLabel());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Tabbar.png"));
			lblNewLabel.setBounds(0, 710, 375, 74);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				Mypage mypage = new Mypage();
				mypage.main(null);
				frmMain.setVisible(false);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblNewLabel_1.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/pressProfile.png"));
				}
			});
			lblNewLabel_1.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Profilebtn.png"));
			lblNewLabel_1.setBounds(320, 736, 24, 24);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblHomebtn() {
		if (lblHomebtn == null) {
			lblHomebtn = new JLabel("");
			lblHomebtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Mainpage mainpage = new Mainpage();
					mainpage.main(null);
					frmMain.setVisible(false);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblHomebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/pressHome.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblHomebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Homebtn.png"));
				}
			});
			lblHomebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Homebtn.png"));
			lblHomebtn.setBounds(40, 736, 24, 24);
		}
		return lblHomebtn;
	}
	private JLabel getLblLikebtn() {
		if (lblLikebtn == null) {
			lblLikebtn = new JLabel("");
			lblLikebtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Likebtn.png"));
			lblLikebtn.setBounds(107, 736, 24, 24);
		}
		return lblLikebtn;
	}
	private JLabel getLblOrderbtn() {
		if (lblOrderbtn == null) {
			lblOrderbtn = new JLabel("");
			lblOrderbtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/orderbtn.png"));
			lblOrderbtn.setBounds(156, 695, 60, 60);
		}
		return lblOrderbtn;
	}
	private JLabel getLblCartbtn() {
		if (lblCartbtn == null) {
			lblCartbtn = new JLabel("");
			lblCartbtn.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/cartbtn.png"));
			lblCartbtn.setBounds(245, 736, 24, 24);
		}
		return lblCartbtn;
	}
}
