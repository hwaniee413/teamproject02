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

public class MenuFrame {
	MainGUI mg;
	JInternalFrame menuFrame = new JInternalFrame();
	JLabel selected_mname_lb;
	JButton previousBt2, nextBt2;
	JPanel menuPanel;
	Color dGreen = new Color(0,153, 51);
	Color white = new Color(255, 255, 255);
	Color black = new Color(0, 0, 0);
	
	MenuFrame(MainGUI mg){
		this.mg=mg;
	}
	public void setIFrameForMenu() {
		// 메뉴선택 내부JFrame	
		menuFrame.setResizable(false);
		menuFrame.setVisible(false);
		menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuFrame.setBackground(new Color(0, 0, 0, 0));
		menuFrame.setLayout(null);
		menuFrame.setBorder(null);
		menuFrame.setClosable(true);
		menuFrame.setBounds(0, 0, MainGUI.WIDTH, MainGUI.HEIGHT);

		JLabel background = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		background.setBounds(0, 40, MainGUI.WIDTH, 80);
		JLabel menuTxtlb = new JLabel(" 메뉴 선택(필수) ");
		menuTxtlb.setHorizontalAlignment(JLabel.CENTER);
		menuTxtlb.setOpaque(true);
		menuTxtlb.setFont(new Font(null, Font.BOLD, 16));
		menuTxtlb.setBackground(white);
		menuTxtlb.setForeground(new Color(0, 102, 51));
		selected_mname_lb = new JLabel();
		selected_mname_lb.setOpaque(true);
		selected_mname_lb.setHorizontalAlignment(JLabel.CENTER);
		selected_mname_lb.setBackground(white);
		selected_mname_lb.setForeground(black);
		selected_mname_lb.setBorder(null);
		menuTxtlb.setBounds(60, 50, 280, 30);
		selected_mname_lb.setBounds(60, 80, 280, 30);

		menuPanel = new JPanel();
		menuPanel.setBounds(0, 120, 400, 390);
		menuPanel.setBackground(white);
		menuPanel.setLayout(new GridLayout(0, 1));
		JScrollPane menuSP = new JScrollPane(menuPanel);
		menuSP.getVerticalScrollBar().setUnitIncrement(10);
		menuSP.setBounds(0, 120, 400, 390);
		menuSP.setBorder(null);

		previousBt2 = new JButton(" 뒤로 ");
		previousBt2.setBorderPainted(false);
		previousBt2.setFocusPainted(false);
		previousBt2.setBackground(dGreen);
		previousBt2.setForeground(white);
		previousBt2.addActionListener(mg);
		nextBt2 = new JButton(" 다음 ");
		nextBt2.setBorderPainted(false);
		nextBt2.setFocusPainted(false);
		nextBt2.setBackground(dGreen);
		nextBt2.setForeground(white);
		nextBt2.addActionListener(mg);
		previousBt2.setBounds(5, 520, 195, 52);
		nextBt2.setBounds(200, 520, 195, 52);

		JLabel buttomBG = new JLabel(new ImageIcon(getClass().getResource("/img/label_background.png")));
		buttomBG.setBounds(0, 515, 400, 80);
		menuFrame.add(selected_mname_lb);
		menuFrame.add(menuTxtlb);
		menuFrame.add(background);
		menuFrame.add(menuSP);
		menuFrame.add(previousBt2);
		menuFrame.add(nextBt2);
		menuFrame.add(buttomBG);
		mg.add(menuFrame);
	}
}
