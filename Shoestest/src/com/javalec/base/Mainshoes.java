package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.javalec.dao.Daomain;
import com.javalec.dto.Dtocust;
import com.javalec.dto.Dtomain;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.SwingConstants;

public class Mainshoes {

	private JFrame frmMainpage;
	private JScrollPane scrollPane;
	private JTable innertable;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnMyPage;

	
	
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	public static String wkProid;
	private JButton btnLogout;
	private JLabel lblCustname;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnOrderList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainshoes window = new Mainshoes();
					window.frmMainpage.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainshoes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainpage = new JFrame();
		frmMainpage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableInit();
				searchAction();
				
			}
		});
		frmMainpage.setTitle("MainPage");
		frmMainpage.setBounds(100, 100, 564, 567);
		frmMainpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainpage.getContentPane().setLayout(null);
		frmMainpage.getContentPane().add(getScrollPane());
		frmMainpage.getContentPane().add(getCbSearch());
		frmMainpage.getContentPane().add(getTfSearch());
		frmMainpage.getContentPane().add(getBtnSearch());
		frmMainpage.getContentPane().add(getBtnMyPage());
		frmMainpage.getContentPane().add(getBtnLogout());
		frmMainpage.getContentPane().add(getLblCustname());
		frmMainpage.getContentPane().add(getLblNewLabel());
		frmMainpage.getContentPane().add(getLblNewLabel_1());
		frmMainpage.getContentPane().add(getBtnOrderList());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(46, 136, 443, 346);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable();
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//tableClick();
					tableTurn();
					frmMainpage.setVisible(false);
				}
			});
			
			innertable.setModel(Outer_Table);
		}
		return innertable;
	}
	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.setModel(new DefaultComboBoxModel(new String[] {"name", "brand", "size", "color"}));
			cbSearch.setBounds(12, 90, 92, 36);
		}
		return cbSearch;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(116, 90, 318, 36);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setFont(new Font("굴림", Font.BOLD, 15));
			btnSearch.setBounds(446, 90, 92, 36);
		}
		return btnSearch;
	}
	private JButton getBtnMyPage() {
		if (btnMyPage == null) {
			btnMyPage = new JButton("Mypage");
			btnMyPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MyPage mypage = new MyPage();
					mypage.setVisible(true);
					frmMainpage.setVisible(false);
				}
			});
			btnMyPage.setFont(new Font("굴림", Font.BOLD, 12));
			btnMyPage.setBounds(391, 32, 79, 29);
		}
		return btnMyPage;
	}
	//---------------------------------------------METHOD----------------------------------------------------
	
	// TableInit
	private void tableInit() {

		Outer_Table.addColumn("No"); // 테이블위에 쓰이는것들
		Outer_Table.addColumn("Name"); // 테이블위에 쓰이는것들
		Outer_Table.addColumn("Brand");
		Outer_Table.addColumn("Price");
		Outer_Table.addColumn("Size");
		Outer_Table.addColumn("Color");
		Outer_Table.addColumn("Quantity");

		Outer_Table.setColumnCount(7); // 몇개인지 알려줘야함.

		int i = Outer_Table.getRowCount(); // 현재 몇줄이냐? 중간 삭제 변경 일때 위에있는 모양이 바뀌니깐. 기존에 있는걸 지울려고 가져옴
		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0); // 하나씩 떙겨오면서 지운다.
		}

		innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF); // 태이블끼리 왓다갓다하면 따른짓을 많이해야해서 끈다.

		int vColIndex = 0;
		TableColumn col = innertable.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 90; // 순서헷갈리면 안된다 위느 1부터 이건 0부터 그리고 width는 글자수 에 따라 서 값을 지저해주는게좋아
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 5;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 6;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
	}// inner table
	
	// Search Action
	private void searchAction() {
		Daomain dao = new Daomain();
		ArrayList<Dtomain> dtoList = dao.selectList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String ppp = Integer.toString(dtoList.get(index).getPprice());
			String psz = Integer.toString(dtoList.get(index).getPsize());
			String pqq = Integer.toString(dtoList.get(index).getPinvenquantity());
			String[] qTxt = { dtoList.get(index).getProid() , dtoList.get(index).getPname(), dtoList.get(index).getPbrand(),
					ppp, psz, dtoList.get(index).getPcolor() ,pqq  };
			Outer_Table.addRow(qTxt);
		}
	}// SearchAction
	
	//-------------------------------------------------------------------------------------------------//
	// Table Click 뭐를 클릭했는지 알아야함
//	private void tableClick() {
//		int i = innertable.getSelectedRow();
//		// 순서를 가져오면됨 화면에 뜬건 다 문자다.그래서 스트링타이븡로 바꾼다.
//		String wkProid = (String) innertable.getValueAt(i, 0);
//		Dao1 dao = new Dao1(wkProid);
//		
//		Dto1 dto = dao.tableClick(); // 리턴값을 받으니 받아야할놈(Dto타입)가(이) 필요한거다.
//
//		tfName.setText(dto.getPname());
//		tfBrand.setText(dto.getPbrand());
//		tfPrice.setText(Integer.toString(dto.getPprice()));
//		tfSize.setText(Integer.toString(dto.getPsize()));
//		tfColor.setText(dto.getPcolor());
//		tfQuan.setText(Integer.toString(dto.getPinvenquantity()));
//
//	}// TABLE CLICK
	
	
	// Table 값 뽑아내기
	private void tableTurn() {
		int row = innertable.getSelectedRow();
	//	TableModel data = innertable.getModel();
		wkProid = (String) innertable.getValueAt(row, 0);
		
		DetailPage detailpage = new DetailPage();
		detailpage.tableCheck();
		detailpage.setVisible(true);

		
	}
	

	
	// ConditionQuery
	private void conditionQuery() {
		int i = cbSearch.getSelectedIndex();
		// 어디가 0번부터인지 알아야함. 0 이름 1주소 2관계
		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "pname";
			break;
		case 1:
			conditionQueryColumn = "pbrand";
			break;
		case 2:
			conditionQueryColumn = "psize";
			break;
		case 3:
			conditionQueryColumn = "pcolor";
			break;
		default:
			break;
		}

		tableInit(); // 테이블 정리
		conditionQueryAction(conditionQueryColumn); // ()안에 네임이면 네임글자가올거고 선택에 따른 값이 옴
	}
	
	// ConditionQuery Action
	
	private void conditionQueryAction(String conditionQueryColumn) {

		Daomain dao = new Daomain(conditionQueryColumn, tfSearch.getText());
		ArrayList<Dtomain> dtoList = dao.conditionList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String ppp = Integer.toString(dtoList.get(index).getPprice());
			String psz = Integer.toString(dtoList.get(index).getPsize());
			String pqq = Integer.toString(dtoList.get(index).getPinvenquantity());
			String[] qTxt = { dtoList.get(index).getProid() , dtoList.get(index).getPname(), dtoList.get(index).getPbrand(),
					ppp, psz, dtoList.get(index).getPcolor() ,pqq  };
			Outer_Table.addRow(qTxt);

		}

	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다!");
					 LoginPage loginPage = new LoginPage();
					 loginPage.main(null);
			         frmMainpage.setVisible(false);
				}
			});
			btnLogout.setFont(new Font("굴림", Font.BOLD, 12));
			btnLogout.setBounds(479, 35, 79, 23);
		}
		return btnLogout;
	}
	private JLabel getLblCustname() {
		if (lblCustname == null) {
			lblCustname = new JLabel("");
			lblCustname.setText("<"+ sayMyname() + ">" + " 님");
			lblCustname.setFont(new Font("굴림", Font.BOLD, 13));
			lblCustname.setBounds(381, 6, 121, 23);
		}
		return lblCustname;
	}
	
	private String sayMyname() {
		Daomain dao = new Daomain(LoginPage.id);
		Dtocust dto = dao.myName(); 
//		lblCustname.setText(dto );
		
		return dto.getCname();
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("SHOES SHOP ★");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 19));
			lblNewLabel.setBounds(12, 24, 216, 23);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("<List>");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 19));
			lblNewLabel_1.setBounds(12, 57, 216, 23);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnOrderList() {
		if (btnOrderList == null) {
			btnOrderList = new JButton("OrderList");
			btnOrderList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				OrderList list = new OrderList();
				list.setVisible(true);
				frmMainpage.setVisible(false);
				}
			});
			btnOrderList.setFont(new Font("Dialog", Font.BOLD, 12));
			btnOrderList.setBounds(287, 35, 92, 23);
		}
		return btnOrderList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end
