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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Purchase extends JDialog {
	private JLabel lblNewLabel_1_3;
	private JTextField tfProductname;
	private JLabel lblNewLabel_1_4;
	private JTextField tfSize;
	private JLabel lblNewLabel_1_5;
	private JTextField tfColor;
	private JLabel lblNewLabel_1_6;
	private JButton btnBuy;
	private JButton btnBack;
	private JLabel lblNewLabel_1_2;
	private JTextField tfBrand;
	private JLabel lblNewLabel_1_6_1;
	
	Daomain dao = new Daomain(Mainshoes.wkProid);
	Dtomain dto = dao.tableClick();
	private JLabel lblPrice;
	private JSpinner spinner;
	public static int a;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase dialog = new Purchase();
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
	public Purchase() {
		setTitle("Purchase Page");
		setBounds(100, 100, 328, 348);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_1_3());
		getContentPane().add(getTfProductname());
		getContentPane().add(getLblNewLabel_1_4());
		getContentPane().add(getTfSize());
		getContentPane().add(getLblNewLabel_1_5());
		getContentPane().add(getTfColor());
		getContentPane().add(getLblNewLabel_1_6());
		getContentPane().add(getBtnBuy());
		getContentPane().add(getBtnBack());
		getContentPane().add(getLblNewLabel_1_2_1());
		getContentPane().add(getTfBrand());
		getContentPane().add(getLblNewLabel_1_6_1());
		getContentPane().add(getLblPrice());
		getContentPane().add(getSpinner());

	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("Product Name : ");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_3.setBounds(27, 32, 110, 16);
		}
		return lblNewLabel_1_3;
	}
	private JTextField getTfProductname() {
		if (tfProductname == null) {
			tfProductname = new JTextField();
			tfProductname.setEditable(false);
			tfProductname.setColumns(10);
			tfProductname.setBounds(161, 27, 130, 26);
		}
		return tfProductname;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("Size : ");
			lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_4.setBounds(76, 103, 61, 16);
		}
		return lblNewLabel_1_4;
	}
	private JTextField getTfSize() {
		if (tfSize == null) {
			tfSize = new JTextField();
			tfSize.setEditable(false);
			tfSize.setColumns(10);
			tfSize.setBounds(161, 98, 130, 26);
		}
		return tfSize;
	}
	private JLabel getLblNewLabel_1_5() {
		if (lblNewLabel_1_5 == null) {
			lblNewLabel_1_5 = new JLabel("Color : ");
			lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_5.setBounds(76, 141, 61, 16);
		}
		return lblNewLabel_1_5;
	}
	private JTextField getTfColor() {
		if (tfColor == null) {
			tfColor = new JTextField();
			tfColor.setEditable(false);
			tfColor.setColumns(10);
			tfColor.setBounds(161, 136, 130, 26);
		}
		return tfColor;
	}
	private JLabel getLblNewLabel_1_6() {
		if (lblNewLabel_1_6 == null) {
			lblNewLabel_1_6 = new JLabel("Quantity : ");
			lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_6.setBounds(46, 179, 91, 16);
		}
		return lblNewLabel_1_6;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("Purchase");
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "구매가 완료되었습니다. 감사합니다.");
					Daomain daomain = new Daomain();
					daomain.insertAction();
					daomain.updateAction();
					
					
					
					
				}
			});
			btnBuy.setBounds(174, 254, 117, 29);
		}
		return btnBuy;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Main");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Mainshoes frmMainpage = new Mainshoes();
					frmMainpage.main(null);
					setVisible(false);
				}
			});
			btnBack.setBounds(27, 254, 117, 29);
		}
		return btnBack;
	}
	private JLabel getLblNewLabel_1_2_1() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("Brand : ");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_2.setBounds(27, 65, 110, 16);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getTfBrand() {
		if (tfBrand == null) {
			tfBrand = new JTextField();
			tfBrand.setEditable(false);
			tfBrand.setColumns(10);
			tfBrand.setBounds(161, 60, 130, 26);
		}
		return tfBrand;
	}
	private JLabel getLblNewLabel_1_6_1() {
		if (lblNewLabel_1_6_1 == null) {
			lblNewLabel_1_6_1 = new JLabel("Price : ");
			lblNewLabel_1_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_6_1.setBounds(46, 212, 91, 16);
		}
		return lblNewLabel_1_6_1;
	}
	
	// M
	public void orderPage() {
		tfProductname.setText(dto.getPname());
		tfBrand.setText(dto.getPbrand());
		tfSize.setText(Integer.toString(dto.getPsize()));
		tfColor.setText(dto.getPcolor());
		
	}
	
	private JLabel getLblPrice() { 
		if (lblPrice == null) {
			lblPrice = new JLabel(Integer.toString(dto.getPprice()));
			lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
			lblPrice.setBounds(161, 212, 130, 16);
			
		}
		//Integer.parseInt(String.getValue(spinner));
		//System.out.println();
		
		return lblPrice;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					//System.out.println(((JOptionPane) e.getSource()).getValue());
					a= (int) (((JSpinner)e.getSource()).getValue());//팔린갯수
					lblPrice.setText(Integer.toString((a*dto.getPprice())));
				}
			});
//			spinner.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//				lblPrice.setText(Integer.toString(Integer.parseInt(String.valueOf(spinner.getValue())) *1000));
//				}
//			});
			spinner.setModel(new SpinnerNumberModel(1, 1, dto.getPinvenquantity(), 1));
			spinner.setBounds(161, 177, 41, 25);
		}
		
		return spinner;
	}
	
} // End
