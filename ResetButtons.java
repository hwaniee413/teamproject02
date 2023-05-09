package pj2.customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class ResetButtons {
	MainGUI mg;
	
	ResetButtons(MainGUI mg){
		this.mg =mg;
	}

	void reset() { // 전체 버튼 리셋
		mg.sf.selcStoreTf.setText("");
		mg.sf.jtable.setSelectionBackground(new Color(255, 255, 204));
		mg.sf.jtable.setSelectionForeground(new Color(0, 0, 0));
		mg.mef.selected_mname_lb.setText("");
		mg.ord.ordered_mname_lb.setText("");
		mg.of.selected_bname_lb.setText("");
		mg.ord.ordered_bname_tf.setText("");
		mg.of.selected_cname_lb.setText("");
		mg.ord.ordered_cname_tf.setText("");
		mg.of.selected_vname_ta.setText("");
		mg.ord.ordered_vname_ta.setText("");
		mg.of.selected_sname_ta.setText("");
		mg.ord.ordered_sname_ta.setText("");
		mg.of.selected_smname_lb.setText("");
		mg.ord.ordered_smname_tf.setText("");
		mg.ord.storeNameInOrderFrame.setText("");
		mg.ord.storePhoneInOrderFrame.setText("");
		mg.ord.storeAddrInOrderFrame.setText("");

		int i = 0;
		for (JRadioButton jr : mg.bc.mRButtons) {
			mg.bc.mRButtons.get(i).setBackground(new Color(255, 255, 255));
			mg.bc.mRButtons.get(i).setForeground(new Color(0, 0, 0));
			mg.bc.bt1.setSelected(true); // 메뉴버튼 해제를 위해 논리적 버튼 하나를 체크
			i++;
		}
		int j = 0;
		for (JRadioButton jr : mg.bc.bRButtons) {
			mg.bc.bRButtons.get(j).setBackground(new Color(255, 255, 255));
			mg.bc.bRButtons.get(j).setForeground(new Color(0, 0, 0));
			mg.bc.bt2.setSelected(true); //
			j++;
		}
		int k = 0;
		for (JRadioButton jr :mg.bc.cRButtons) {
			mg.bc.cRButtons.get(k).setBackground(new Color(255, 255, 255));
			mg.bc.cRButtons.get(k).setForeground(new Color(0, 0, 0));
			mg.bc.bt3.setSelected(true); //
			k++;
		}
		int l = 0;
		for (JRadioButton jr : mg.bc.vRButtons) {
			mg.bc.vRButtons.get(l).setBackground(new Color(255, 255, 255));
			mg.bc.vRButtons.get(l).setForeground(new Color(0, 0, 0));
			mg.bc.vRButtons.get(l).setSelected(false);
			l++;
		}
		int m = 0;
		for (JRadioButton jr : mg.bc.sRButtons) {
			mg.bc.sRButtons.get(m).setBackground(new Color(255, 255, 255));
			mg.bc.sRButtons.get(m).setForeground(new Color(0, 0, 0));
			mg.bc.sRButtons.get(m).setSelected(false);
			m++;
		}
		int n = 0;
		for (JRadioButton jr : mg.bc.smRButtons) {
			mg.bc.smRButtons.get(n).setBackground(new Color(255, 255, 255));
			mg.bc.smRButtons.get(n).setForeground(new Color(0, 0, 0));
			mg.bc.bt4.setSelected(true); //
			n++;
		}
		mg.orderBt.setVisible(true);
		mg.ord.count=1;
		mg.ord.count_lb.setText(""+mg.ord.count);
	}

	public void resizeFontSize() {
		if (mg.ord.ordered_vname_ta.getText().length() > 10) {

			mg.ord.ordered_vname_ta.setFont(new Font(null, Font.BOLD, 12));
		} else {
			mg.ord.ordered_vname_ta.setFont(new Font(null, Font.BOLD, 16));
		}
		if (mg.ord.ordered_sname_ta.getText().length() > 14) {
			mg.ord.ordered_sname_ta.setFont(new Font(null, Font.BOLD, 11));
		} else {
			mg.ord.ordered_sname_ta.setFont(new Font(null, Font.BOLD, 16));
		}
	}

	void resetCheeseBt() {
		int k = 0;
		for (JRadioButton jr : mg.bc.cRButtons) {
			mg.bc.cRButtons.get(k).setBackground(new Color(255, 255, 255));
			mg.bc.cRButtons.get(k).setForeground(new Color(0, 0, 0));
			mg.bc.bt3.setSelected(true); //
			k++;
		}
		mg.of.selected_cname_lb.setText("치즈 제외");
		mg.ord.ordered_cname_tf.setText("치즈 제외");
	}

	void resetVegeBt() {
		int l = 0;
		for (JRadioButton jr : mg.bc.vRButtons) {
			mg.bc.vRButtons.get(l).setBackground(new Color(255, 255, 255));
			mg.bc.vRButtons.get(l).setForeground(new Color(0, 0, 0));
			mg.bc.vRButtons.get(l).setSelected(false);
			l++;
		}
		mg.of.selected_vname_ta.setText("모두 제외");
		mg.ord.ordered_vname_ta.setText("모두 제외");
	}

	void resetSauceBt() {
		int m = 0;
		for (JRadioButton jr : mg.bc.sRButtons) {
			mg.bc.sRButtons.get(m).setBackground(new Color(255, 255, 255));
			mg.bc.sRButtons.get(m).setForeground(new Color(0, 0, 0));
			mg.bc.sRButtons.get(m).setSelected(false);
			m++;
		}
		mg.of.selected_sname_ta.setText("모두 제외");
		mg.ord.ordered_sname_ta.setText("모두 제외");
	}

	void resetSetMenu() { // 세트메뉴만 선택 안 할 때: 세트메뉴 버튼 리셋
		int i = 0;
		for (Object ob : mg.bc.smRButtons) {
			mg.bc.smRButtons.get(i).setBackground(new Color(255, 255, 255));
			mg.bc.smRButtons.get(i).setForeground(new Color(0, 0, 0));
			mg.bc.bt4.setSelected(true);
			long l = Long.parseLong(mg.ord.amount_lb.getText());
			if (l == 7000) {
				l -= 2000;
				mg.ord.amount_lb.setText("" + l);
			}
			i++;
		}
		mg.of.selected_smname_lb.setText("단품");
		mg.ord.ordered_smname_tf.setText("단품");
	}
	

}
