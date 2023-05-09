package pj2.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrderFrame {

	JLabel ordered_mname_lb, ordered_smname_tf;
	JTextField ordered_bname_tf, ordered_cname_tf;
	JTextArea ordered_sname_ta, ordered_vname_ta;
	JLabel storeNameInOrderFrame, storeAddrInOrderFrame, storePhoneInOrderFrame;
	JLabel amount_lb, count_lb; // 주문시 가격 + 수량
	JButton plusBt, minusBt;
	JButton basketBtInFrame, cancelBtInFrame, orderBtInFrame;
	JButton usingmilgBt;
	JLabel paylabel, currMilg_titleLb, currMilg_Lb;
	JTextField payTf, useMilgTf;
	JPanel payPanel;
	JScrollPane summarySp;
	JLabel title_bar_lb1, ordered_mtitle_lb, ordered_btitle_lb, ordered_ctitle_lb, ordered_vtitle_lb, ordered_stitle_lb,
			ordered_smtitle_lb, storeName, amount_title_lb, count_lb1, buttomBG;
	JScrollPane jsp1, jsp2;
	JComboBox<String> paywayCb;

	JPanel summaryPn;
	JLabel summary_storename_lb, summary_storename_display;
	JLabel summary_mname_lb, summary_mname_display;
	JLabel summary_bname_lb, summary_bname_display;
	JLabel summary_cname_lb, summary_cname_display;
	JLabel summary_vname_lb, summary_vname_display;
	JLabel summary_sname_lb, summary_sname_display;
	JLabel summary_smname_lb, summary_smname_display;
	JLabel summary_quantity_lb, summary_quantity_display;
	JLabel summary_amount_lb, summary_amount_display;
	JButton payBt;
	JLabel selected_payway;// 숨은 레이블
	Color c1 = new Color(153, 102, 204);
	Color c2 = new Color(102, 0, 153);
	Color dBrown = new Color(51, 0, 0);
	Color white = new Color(255, 255, 255);
	Color black = new Color(0, 0, 0);
	Color dGreen = new Color(0, 153, 51);

	JInternalFrame orderFrame = new JInternalFrame();
	long initCost; // 금액 증감을 위한 초기값 변서
	int count = 1;
	double milgRate = 0.05;
	MainGUI mg;

	public OrderFrame(MainGUI mg) {
		this.mg = mg;
	}

	public void setIFrameForOrder() {
		payComponents();

		// 주문정보 및 결제 내부JFrame
		orderFrame.setResizable(false);
		orderFrame.setVisible(false);
		orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		orderFrame.setBackground(new Color(0, 0, 0, 0));
		orderFrame.setLayout(null);
		orderFrame.setBorder(null);
		orderFrame.setClosable(true);
		orderFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		title_bar_lb1 = new JLabel(new ImageIcon(getClass().getResource("/img/ordermenubar2.png")));
		ordered_mtitle_lb = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_menu_title_bar.png")));

		ordered_mtitle_lb.setHorizontalAlignment(JLabel.LEFT);
		ordered_mname_lb = new JLabel();
		ordered_mname_lb.setOpaque(true);
		ordered_mname_lb.setBackground(white);
		ordered_mname_lb.setForeground(black);
		ordered_mname_lb.setFont(new Font(null, Font.BOLD, 16));
		ordered_btitle_lb = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_bread_title_bar.png")));

		ordered_btitle_lb.setHorizontalAlignment(JLabel.LEFT);
		ordered_bname_tf = new JTextField();
		ordered_bname_tf.setBackground(white);
		ordered_bname_tf.setForeground(black);
		ordered_bname_tf.setFont(new Font(null, Font.BOLD, 16));
		ordered_bname_tf.setBorder(null);
		ordered_bname_tf.setEditable(false);

		ordered_ctitle_lb = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_cheese_title_bar.png")));
		ordered_ctitle_lb.setHorizontalAlignment(JLabel.LEFT);
		ordered_cname_tf = new JTextField();
		ordered_cname_tf.setBackground(white);
		ordered_cname_tf.setForeground(black);
		ordered_cname_tf.setFont(new Font(null, Font.BOLD, 16));
		ordered_cname_tf.setBorder(null);
		ordered_cname_tf.setEditable(false);

		ordered_vtitle_lb = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_vege_title_bar.png")));
		ordered_vtitle_lb.setHorizontalAlignment(JLabel.LEFT);
		ordered_vname_ta = new JTextArea();
		ordered_vname_ta.setFont(new Font(null, Font.BOLD, 16));
		ordered_vname_ta.setEditable(false);

		ordered_stitle_lb = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_sauce_title_bar.png")));
		ordered_stitle_lb.setHorizontalAlignment(JLabel.LEFT);
		ordered_sname_ta = new JTextArea();

		ordered_sname_ta.setFont(new Font(null, Font.BOLD, 16));
		ordered_sname_ta.setEditable(false);
		ordered_smtitle_lb = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_set_title_bar.png")));
		ordered_smtitle_lb.setHorizontalAlignment(JLabel.LEFT);
		ordered_smname_tf = new JLabel();
		ordered_smname_tf.setOpaque(true);
		ordered_smname_tf.setBackground(white);
		ordered_smname_tf.setForeground(black);
		ordered_smname_tf.setFont(new Font(null, Font.BOLD, 16));

		ordered_mname_lb.setBackground(new Color(255, 255, 255));
		ordered_bname_tf.setBackground(new Color(255, 255, 255));
		ordered_cname_tf.setBackground(new Color(255, 255, 255));
		ordered_vname_ta.setBackground(new Color(255, 255, 255));
		ordered_sname_ta.setBackground(new Color(255, 255, 255));
		ordered_smname_tf.setBackground(new Color(255, 255, 255));

		storeName = new JLabel(new ImageIcon(getClass().getResource("/img/ordered_store_title_bar.png")));
		storeName.setHorizontalAlignment(JLabel.LEFT);
		storeNameInOrderFrame = new JLabel();
		storeNameInOrderFrame.setOpaque(true);
		storeNameInOrderFrame.setBackground(white);
		storeNameInOrderFrame.setForeground(black);
		storeNameInOrderFrame.setBackground(new Color(255, 255, 255));
		storeNameInOrderFrame.setHorizontalAlignment(JLabel.LEFT);
		storeAddrInOrderFrame = new JLabel();
		storeAddrInOrderFrame.setOpaque(true);
		storeAddrInOrderFrame.setBackground(new Color(255, 255, 255));
		storeAddrInOrderFrame.setHorizontalAlignment(JLabel.LEFT);
		storePhoneInOrderFrame = new JLabel();
		storePhoneInOrderFrame.setOpaque(true);
		storePhoneInOrderFrame.setBackground(new Color(255, 255, 255));
		storePhoneInOrderFrame.setHorizontalAlignment(JLabel.LEFT);
		title_bar_lb1.setBounds(50, 50, 200, 30);
		storeName.setBounds(50, 100, 150, 30);
		storeNameInOrderFrame.setBounds(50, 130, 150, 30);
		ordered_mtitle_lb.setBounds(50, 160, 150, 30);
		ordered_mname_lb.setBounds(50, 190, 150, 30);
		ordered_smtitle_lb.setBounds(215, 160, 150, 30);
		ordered_smname_tf.setBounds(215, 190, 150, 30);
		ordered_btitle_lb.setBounds(50, 220, 150, 30);
		ordered_bname_tf.setBounds(50, 250, 150, 30);
		ordered_ctitle_lb.setBounds(215, 220, 150, 30);
		ordered_cname_tf.setBounds(215, 250, 150, 30);
		ordered_vtitle_lb.setBounds(50, 280, 150, 30);
		jsp1 = new JScrollPane(ordered_vname_ta);
		jsp1.setBounds(50, 310, 300, 50);
		ordered_stitle_lb.setBounds(50, 360, 150, 30);
		jsp2 = new JScrollPane(ordered_sname_ta);
		jsp2.setBounds(50, 390, 300, 50);
		amount_title_lb = new JLabel("총 주문 금액");
		amount_title_lb.setOpaque(true);
		amount_title_lb.setFont(new Font(null, Font.BOLD, 12));
		amount_title_lb.setBackground(new Color(255, 255, 255));
		amount_title_lb.setHorizontalAlignment(JLabel.LEFT);
		amount_lb = new JLabel();
		amount_lb.setOpaque(true);
		amount_lb.setFont(new Font(null, Font.BOLD, 16));
		amount_lb.setBackground(new Color(255, 255, 255));
		amount_lb.setForeground(new Color(0, 153, 51));
		amount_lb.setHorizontalAlignment(JLabel.RIGHT);

		count_lb1 = new JLabel("수량");
		count_lb1.setOpaque(true);
		count_lb1.setBackground(new Color(255, 255, 255));
		count_lb1.setHorizontalAlignment(JLabel.LEFT);
		count_lb = new JLabel("" + count);
		count_lb.setHorizontalAlignment(JLabel.CENTER);
		// count_lb.setFont(new Font(null, Font.BOLD, 13));
		plusBt = new JButton(new ImageIcon(getClass().getResource("/img/plus.png")));
		plusBt.setBorderPainted(false);
		plusBt.setContentAreaFilled(false);
		plusBt.setFocusPainted(false);
		plusBt.addActionListener(mg);
		minusBt = new JButton(new ImageIcon(getClass().getResource("/img/minus.png")));
		minusBt.setBorderPainted(false);
		minusBt.setContentAreaFilled(false);
		minusBt.setFocusPainted(false);
		minusBt.addActionListener(mg);
		amount_title_lb.setBounds(50, 442, 150, 30);
		amount_lb.setBounds(245, 442, 100, 30);
		count_lb1.setBounds(50, 474, 150, 30);
		minusBt.setBounds(260, 474, 30, 30);
		count_lb.setBounds(290, 474, 30, 30);
		plusBt.setBounds(320, 474, 30, 30);
		cancelBtInFrame = new JButton(" 취소 ");
		cancelBtInFrame.setBorderPainted(false);
		cancelBtInFrame.setBackground(dGreen);
		cancelBtInFrame.setForeground(white);
		cancelBtInFrame.setFocusPainted(false);
		cancelBtInFrame.addActionListener(mg);

		basketBtInFrame = new JButton(" 담기 ");
		basketBtInFrame.setBorderPainted(false);
		basketBtInFrame.setBackground(dGreen);
		basketBtInFrame.setForeground(white);
		;
		basketBtInFrame.setFocusPainted(false);
		basketBtInFrame.addActionListener(mg);

		orderBtInFrame = new JButton(" 주문 ");
		orderBtInFrame.setBorderPainted(false);
		orderBtInFrame.setBackground(dGreen);
		orderBtInFrame.setForeground(white);
		;
		orderBtInFrame.addActionListener(mg);

		cancelBtInFrame.setBounds(5, 520, 130, 52);
		basketBtInFrame.setBounds(135, 520, 130, 52);
		orderBtInFrame.setBounds(265, 520, 130, 52);
		buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);

		orderFrame.add(title_bar_lb1);
		orderFrame.add(storeName);
		orderFrame.add(storeNameInOrderFrame);
		orderFrame.add(ordered_mtitle_lb);
		orderFrame.add(ordered_mname_lb);
		orderFrame.add(ordered_btitle_lb);
		orderFrame.add(ordered_bname_tf);
		orderFrame.add(ordered_ctitle_lb);
		orderFrame.add(ordered_cname_tf);
		orderFrame.add(ordered_vtitle_lb);
		orderFrame.add(jsp1);
		orderFrame.add(ordered_stitle_lb);
		orderFrame.add(jsp2);
		orderFrame.add(ordered_smtitle_lb);
		orderFrame.add(ordered_smname_tf);
		orderFrame.add(amount_title_lb);
		orderFrame.add(amount_lb);
		orderFrame.add(count_lb1);
		orderFrame.add(minusBt);
		orderFrame.add(count_lb);
		orderFrame.add(plusBt);
		orderFrame.add(basketBtInFrame);
		orderFrame.add(orderBtInFrame);
		orderFrame.add(cancelBtInFrame);
		orderFrame.add(buttomBG);

		orderFrame.add(summaryPn);
		orderFrame.add(payPanel);
		orderFrame.add(payBt);
		mg.add(orderFrame);
	}

	final long initSMcost = 2000;
	long smCost = 2000;

	public void minusAmount() {
		long totalCost = Long.parseLong(amount_lb.getText());
		long minus = totalCost - initCost; // 금액감소
		amount_lb.setText("" + minus);
	}

	public void plusAmount() {
		long totalCost = Long.parseLong(amount_lb.getText());
		long plus = totalCost + initCost; // 금액증가
		amount_lb.setText("" + plus);
	}

	public void payComponents() {
		summary_storename_lb = new JLabel("매장");
		summary_storename_lb.setOpaque(true);
		summary_storename_lb.setBackground(white);
		summary_storename_lb.setForeground(black);
		summary_storename_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_storename_display = new JLabel();
		summary_storename_display.setOpaque(true);
		summary_storename_display.setBackground(white);
		summary_storename_display.setForeground(black);
		summary_storename_display.setHorizontalAlignment(JLabel.CENTER);
		summary_mname_lb = new JLabel("메인메뉴");
		summary_mname_lb.setOpaque(true);
		summary_mname_lb.setBackground(white);
		summary_mname_lb.setForeground(black);
		summary_mname_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_mname_display = new JLabel();
		summary_mname_display.setOpaque(true);
		summary_mname_display.setBackground(white);
		summary_mname_display.setForeground(black);
		summary_mname_display.setHorizontalAlignment(JLabel.CENTER);

		summary_bname_lb = new JLabel("빵");
		summary_bname_lb.setOpaque(true);
		summary_bname_lb.setBackground(white);
		summary_bname_lb.setForeground(black);
		summary_bname_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_bname_display = new JLabel();
		summary_bname_display.setOpaque(true);
		summary_bname_display.setBackground(white);
		summary_bname_display.setForeground(black);
		summary_bname_display.setHorizontalAlignment(JLabel.CENTER);

		summary_cname_lb = new JLabel("치즈");
		summary_cname_lb.setOpaque(true);
		summary_cname_lb.setBackground(white);
		summary_cname_lb.setForeground(black);
		summary_cname_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_cname_display = new JLabel();
		summary_cname_display.setOpaque(true);
		summary_cname_display.setBackground(white);
		summary_cname_display.setForeground(black);
		summary_cname_display.setHorizontalAlignment(JLabel.CENTER);

		summary_vname_lb = new JLabel("야채");
		summary_vname_lb.setOpaque(true);
		summary_vname_lb.setBackground(white);
		summary_vname_lb.setForeground(black);
		summary_vname_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_vname_display = new JLabel();
		summary_vname_display.setOpaque(true);
		summary_vname_display.setBackground(white);
		summary_vname_display.setForeground(black);
		summary_vname_display.setHorizontalAlignment(JLabel.CENTER);

		summary_sname_lb = new JLabel("시즈닝");
		summary_sname_lb.setOpaque(true);
		summary_sname_lb.setBackground(white);
		summary_sname_lb.setForeground(black);
		summary_sname_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_sname_display = new JLabel();
		summary_sname_display.setOpaque(true);
		summary_sname_display.setBackground(white);
		summary_sname_display.setForeground(black);
		summary_sname_display.setHorizontalAlignment(JLabel.CENTER);

		summary_smname_lb = new JLabel("세트");
		summary_smname_lb.setOpaque(true);
		summary_smname_lb.setBackground(white);
		summary_smname_lb.setForeground(black);
		summary_smname_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_smname_display = new JLabel();
		summary_smname_display.setOpaque(true);
		summary_smname_display.setBackground(white);
		summary_smname_display.setForeground(black);
		summary_smname_display.setHorizontalAlignment(JLabel.CENTER);

		summary_quantity_lb = new JLabel("수량");
		summary_quantity_lb.setOpaque(true);
		summary_quantity_lb.setBackground(white);
		summary_quantity_lb.setForeground(black);
		summary_quantity_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_quantity_display = new JLabel();
		summary_quantity_display.setOpaque(true);
		summary_quantity_display.setBackground(white);
		summary_quantity_display.setForeground(black);
		summary_quantity_display.setHorizontalAlignment(JLabel.CENTER);

		summary_amount_lb = new JLabel("가격");
		summary_amount_lb.setOpaque(true);
		summary_amount_lb.setBackground(white);
		summary_amount_lb.setForeground(black);
		summary_amount_lb.setHorizontalAlignment(JLabel.CENTER);
		summary_amount_display = new JLabel();
		summary_amount_display.setOpaque(true);
		summary_amount_display.setBackground(white);
		summary_amount_display.setForeground(black);
		summary_amount_display.setHorizontalAlignment(JLabel.CENTER);
		selected_payway = new JLabel();
		selected_payway.setVisible(false);
		summary_storename_lb.setBounds(10, 5, 50, 20);
		summary_storename_display.setBounds(75, 5, 175, 20);
		summary_mname_lb.setBounds(10, 35, 50, 20);
		summary_mname_display.setBounds(75, 35, 175, 20);
		summary_bname_lb.setBounds(10, 65, 50, 20);
		summary_bname_display.setBounds(75, 65, 175, 20);
		summary_cname_lb.setBounds(10, 95, 50, 20);
		summary_cname_display.setBounds(75, 95, 175, 20);
		summary_vname_lb.setBounds(10, 125, 50, 20);
		summary_vname_display.setBounds(75, 125, 175, 20);
		summary_sname_lb.setBounds(10, 155, 50, 20);
		summary_sname_display.setBounds(75, 155, 175, 20);
		summary_smname_lb.setBounds(10, 185, 50, 20);
		summary_smname_display.setBounds(75, 185, 175, 20);
		summary_quantity_lb.setBounds(10, 215, 50, 20);
		summary_quantity_display.setBounds(75, 215, 175, 20);
		summary_amount_lb.setBounds(10, 245, 50, 20);
		summary_amount_display.setBounds(75, 245, 175, 20);
		summaryPn = new JPanel();
		summaryPn.setLayout(new BorderLayout());
		summaryPn.setBounds(75, 60, 260, 270);
		summaryPn.add(summary_storename_lb);
		summaryPn.add(summary_storename_display);
		summaryPn.add(summary_mname_lb);
		summaryPn.add(summary_mname_display);
		summaryPn.add(summary_bname_lb);
		summaryPn.add(summary_bname_display);
		summaryPn.add(summary_cname_lb);
		summaryPn.add(summary_cname_display);
		summaryPn.add(summary_vname_lb);
		summaryPn.add(summary_vname_display);
		summaryPn.add(summary_sname_lb);
		summaryPn.add(summary_sname_display);
		summaryPn.add(summary_smname_lb);
		summaryPn.add(summary_smname_display);
		summaryPn.add(summary_quantity_lb);
		summaryPn.add(summary_quantity_display);
		summaryPn.add(summary_amount_lb);
		summaryPn.add(summary_amount_display);
		summaryPn.add(selected_payway);

		payPanel = new JPanel();
		payPanel.setBounds(75, 340, 260, 150);
		payPanel.setLayout(new GridLayout(0, 1));
		// payPanel.setBackground(Color.white);
		paylabel = new JLabel("[ 결제방법 선택 ]");
		paylabel.setOpaque(true);
		paylabel.setBackground(c1);
		paylabel.setForeground(Color.WHITE);
		paylabel.setHorizontalAlignment(JLabel.CENTER);
		currMilg_titleLb = new JLabel("[ 현재 마일리지 ](입력 후 엔터)");
		currMilg_titleLb.setOpaque(true);
		currMilg_titleLb.setBackground(c2);
		currMilg_titleLb.setForeground(Color.WHITE);
		currMilg_titleLb.setHorizontalAlignment(JLabel.CENTER);
		currMilg_Lb = new JLabel();
		currMilg_Lb.setOpaque(true);
		currMilg_Lb.setBackground(Color.WHITE);
		currMilg_Lb.setForeground(Color.BLACK);
		currMilg_Lb.setHorizontalAlignment(JLabel.RIGHT);
		payTf = new JTextField();
		useMilgTf = new JTextField();
		useMilgTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					chgMilgStrToLong();
					useMilg();
				} else {
					usedMilg = 0;
				}
			}
		});
		String[] strs = { "신용/체크카드", "실시간계좌출금", "카카오페이", "네이버페이" };
		paywayCb = new JComboBox<String>(strs);
		paywayCb.setBackground(Color.white);
		paywayCb.addActionListener(mg);
		// paylabel.setBounds(110, 150, 40, 20);
		// payTf.setBounds(40, 190, 100, 20);
		// paywayCb.setBounds(40, 240, 100, 20);
		payPanel.add(paylabel);
		payPanel.add(paywayCb);
		payPanel.add(currMilg_titleLb);
		payPanel.add(currMilg_Lb);
		payPanel.add(useMilgTf);

		payBt = new JButton("결제하기");
		payBt.setBounds(100, 510, 200, 60);
		payBt.setBorderPainted(false);
		payBt.setBackground(dGreen);
		payBt.setForeground(white);
		payBt.setFocusPainted(false);
		payBt.addActionListener(mg);
	}

	public int outputOfPaywayCb() {
		String payway = paywayCb.getSelectedItem().toString();
		if (payway.equals("신용/체크카드")) {
			return 1;
		} else if (payway.equals("실시간계좌출금")) {
			return 2;
		} else if (payway.equals("카카오페이")) {
			return 3;
		} else if (payway.equals("네이버페이")) {
			return 4;
		} else {
			return 0;
		}

	}

	public void setSummaryView() {
		summary_storename_display.setText(storeNameInOrderFrame.getText());
		summary_mname_display.setText(ordered_mname_lb.getText());
		summary_bname_display.setText(ordered_bname_tf.getText());
		summary_cname_display.setText(ordered_cname_tf.getText());
		summary_vname_display.setText(ordered_vname_ta.getText());
		summary_sname_display.setText(ordered_sname_ta.getText());
		summary_smname_display.setText(ordered_smname_tf.getText());
		summary_quantity_display.setText(count_lb.getText());
		summary_amount_display.setText(amount_lb.getText());
		currMilg_Lb.setText(mg.mif.myinfoList.get(4));
	}

	public void insertDataIntoPaylog() {
		try {
			long fcode = mg.d.getFCodeFromFranchise(mg.sf.selcStoreTf.getText().trim());
			String email = mg.mif.myinfoList.get(1);
			int menucode = mg.d.getMCodeFromMenu(ordered_mname_lb.getText().trim());
			String bread = ordered_bname_tf.getText().trim();
			String cheese = ordered_cname_tf.getText().trim();
			String vege = ordered_vname_ta.getText().trim();
			String sauce = ordered_sname_ta.getText().trim();
			int setcode = mg.d.getSCodeFromSet(ordered_smname_tf.getText().trim());
			int quantity = Integer.parseInt(count_lb.getText());
			long amount = Long.parseLong(summary_amount_display.getText());
			int pcode = outputOfPaywayCb();
			boolean flag = mg.d.insertDintoPaylog(fcode, email, menucode, bread, cheese, vege, sauce, setcode, quantity,
					amount, pcode);
			if (flag) {
				JOptionPane.showMessageDialog(null, "결제를 완료했습니다.");
				updateMyMilg();
			} else {
				JOptionPane.showMessageDialog(null, "결제를 실패했습니다.");
			}
		} catch (NumberFormatException ne) {
			pln("insertDataIntoPaylog(): " + ne);
		}
	}
	public void insertCDIntoPaylog() {
		try {
			long fcode = mg.d.getFCodeFromFranchise(summary_storename_display.getText().trim());
			String email = mg.mif.myinfoList.get(1);
			int menucode = mg.d.getMCodeFromMenu(summary_mname_display.getText().trim());
			String bread = summary_bname_display.getText().trim();
			String cheese = summary_cname_display.getText().trim();
			String vege = summary_vname_display.getText().trim();
			String sauce = summary_sname_display.getText().trim();
			int setcode = mg.d.getSCodeFromSet(summary_smname_display.getText().trim());
			int quantity = Integer.parseInt(summary_quantity_display.getText());
			long amount = Long.parseLong(summary_amount_display.getText());
			int pcode = outputOfPaywayCb();
			boolean flag = mg.d.insertDintoPaylog(fcode, email, menucode, bread, cheese, vege, sauce, setcode, quantity,
					amount, pcode);
			if (flag) {
				JOptionPane.showMessageDialog(null, "결제를 완료했습니다.");
				updateMyMilg();
			} else {
				JOptionPane.showMessageDialog(null, "결제를 실패했습니다.");
			}
		} catch (NumberFormatException ne) {
			pln("insertDataIntoPaylog(): " + ne);
		}
	}

	long usedMilg;
	String milgStr; 
	// 텍스트 필드에서 엔터 이벤트가 발생하면...
	void chgMilgStrToLong() {
		milgStr = useMilgTf.getText();
		pln(milgStr);
		try {
			usedMilg = Long.parseLong(milgStr); // long타입으로 변환
		} catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(null, "문자는 입력할 수 없습니다.");
		}
	}
	long amount;
	long currMilg;
	long modifiedMilg;
	long modifiedAmount;
	void useMilg() { // 최종가격에 마일리지 적용
		amount = Long.parseLong(amount_lb.getText());
		pln("useMilg(): "+amount);
		currMilg = Long.parseLong(mg.mif.myinfoList.get(4));// 현재 마일리지
		// 텍스트필드에 입력한 수를 받아옴
		if (milgStr != null) {
			milgStr = milgStr.trim();
		}
		if (milgStr.length() != 0) {
			if (usedMilg < 0) {
				JOptionPane.showMessageDialog(null, "음수는 입력할 수 없습니다.");
			} else {
				modifiedMilg = currMilg - usedMilg;
				if (modifiedMilg < 0) {
					JOptionPane.showMessageDialog(null, "입력한 마일리지 금액은\n상품 총 금액을 초과할 수 없습니다.");
				} else {
					// 기존 마일리지에서 사용한 만큼 차감
					currMilg_Lb.setText("" + modifiedMilg);
					modifiedAmount = amount - usedMilg;
					summary_amount_display.setText("" + modifiedAmount);
				}
			}
		} else {
			usedMilg = 0;
			amount += usedMilg;
			long l = currMilg - usedMilg;
			currMilg_Lb.setText("" + l);
			summary_amount_display.setText("" + amount);
			// 입력값이 없으면 0으로 세팅
		}
	}
	void updateMyMilg() { // 결제버튼 클릭 후 DB에 마일리지 업데이트
		String email = mg.mif.emailLb_myinfo.getText();
		// 텍스트필드에서 엔터이벤트가 발생하면 usedMilg = Long.parseLong(milgStr)/ milgStr = useMilgTf.getText();
	    if (usedMilg >=0) {
			boolean flag = mg.d.updateMinusMilg(email, usedMilg); //db에서 milg x원 차감	
			if (flag) { // db에서 마일리지 차감
				JOptionPane.showMessageDialog(null, "마일리지 " + usedMilg + "원이 차감되었습니다.");
			}
		} else {  //텍스트필드에서 엔터이벤트가 발생하지 않으면 milgStr는 null / usedMilg=0;
			mg.d.updateMinusMilg(email, usedMilg); //db에서 milg 0원 차감	
			try {
		 		long amount = Long.parseLong(summary_amount_display.getText());
				long modifiedMilg = (long) (amount * milgRate);
				if (mg.d.updatePlusMilg(email, modifiedMilg)) {
					JOptionPane.showMessageDialog(null, "마일리지가 적립되었습니다.");
				}
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "문자는 입력할 수 없습니다.");
			}
		}
	}
	void pln(String str) {
		System.out.println(str);
	}
}
