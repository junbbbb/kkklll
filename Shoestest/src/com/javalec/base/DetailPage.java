package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.javalec.dao.Daomain;
import com.javalec.dto.Dtomain;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DetailPage extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_1_1;
	private JTextField tfBrand;
	private JLabel lblNewLabel_1_2;
	private JTextField tfPrice;
	private JLabel lblNewLabel_1_3;
	private JTextField tfSize;
	private JLabel lblNewLabel_1_4;
	private JTextField tfColor;
	private JLabel lblNewLabel_1_5;
	private JTextField tfQuantity;
	private JButton btnBack;
	private JButton btnBuying;

	Daomain dao = new Daomain(Mainshoes.wkProid);
	Dtomain dto = dao.tableClick();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailPage dialog = new DetailPage();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DetailPage() {
		setTitle("Detail Page");
		setBounds(100, 100, 332, 428);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfName());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getTfBrand());
		getContentPane().add(getLblNewLabel_1_2());
		getContentPane().add(getTfPrice());
		getContentPane().add(getLblNewLabel_1_3());
		getContentPane().add(getTfSize());
		getContentPane().add(getLblNewLabel_1_4());
		getContentPane().add(getTfColor());
		getContentPane().add(getLblNewLabel_1_5());
		getContentPane().add(getTfQuantity());
		getContentPane().add(getBtnBack());
		getContentPane().add(getBtnBuying());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Product Details");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 25, 294, 29);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Name : ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(47, 85, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setBounds(146, 80, 130, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("Brand : ");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1.setBounds(47, 123, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfBrand() {
		if (tfBrand == null) {
			tfBrand = new JTextField();
			tfBrand.setEditable(false);
			tfBrand.setColumns(10);
			tfBrand.setBounds(146, 118, 130, 26);
		}
		return tfBrand;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Price : ");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_2.setBounds(47, 163, 61, 16);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setColumns(10);
			tfPrice.setBounds(146, 158, 130, 26);
		}
		return tfPrice;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("Size : ");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_3.setBounds(47, 202, 61, 16);
		}
		return lblNewLabel_1_3;
	}
	private JTextField getTfSize() {
		if (tfSize == null) {
			tfSize = new JTextField();
			tfSize.setEditable(false);
			tfSize.setColumns(10);
			tfSize.setBounds(146, 197, 130, 26);
		}
		return tfSize;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("Color : ");
			lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_4.setBounds(47, 243, 61, 16);
		}
		return lblNewLabel_1_4;
	}
	private JTextField getTfColor() {
		if (tfColor == null) {
			tfColor = new JTextField();
			tfColor.setEditable(false);
			tfColor.setColumns(10);
			tfColor.setBounds(146, 238, 130, 26);
		}
		return tfColor;
	}
	private JLabel getLblNewLabel_1_5() {
		if (lblNewLabel_1_5 == null) {
			lblNewLabel_1_5 = new JLabel("Quantity : ");
			lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_5.setBounds(48, 286, 61, 16);
		}
		return lblNewLabel_1_5;
	}
	private JTextField getTfQuantity() {
		if (tfQuantity == null) {
			tfQuantity = new JTextField();
			tfQuantity.setEditable(false);
			tfQuantity.setColumns(10);
			tfQuantity.setBounds(147, 281, 130, 26);
		}
		return tfQuantity;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Mainshoes frmMainpage = new Mainshoes();
					frmMainpage.main(null);
					setVisible(false);
				}
			});
			btnBack.setBounds(41, 330, 117, 29);
		}
		return btnBack;
	}
	private JButton getBtnBuying() {
		if (btnBuying == null) {
			btnBuying = new JButton("Buy");
			btnBuying.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(dto.getPinvenquantity() > 0) {
						Purchase purchase = new Purchase();
						purchase.orderPage();
						purchase.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "재고가 부족합니다.");
					}
				
				}
			});
			btnBuying.setBounds(170, 330, 117, 29);
		}
		return btnBuying;
	}
	
	// 클릭한 상품의 인덱스 번호값 받아오기
		public void tableCheck() {
			
			tfName.setText(dto.getPname());
			tfBrand.setText(dto.getPbrand());
			tfPrice.setText(Integer.toString(dto.getPprice()));
			tfSize.setText(Integer.toString(dto.getPsize()));
			tfColor.setText(dto.getPcolor());
			tfQuantity.setText(Integer.toString(dto.getPinvenquantity()));
		}
		
	
	
	
	
} // End
