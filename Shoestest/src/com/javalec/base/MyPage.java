package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Daomypage;
import com.javalec.dto.Dtocust;
import com.javalec.util.DBConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// ------------------------------ 마이페이지 화면 출력 클래스 ------------------------------
public class MyPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JButton btnHome;
	private JLabel lblId_1;
	private JLabel lblId_2;
	private JLabel lblId_3;
	private JLabel lblId_4;
	private JTextField tfId;
	private JTextField tfPw;
	private JTextField tfName;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private JButton btnUpdate;
	private JButton btnDelete;

	public static void main(String[] args) {
		try {
			MyPage dialog = new MyPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MyPage() {

		// -------------------- 마이페이지 출력 시, 고객 정보 출력 --------------------
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				searchAction(); // 고객 정보 출력 메소드 호출
			}
		});
		setBounds(100, 100, 417, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblId());
		contentPanel.add(getBtnHome());
		contentPanel.add(getLblId_1());
		contentPanel.add(getLblId_2());
		contentPanel.add(getLblId_3());
		contentPanel.add(getLblId_4());
		contentPanel.add(getTfId());
		contentPanel.add(getTfPw());
		contentPanel.add(getTfName());
		contentPanel.add(getTfPhone());
		contentPanel.add(getTfAddress());
		contentPanel.add(getBtnUpdate());
		contentPanel.add(getBtnDelete());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("My Page");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(34, 10, 335, 43);
		}
		return lblNewLabel;
	}

	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID :");
			lblId.setHorizontalAlignment(SwingConstants.LEFT);
			lblId.setForeground(Color.BLACK);
			lblId.setFont(new Font("굴림", Font.BOLD, 15));
			lblId.setBounds(43, 74, 62, 33);
		}
		return lblId;
	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("Main");
			btnHome.setFont(new Font("굴림", Font.BOLD, 15));
			btnHome.setToolTipText("");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Mainshoes mainshoes = new Mainshoes();
					mainshoes.main(null);
					setVisible(false);
				}
			});
			btnHome.setBounds(33, 360, 105, 33);
		}
		return btnHome;
	}

	private JLabel getLblId_1() {
		if (lblId_1 == null) {
			lblId_1 = new JLabel("  PW :");
			lblId_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblId_1.setForeground(Color.BLACK);
			lblId_1.setFont(new Font("굴림", Font.BOLD, 15));
			lblId_1.setBounds(34, 117, 83, 28);
		}
		return lblId_1;
	}

	private JLabel getLblId_2() {
		if (lblId_2 == null) {
			lblId_2 = new JLabel("이름 :");
			lblId_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblId_2.setForeground(Color.BLACK);
			lblId_2.setFont(new Font("굴림", Font.BOLD, 15));
			lblId_2.setBounds(34, 155, 83, 33);
		}
		return lblId_2;
	}

	private JLabel getLblId_3() {
		if (lblId_3 == null) {
			lblId_3 = new JLabel("전화번호 :");
			lblId_3.setHorizontalAlignment(SwingConstants.LEFT);
			lblId_3.setForeground(Color.BLACK);
			lblId_3.setFont(new Font("굴림", Font.BOLD, 15));
			lblId_3.setBounds(34, 198, 125, 28);
		}
		return lblId_3;
	}

	private JLabel getLblId_4() {
		if (lblId_4 == null) {
			lblId_4 = new JLabel("주소 :");
			lblId_4.setHorizontalAlignment(SwingConstants.LEFT);
			lblId_4.setForeground(Color.BLACK);
			lblId_4.setFont(new Font("굴림", Font.BOLD, 15));
			lblId_4.setBounds(34, 237, 83, 33);
		}
		return lblId_4;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setEditable(false);
			tfId.setBounds(137, 78, 118, 30);
			tfId.setColumns(10);
		}
		return tfId;
	}

	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(137, 118, 118, 30);
		}
		return tfPw;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(137, 158, 118, 30);
		}
		return tfName;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(137, 199, 118, 30);
		}
		return tfPhone;
	}

	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(137, 239, 203, 30);
		}
		return tfAddress;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("Update");
			btnUpdate.setFont(new Font("굴림", Font.BOLD, 12));
			btnUpdate.setToolTipText("");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
				}
			});
			btnUpdate.setBounds(150, 361, 105, 33);
		}
		return btnUpdate;
	}

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete ID");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Daomypage dao = new Daomypage();
					dao.deleteAction(); // 탈퇴하기
					JOptionPane.showMessageDialog(null, "계정 탈퇴가 완료되었습니다.");
					setVisible(false);
					LoginPage window = new LoginPage();
					window.main(null);

				}
			});
			btnDelete.setToolTipText("");
			btnDelete.setFont(new Font("굴림", Font.BOLD, 12));
			btnDelete.setBounds(264, 361, 105, 33);
		}
		return btnDelete;
	}

	// ----------------------------------------------- Functions

	// -------------------- 고객 정보 출력 메소드 --------------------
	private void searchAction() {
		Daomypage dao = new Daomypage(); // Daomypage 클래스 인스턴스 선언
		ArrayList<Dtocust> dtoList = dao.conditionList(); // Daomypage의 conditionList메소드 호출

		String temp = (dtoList.get(0).getCustid());

		tfId.setText(temp);
		tfPw.setText(dtoList.get(0).getCpw());
		tfName.setText(dtoList.get(0).getCname());
		tfPhone.setText(dtoList.get(0).getCphone());
		tfAddress.setText(dtoList.get(0).getCaddress());

	}

	private void updateAction() { // insert, delete update have same format
		Daomypage dao = new Daomypage();

		boolean ok = dao.updateAction(tfPw.getText(), tfName.getText(), tfPhone.getText(), tfAddress.getText());

		if (ok == true) {

			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 수정 되었습니다.!");
		} else {
			JOptionPane.showMessageDialog(null, "DB 작업중 문제가 발생했습니다. \n행정실에 문의하세요!");

		}

	}

} // End
