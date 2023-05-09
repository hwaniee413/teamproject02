package pj2.customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyInfoFrame extends JFrame {
	JInternalFrame loginFrame = new JInternalFrame();
	JLabel emailLb, pwdLb;
	JLabel nicknameLb_myinfo, emailLb_myinfo, rdateLb_myinfo, mileageLb_myinfo;
	JLabel mileagelb, won; // 로그인 후 뜨는 유저 마일리지 정보
	JLabel modyfyingInfoBG, modifyingInfo_titleLb, modifyingNick_titleLb, 
	   modifyingPwd_titleLb, modifyingPnum_titleLb;
	JLabel modifyingEmail_titleLb, modifyingEmail_txtLb, modifyingNoticeLb, payhistoryBG;
	JTextField emailTf, pwdTf, modifyingNick_tf, modifyingPwd_tf, modifyingPnum_tf;
	JButton modifyingBt, logoutBt;
	JButton modifyingNickBt, modifyingPwdBt, modifyingPnumBt;
	JButton exit_modifyingBt, delete_AllMyInfoBt, searchingBt;
	JPanel myinfoPn, searchingDatePn, payhistoryPn;
	JTable payhitoryT;
	JScrollPane payT_jsp;
	JTabbedPane jtp;
	RoundedButtonY logInBt;
	RoundedButtonW signUpBt;
	
	JComboBox<Object> year_start, month_start, day_start, year_end, month_end, day_end;
	String year,month,day;
	String patternY = "yyyy";SimpleDateFormat simpleDateFormatY = new SimpleDateFormat(patternY);
	String patternM = "MM";SimpleDateFormat simpleDateFormatM = new SimpleDateFormat(patternM);
	String patternD = "dd";SimpleDateFormat simpleDateFormatD = new SimpleDateFormat(patternD);
	
	String sysdateY = simpleDateFormatY.format(new Date());
	String sysdateM = simpleDateFormatM.format(new Date());
	String sysdateD = simpleDateFormatD.format(new Date());
	
	ImageIcon mainBG = new ImageIcon(getClass().getResource("/img/loginFrameBG.png"));
	JLabel loginFrameBG = new JLabel(mainBG);
	JLabel yellowbar1 = new JLabel(new ImageIcon(getClass().getResource("/img/yellow_bar.png")));
	JLabel avatar = new JLabel(new ImageIcon(getClass().getResource("/img/sandwich_avatar.png")));
	ImageIcon myinfoBG = new ImageIcon((getClass().getResource("/img/myinfoBG.png")));
	

	
	Color dBrown = new Color(51,0,0);
	Color white = new Color(255,255,255);
	
	DefaultTableModel pay_dftmodel = new DefaultTableModel();
	Vector<String> myinfoList;
	public boolean loginflag = false;
	
	MainGUI mg;
	public MyInfoFrame(MainGUI mg) {
		this.mg=mg;
	}
	// 로그인용 내부 JFrame
	public void setIFrameForLogin() {
		setComponentsForModifying();
		setComponentsForPayP();
		loginFrame.setResizable(false);
		loginFrame.setVisible(false);
		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginFrame.setBackground(new Color(0, 0, 0, 0));
		loginFrame.setLayout(null);
		loginFrame.setBorder(null);
		loginFrame.setClosable(true);
		loginFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);
		// 로그인 관련 컴포넌트들
		emailLb = new JLabel(" 이메일 ");
		emailLb.setFont(new Font(null, Font.BOLD, 15));
		emailLb.setForeground(new Color(255, 255, 255));
		emailTf = new JTextField(20);
		emailTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				if (i == KeyEvent.VK_ENTER) {
					pwdTf.requestFocus();
				}
			}
		});

		pwdLb = new JLabel(" 패스워드 ");
		pwdLb.setFont(new Font(null, Font.BOLD, 15));
		pwdLb.setForeground(new Color(255, 255, 255));
		pwdTf = new JTextField(20);
		logInBt = new RoundedButtonY("로그인");
		signUpBt = new RoundedButtonW("회원가입");
		logInBt.addActionListener(mg);
		signUpBt.addActionListener(mg);
		emailLb.setBounds(70, 100, 70, 30);
		emailTf.setBounds(140, 100, 165, 30);
		pwdLb.setBounds(70, 132, 70, 30);
		pwdTf.setBounds(140, 132, 165, 30);
		logInBt.setBounds(40, 180, 160, 40);
		signUpBt.setBounds(200, 180, 160, 40);
		
		// 내 정보 관련 컴포넌트들
		nicknameLb_myinfo = new JLabel();
		nicknameLb_myinfo.setForeground(new Color(255, 255, 255));
		nicknameLb_myinfo.setFont(new Font(null, Font.BOLD, 45));
		emailLb_myinfo = new JLabel();
		emailLb_myinfo.setForeground(new Color(255, 255, 255));
		mileagelb = new JLabel("현재 보유 마일리지");
		mileagelb.setForeground(new Color(255, 255, 255));
		mileagelb.setFont(new Font(null, Font.BOLD, 15));
		mileagelb.setHorizontalAlignment(JLabel.RIGHT);
		mileageLb_myinfo = new JLabel("0");
			mileageLb_myinfo.setForeground(new Color(255, 204, 51));
		mileageLb_myinfo.setFont(new Font(null, Font.BOLD, 30));
		mileageLb_myinfo.setHorizontalAlignment(JLabel.RIGHT);
		won = new JLabel("원");
		won.setForeground(new Color(255, 204, 51));
		won.setFont(new Font(null, Font.BOLD, 30));
		modifyingBt = new JButton("정보수정");
		modifyingBt.setBackground(new Color(255, 204, 51));
		modifyingBt.setForeground(new Color(0, 0, 0));
		modifyingBt.setFocusPainted(false);
		modifyingBt.addActionListener(mg);
		logoutBt = new JButton("로그아웃");
		logoutBt.setFocusPainted(false);
		logoutBt.setBackground(new Color(255, 204, 51));
		logoutBt.setForeground(new Color(0, 0, 0));
		logoutBt.addActionListener(mg);
		yellowbar1.setBounds(0, 7, MainGUI.WIDTH, 30);
		avatar.setBounds(50, 80, 100, 100);
		nicknameLb_myinfo.setBounds(160, 90, 240, 70);
		emailLb_myinfo.setBounds(160, 150, 100, 20);
		mileagelb.setBounds(50, 200, 320, 20);
		mileageLb_myinfo.setBounds(200, 220, 150, 50);
		won.setBounds(350, 220, 50, 50);
		modifyingBt.setBounds(100, 285, 100, 30);
		logoutBt.setBounds(200, 285, 100, 30);
		
		//내 정보 수정 관련 컴포넌트들
		
		jtp= new JTabbedPane();
		jtp.setBounds(25, 75, 350, 450);
		jtp.addTab("정보 수정", myinfoPn);
		jtp.addTab("결제 내역", payhistoryPn);
		
		loginFrame.add(jtp);	
		loginFrame.add(yellowbar1);	
		loginFrame.add(emailLb);
		loginFrame.add(emailTf);
		loginFrame.add(pwdLb);
		loginFrame.add(pwdTf);
		loginFrame.add(logInBt);
		loginFrame.add(signUpBt);
		loginFrame.add(avatar);
		loginFrame.add(nicknameLb_myinfo);
		loginFrame.add(emailLb_myinfo);
		loginFrame.add(mileagelb);
		loginFrame.add(mileageLb_myinfo);
		loginFrame.add(won);
		loginFrame.add(modifyingBt);
		loginFrame.add(logoutBt);
	
		// 배경이미지 레이블
		loginFrameBG.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);
		loginFrameBG.setOpaque(true);
		loginFrame.add(loginFrameBG);
		mg.add(loginFrame);
	}
	void setComponentsForModifying() {
		modyfyingInfoBG = new JLabel(new ImageIcon(getClass().getResource("/img/myinfoBG.png")));
		modifyingInfo_titleLb = new JLabel("[ 내 정보 수정 ] ");
		modifyingInfo_titleLb.setForeground(new Color(0, 0, 0));
		modifyingInfo_titleLb.setFont(new Font(null, Font.BOLD, 20));
		modifyingEmail_titleLb = new JLabel("이메일");
		modifyingEmail_titleLb.setForeground(new Color(0, 0, 0));
		modifyingEmail_titleLb.setFont(new Font(null, Font.BOLD, 14));
		modifyingEmail_titleLb.setHorizontalAlignment(JLabel.CENTER);
		modifyingEmail_txtLb = new JLabel();
		modifyingEmail_txtLb.setForeground(new Color(0, 0, 0));
		modifyingEmail_txtLb.setFont(new Font(null, Font.BOLD, 14));
		modifyingNick_titleLb = new JLabel(" 닉네임 ");
		modifyingNick_titleLb.setForeground(new Color(0, 0, 0));
		modifyingNick_titleLb.setFont(new Font(null, Font.BOLD, 14));
		modifyingNick_titleLb.setHorizontalAlignment(JLabel.CENTER);
		modifyingPwd_titleLb = new JLabel(" 패스워드 ");
		modifyingPwd_titleLb.setForeground(new Color(0, 0, 0));
		modifyingPwd_titleLb.setFont(new Font(null, Font.BOLD, 14));
		modifyingPwd_titleLb.setHorizontalAlignment(JLabel.CENTER);
		modifyingPnum_titleLb = new JLabel(" 전화번호 ");
		modifyingPnum_titleLb.setForeground(new Color(0, 0, 0));
		modifyingPnum_titleLb.setHorizontalAlignment(JLabel.CENTER);
		modifyingPnum_titleLb.setFont(new Font(null, Font.BOLD, 14));
		modifyingNick_tf = new JTextField();
		modifyingPwd_tf = new JTextField();
		modifyingPnum_tf = new JTextField();
		modifyingNickBt = new JButton("수정");
		modifyingNickBt.setBorderPainted(false);
		modifyingNickBt.setBackground(dBrown);
		modifyingNickBt.setForeground(white);
		modifyingNickBt.setFocusPainted(false);
		modifyingNickBt.addActionListener(mg);
		modifyingPwdBt = new JButton("수정");
		modifyingPwdBt.setBorderPainted(false);
		modifyingPwdBt.setBackground(dBrown);
		modifyingPwdBt.setForeground(white);
		modifyingPwdBt.setFocusPainted(false);
		modifyingPwdBt.addActionListener(mg);
		modifyingPnumBt = new JButton("수정");
		modifyingPnumBt.setBorderPainted(false);
		modifyingPnumBt.setBackground(dBrown);
		modifyingPnumBt.setForeground(white);
		modifyingPnumBt.setFocusPainted(false);
		modifyingPnumBt.addActionListener(mg);
		exit_modifyingBt = new JButton("완료");
		exit_modifyingBt.setBorderPainted(false);
		exit_modifyingBt.setBackground(dBrown);
		exit_modifyingBt.setForeground(white);
		exit_modifyingBt.setFocusPainted(false);
		exit_modifyingBt.addActionListener(mg);	
		delete_AllMyInfoBt = new JButton("탈퇴");
		delete_AllMyInfoBt.setBorderPainted(false);
		delete_AllMyInfoBt.setBackground(dBrown);
		delete_AllMyInfoBt.setForeground(white);
		delete_AllMyInfoBt.setFocusPainted(false);
		delete_AllMyInfoBt.addActionListener(mg);
		modifyingNoticeLb = new JLabel();
		modifyingNoticeLb.setForeground(new Color(0, 0, 0));
		modifyingNoticeLb.setFont(new Font(null, Font.BOLD, 12));
		modifyingNoticeLb.setHorizontalAlignment(JLabel.CENTER);
		modifyingNickBt.setBorderPainted(false);
		modifyingInfo_titleLb.setBounds(100, 10, 150, 70);
		modifyingEmail_titleLb.setBounds(15, 100, 80, 30);
		modifyingNick_titleLb.setBounds(15, 150, 80, 30);
		modifyingPwd_titleLb.setBounds(15, 200, 80, 30);
		modifyingPnum_titleLb.setBounds(15, 250, 80, 30);
		modifyingEmail_txtLb.setBounds(95, 100, 150, 30);
		modifyingNick_tf.setBounds(95, 150, 150, 30);
		modifyingPwd_tf.setBounds(95, 200, 150, 30);
		modifyingPnum_tf.setBounds(95, 250, 150, 30);
		modifyingNickBt.setBounds(245, 150, 75, 30);
		modifyingPwdBt.setBounds(245, 200, 75, 30);
		modifyingPnumBt.setBounds(245, 250, 75, 30);
		modifyingNoticeLb.setBounds(25, 290, 300, 40);
		exit_modifyingBt.setBounds(95, 350, 80, 30);	
		delete_AllMyInfoBt.setBounds(185, 350, 80, 30);
		myinfoPn = new JPanel();
		myinfoPn.setLayout(new BorderLayout());
		myinfoPn.setBounds(25, 75, 350, 450);
		myinfoPn.add(modifyingInfo_titleLb);
		myinfoPn.add(modifyingEmail_titleLb);
		myinfoPn.add(modifyingNick_titleLb);
		myinfoPn.add(modifyingPwd_titleLb);
		myinfoPn.add(modifyingPnum_titleLb);
		myinfoPn.add(modifyingEmail_txtLb);
		myinfoPn.add(modifyingNick_tf);
		myinfoPn.add(modifyingPwd_tf);
		myinfoPn.add(modifyingPnum_tf);
		myinfoPn.add(modifyingNickBt);
		myinfoPn.add(modifyingPwdBt);
		myinfoPn.add(modifyingPnumBt);
		myinfoPn.add(modifyingNoticeLb);
		myinfoPn.add(exit_modifyingBt);
		myinfoPn.add(delete_AllMyInfoBt);
		myinfoPn.add(modyfyingInfoBG);
	}
	void setComponentsForPayP() {//Payment History
		payhistoryPn = new JPanel();
		payhistoryPn.setBackground(Color.WHITE);
		year_start = new JComboBox<Object>();
		month_start = new JComboBox<Object>();
		day_start = new JComboBox<Object>();
		year_end = new JComboBox<Object>();
		month_end = new JComboBox<Object>();
		day_end = new JComboBox<Object>();
		year_start.setBackground(white);
		month_start.setBackground(white);
		day_start.setBackground(white);
		year_end.setBackground(white);
		month_end.setBackground(white);
		day_end.setBackground(white);
		
		searchingDatePn = new JPanel();
		searchingDatePn.setLayout(new FlowLayout());
		searchingDatePn.setBackground(white);
		for (int y=2022;y>=1900;y--){ //년
			year_start.addItem(y);
			year_end.addItem(y);
		}
		for (int j=1;j<13;j++){ //월
			String m=String.format("%02d",j);			 
			month_start.addItem(m);
			month_end.addItem(m);
		}
		for (int k=1;k<=31;k++){ //일 
			String d=String.format("%02d",k);
			day_start.addItem(d);
			day_end.addItem(d);
		}
		year_start.setSelectedItem(sysdateY);
		month_start.setSelectedItem(sysdateM);
		day_start.setSelectedItem(sysdateD);
		year_end.setSelectedItem(sysdateY);
		month_end.setSelectedItem(sysdateM);
		day_end.setSelectedItem(sysdateD);
		JLabel jl = new JLabel(" ~ ");
		searchingDatePn.add(year_start);
		searchingDatePn.add(month_start);
		searchingDatePn.add(day_start);
		searchingDatePn.add(jl);
		searchingDatePn.add(year_end);
		searchingDatePn.add(month_end);
		searchingDatePn.add(day_end);
		
		searchingBt = new JButton("검색");
		searchingBt.setBorderPainted(false);
		searchingBt.setBackground(dBrown);
		searchingBt.setForeground(white);
		searchingBt.setFocusPainted(false);
		
		payhitoryT = new JTable(pay_dftmodel);
		//payhitoryT.setPreferredSize(new Dimension(250, 370));
		payhitoryT.setShowGrid(false);
		payhitoryT.getTableHeader().setReorderingAllowed(false);
		payhitoryT.setBackground(new Color(255, 255, 204));
		payhitoryT.setGridColor(new Color(255, 153, 102));
		payhitoryT.setEnabled(false);
		payT_jsp = new JScrollPane(payhitoryT);
		payT_jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		payT_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		payT_jsp.setPreferredSize(new Dimension(330, 370));
		payhistoryBG = new JLabel(new ImageIcon(getClass().getResource("/img/myinfoBG.png")));
		payhistoryPn.add(searchingDatePn);
		payhistoryPn.add(searchingBt);
		payhistoryPn.add(payT_jsp);
		payhistoryPn.add(payhistoryBG);
	}
	public void login() {
		String email = emailTf.getText().trim();
		String pwd = pwdTf.getText().trim();
		boolean flag1 = mg.d.isEmail(email);
		boolean flag2 = mg.d.isPwd(email, pwd);
		int i = email.indexOf("@");
		String str = email.substring(email.indexOf(".") + 1);
		if (!str.equals("com") && i == -1) {
			JOptionPane.showMessageDialog(null, "입력한 이메일 형식이 올바르지 않습니다.\n(aa@aa.com/aa@aa.net/aa@aa.co.kr)만 가능");
		} else if (!str.equals("net") && i == -1) {
			JOptionPane.showMessageDialog(null, "입력한 이메일 형식이 올바르지 않습니다.\n(aa@aa.com/aa@aa.net/aa@aa.co.kr)만 가능");
		} else if (!str.equals("co.kr") && i == -1) {
			JOptionPane.showMessageDialog(null, "입력한 이메일 형식이 올바르지 않습니다.\n(aa@aa.com/aa@aa.net/aa@aa.co.kr)만 가능");
		} else if (flag1 && flag2) {
			mg.d.insertLoginInfo(email);
			myinfoList = mg.d.getMyInfoFromMember(email);
			loginFrame.dispose();
			mg.orderBt.setVisible(true);
			loginflag = true;
		} else {
			JOptionPane.showMessageDialog(null, "이메일 혹은 패스워드가 일치하지 않습니다.\n입력정보를 다시 확인하거나 회원가입을 해주세요.");
		}
	}
	Vector<String> plColumnNames;
	Vector<Vector<String>> plRowData;
	public void setMyInfo() {
		//0.NNAME, 1.EMAIL, 2.PWD, 3.PHONE, 4.MILG
		nicknameLb_myinfo.setText(myinfoList.get(0));  //0 닉네임
		emailLb_myinfo.setText(myinfoList.get(1)); //1 이메일
		mileageLb_myinfo.setText(myinfoList.get(4)); //4 마일리지
		modifyingEmail_txtLb.setText(myinfoList.get(1)); //이메일
		boolean flag = mg.d.isEmailinPaylog(myinfoList.get(1));
		if(flag) {
			plColumnNames = mg.d.getPaylogColumn(myinfoList.get(1));
			plRowData =mg.d.getPlRow(myinfoList.get(1));
			pay_dftmodel.setDataVector(plRowData, plColumnNames);
		}
	}
	public void checkPwd() {
		String chkpwd = JOptionPane.showInputDialog(null, "패스워드를 입력하세요",
				"내 정보 수정", JOptionPane.QUESTION_MESSAGE);
		boolean flag = mg.d.isPwd(emailLb_myinfo.getText(),chkpwd);
		if(flag) {
			mg.cv.chgMyInfoToModifying();
		} else {
			JOptionPane.showInternalMessageDialog(null, "패스워드가 일치하지 않아서\n 회원정보 수정을 할 수 없습니다.");
		}
	}
	public void purgeMyInfoArray() {
		for(int i=0; i<myinfoList.size();i++) {
			myinfoList.remove(i);
		}
	}
	public void setMyInfoArray() {
		String email = emailLb_myinfo.getText();
		myinfoList = mg.d.getMyInfoFromMember(email);
		
	}
	public void setModifying() {
		modifyingNick_tf.setText(myinfoList.get(0));
		modifyingPwd_tf.setText(myinfoList.get(2)); //현재 비번
		modifyingPnum_tf.setText(myinfoList.get(3)); //현재 전번
	}
	public void modifyNickName() {
		String email = emailLb_myinfo.getText();
		String nname = modifyingNick_tf.getText().trim();
		if(mg.d.modifyNick(email,nname)) {
			modifyingNoticeLb.setText("닉네임을 수정했습니다.");
		} else {
			modifyingNoticeLb.setText("동일한 닉네임이 이미 사용 중입니다.");
		}
		modifyingNick_tf.setText("");
	}
	public void modifyPwd() {
		String email = emailLb_myinfo.getText();
		String pwd = modifyingPwd_tf.getText().trim();
		if(mg.d.modifyPwd(email, pwd)) {
			modifyingNoticeLb.setText("패스워드를 수정했습니다.");
		} 
		modifyingPwd_tf.setText("");
	}
	public void modifyPhoneNumber() {
		String email = emailTf.getText();
		String phone = modifyingPnum_tf.getText().trim();
		try {
			long l = Long.parseLong(phone);
			if(phone.length()>11) {
				JOptionPane.showMessageDialog(null, "11자리까지만 입력 가능합니다.");
			} else if(mg.d.modifyPhone(email, phone)) {
				modifyingNoticeLb.setText("연락처를 수정했습니다.");
			} else {
				modifyingNoticeLb.setText("연락처를 누군가 사용 중입니다.");
			}
		}catch(NumberFormatException ne) {
			JOptionPane.showConfirmDialog(null, "문자는 입력할 수 없습니다.", null, JOptionPane.ERROR_MESSAGE);
		}
		modifyingPnum_tf.setText("");
	}
	public void withdraw() {//회원탈퇴
		int select = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠어요?", "회원탈퇴", 1, JOptionPane.YES_NO_OPTION);
		if(select==JOptionPane.YES_OPTION) {
			String email = emailLb_myinfo.getText();
			String pwd = JOptionPane.showInputDialog("패스워드를 다시 입력해주세요.");
			if(mg.d.isPwd(email, pwd)) {
				if(mg.d.withdraw(email, pwd)) {
					JOptionPane.showMessageDialog(null,"탈퇴되었습니다.\n그동안 이용해주셔 감사합니다.");
					mg.closeFrames();
				}
			} else {
				JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.");
			}
		}
	}
	
	
	
	public void removeAllMyInfo() {
		emailTf.setText("");
		pwdTf.setText("");
		nicknameLb_myinfo.setText("");  
		emailLb_myinfo.setText(""); 
		mileageLb_myinfo.setText(""); 
		modifyingEmail_txtLb.setText("");
		modifyingNick_tf.setText("");
		modifyingPwd_tf.setText(""); 
		modifyingPnum_tf.setText(""); 	
		purgeMyInfoArray();
		loginFrame.dispose();
		loginflag = false;
	}
	
	
	public void pln(String str) {
		System.out.println(str);
	}
}
