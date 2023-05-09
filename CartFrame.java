package pj2.customer;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedHashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CartFrame{
	JInternalFrame cartFrame = new JInternalFrame();
	JPanel mybasketPanel;
	JButton  payBtInMyBasket, exitMyBasket;
	Color dBrown = new Color(51,0,0);
	Color white = new Color(255,255,255);
	MainGUI mg;
	boolean isCart = false;
	CartFrame(MainGUI mg) {
		this.mg=mg;
	}

	// 장바구니 내부JFrame
	public void setIFrameForCart() {
		cartFrame.setResizable(false);
		cartFrame.setVisible(false);
		cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cartFrame.setBackground(new Color(0, 0, 0, 0));
		cartFrame.setLayout(null);
		cartFrame.setBorder(null);
		cartFrame.setClosable(true);
		cartFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel basketUpperBg = new JLabel(new ImageIcon(getClass().getResource("/img/basketUpperBg.jpg")));
		basketUpperBg.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		mybasketPanel = new JPanel();
		mybasketPanel.setBounds(0, 120, 400, 390);
		mybasketPanel.setBackground(new Color(255, 255, 255));
		mybasketPanel.setLayout(new GridLayout(0, 1));
		JScrollPane mmSP = new JScrollPane(mybasketPanel);
		mmSP.getVerticalScrollBar().setUnitIncrement(10);
		mmSP.setBounds(0, 120, 400, 390);
		mmSP.setBorder(null);

		exitMyBasket = new JButton("닫기");
		exitMyBasket.setBorderPainted(false);
		exitMyBasket.setBackground(dBrown);
		exitMyBasket.setForeground(white);	
		exitMyBasket.setFocusPainted(false);
		exitMyBasket.addActionListener(mg);
		payBtInMyBasket = new JButton("결제하기");
		payBtInMyBasket.setBorderPainted(false);
		payBtInMyBasket.setBackground(dBrown);
		payBtInMyBasket.setForeground(white);	
		payBtInMyBasket.setFocusPainted(false);
		payBtInMyBasket.addActionListener(mg);
		exitMyBasket.setBounds(5, 520, 195, 52);
		payBtInMyBasket.setBounds(200, 520, 195, 52);

		cartFrame.add(basketUpperBg);
		cartFrame.add(mmSP);
		cartFrame.add(exitMyBasket);
		cartFrame.add(payBtInMyBasket);
		mg.add(cartFrame);
	}

	void insertDataIntoCart() {
		long fcode = mg.d.getFCodeFromFranchise(mg.sf.selcStoreTf.getText().trim());
		String email = mg.mif.myinfoList.get(1);
		int menucode = mg.d.getMCodeFromMenu(mg.ord.ordered_mname_lb.getText().trim());
		String bread = mg.ord.ordered_bname_tf.getText().trim();
		String cheese = mg.ord.ordered_cname_tf.getText().trim();
		String vege = mg.ord.ordered_vname_ta.getText().trim();
		String sauce = mg.ord.ordered_sname_ta.getText().trim();
		int setcode = mg.d.getSCodeFromSet(mg.ord.ordered_smname_tf.getText().trim());
		int quantity = Integer.parseInt(mg.ord.count_lb.getText());
		long amount = Long.parseLong(mg.ord.amount_lb.getText());
		//int count = mg.d.countCartNo(email);
		String seqID = email.substring(0, email.indexOf("@")).trim();
		boolean isSeqName = mg.d.checkSeqName(seqID); 	
		boolean flag2 = mg.d.insertDataIntoCart(fcode, email, menucode, bread, cheese, vege, sauce, setcode, quantity,
					amount, seqID);
		if (flag2) {
			JOptionPane.showMessageDialog(null, "선택한 항목들이 장바구니에 담겼습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "시스템 오류로 담기 실패했습니다.");
		}	
	}
	
	//장바구니에 뜬 여러 목록 중 하나 선택해서 결제하는 하고 
	//결제된 것은 삭제 되는 것 구현 못함
	LinkedHashMap<Integer, Vector<String>>  rowDataInCart_m;
	Vector<String> v1;
	//int cartno;
	public void moveDfromCtoP(int k) {
		int keyCode=0;
		String email = mg.mif.emailLb_myinfo.getText();
		//buttonscontrol의 LinkedHahMap
		for(int key: mg.bc.rowDataInCart_map.keySet()) { 
			pln("key: " + key);
			if(key==k) {
				keyCode=k;
				pln("keyCode:" + keyCode);
				break;
			}
		}		
		pln("k: " + k);
		if(keyCode==k) {	
			rowDataInCart_m = mg.d.getAllinCart(email, k);
			v1 = rowDataInCart_m.get(k);
			pln("v1: " + v1);
			String fname = v1.get(0);
			String mname = v1.get(1);
			String bname = v1.get(2);
			String cname = v1.get(3);
			String vname = v1.get(4);
			String sname = v1.get(5);
			String smname = v1.get(6);
			String quantity = v1.get(7);
			String amount = v1.get(8);
			mg.ord.summary_storename_display.setText(fname);
			mg.ord.summary_mname_display.setText(mname);
			mg.ord.summary_bname_display.setText(bname);
			mg.ord.summary_cname_display.setText(cname);
			mg.ord.summary_vname_display.setText(vname);
			mg.ord.summary_sname_display.setText(sname);
			mg.ord.summary_smname_display.setText(smname);
			mg.ord.summary_quantity_display.setText(quantity);
			mg.ord.summary_amount_display.setText(amount);
			mg.ord.currMilg_Lb.setText(mg.mif.myinfoList.get(4));
			isCart = true;
		} else {
			isCart =false;
		}
		
	}
	public void deleteDinCart(int cartno) {
		//this.cartno=cartno;
		String email = mg.mif.emailLb_myinfo.getText();
		for(int key: rowDataInCart_m.keySet()) {
			if(cartno==key) {
				pln("deleteDinCart():" + cartno);
				boolean flag = mg.d.deleteDataFromCart(email, cartno);
				pln("cart/deleteDinCart(): " + flag);
				if(flag) {
					JOptionPane.showMessageDialog(null, "장바구니의 상품이 자동 삭제 되었습니다.");
					return;
				}
			}
		}
		for(int i=0; i<v1.size();i++) {
			v1.remove(i);
		}
	}
	public void purgeCartDataVector() {
		//boolean f = rowDataInCart_v.isEmpty();
		//pln("cart/purgeCartDataVector: + " + f);
	}
	
	void pln(String str) {
		System.out.println(str);
	}
}
