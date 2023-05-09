package pj2.customer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ButtonsControl extends JFrame implements ItemListener {

	MainGUI mg;
	// 메뉴 이미지
	ImageIcon ii01 = new ImageIcon((getClass().getResource("/img/01menu/menu01ex.png")));;
	ImageIcon ii02 = new ImageIcon((getClass().getResource("/img/01menu/menu02ex.png")));;
	ImageIcon ii03 = new ImageIcon((getClass().getResource("/img/01menu/menu03ex.png")));;
	ImageIcon ii04 = new ImageIcon((getClass().getResource("/img/01menu/menu04ex.png")));;
	ImageIcon ii05 = new ImageIcon((getClass().getResource("/img/01menu/menu05ex.png")));;
	ImageIcon ii06 = new ImageIcon((getClass().getResource("/img/01menu/menu06ex.png")));;
	ImageIcon ii07 = new ImageIcon((getClass().getResource("/img/01menu/menu07ex.png")));;
	ImageIcon ii08 = new ImageIcon((getClass().getResource("/img/01menu/menu08ex.png")));;
	ImageIcon ii09 = new ImageIcon((getClass().getResource("/img/01menu/menu09ex.png")));;
	ImageIcon ii0 = new ImageIcon((getClass().getResource("/img/01menu/menu10ex.png")));;
	// 빵
	ImageIcon b1 = new ImageIcon((getClass().getResource("/img/02bread/01WhiteBread.png")));;
	ImageIcon b2 = new ImageIcon((getClass().getResource("/img/02bread/02OreganoBread.png")));;
	ImageIcon b3 = new ImageIcon((getClass().getResource("/img/02bread/03WitBread.png")));;
	ImageIcon b4 = new ImageIcon((getClass().getResource("/img/02bread/04HoneyOat.png")));;
	ImageIcon b5 = new ImageIcon((getClass().getResource("/img/02bread/05FlatBread.png")));;
	// 치즈
	ImageIcon c1 = new ImageIcon((getClass().getResource("/img/03cheese/01americancheese.png")));;
	ImageIcon c2 = new ImageIcon((getClass().getResource("/img/03cheese/02threadcheese.png")));;
	ImageIcon c3 = new ImageIcon((getClass().getResource("/img/03cheese/03mozzarella.png")));;
	// 채소
	ImageIcon v1 = new ImageIcon((getClass().getResource("/img/04vege/1_Lettuce.png")));;
	ImageIcon v2 = new ImageIcon((getClass().getResource("/img/04vege/2_Tomato.png")));;
	ImageIcon v3 = new ImageIcon((getClass().getResource("/img/04vege/3_Cucumber.png")));;
	ImageIcon v4 = new ImageIcon((getClass().getResource("/img/04vege/4_BellPepper.png")));;
	ImageIcon v5 = new ImageIcon((getClass().getResource("/img/04vege/5_Onion.png")));;
	ImageIcon v6 = new ImageIcon((getClass().getResource("/img/04vege/6_Pickles.png")));;
	ImageIcon v7 = new ImageIcon((getClass().getResource("/img/04vege/7_Jalapeno.png")));;
	// 소스
	ImageIcon s1 = new ImageIcon((getClass().getResource("/img/05sauce/1_SweetOnion.png")));;
	ImageIcon s2 = new ImageIcon((getClass().getResource("/img/05sauce/2_HoneyMustard.png")));;
	ImageIcon s3 = new ImageIcon((getClass().getResource("/img/05sauce/3_SweetChilli.png")));;
	ImageIcon s4 = new ImageIcon((getClass().getResource("/img/05sauce/4_SmokeBarbecue.png")));;
	ImageIcon s5 = new ImageIcon((getClass().getResource("/img/05sauce/5_Ranch.png")));;
	ImageIcon s6 = new ImageIcon((getClass().getResource("/img/05sauce/6_Mayonnaise.png")));;
	ImageIcon s7 = new ImageIcon((getClass().getResource("/img/05sauce/7_HotChili.png")));;

	// 세트
	ImageIcon set1 = new ImageIcon((getClass().getResource("/img/06setmenu/1_RasBerry.png")));;
	ImageIcon set2 = new ImageIcon((getClass().getResource("/img/06setmenu/2_DoubleChoco.png")));;
	ImageIcon set3 = new ImageIcon((getClass().getResource("/img/06setmenu/3_Chocochip.png")));;
	ImageIcon set4 = new ImageIcon((getClass().getResource("/img/06setmenu/4_Oatmeal.png")));;
	ImageIcon set5 = new ImageIcon((getClass().getResource("/img/06setmenu/5_WhiteChoco.png")));

	ButtonsControl(MainGUI mg) {
		this.mg = mg;
		addImgToArray();

	}

	ArrayList<ImageIcon> mImgList = new ArrayList<>();
	LinkedHashMap<String, ImageIcon> bImgList = new LinkedHashMap<>();
	LinkedHashMap<String, ImageIcon> cImgList = new LinkedHashMap<>();
	LinkedHashMap<String, ImageIcon> vImgList = new LinkedHashMap<>();
	LinkedHashMap<String, ImageIcon> sImgList = new LinkedHashMap<>();
	ArrayList<ImageIcon> smImgList = new ArrayList<>();
	public void addImgToArray() {
		mImgList.add(ii01);
		mImgList.add(ii02);
		mImgList.add(ii03);
		mImgList.add(ii04);
		mImgList.add(ii05);
		mImgList.add(ii06);
		mImgList.add(ii07);
		mImgList.add(ii08);
		mImgList.add(ii09);
		mImgList.add(ii0);
		//빵
		bImgList.put("화이트", b1);
		bImgList.put("파마산", b2);
		bImgList.put("위트", b3);
		bImgList.put("허니오트", b4);
		bImgList.put("플랫브레드", b5);
		//치즈
		cImgList.put("아메리칸 치즈", c1);
		cImgList.put("슈레드 치즈", c2);
		cImgList.put("모짜렐라 치즈", c3);
	
		//야채
		vImgList.put("양상추", v1);
		vImgList.put("토마토", v2);
		vImgList.put("오이", v3);
		vImgList.put("피망", v4);
		vImgList.put("양파", v5);
		vImgList.put("피클", v6);
		vImgList.put("할라피뇨", v7);
		//소스
		sImgList.put("스위트 어니언", s1);
		sImgList.put("허니 머스타드", s2);
		sImgList.put("스위트 칠리", s3);
		sImgList.put("스모크 바비큐", s4);
		sImgList.put("랜치", s5);
		sImgList.put("마요네즈", s6);
		sImgList.put("핫칠", s7);
		//세트
		smImgList.add(set1);
		smImgList.add(set2);
		smImgList.add(set3);
		smImgList.add(set4);
		smImgList.add(set5);

	}

	// 메뉴버튼
	Vector<JRadioButton> mRButtons = new Vector<>();
	Vector<JRadioButton> bRButtons = new Vector<>();
	Vector<JRadioButton> cRButtons = new Vector<>();
	Vector<JRadioButton> vRButtons = new Vector<>();
	Vector<JRadioButton> sRButtons = new Vector<>();
	Vector<JRadioButton> smRButtons = new Vector<>();

	public void addMBtoVector(Vector<String> mname, int count) {
		try {
			for (int i = 0; i < count; i++) {
				String str = mname.get(i);
				JRadioButton mbt = new JRadioButton(str, mImgList.get(i));
				mbt.setPreferredSize(new Dimension(320, 120));
				mbt.setHorizontalAlignment(SwingConstants.CENTER);
				mbt.setBackground(new Color(255, 255, 255));
				mbt.setBorderPainted(false);
				mbt.setFocusPainted(false);
				mRButtons.add(mbt);
			}
		} catch (NullPointerException ne) {
			pln("addMBtoVector: " + ne);
		}
	}
	public void addSMBtoVector(Vector<String> smname, int count) {
		try {		
			for (int i = 0; i <count-1; i++) {
				String str = smname.get(i);
				JRadioButton smbt = new JRadioButton(str, smImgList.get(i));
				smbt.setPreferredSize(new Dimension(320, 120));
				smbt.setHorizontalAlignment(SwingConstants.CENTER);
				smbt.setBackground(new Color(255, 255, 255));
				smbt.setBorderPainted(false);
				smbt.setFocusPainted(false);
				smRButtons.add(smbt);
			}
		} catch (NullPointerException ne) {
			pln("addMBtoVector: " + ne);
		}
	}
	public void addBtoVector() {
		for (String key : bImgList.keySet()) { // 빵
			JRadioButton bbt = new JRadioButton(key, bImgList.get(key));
			bbt.setPreferredSize(new Dimension(320, 120));
			bbt.setHorizontalAlignment(SwingConstants.CENTER);
			bbt.setBackground(new Color(255, 255, 255));
			bbt.setBorderPainted(false);
			//bbt.setContentAreaFilled(true);
			bbt.setFocusPainted(false);
			bRButtons.add(bbt);
		}
		for (String key : cImgList.keySet()) { // 치즈
			JRadioButton cbt = new JRadioButton(key, cImgList.get(key));
			cbt.setPreferredSize(new Dimension(380, 120));
			cbt.setHorizontalAlignment(SwingConstants.CENTER);
			cbt.setBackground(new Color(255, 255, 255));
			cbt.setBorderPainted(false);
			//cbt.setContentAreaFilled(true);
			cbt.setFocusPainted(false);
			cRButtons.add(cbt);
		}
		for (String key : vImgList.keySet()) { //야채버튼
			JRadioButton vcb = new JRadioButton(key, vImgList.get(key));
			vcb.setPreferredSize(new Dimension(320, 120));
			vcb.setHorizontalAlignment(SwingConstants.CENTER);
			vcb.setBackground(new Color(255, 255, 255));
			vcb.setBorderPainted(false);
			//vcb.setContentAreaFilled(true);
			vcb.setFocusPainted(false);
			vRButtons.add(vcb);
		}
		for (String key : sImgList.keySet()) { // 소스
			JRadioButton scb = new JRadioButton(key, sImgList.get(key));
			scb.setPreferredSize(new Dimension(150, 95));
			scb.setHorizontalAlignment(SwingConstants.LEFT);
			scb.setBackground(new Color(255, 255, 255));
			scb.setBorderPainted(false);
			//scb.setContentAreaFilled(true);
			scb.setFocusPainted(false);
			sRButtons.add(scb);
		}
	}

	ButtonGroup bg1 = new ButtonGroup();
	ButtonGroup bg2 = new ButtonGroup();
	ButtonGroup bg3 = new ButtonGroup();
	ButtonGroup bg4 = new ButtonGroup();
	JRadioButton bt1 = new JRadioButton(); // 메뉴 논리적버튼
	JRadioButton bt2 = new JRadioButton(); //빵 논리적 버튼
	JRadioButton bt3 = new JRadioButton(); //치즈 논리적 버튼
	JRadioButton bt4 = new JRadioButton(); // 세트메뉴 논리적버튼

	public void addBtoPanel() {
		int i = 0;
		bg1.add(bt1); // 버튼 그룹 내에서 다른 버튼들을 해제하기 위한 논리적 버튼
		for (JRadioButton jr : mRButtons) { // 메뉴
			bg1.add(mRButtons.get(i));
			mg.mef.menuPanel.add(mRButtons.get(i));
			i++;
		}
		bg2.add(bt2);
		int j = 0;
		for (JRadioButton jr : bRButtons) { // 빵
			bg2.add(bRButtons.get(j));
			mg.of.breadPanel.add(bRButtons.get(j));
			j++;
		}
		bg3.add(bt3);
		int k = 0;
		for (JRadioButton jr : cRButtons) { // 치즈
			bg3.add(cRButtons.get(k));
			mg.of.cheesePanel.add(cRButtons.get(k));
			k++;
		}
		int l = 0;
		for (JRadioButton jr : vRButtons) { // 채소
			mg.of.vegePanel.add(vRButtons.get(l));
			l++;
		}
		int m = 0;
		for (JRadioButton jr : sRButtons) { // 소스
			mg.of.saucePanel.add(sRButtons.get(m));
			m++;
		}
		bg4.add(bt4);
		int n = 0;
		for (JRadioButton jr : smRButtons) { // 세트메뉴
			bg4.add(smRButtons.get(n));
			mg.of.setmenuPanel.add(smRButtons.get(n));
			n++;
		}

	}
	//카트에 매장 이름, 메뉴명, 선택내용, 가격 수량 넣기...
	LinkedHashMap<Integer, Vector<String>> rowDataInCart_map;
	Vector<JRadioButton> cartButtons = new Vector<>();
	public void addCartInfoToMap() {
		mg.cart.mybasketPanel.removeAll();
		boolean flag = mg.d.isEmailinCart(mg.mif.myinfoList.get(1));
		if(flag) {
			rowDataInCart_map = mg.d.getCartInfo(mg.mif.myinfoList.get(1));
			pln("bc: " + rowDataInCart_map);
			for(int key:rowDataInCart_map.keySet()) {
				JRadioButton mycartRb  = new JRadioButton(rowDataInCart_map.get(key).toString());
				mycartRb.setBounds(50, 0, 300, 30);
				mycartRb.setBackground(new Color(255, 255, 255));
				//ta.setEditable(false);
				mycartRb.addItemListener(this);
				//mycartRb.setText(rowDataInCart.get(key).toString(), );
				cartButtons.add(mycartRb);
				//mg.cart.mybasketPanel.add(mycartRb);
			}
		}
	}
	ButtonGroup bg5 = new ButtonGroup();
	JRadioButton bt5;
	public void addCartBtoP() {
		
		int i=0;
		bt5 = new JRadioButton();
		bg5.add(bt5);
		for(JRadioButton jr: cartButtons) {
			bg5.add(cartButtons.get(i));
			mg.cart.mybasketPanel.add(cartButtons.get(i));
			i++;
		}
	}
	public void purgeCartBtV() {
		int i=0;
		for(JRadioButton jr: cartButtons) {
			cartButtons.remove(i);
			i++;
		}
	}
	public void purgeCartDataMap() {
		for(int key: rowDataInCart_map.keySet()) {
			rowDataInCart_map.remove(key);
		}
	}

	public void initEvent() {
		int i = 0;
		for (JRadioButton jr : mRButtons) { // 메뉴			
			mRButtons.get(i).addItemListener(this);
			i++;
		}
		int j = 0;
		for (JRadioButton jr : bRButtons) { // 빵
			bRButtons.get(j).addItemListener(this);
			j++;
		}
		int k = 0;
		for (JRadioButton jr : cRButtons) { // 치즈			
			cRButtons.get(k).addItemListener(this);
			k++;
		}
		int l = 0;
		for (JRadioButton jr : vRButtons) { // 채소		
			vRButtons.get(l).addItemListener(this);
			l++;
		}
		int m = 0;
		for (JRadioButton jr : sRButtons) { // 소스
			sRButtons.get(m).addItemListener(this);
			m++;
		}
		int n = 0;
		for (JRadioButton jr : smRButtons) { // 세트메뉴
			smRButtons.get(n).addItemListener(this);
			n++;
		}
	}
	int m_cost=5000;
	int sm_cost=2000;
	int cartno;
	long sum;
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if (mg.mef.menuFrame.isVisible()) {
			int i = 0;
			for (JRadioButton jr : mRButtons) { // 메뉴
				if (mRButtons.get(i).isSelected()) {
					mRButtons.get(i).setBackground(new Color(0, 153, 51));
					mRButtons.get(i).setForeground(new Color(255, 255, 255));
					mg.mef.selected_mname_lb.setText(mRButtons.get(i).getText());
					mg.ord.ordered_mname_lb.setText(mRButtons.get(i).getText());
					mg.ord.amount_lb.setText(""+m_cost);
				} else {
					mRButtons.get(i).setBackground(new Color(255, 255, 255));
					mRButtons.get(i).setForeground(new Color(0, 0, 0));
				}
				i++;
			}
		}
		if (mg.of.opBreadFrame.isVisible()) {
			int j = 0;
			for (JRadioButton jr : bRButtons) { // 빵
				if (bRButtons.get(j).isSelected()) {
					bRButtons.get(j).setBackground(new Color(0, 153, 51));
					bRButtons.get(j).setForeground(new Color(255, 255, 255));
					mg.of.selected_bname_lb.setText(bRButtons.get(j).getText());
					mg.ord.ordered_bname_tf.setText(bRButtons.get(j).getText());
				} else {
					bRButtons.get(j).setBackground(new Color(255, 255, 255));
					bRButtons.get(j).setForeground(new Color(0, 0, 0));
					j++;
				}
			}
		}
		if (mg.of.opCheeseFrame.isVisible()) {
			int k = 0;
			for (JRadioButton jr : cRButtons) { // 치즈
				if (cRButtons.get(k).isSelected()) {
					cRButtons.get(k).setBackground(new Color(0, 153, 51));
					cRButtons.get(k).setForeground(new Color(255, 255, 255)); 
					mg.of.selected_cname_lb.setText(cRButtons.get(k).getText());
					mg.ord.ordered_cname_tf.setText(cRButtons.get(k).getText());
				}else {
					cRButtons.get(k).setBackground(new Color(255, 255, 255));
					cRButtons.get(k).setForeground(new Color(0, 0, 0));
				}
				k++;
			}
		}
		if (mg.of.opVegeFrame.isVisible()) {
			int l = 0;
			LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<>();
			for (JRadioButton jr : vRButtons) { // 채소
				mg.of.selected_vname_ta.setText("");
				mg.ord.ordered_vname_ta.setText("");
				if (vRButtons.get(l).isSelected()) {
					vRButtons.get(l).setBackground(new Color(0, 153, 51));
					vRButtons.get(l).setForeground(new Color(255, 255, 255));
					hm1.put(vRButtons.get(l).getText(), l);
				} else {
					vRButtons.get(l).setBackground(new Color(255, 255, 255));
					vRButtons.get(l).setForeground(new Color(0, 0, 0));
				}
				l++;
			}
			for(String key: hm1.keySet()) {
				mg.rb.resizeFontSize();
				mg.of.selected_vname_ta.append(key+ " ");
				mg.ord.ordered_vname_ta.append(key+ " ");
			}
		}		
		if (mg.of.opSauceFrame.isVisible()) {
			int m = 0;
			HashMap<String, Integer> hm2 = new HashMap<>();
			for (JRadioButton jr : sRButtons) { // 소스
				mg.of.selected_sname_ta.setText("");
				mg.ord.ordered_sname_ta.setText("");
				if (sRButtons.get(m).isSelected()) {
					sRButtons.get(m).setBackground(new Color(0, 153, 51));
					sRButtons.get(m).setForeground(new Color(255, 255, 255));
					hm2.put(sRButtons.get(m).getText(), m);			
				} else {
					sRButtons.get(m).setBackground(new Color(255, 255, 255));
					sRButtons.get(m).setForeground(new Color(0, 0, 0));
				}
				m++;
			}
			for(String key: hm2.keySet()) {
				mg.rb.resizeFontSize();
				mg.of.selected_sname_ta.append(key + " ");
				mg.ord.ordered_sname_ta.append(key + " ");
			}
		}
		if (mg.of.opSetFrame.isVisible()) {
			int n = 0;
			for (JRadioButton jr : smRButtons) { // 세트
				if (smRButtons.get(n).isSelected()) {
					smRButtons.get(n).setBackground(new Color(0, 153, 51));
					smRButtons.get(n).setForeground(new Color(255, 255, 255));
					mg.of.selected_smname_lb.setText(smRButtons.get(n).getText());
					mg.ord.ordered_smname_tf.setText(smRButtons.get(n).getText());
					sum = m_cost + sm_cost;
					mg.ord.amount_lb.setText(""+sum);
				} else {
					smRButtons.get(n).setBackground(new Color(255, 255, 255));
					smRButtons.get(n).setForeground(new Color(0, 0, 0));
				}
				n++;
			}
		}
		if (mg.cart.cartFrame.isVisible()) {
			int n = 0;
			for (int key:rowDataInCart_map.keySet()) { // 세트
				if (cartButtons.get(n).isSelected()) {
					cartButtons.get(n).setBackground(new Color(0, 153, 51));
					cartButtons.get(n).setForeground(new Color(255, 255, 255));
					pln("bc/itemStateChanged: " +rowDataInCart_map);
					//cartno=n+1;
					//mg.cart.purgeCartDataVector();
					mg.cart.moveDfromCtoP(key);
				} else {
					cartButtons.get(n).setBackground(new Color(255, 255, 255));
					cartButtons.get(n).setForeground(new Color(0, 0, 0));
				}
				n++;
			}

		}
	}
	

	void pln(String str) {
		System.out.println(str);
	}
}
