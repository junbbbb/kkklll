package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoOrder;
import com.javalec.dao.Daomain;
import com.javalec.dto.Dtomain;
import com.javalec.dto.Dtoorder;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderList extends JDialog {
	private JScrollPane scrollPane;
	private JTable ordertable;
	private JButton btnMain;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderList dialog = new OrderList();
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
	public OrderList() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setTitle("My Order List");
		setBounds(100, 100, 350, 381);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnMain());

	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 17, 337, 279);
			scrollPane.setViewportView(getOrdertable());
		}
		return scrollPane;
	}
	private JTable getOrdertable() {
		if (ordertable == null) {
			ordertable = new JTable();
			ordertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ordertable.setModel(Outer_Table);
		}
		return ordertable;
		
	}
	private JButton getBtnMain() {
		if (btnMain == null) {
			btnMain = new JButton("Main");
			btnMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Mainshoes frmMainpage = new Mainshoes();
					frmMainpage.main(null);
					setVisible(false);
				}
			});
			btnMain.setBounds(113, 309, 117, 29);
		}
		return btnMain;
	}
	
	
	// M
	private void tableInit() {

		Outer_Table.addColumn("No"); // 테이블위에 쓰이는것들
		Outer_Table.addColumn("Order Date"); // 테이블위에 쓰이는것들
		Outer_Table.addColumn("Cust Name");
		Outer_Table.addColumn("Product Name");
		Outer_Table.addColumn("Product Brand");
		Outer_Table.addColumn("Size");
		Outer_Table.addColumn("Color");
		Outer_Table.addColumn("Quantity");
		Outer_Table.addColumn("Total Price");

		Outer_Table.setColumnCount(9); // 몇개인지 알려줘야함.

		int i = Outer_Table.getRowCount(); // 현재 몇줄이냐? 중간 삭제 변경 일때 위에있는 모양이 바뀌니깐. 기존에 있는걸 지울려고 가져옴
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0); // 하나씩 떙겨오면서 지운다.
		}

		ordertable.setAutoResizeMode(ordertable.AUTO_RESIZE_OFF); // 태이블끼리 왓다갓다하면 따른짓을 많이해야해서 끈다.

		int vColIndex = 0;
		TableColumn col = ordertable.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 100; // 순서헷갈리면 안된다 위느 1부터 이건 0부터 그리고 width는 글자수 에 따라 서 값을 지저해주는게좋아
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 5;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 6;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 7;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
		
		vColIndex = 8;
		col = ordertable.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
		
	}// inner table
	
	private void searchAction() {
		DaoOrder dao = new DaoOrder();
		ArrayList<Dtoorder> dtoList = dao.selectList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String orderid = Integer.toString(dtoList.get(index).getOrderid());
			String quant = Integer.toString(dtoList.get(index).getOquantity());
			int price = dtoList.get(index).getPprice();
			String psize = Integer.toString(dtoList.get(index).getPsize());
			String totalPrice = Integer.toString(dtoList.get(index).getOquantity() * price);
			String[] qTxt = { orderid, dtoList.get(index).getOdate() , dtoList.get(index).getCname(), dtoList.get(index).getPname(),
					dtoList.get(index).getPbrand(), psize, dtoList.get(index).getPcolor(), quant, totalPrice, dtoList.get(index).getPname() };
			Outer_Table.addRow(qTxt);
		}
	}// SearchAction
	
	
	
	
	
	
	
	
} // ENd


