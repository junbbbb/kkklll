package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javalec.dao.Daosign;
import com.javalec.util.DBConnect;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Signup {

	private JFrame frame;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblPw;
	private JLabel lblPwcheck;
	private JTextField tfPhone;
	private JLabel lblPhone;
	private JTextField tfAddress;
	private JLabel lblAddress;
	private JButton btnSignupok;
	private JButton btnNewButton_1;
	private JTextField tfName;
	private JLabel lblName;
	private JButton btnLogin;
	ArrayList<String> arraylist = new ArrayList<String>();
	private boolean idcheck = false;
	private boolean pwcheck = false;
	private JButton btnPwcheck;
	private JPasswordField pfPw;
	private JPasswordField pfPwcheck;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 371, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblId());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getLblPw());
		frame.getContentPane().add(getLblPwcheck());
		frame.getContentPane().add(getTfPhone());
		frame.getContentPane().add(getLblPhone());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblAddress());
		frame.getContentPane().add(getBtnSignupok());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblName());
		frame.getContentPane().add(getBtnLogin());
		frame.getContentPane().add(getBtnPwcheck());
		frame.getContentPane().add(getPfPw());
		frame.getContentPane().add(getPfPwcheck());
		frame.getContentPane().add(getChckbxNewCheckBox());
		frame.getContentPane().add(getLblNewLabel());
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID :");
			lblId.setBounds(40, 55, 36, 26);
		}
		return lblId;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(121, 56, 130, 26);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblPw() {
		if (lblPw == null) {
			lblPw = new JLabel("비밀번호 :");
			lblPw.setBounds(40, 154, 53, 26);
		}
		return lblPw;
	}
	private JLabel getLblPwcheck() {
		if (lblPwcheck == null) {
			lblPwcheck = new JLabel("비밀번호 확인");
			lblPwcheck.setBounds(40, 215, 65, 26);
		}
		return lblPwcheck;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(121, 252, 130, 26);
		}
		return tfPhone;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("연락처");
			lblPhone.setBounds(40, 251, 36, 26);
		}
		return lblPhone;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(121, 291, 175, 26);
		}
		return tfAddress;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소");
			lblAddress.setBounds(40, 290, 36, 26);
		}
		return lblAddress;
	}
	private JButton getBtnSignupok() {
		if (btnSignupok == null) {
			btnSignupok = new JButton("회원가입 완료하기");
			btnSignupok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int i_chk = insertFieldCheck();
					if(i_chk == 0) {
						
						
						if(idcheck== true && pwcheck ==true) {
							
							insertAction();
							LoginPage loginPage = new LoginPage();
							 loginPage.main(null);
					         frame.setVisible(false);
							
							
						}
						if(idcheck== false) {
							JOptionPane.showMessageDialog(null, "아이디 중복체크를 확인해주세요!");
						}
						if(pwcheck == false) {
							JOptionPane.showMessageDialog(null, "비밀번호가 같은지 확인해주세요!");
						}
												
					}
				}
			});
			btnSignupok.setBounds(103, 341, 135, 29);
		}
		return btnSignupok;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("중복확인");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idDuplicatedCheck();
				}
			});
			btnNewButton_1.setBounds(257, 56, 88, 29);
		}
		return btnNewButton_1;
	}
	
	
	
	
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(121, 105, 130, 26);
		}
		return tfName;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름 :");
			lblName.setBounds(40, 109, 36, 16);
		}
		return lblName;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인화면으로 가기");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//			         Mainshoes mainshoes = new Mainshoes();
//			         mainshoes.main(null);
					 LoginPage loginPage = new LoginPage();
					 loginPage.main(null);
			         frame.setVisible(false);
					
				}
			});
			btnLogin.setBounds(103, 381, 135, 29);
		}
		return btnLogin;
	}
	private JButton getBtnPwcheck() {
		if (btnPwcheck == null) {
			btnPwcheck = new JButton("확인");
			btnPwcheck.setFont(new Font("굴림", Font.PLAIN, 10));
			btnPwcheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pwSameCheck();
				}
			});
			btnPwcheck.setBounds(257, 153, 88, 29);
		}
		return btnPwcheck;
	}
	
	
	
	//----------method
	
		private int insertFieldCheck() {
			int i = 0;
			String message = "";
			
			if(tfId.getText().trim().length() == 0) {
				i++;
				message = "ID ";			
				arraylist.add(message);
				tfId.requestFocus();//그위치에 가서 커서가 깜빡임
			}
				
			if(tfName.getText().trim().length() == 0) {
				i++;
				message = "이름 ";			
				arraylist.add(message);
				tfName.requestFocus();//그위치에 가서 커서가 깜빡임
				
			}
				
			char[] pass1 = pfPw.getPassword();
			char[] pass2 = pfPwcheck.getPassword();
			
			String passString1 = new String(pass1); //char를 string으로...
			String passString2 = new String(pass2); //char를 string으로...
			
			if(passString1.trim().length()==0) {
				i++;
				message = "비밀번호 ";	
				arraylist.add(message);
				pfPw.requestFocus();//그위치에 가서 커서가 깜빡임
				
			}
			if(tfPhone.getText().trim().length() == 0) {
				i++;
				message = "번호 ";	
				arraylist.add(message);
				tfPhone.requestFocus();//그위치에 가서 커서가 깜빡임
				
			}
			
			
			if(tfAddress.getText().trim().length() == 0) {
				i++;
				message = "주소 ";	
				arraylist.add(message);
				tfAddress.requestFocus();//그위치에 가서 커서가 깜빡임
				
			}
			
			
		
			if(i>0) {
				JOptionPane.showMessageDialog(null, arraylist+"입력하세요!");
				arraylist.clear();
			}
			return i;
		}
		
		private int insertAction() {
			int check =0;
			char[] pass1 = pfPw.getPassword();
			
			
			String passString1 = new String(pass1); //char를 string으로...
			
			
			String custid = tfId.getText().trim();
			String cname = tfName.getText().trim();
			String cpw = passString1.trim();
			String phone = tfPhone.getText().trim();
			String address = tfAddress.getText().trim();
			
			Daosign dao = new Daosign( custid, cname, cpw, phone, address );
			
			boolean ok = dao.insertAction();
			
			if(ok == true) {
				JOptionPane.showMessageDialog(null, tfName.getText()+"님의 가입을 축하드립니다!");
				check = 1;
				return check;
			}else {
				JOptionPane.showMessageDialog(null, "DB 작업중 문제가 발생했습니다. \n 행정실에 문의 하세요!.");
				check = 0;
				return check;
			}
		}
		
		
		
		private boolean pwSameCheck() {// 비밀번호 체
			char[] pass1 = pfPw.getPassword();
			char[] pass2 = pfPwcheck.getPassword();
			
			String passString1 = new String(pass1); //char를 string으로...
			String passString2 = new String(pass2); //char를 string으로...
			
			if(passString1.trim().equals(passString2.trim()) ) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다!");
				pwcheck = true;
				return true;
				
				
				
			}else {
				
				JOptionPane.showMessageDialog(null, "비밀번호가 같은지 다시 확인하세요!");
				pfPw.setText("");
				pfPwcheck.setText("");
				pwcheck = false;
				return false;
				
			}
			
			
		}
		
		private void idDuplicatedCheck() {
			int check =0;
			String custid = tfId.getText().trim();
			Daosign dao2 = new Daosign(custid);
			check = dao2.idDuplicatedCheck();
			if(check==1) {
				JOptionPane.showMessageDialog(null, "ID가 중복됩니다. 다시 입력해주세요");
				tfId.setText("");
				idcheck = false;
				
			}if(check==0) {
				JOptionPane.showMessageDialog(null, "사용가능한 ID 입니다!");
				idcheck = true;
//				return true;
				
			}
		}
	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setBounds(121, 155, 130, 26);
		}
		return pfPw;
	}
	private JPasswordField getPfPwcheck() {
		if (pfPwcheck == null) {
			pfPwcheck = new JPasswordField();
			pfPwcheck.setBounds(121, 216, 132, 26);
		}
		return pfPwcheck;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("비밀번호 보기");
			chckbxNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxNewCheckBox.isSelected()) {
		                pfPw.setEchoChar((char)0);
		               }else {
		                pfPw.setEchoChar('●');
		               }
				}
			});
			chckbxNewCheckBox.setBounds(211, 188, 108, 23);
		}
		return chckbxNewCheckBox;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 333, 26);
		}
		return lblNewLabel;
	}
}// End
