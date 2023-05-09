package pj2.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class StoreFrame {
	JInternalFrame storeFrame;
	JComboBox<String> storeCb;
	JTextField selcStoreTf;
	JTable jtable;
	JButton previousBt1, nextBt1;
	Color white = new Color(255, 255,255);
	Color black = new Color(0, 0,0);
	Color dGreen = new Color(0,153, 51);
	
	DefaultTableModel dftmodel = new DefaultTableModel();
	Vector<String> columnNames;

	MainGUI mg;

	StoreFrame(MainGUI mg) {
		this.mg = mg;
	}
	// 매장선택 내부JFrame
	public void setIFrameForStore() {
		storeFrame = new JInternalFrame();
		storeFrame.setResizable(false);
		storeFrame.setVisible(false);
		storeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		storeFrame.setBackground(new Color(0, 0, 0, 0));
		storeFrame.setLayout(null);
		storeFrame.setBorder(null);
		// storeFrameBG.setBounds(0, 0, WIDTH, HEIGHT);
		storeFrame.setClosable(true);
		storeFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);

		JLabel storeLb = new JLabel(" 가맹점 선택 ");
		storeLb.setOpaque(true);
		storeLb.setFont(new Font(null, Font.BOLD, 14));
		storeLb.setBackground(new Color(255, 255, 255));
		storeLb.setForeground(new Color(0, 102, 51));
		storeLb.setHorizontalAlignment(JLabel.CENTER);
		storeLb.setBounds(60, 50, 280, 30);
		String[] strs = { "전체", "서울", "인천", "대전", "대구", "울산", "부산", "경기도", "강원도", "충청북도", "충청남도", "경상북도", "경상남도",
				"전라북도", "전라남도", "제주도" };
		storeCb = new JComboBox<String>(strs);
		storeCb.setBounds(60, 80, 100, 30);
		storeCb.addActionListener(mg);
		selcStoreTf = new JTextField(20);
		selcStoreTf.setBorder(null);
		selcStoreTf.setBounds(160, 80, 180, 30);
		selcStoreTf.requestFocus();
		selcStoreTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String str = selcStoreTf.getText();
				if(str != null) str = str.trim();
				if(str.length() != 0) {
					str = str.trim();
					Vector<Vector<String>> reRowData = mg.d.selectFaddr(str);
					System.out.println("keyEvent: " +reRowData);
					dftmodel.setDataVector(reRowData, columnNames);
				}
			}
		});
		initJtable();

		jtable = new JTable(dftmodel);
		jtable.setShowGrid(false);
		jtable.getTableHeader().setReorderingAllowed(false);
		jtable.setBackground(new Color(255, 255, 204));
		jtable.setGridColor(new Color(255, 153, 102));
		jtable.setSelectionBackground(new Color(0, 153, 51));
		jtable.setSelectionForeground(new Color(255, 255, 255));
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = jtable.getSelectedRow();
				int j = jtable.getSelectedColumn();
				String str1 = (String) jtable.getValueAt(i, 0);
				String str2 = (String) jtable.getValueAt(i, 1);
				String str3 = (String) jtable.getValueAt(i, 2);
				selcStoreTf.setText(str1);
				mg.ord.storeNameInOrderFrame.setText("매장이름: " + str1);
				mg.ord.storeAddrInOrderFrame.setText("주소: " + str2);
				mg.ord.storePhoneInOrderFrame.setText("전화번호: " + str3);
				jtable.setToolTipText("<HTML>가맹점명: " + str1 + "<br>주소: " + str2 + "<br>매장연락처: " + str3 + "</html>");
				jtable.setSelectionBackground(new Color(0, 153, 51));
				jtable.setSelectionForeground(new Color(255, 255, 255));
			}
		});
		JScrollPane jsp = new JScrollPane(jtable);
		jsp.setBorder(new LineBorder(new Color(255, 153, 102), 1, true));
		jsp.setBounds(15, 160, 370, 300);
		nextBt1 = new JButton(" 다음 ");
		nextBt1.setBorderPainted(false);
		nextBt1.setBackground(dGreen);
		nextBt1.setForeground(white);
		nextBt1.setFocusPainted(false);
		nextBt1.addActionListener(mg);
		nextBt1.setBounds(5, 520, 390, 52);
		JLabel buttomBG = new JLabel(new ImageIcon("/img/label_background.png"));
		buttomBG.setBounds(0, 515, 400, 80);
		storeFrame.add(storeLb);
		storeFrame.add(storeCb);
		storeFrame.add(selcStoreTf);
		storeFrame.add(background);
		storeFrame.add(nextBt1);
		storeFrame.add(jsp);
		storeFrame.add(buttomBG);
		mg.add(storeFrame);
	}

	void initJtable() {
		columnNames = mg.d.getStoreColumnName();
		Vector<Vector<String>> rowData = mg.d.getStoreRowData();
		dftmodel.setDataVector(rowData, columnNames);
	
	}
	void pln(String str) {
		System.out.println(str);
	}
}
