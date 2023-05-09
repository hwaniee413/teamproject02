package pj2.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import pj2.dbhandle.DBHandler;

public class MainGUI extends JFrame implements ActionListener {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	private Image screenImage;
	private Graphics screenGraphic;
	private int mouseX, mouseY;

	JLabel logoLb;
	JButton exitBt, menuBt, orderBt, infoButton, basketBt;
	private Image mainBackground = new ImageIcon(getClass().getResource("/img/main_background1.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(getClass().getResource("/img/title_bar.png")));
	JLabel yellowbar2 = new JLabel(new ImageIcon(getClass().getResource("/img/yellow_bar.png")));
	ImageIcon nothing = new ImageIcon(getClass().getResource("/img/nothing.png"));
	
	
	DBHandler d = new DBHandler();
	ButtonsControl bc;
	ControlView cv;
	ResetButtons rb;
	MyInfoFrame mif;
	StoreFrame sf;
	SignUpFrame suf;
	MenuFrame mef;
	OptionFrame of;
	OrderFrame ord;
	CartFrame cart;
	
	LinkedHashMap<Integer, Vector<String>> rowDataInCart;
	
	MainGUI() {
		cv = new ControlView(this);
		rb = new ResetButtons(this);
		mif = new MyInfoFrame(this);
		sf = new StoreFrame(this);
		suf = new SignUpFrame(this);
		mef = new MenuFrame(this);
		of = new OptionFrame(this);
		ord = new OrderFrame(this);
		cart = new CartFrame(this);
		bc = new ButtonsControl(this);
		
		setUI();
		init();
	}
	void setUI() {
		setUndecorated(true);
		setTitle("Mimi Sandwich ver 1.0");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(0, 0, 0, 0));

		setLayout(null);
	}

	void init() {
		exitBt = new JButton(new ImageIcon(getClass().getResource("/img/exit.png")));
		exitBt.setBounds(370, 0, 30, 30);
		exitBt.setBorderPainted(false);
		exitBt.setContentAreaFilled(false);
		exitBt.setFocusPainted(false);
		exitBt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				int select = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "Exit", JOptionPane.YES_NO_OPTION);
				if (select == JOptionPane.YES_OPTION) {
					mif.loginflag=false;
					System.exit(0);
					d.closeAll();
				}
			}
		});
		add(exitBt);
		menuBar.setBounds(0, 0, WIDTH, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				mouseX = me.getX();
				mouseY = me.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent me) {
				int x = me.getXOnScreen();
				int y = me.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		logoLb = new JLabel(new ImageIcon(getClass().getResource("/img/homeButton.png")));
		logoLb.setBounds(150, 30, 100, 30);
		logoLb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				orderBt.setVisible(true);
				closeFrames();
			}
		});
		add(logoLb);

		// 로그인&회원가입 버튼
		infoButton = new JButton(new ImageIcon(getClass().getResource("/img/infoButton.png")));
		infoButton.setBounds(0, 30, 30, 30);
		infoButton.setBorderPainted(false);
		infoButton.setContentAreaFilled(false);
		infoButton.setFocusPainted(false);
		infoButton.addActionListener(this);
		// 매인프레임 장바구니 버튼
		basketBt = new JButton(new ImageIcon(getClass().getResource("/img/basket.png")));
		basketBt.setBounds(370, 30, 30, 30);
		basketBt.setBorderPainted(false);
		basketBt.setContentAreaFilled(false);
		basketBt.setFocusPainted(false);
		basketBt.addActionListener(this);
		add(basketBt);
		add(infoButton);

	
		// 각 내부프레임 세팅
		mif.setIFrameForLogin();
		suf.setIFrameforMember();
		sf.setIFrameForStore();
		mef.setIFrameForMenu();
		of.setIFrameForOptB();// 빵
		of.setIFrameForOptC();// 치즈
		of.setIFrameForOptV();// 채소
		of.setIFrameForOptS();// 소스
		of.setIFrameForSet(); //세트메뉴
		ord.setIFrameForOrder(); //주문
		cart.setIFrameForCart();
		
		//각 내부프레임에 버튼 삽입
		
		Vector<String> menuName = d.getMenuName();
		Vector<Integer> menuCost = d.getMenuCost();
		int m_count = d.countMenu();
		Vector<String> smenuName = d.getSMenuName();
		Vector<Integer> smenuCost = d.getSMenuCost();
		int sm_count = d.countSMenu();
		bc.addMBtoVector(menuName, m_count);
		bc.addSMBtoVector(smenuName, sm_count);
		bc.addBtoVector();
		bc.addBtoPanel();
		
		orderBt = new JButton("주문시작");
		orderBt.setBackground(new Color(0, 153, 51));
		orderBt.setForeground(new Color(255, 255, 255));
		orderBt.setFont(new Font(null, Font.BOLD, 25));
		orderBt.setBounds(100, 540, 200, 60);
		orderBt.setBorderPainted(false);
		orderBt.setFocusPainted(false);
		orderBt.addActionListener(this);
		add(orderBt);
	
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == infoButton) { // 삼선 버튼
			closeFrames();
			if (mif.loginflag) {
				cv.chgLoginToMyInfo();
				mif.loginFrame.setVisible(true);
			} else {
				cv.chgMyInfoToLogin();
			    //cc.chgMyInfoToModifying();//내정보 수정 용
				mif.loginFrame.setVisible(true);
			}
		} else if (obj == mif.logInBt) { //로그인 버튼
			mif.login();
			if(mif.loginflag) { 
				mif.setMyInfo(); 			
			}
		} else if (obj == mif.signUpBt) { //로긴프레임 내 가입버튼
			orderBt.setVisible(false);
			if (mif.emailTf.getText().length() !=0 &&mif.pwdTf.getText().length() != 0) {
				suf.signup_email_tf.setText(mif.emailTf.getText().trim());
				suf.signup_pwd_tf.setText(mif.pwdTf.getText().trim());
			}
			mif.loginFrame.dispose();
			suf.signupFrame.setVisible(true);
		} else if (obj == suf.signUpBt2) { // 가입프레임 내 가입버튼
			suf.signup();
		} else if (obj == orderBt) { // 주문시작 버튼
			orderBt.setVisible(false);
			if(mif.loginflag) {
				//rb.reset();
				bc.initEvent();
				sf.storeFrame.setVisible(true);
			} else {
				cv.chgMyInfoToLogin();
				mif.loginFrame.setVisible(true);
			}
		} else if (obj == sf.storeCb) { // 가맹점 콤보박스
			String str = sf.storeCb.getSelectedItem().toString();
			sf.selcStoreTf.setText("");
			if (str.equals("전체")) {
				sf.initJtable();
			} else {
				Vector<Vector<String>> rowData = d.reselectStoreInfo(str);
				sf.dftmodel.setDataVector(rowData, sf.columnNames);
			}
		} else if (obj == sf.nextBt1) { // 가맹점 선택 프레임에서
			sf.storeFrame.dispose();
			mef.menuFrame.setVisible(true);
		} else if (obj == mef.previousBt2) { // 메뉴 선택 프레임에서
			sf.storeFrame.setVisible(true);
			mef.menuFrame.dispose();
		} else if (obj == mef.nextBt2) {
			if(mef.selected_mname_lb.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "메인메뉴는 필수 선택입니다.");
			} else {
				of.opBreadFrame.setVisible(true);
				mef.menuFrame.dispose();
			}
		} else if (obj == of.previousBt3) { // 빵선택 프레임에서
			mef.menuFrame.setVisible(true);
			of.opBreadFrame.dispose();
		} else if (obj == of.nextBt3) {
			if(of.selected_bname_lb.getText().length()==0) {
				JOptionPane.showMessageDialog(null, "빵은 필수 선택입니다.");
			} else {
				of.opBreadFrame.dispose();
				of.opCheeseFrame.setVisible(true);
			}
		} else if (obj == of.previousBt4) { // 치즈선택
			of.opCheeseFrame.dispose();
			of.opBreadFrame.setVisible(true);
		} else if (obj == of.nextBt4) {
			of.opCheeseFrame.dispose();
			of.opVegeFrame.setVisible(true);
		} else if (obj == of.previousBt5) { // 채소선택
			of.opVegeFrame.dispose();
			of.opCheeseFrame.setVisible(true);
		} else if (obj == of.nextBt5) {
			of.opVegeFrame.dispose();
			of.opSauceFrame.setVisible(true);
		} else if (obj == of.previousBt6) { // 소스
			of.opSauceFrame.dispose();
			of.opVegeFrame.setVisible(true);
		} else if (obj == of.nextBt6) {
			of.opSauceFrame.dispose();
			of.opSetFrame.setVisible(true);
		} else if (obj == of.previousBt7) { // 세트
			of.opSetFrame.dispose();
			of.opSauceFrame.setVisible(true);
		} else if (obj == of.nextBt7) {
			of.opSetFrame.dispose();
			cv.chgPayInfoToSelcInfo();
			ord.orderFrame.setVisible(true);
			if(ord.amount_lb.getText().length()!=0)
				ord.initCost = Long.parseLong(ord.amount_lb.getText()); //수량 증가시 계산을 위한 초기화
		} else if (obj == ord.cancelBtInFrame) { // 선택 전체확인에서 취소
			ord.orderFrame.dispose();
			rb.reset();
			ord.count = 1;
			ord.count_lb.setText("" + ord.count);
		} else if (obj == ord.basketBtInFrame) { // 선택확인창에서 카트에 담기/"담기 버튼"
			orderBt.setVisible(false);
			ord.orderFrame.dispose();
			cart.insertDataIntoCart();
			bc.addCartInfoToMap();
			bc.addCartBtoP();
			cart.cartFrame.setVisible(true);
		} else if (obj == ord.orderBtInFrame) { //선택확인창에서 주문 및 결제
			ord.setSummaryView();
			cv.chgSelcInfoToPayInfo();
		} else if (obj == basketBt) { // 홈화면 장바구니 버튼
			if(mif.loginflag) {
				orderBt.setVisible(false);
				bc.addCartInfoToMap();
				bc.addCartBtoP();
				closeFrames();
				cart.cartFrame.setVisible(true);
				//cart.mybasketPanel.setVisible(true);
			}
		}else if (obj == of.nothingBtC) { //치즈 모두 제외
			rb.resetCheeseBt();
		} else if (obj == of.nothingBtS) { // 소스 모드 제외
			rb.resetSauceBt();
		} else if (obj == of.nothingBtV) { // 야채 모두 제외
			rb.resetVegeBt();
		} else if (obj == of.nothingBtSM) { // 세트 제외
			rb.resetSetMenu();
		} else if (obj == mif.logoutBt) { // 로그아웃
			// d.updateLogoutInfo(emailTf.getText());
			mif.removeAllMyInfo();		
		} else if (obj == ord.minusBt) { 
			if(ord.amount_lb.getText().length()!=0) {
				if (ord.count >= 2) {
					ord.count--;
					ord.count_lb.setText("" + ord.count);
					if (ord.smCost > 0) {
						ord.smCost = ord.smCost - ord.initSMcost;
					}
					ord.minusAmount();
				} else if (ord.count == 1) {
					ord.count = 1;
				}
			}
		} else if (obj == ord.plusBt) {
			ord.count++;
			if(ord.amount_lb.getText().length()!=0) {
				long l = Long.parseLong(ord.amount_lb.getText());
				if (l != 0) {
					ord.count_lb.setText("" + ord.count);
					ord.smCost = ord.smCost + ord.initSMcost;
					ord.plusAmount();
				}
			}
		} else if (obj == cart.exitMyBasket) { //장바구니에서 나갈 때
			bc.bt5.setSelected(true);
			rb.reset();
			cart.cartFrame.dispose();
			orderBt.setVisible(true);
		} else if(obj == cart.payBtInMyBasket) { // 장바구니 내 결제 버튼
			cv.chgSelcInfoToPayInfo();
			cart.cartFrame.dispose();
			ord.orderFrame.setVisible(true);
			//cart.moveDfromCtoP();  //장바구니 정보를 결제창으로 이동
		} else if(obj == mif.modifyingBt) { //내 정보 수정 버튼
			mif.checkPwd();
			mif.purgeMyInfoArray();
			mif.setMyInfoArray();
			mif.setMyInfo();
		} else if(obj == mif.modifyingNickBt){ // 닉네임 수정 버튼
			mif.modifyNickName();
		} else if(obj == mif.modifyingPwdBt) { // pwd 수정 버튼
			mif.modifyPwd();
		} else if(obj == mif.modifyingPnumBt) {
			mif.modifyPhoneNumber();
		} else if(obj == mif.exit_modifyingBt) { //정보수정 완료버튼
			mif.purgeMyInfoArray();
			mif.setMyInfoArray();
			mif.setMyInfo();
			cv.chgModifyingToMyInfo();
			mif.modifyingEmail_txtLb.setText("");
			mif.modifyingNoticeLb.setText("");
		} else if(obj == mif.delete_AllMyInfoBt) {
			mif.withdraw();
			mif.removeAllMyInfo();
			cv.chgMyInfoToLogin();
		} else if(obj== ord.paywayCb) {
			int setcode = ord.outputOfPaywayCb();
			ord.selected_payway.setText(""+setcode);
		} else if(obj== ord.payBt) { // 결제창 내 결제 버튼
			//cv.chgSelcInfoToPayInfo();
			ord.insertDataIntoPaylog();
			mif.purgeMyInfoArray();
			mif.setMyInfoArray();
			mif.setMyInfo();
			rb.reset();
			closeFrames();
			orderBt.setVisible(true);
		}
		
	}
	void closeFrames() {
		if (mif.loginFrame.isVisible()) {
			mif.loginFrame.dispose();
		} else if (suf.signupFrame.isVisible()) { // 회원가입
			suf.signupFrame.dispose();
		} else if (sf.storeFrame.isVisible()) { // 가맹점
			sf.storeFrame.dispose();
		} else if (mef.menuFrame.isVisible()) { // 메뉴
			mef.menuFrame.dispose();
		} else if (of.opBreadFrame.isVisible()) { // 빵
			of.opBreadFrame.dispose();
		} else if (of.opCheeseFrame.isVisible()) { // 치즈
			of.opCheeseFrame.dispose();
		} else if (of.opVegeFrame.isVisible()) { // 채소
			of.opVegeFrame.dispose();
		} else if (of.opSauceFrame.isVisible()) { // 소스
			of.opSauceFrame.dispose();
		} else if (of.opSetFrame.isVisible()) { // 세트
			of.opSetFrame.dispose();
		} else if (ord.orderFrame.isVisible()) { // 주문
			ord.orderFrame.dispose();
		} else if(cart.cartFrame.isVisible()) { //장바구니
			cart.cartFrame.dispose();
		} 
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(WIDTH, HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(mainBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	void pln(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		new MainGUI();
	}
}
