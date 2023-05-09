package pj2.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OptionFrame {
	MainGUI mg;
	JInternalFrame opBreadFrame, opCheeseFrame, opVegeFrame;
	JInternalFrame opSauceFrame, opSetFrame;
	JPanel breadPanel, cheesePanel, vegePanel, saucePanel, setmenuPanel; // 메뉴프레임에 들어가는 패널
	JButton previousBt3, nextBt3, previousBt4, nextBt4, previousBt5, nextBt5;
	JButton previousBt6, nextBt6, previousBt7, nextBt7;
	JLabel selected_bname_lb, selected_cname_lb, selected_smname_lb;;
	JTextArea selected_vname_ta, selected_sname_ta;
	JButton nothingBtC, nothingBtV, nothingBtS, nothingBtSM;
	
	Color white = new Color(255, 255, 255);
	Color black = new Color(0, 0,0);
	Color dGreen = new Color(0, 153, 51);
	
	public OptionFrame(MainGUI mg) {
		this.mg=mg;
	}

	// 빵선택 내부JFrame
	public void setIFrameForOptB() {
		opBreadFrame = new JInternalFrame();
		opBreadFrame.setResizable(false);
		opBreadFrame.setVisible(false);
		opBreadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		opBreadFrame.setBackground(new Color(0, 0, 0, 0));
		opBreadFrame.setLayout(null);
		opBreadFrame.setBorder(null);
		opBreadFrame.setClosable(true);
		opBreadFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel optTxtLb = new JLabel(" 빵 선택(필수/15cm) ");
		optTxtLb.setHorizontalAlignment(JLabel.CENTER);
		optTxtLb.setOpaque(true);
		optTxtLb.setFont(new Font(null, Font.BOLD, 16));
		optTxtLb.setBackground(white);
		optTxtLb.setForeground(new Color(0, 102, 51));
		selected_bname_lb = new JLabel();
		selected_bname_lb.setOpaque(true);
		selected_bname_lb.setHorizontalAlignment(JLabel.CENTER);
		selected_bname_lb.setBackground(white);
		selected_bname_lb.setForeground(new Color(0, 0, 0));
		selected_bname_lb.setBorder(null);
		optTxtLb.setBounds(60, 50, 280, 30);
		selected_bname_lb.setBounds(60, 80, 280, 30);

		breadPanel = new JPanel();
		breadPanel.setBounds(0, 120, 400, 390);
		breadPanel.setBackground(white);
		breadPanel.setLayout(new GridLayout(0, 1));
		mg.bc.addBtoPanel();

		JScrollPane breadSP = new JScrollPane(breadPanel);
		breadSP.getVerticalScrollBar().setUnitIncrement(10);
		breadSP.setBounds(0, 120, 400, 390);
		breadSP.setBorder(null);
		previousBt3 = new JButton(" 뒤로 ");
		previousBt3.setBorderPainted(false);
		previousBt3.setFocusPainted(false);
		previousBt3.setBackground(dGreen);
		previousBt3.setForeground(white);
		previousBt3.addActionListener(mg);
		nextBt3 = new JButton(" 다음 ");
		nextBt3.setBorderPainted(false);
		nextBt3.setFocusPainted(false);
		nextBt3.setBackground(dGreen);
		nextBt3.setForeground(white);
		nextBt3.addActionListener(mg);
		previousBt3.setBounds(5, 520, 195, 52);
		nextBt3.setBounds(200, 520, 195, 52);

		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		opBreadFrame.add(selected_bname_lb);
		opBreadFrame.add(optTxtLb);
		opBreadFrame.add(background);
		opBreadFrame.add(breadSP);
		opBreadFrame.add(previousBt3);
		opBreadFrame.add(nextBt3);
		opBreadFrame.add(buttomBG);
		mg.add(opBreadFrame);

	}
	// 치즈선택 내부JFrame
	public void setIFrameForOptC() {
		opCheeseFrame = new JInternalFrame();
		opCheeseFrame.setResizable(false);
		opCheeseFrame.setVisible(false);
		opCheeseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		opCheeseFrame.setBackground(new Color(0, 0, 0, 0));
		opCheeseFrame.setLayout(null);
		opCheeseFrame.setBorder(null);
		opCheeseFrame.setClosable(true);
		opCheeseFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel optTxtLb = new JLabel(" 치즈 선택 ");
		optTxtLb.setHorizontalAlignment(JLabel.CENTER);
		optTxtLb.setOpaque(true);
		optTxtLb.setFont(new Font(null, Font.BOLD, 16));
		optTxtLb.setBackground(white);
		optTxtLb.setForeground(new Color(0, 102, 51));
		optTxtLb.setBounds(60, 60, 280, 40);
		selected_cname_lb = new JLabel();
		selected_cname_lb.setOpaque(true);
		selected_cname_lb.setHorizontalAlignment(JLabel.CENTER);
		selected_cname_lb.setBackground(white);
		selected_cname_lb.setForeground(new Color(0, 0, 0));
		selected_cname_lb.setBorder(null);
		optTxtLb.setBounds(60, 50, 280, 30);
		selected_cname_lb.setBounds(60, 80, 280, 30);

		cheesePanel = new JPanel();
		cheesePanel.setBounds(0, 120, 400, 310);
		cheesePanel.setBackground(white);
		cheesePanel.setLayout(new GridLayout(0, 1));
		JScrollPane cheeseSP = new JScrollPane(cheesePanel);
		cheeseSP.getVerticalScrollBar().setUnitIncrement(10);
		cheeseSP.setBounds(0, 120, 400, 390);
		cheeseSP.setBorder(null);
		previousBt4 = new JButton(" 뒤로 ");
		previousBt4.setBorderPainted(false);
		previousBt4.setFocusPainted(false);
		previousBt4.setBackground(dGreen);
		previousBt4.setForeground(white);
		previousBt4.addActionListener(mg);
		nextBt4 = new JButton(" 다음 ");
		nextBt4.setBorderPainted(false);
		nextBt4.setFocusPainted(false);
		nextBt4.setBackground(dGreen);
		nextBt4.setForeground(white);
		nextBt4.addActionListener(mg);
		nothingBtC = new JButton("치즈 제외");
		nothingBtC.setBorderPainted(false);
		nothingBtC.setFocusPainted(false);
		nothingBtC.setBackground(dGreen);
		nothingBtC.setForeground(white);
		nothingBtC.addActionListener(mg);
		
		
		previousBt4.setBounds(5, 520, 130, 52);
		nothingBtC.setBounds(135, 520, 130, 52);
		nextBt4.setBounds(265, 520, 130, 52);

		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		opCheeseFrame.add(selected_cname_lb);
		opCheeseFrame.add(optTxtLb);
		opCheeseFrame.add(background);
		opCheeseFrame.add(cheeseSP);
		opCheeseFrame.add(nothingBtC);
		opCheeseFrame.add(previousBt4);
		opCheeseFrame.add(nextBt4);
		opCheeseFrame.add(buttomBG);
		mg.add(opCheeseFrame);
	}

	// 야채선택 내부JFrame
	public void setIFrameForOptV() {
		opVegeFrame = new JInternalFrame();
		opVegeFrame.setResizable(false);
		opVegeFrame.setVisible(false);
		opVegeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		opVegeFrame.setBackground(new Color(0, 0, 0, 0));
		opVegeFrame.setLayout(null);
		opVegeFrame.setBorder(null);
		opVegeFrame.setClosable(true);
		opVegeFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel optTxtLb = new JLabel("<html><body style='text-align:center;'>야채 선택&nbsp;(다중 선택)</html>");
		optTxtLb.setHorizontalAlignment(JLabel.CENTER);
		optTxtLb.setOpaque(true);
		optTxtLb.setFont(new Font(null, Font.BOLD, 16));
		optTxtLb.setBackground(white);
		optTxtLb.setForeground(new Color(0, 102, 51));
		optTxtLb.setBounds(60, 60, 280, 40);
		selected_vname_ta = new JTextArea();
		selected_vname_ta.setEditable(false);

		selected_vname_ta.setBackground(white);
		selected_vname_ta.setForeground(new Color(0, 0, 0));
		selected_vname_ta.setBorder(null);
		optTxtLb.setBounds(60, 50, 280, 30);
		selected_vname_ta.setBounds(60, 80, 280, 30);

		vegePanel = new JPanel();
		vegePanel.setBounds(0, 120, 400, 390);
		vegePanel.setBackground(white);
		vegePanel.setLayout(new GridLayout(0, 1));
		JScrollPane vegeSP = new JScrollPane(vegePanel);
		vegeSP.getVerticalScrollBar().setUnitIncrement(10);
		vegeSP.setBounds(0, 120, 400, 390);
		vegeSP.setBorder(null);
		previousBt5 = new JButton(" 뒤로 ");
		previousBt5.setBorderPainted(false);
		previousBt5.setFocusPainted(false);
		previousBt5.setBackground(dGreen);
		previousBt5.setForeground(white);
		previousBt5.addActionListener(mg);
		nextBt5 = new JButton(" 다음 ");
		nextBt5.addActionListener(mg);
		nextBt5.setBorderPainted(false);
		nextBt5.setFocusPainted(false);
		nextBt5.setBackground(dGreen);
		nextBt5.setForeground(white);
		nothingBtV = new JButton("모두 제외");
		nothingBtV.addActionListener(mg);
		nothingBtV.setBorderPainted(false);
		nothingBtV.setFocusPainted(false);
		nothingBtV.setBackground(dGreen);
		nothingBtV.setForeground(white);
		
		previousBt5.setBounds(5, 520, 130, 52);
		nothingBtV.setBounds(135, 520, 130, 52);
		nextBt5.setBounds(265, 520, 130, 52);

		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		opVegeFrame.add(selected_vname_ta);
		opVegeFrame.add(optTxtLb);
		opVegeFrame.add(background);
		opVegeFrame.add(vegeSP);
		opVegeFrame.add(previousBt5);
		opVegeFrame.add(nothingBtV);
		opVegeFrame.add(nextBt5);
		opVegeFrame.add(buttomBG);
		mg.add(opVegeFrame);
	}

	// 소스선택 내부JFrame
	public void setIFrameForOptS() {
		opSauceFrame = new JInternalFrame();
		opSauceFrame.setResizable(false);
		opSauceFrame.setVisible(false);
		opSauceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		opSauceFrame.setBackground(new Color(0, 0, 0, 0));
		opSauceFrame.setLayout(null);
		opSauceFrame.setBorder(null);
		opSauceFrame.setClosable(true);
		opSauceFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel optTxtLb = new JLabel("<html><body style='text-align:center;'>소스/시즈닝 선택&nbsp;(다중 선택)</html>");
		optTxtLb.setHorizontalAlignment(JLabel.CENTER);
		optTxtLb.setOpaque(true);
		optTxtLb.setFont(new Font(null, Font.BOLD, 16));
		optTxtLb.setBackground(white);
		optTxtLb.setForeground(new Color(0, 102, 51));
		optTxtLb.setBounds(60, 60, 280, 40);
		selected_sname_ta = new JTextArea();
		selected_sname_ta.setEditable(false);
		selected_sname_ta.setBackground(white);
		selected_sname_ta.setForeground(new Color(0, 0, 0));
		selected_sname_ta.setBorder(null);
		optTxtLb.setBounds(60, 50, 280, 30);
		selected_sname_ta.setBounds(60, 80, 280, 30);

		saucePanel = new JPanel();
		saucePanel.setBounds(0, 120, 400, 390);
		saucePanel.setBackground(white);
		saucePanel.setLayout(new GridLayout(0, 2));
		JScrollPane sauceSP = new JScrollPane(saucePanel);
		sauceSP.getVerticalScrollBar().setUnitIncrement(10);
		sauceSP.setBounds(0, 120, 400, 390);
		sauceSP.setBorder(null);
		previousBt6 = new JButton(" 뒤로 ");
		previousBt6.addActionListener(mg);
		previousBt6.setBorderPainted(false);
		previousBt6.setFocusPainted(false);
		previousBt6.setBackground(dGreen);
		previousBt6.setForeground(white);
		
		nothingBtS = new JButton("선택안함");
		nothingBtS.addActionListener(mg);
		nothingBtS.setBorderPainted(false);
		nothingBtS.setFocusPainted(false);
		nothingBtS.setBackground(dGreen);
		nothingBtS.setForeground(white);
		
		nextBt6 = new JButton(" 다음 ");
		nextBt6.addActionListener(mg);
		nextBt6.setBorderPainted(false);
		nextBt6.setFocusPainted(false);
		nextBt6.setBackground(dGreen);
		nextBt6.setForeground(white);
			
		previousBt6.setBounds(5, 520, 130, 52);
		nothingBtS.setBounds(135, 520, 130, 52);
		nextBt6.setBounds(265, 520, 130, 52);

		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		opSauceFrame.add(selected_sname_ta);
		opSauceFrame.add(optTxtLb);
		opSauceFrame.add(background);
		opSauceFrame.add(sauceSP);
		opSauceFrame.add(previousBt6);
		opSauceFrame.add(nothingBtS);
		opSauceFrame.add(nextBt6);
		opSauceFrame.add(buttomBG);
		mg.add(opSauceFrame);
	}

	public void setIFrameForSet() { // 세트메뉴시 추가
		opSetFrame = new JInternalFrame();
		opSetFrame.setResizable(false);
		opSetFrame.setVisible(false);
		opSetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		opSetFrame.setBackground(new Color(0, 0, 0, 0));
		opSetFrame.setLayout(null);
		opSetFrame.setBorder(null);
		opSetFrame.setClosable(true);
		opSetFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);
		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel optTxtLb = new JLabel(" 세트 선택(2000원 추가)");
		optTxtLb.setHorizontalAlignment(JLabel.CENTER);
		optTxtLb.setOpaque(true);
		optTxtLb.setFont(new Font(null, Font.BOLD, 16));
		optTxtLb.setBackground(white);
		optTxtLb.setForeground(new Color(0, 102, 51));
		optTxtLb.setBounds(60, 60, 280, 40);
		selected_smname_lb = new JLabel();
		selected_smname_lb.setOpaque(true);
		selected_smname_lb.setHorizontalAlignment(JLabel.CENTER);
		selected_smname_lb.setBackground(white);
		selected_smname_lb.setForeground(new Color(0, 0, 0));
		selected_smname_lb.setBorder(null);
		optTxtLb.setBounds(60, 50, 280, 30);
		selected_smname_lb.setBounds(60, 80, 280, 30);

		setmenuPanel = new JPanel();
		setmenuPanel.setBounds(0, 120, 400, 390);
		setmenuPanel.setBackground(white);
		setmenuPanel.setLayout(new GridLayout(0, 1));
		JScrollPane sauceSP = new JScrollPane(setmenuPanel);
		sauceSP.getVerticalScrollBar().setUnitIncrement(10);
		sauceSP.setBounds(0, 120, 400, 390);
		sauceSP.setBorder(null);
		previousBt7 = new JButton(" 뒤로 ");
		previousBt7.addActionListener(mg);
		previousBt7.setBorderPainted(false);
		previousBt7.setFocusPainted(false);
		previousBt7.setBackground(dGreen);
		previousBt7.setForeground(white);
		
		nothingBtSM = new JButton("<html><body style='text-align:center'>선택안함<br>(단품선택)</html>");
		nothingBtSM.addActionListener(mg);
		nothingBtSM.setBorderPainted(false);
		nothingBtSM.setFocusPainted(false);
		nothingBtSM.setBackground(dGreen);
		nothingBtSM.setForeground(white);

		nextBt7 = new JButton(" 다음 ");
		nextBt7.addActionListener(mg);
		nextBt7.setBorderPainted(false);
		nextBt7.setFocusPainted(false);
		nextBt7.setBackground(dGreen);
		nextBt7.setForeground(white);
		
		previousBt7.setBounds(5, 520, 130, 52);
		nothingBtSM.setBounds(135, 520, 130, 52);
		nextBt7.setBounds(265, 520, 130, 52);

		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		opSetFrame.add(selected_smname_lb);
		opSetFrame.add(optTxtLb);
		opSetFrame.add(background);
		opSetFrame.add(sauceSP);
		opSetFrame.add(previousBt7);
		opSetFrame.add(nothingBtSM);
		opSetFrame.add(nextBt7);
		opSetFrame.add(buttomBG);
		mg.add(opSetFrame);
	}

}
