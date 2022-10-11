package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.javalec.dao.Daologin;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JLabel lblBackground;
	private JLabel lblTitleimage;
	private JTextField tfId;
	private JLabel lblNewLabel;
	private JLabel lblPw;
	private JLabel btnLogin;
	private JLabel btnSignup;
	private JPasswordField pfPassword;
	private JCheckBox cbPwsign;
	private JLabel lblLock;
	private JLabel lblFindid;
	private JLabel lblFindpw;
	public static String id;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		frmLogin.setTitle("LoginPage");
		frmLogin.setBounds(700, 100, 375, 812);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(getLblTitleimage());
		frmLogin.getContentPane().add(getTfId());
		frmLogin.getContentPane().add(getLblNewLabel());
		frmLogin.getContentPane().add(getLblPw());
		frmLogin.getContentPane().add(getBtnLogin());
		frmLogin.getContentPane().add(getBtnSignup());
		frmLogin.getContentPane().add(getPfPassword());
		frmLogin.getContentPane().add(getCbPwsign());
		frmLogin.getContentPane().add(getLblLock());
		frmLogin.getContentPane().add(getLblFindid());
		frmLogin.getContentPane().add(getLblFindpw());
		frmLogin.getContentPane().add(getLblNewLabel_1());
		frmLogin.getContentPane().add(getLblNewLabel_1_1());
		frmLogin.getContentPane().add(getLblBackground());
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Loginbackground.png"));
			lblBackground.setBounds(0, 0, 375, 784);
		}
		return lblBackground;
	}
	private JLabel getLblTitleimage() {
		if (lblTitleimage == null) {
			lblTitleimage = new JLabel("");
			lblTitleimage.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/dochicoffe.png"));
			lblTitleimage.setBounds(67, 130, 243, 212);
		}
		return lblTitleimage;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBackground(Color.decode("#ECE0D1"));
			tfId.setBounds(112, 427, 171, 32);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(79, 427, 36, 32);
		}
		return lblNewLabel;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("PW");
			lblPw.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
			lblPw.setHorizontalAlignment(SwingConstants.CENTER);
			lblPw.setBounds(79, 471, 36, 32);
		}
		return lblPw;
	}
	private JLabel getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JLabel("");
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					customerCheck();
				}
				@Override
				public void mousePressed(MouseEvent e) {
					btnLogin.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/pressLogin.png"));
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					btnLogin.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/LoginBtn.png"));
				}
			});
			btnLogin.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/LoginBtn.png"));
			btnLogin.setBounds(203, 515, 80, 40);
		}
		return btnLogin;
	}
	
	// 회원가입 페이지로 이동 
	private JLabel getBtnSignup() {
		if (btnSignup == null) {
			btnSignup = new JLabel("");
			btnSignup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Signup signup = new Signup();
					signup.main(null);
					frmLogin.setVisible(false);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					btnSignup.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/pressSignup.png"));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnSignup.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/SignupBtn.png"));
				}
			});
			btnSignup.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/SignupBtn.png"));
			btnSignup.setBounds(203, 567, 80, 40);
		}
		return btnSignup;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBackground(Color.decode("#ECE0D1"));
			pfPassword.setBounds(112, 471, 171, 32);
		}
		return pfPassword;
	}
	private JCheckBox getCbPwsign() {
		if (cbPwsign == null) {
			cbPwsign = new JCheckBox("Pw");
			cbPwsign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		               if(cbPwsign.isSelected()) {
		                   pfPassword.setEchoChar((char)0);
		                }else {
		                   pfPassword.setEchoChar('●');
		                }
				}
			});
			cbPwsign.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			cbPwsign.setBounds(112, 501, 65, 23);
		}
		return cbPwsign;
	}
	private JLabel getLblLock() {
		if (lblLock == null) {
			lblLock = new JLabel("");
			lblLock.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Locked.png"));
			lblLock.setBounds(86, 644, 19, 25);
		}
		return lblLock;
	}
	private JLabel getLblFindid() {
		if (lblFindid == null) {
			lblFindid = new JLabel("");
			lblFindid.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Findid findid = new Findid();
					findid.setVisible(true);
				}
			});
			lblFindid.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Findid.png"));
			lblFindid.setBounds(113, 649, 80, 20);
		}
		return lblFindid;
	}
	private JLabel getLblFindpw() {
		if (lblFindpw == null) {
			lblFindpw = new JLabel("");
			lblFindpw.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Findpw findpw = new Findpw();
					findpw.setVisible(true);
				}
			});
			lblFindpw.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/Findpw.png"));
			lblFindpw.setBounds(203, 649, 80, 20);
		}
		return lblFindpw;
	}
	
	// Method
	
	// Id Pw check Method
	  private void customerCheck() {
	      // 여기는 값을 받아서 넘겨주는 메소드
	      // 받아오기>>넘겨주기>>다오안에 있는 체크 메세지 실행   다오는 ?데이타베이스랑 연결  dto는 게터세터 모음집
	      int check=0;
	      int check1=0;
	       id=tfId.getText().trim();
	      String pw=pfPassword.getText().trim();
	      Daologin dao=new Daologin(id, pw);
	      check=dao.customerCheck();
	      check1=dao.customerCheck1();
	      if(check1==1) {
	         JOptionPane.showMessageDialog(null, "탈퇴된 회원입니다.");
	      }else {
	         check=dao.customerCheck();
	         if(check==1) {
	             JOptionPane.showMessageDialog(null, id+"님 로그인 되었습니다.");
					Mainpage mainpage = new Mainpage();
					mainpage.main(null);
					frmLogin.setVisible(false);}
	          }
	          if(check==0) {
	             JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요.");
	             tfId.setText("");/// 텍스트필드를 다 지워버리기.
	             pfPassword.setText("");
	             tfId.requestFocus();
				}
			}
		
	  
	  
	  
	  
	  
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/dochitabbar.png"));
			lblNewLabel_1.setBounds(0, 710, 375, 57);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon("/Users/Bhan/Documents/JAVA/Coffee/src/com/javalec/image/dochitabbar.png"));
			lblNewLabel_1_1.setBounds(0, 0, 375, 57);
		}
		return lblNewLabel_1_1;
	}
}// End
