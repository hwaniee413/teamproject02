package pj2.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignUpFrame {
	JInternalFrame signupFrame;
	JLabel signup_phone_lb;
	JTextField signup_email_tf, signup_nick_tf, signup_pwd_tf, signup_phone_tf;
	JButton signUpBt2;
	
	MainGUI mg;

	SignUpFrame(MainGUI mg){
		this.mg=mg;
	}
	// 회원가입용 내부JFrame
	public void setIFrameforMember() {
		signupFrame = new JInternalFrame();
		signupFrame.setResizable(false);
		signupFrame.setVisible(false);
		signupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		signupFrame.setBackground(new Color(0, 0, 0, 0));
		signupFrame.setLayout(null);
		signupFrame.setBorder(null);

		// signupFrameBG.setBounds(0, 0, WIDTH, HEIGHT);
		signupFrame.setClosable(true);
		signupFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel membershipLogo = new JLabel(new ImageIcon(getClass().getResource("/img/membershipLogo1.png")));
		JLabel signup_email_lb = new JLabel(" E-mail ");
		signup_email_lb.setFont(new Font(null, Font.BOLD, 13));
		JLabel signup_nick_lb = new JLabel(" 이름 혹은 별명 ");
		JLabel signup_pwd_lb = new JLabel(" 패스워드 ");
		JLabel signup_phone_lb = new JLabel(" 연락처 (-표시 제외)");
		signup_email_tf = new JTextField(20);
		signup_nick_tf = new JTextField(20);
		signup_pwd_tf = new JTextField(20);
		signup_phone_tf = new JTextField(20);
		signup_email_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				if (i == KeyEvent.VK_ENTER) {
					signup_nick_tf.requestFocus();
				}
			}
		});
		signup_nick_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				if (i == KeyEvent.VK_ENTER) {
					signup_pwd_tf.requestFocus();
				}
			}
		});
		signup_pwd_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				if (i == KeyEvent.VK_ENTER) {
					signup_phone_tf.requestFocus();
				}
			}
		});
		signup_phone_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int i = e.getKeyCode();
				if (i == KeyEvent.VK_ENTER) {
					signUpBt2.requestFocus();
				}
			}
		});
		membershipLogo.setBounds(85, 65, 230, 75);
		signup_email_lb.setBounds(85, 150, 120, 30);
		signup_email_tf.setBounds(85, 182, 230, 30);
		signup_nick_lb.setBounds(85, 214, 120, 30);
		signup_nick_tf.setBounds(85, 246, 230, 30);
		signup_pwd_lb.setBounds(85, 278, 120, 30);
		signup_pwd_tf.setBounds(85, 310, 230, 30);
		signup_phone_lb.setBounds(85, 342, 120, 30);
		signup_phone_tf.setBounds(85, 374, 230, 30);

		signupFrame.add(membershipLogo);
		signupFrame.add(signup_email_lb);
		signupFrame.add(signup_email_tf);
		signupFrame.add(signup_nick_lb);
		signupFrame.add(signup_nick_tf);
		signupFrame.add(signup_pwd_lb);
		signupFrame.add(signup_pwd_tf);
		signupFrame.add(signup_phone_lb);
		signupFrame.add(signup_phone_tf);

		signUpBt2 = new RoundedButtonY(" 회원가입 ");
		signUpBt2.setBorderPainted(false);
		signUpBt2.setFocusPainted(false);
		signUpBt2.addActionListener(mg);
		signUpBt2.setBounds(150, 410, 100, 40);
		signupFrame.add(signUpBt2);
		mg.add(signupFrame);
	}

	void signup() {
		String email = signup_email_tf.getText().trim();
		String nname = signup_nick_tf.getText().trim();
		String pwd = signup_pwd_tf.getText().trim();
		String phoneStr = signup_phone_tf.getText().trim();
		try {
			long phone = Long.parseLong(phoneStr);
			int i = email.indexOf("@");
			String str = email.substring(email.indexOf(".") + 1);
			if (!str.equals("com") && i == -1) {
				JOptionPane.showMessageDialog(null, "입력한 이메일 형식이 올바르지 않습니다.\n(aa@aa.com/aa@aa.net/aa@aa.co.kr)만 가능");
			} else if (!str.equals("net") && i == -1) {
				JOptionPane.showMessageDialog(null, "입력한 이메일 형식이 올바르지 않습니다.\n(aa@aa.com/aa@aa.net/aa@aa.co.kr)만 가능");
			} else if (!str.equals("co.kr") && i == -1) {
				JOptionPane.showMessageDialog(null, "입력한 이메일 형식이 올바르지 않습니다.\n(aa@aa.com/aa@aa.net/aa@aa.co.kr)만 가능");
			} else if (email.length() == 0 || nname.length() == 0 || pwd.length() == 0 || phoneStr.length() == 0) {
				JOptionPane.showMessageDialog(null, "입력이 누락된 정보가 있습니다.");
			} else if (phoneStr.length()>11) {
				JOptionPane.showMessageDialog(null, "연락처는 최대 11자리를 넘을 수 없습니다.");	
			} else if (phoneStr.length()<9) { 
				JOptionPane.showMessageDialog(null, "연락처는 최소 9자리를 입력해야 합니다.");
			}else if (pwd.length()>8){
				JOptionPane.showMessageDialog(null, "패스워드는 최대 8자리까지 가능합니다.");
			} else {
				boolean flag = mg.d.join(email, nname, pwd, phoneStr);
				if(flag) {
					signupFrame.dispose();
					mg.orderBt.setVisible(true);
					signup_email_tf.setText("");
					signup_nick_tf.setText("");
					signup_pwd_tf.setText("");
					signup_phone_tf.setText("");
					JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.\n주문을 원하시면 로그인 해주세요.");
				}
			}
		}catch(NumberFormatException ne) {
			JOptionPane.showConfirmDialog(null, "연락처에 문자는 입력할 수 없습니다.", null, JOptionPane.ERROR_MESSAGE);
		}
	}

	
}
