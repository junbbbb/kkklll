package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import com.javalec.dao.Daologin;

public class LoginPage {

   private JFrame frame1;
   private JLabel lblNewLabel;
   private JTextField tfId;
   private JLabel lblPw;
   private JButton btnLogin;
   private JButton btnSignup;
   private JLabel lblNewLabel_1;
   private JPasswordField pfPw;
   private JCheckBox chkIdpw;
   public static String id;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               LoginPage window = new LoginPage();
               window.frame1.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public LoginPage() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame1 = new JFrame();
      frame1.getContentPane().setBackground(new Color(255, 255, 255));
      frame1.setTitle("Login");
      frame1.setBounds(100, 100, 283, 482);
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.getContentPane().setLayout(null);
      frame1.getContentPane().add(getLblNewLabel());
      frame1.getContentPane().add(getTfId());
      frame1.getContentPane().add(getLblPw());
      frame1.getContentPane().add(getBtnLogin());
      frame1.getContentPane().add(getBtnSignup());
      frame1.getContentPane().add(getLblNewLabel_1());
      frame1.getContentPane().add(getPfPw());
      frame1.getContentPane().add(getChkIdpw());
   }

   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("ID  :");
         lblNewLabel.setBounds(51, 259, 57, 15);
      }
      return lblNewLabel;
   }

   private JTextField getTfId() {
      if (tfId == null) {
         tfId = new JTextField();
         tfId.setBounds(85, 256, 142, 21);
         tfId.setColumns(10);
      }
      return tfId;
   }

   private JLabel getLblPw() {
      if (lblPw == null) {
         lblPw = new JLabel("PW  :");
         lblPw.setBounds(51, 299, 57, 15);
      }
      return lblPw;
   }

   private JButton getBtnLogin() {
      if (btnLogin == null) {
         btnLogin = new JButton("?????????");
         btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // ????????? ????????? ????????? ??????????????? ???????????? 000??????????????? ??????????????? ????????????
               // ???????????????
               // (id/pw/deldate)???????????? ????????? 1 ?????? goMain?????? ????????????
               // (id/pw/deldate)???????????? ?????????0 ?????? goSignup?????? ????????? Joptiondialogmessage ?????????
               // goSignup??? ????????? ???????????? ?????????.....
               customerCheck();

			   

            }
         });
         btnLogin.setBounds(146, 380, 97, 23);
      }
      return btnLogin;
   }

   private JButton getBtnSignup() {
      if (btnSignup == null) {
         btnSignup = new JButton("????????????");
         btnSignup.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
//         		Signup signup = new Signup();
//         		signup.main(null);
                frame1.setVisible(false);
         	}
         });
         btnSignup.setBounds(24, 380, 97, 23);
      }
      return btnSignup;
   }

   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("Shoes Shop");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel_1.setFont(new Font("??????", Font.PLAIN, 30));
         lblNewLabel_1.setBounds(24, 36, 219, 62);
      }
      return lblNewLabel_1;
   }
   private JPasswordField getPfPw() {
      if (pfPw == null) {
         pfPw = new JPasswordField();
         pfPw.setBounds(85, 296, 142, 21);
      }
      return pfPw;
   }//function

   private void customerCheck() {
      // ????????? ?????? ????????? ???????????? ?????????
      // ????????????>>????????????>>???????????? ?????? ?????? ????????? ??????   ????????? ?????????????????????? ??????  dto??? ???????????? ?????????
      int check=0;
       id=tfId.getText().trim();
      String pw=pfPw.getText().trim();
      Daologin dao=new Daologin(id, pw);
      check=dao.customerCheck();
      if(check==1) {
         JOptionPane.showMessageDialog(null, id+"??? ????????? ???????????????.");
//         Mainshoes mainshoes = new Mainshoes();
//         mainshoes.main(null);
         frame1.setVisible(false);
      }
      if(check==0) {
         JOptionPane.showMessageDialog(null, "???????????? ??????????????? ???????????????.");
         tfId.setText("");/// ?????????????????? ??? ???????????????.
         pfPw.setText("");
         tfId.requestFocus();
      }
      
      
   }

   private JCheckBox getChkIdpw() {
      if (chkIdpw == null) {
         chkIdpw = new JCheckBox("???????????? ??????");
         chkIdpw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(chkIdpw.isSelected()) {
                  pfPw.setEchoChar((char)0);
               }else {
                  pfPw.setEchoChar('???');
               }
            }
            
            
         });
         chkIdpw.setBounds(85, 320, 142, 23);
      }
      return chkIdpw;
   }
}// End