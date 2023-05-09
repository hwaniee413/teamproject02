package pj2.customer;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControlView {

	MainGUI mg;

	ControlView(MainGUI mg) {
		this.mg = mg;
	}

	// 로그인/내정보/정보수정 제어
	public void chgMyInfoToLogin() {// 로그인 하기 전
		// 로그인관련 레이블들 가시화
		mg.mif.emailLb.setVisible(true);
		mg.mif.emailTf.setVisible(true);
		mg.mif.pwdLb.setVisible(true);
		mg.mif.pwdTf.setVisible(true);
		mg.mif.logInBt.setVisible(true);
		mg.mif.signUpBt.setVisible(true);
		// 내정보 관련 컴포넌트들 비가시화
		mg.mif.avatar.setVisible(false);
		mg.mif.nicknameLb_myinfo.setVisible(false);
		mg.mif.emailLb_myinfo.setVisible(false);
		mg.mif.mileagelb.setVisible(false);
		mg.mif.mileageLb_myinfo.setVisible(false);
		mg.mif.won.setVisible(false);
		mg.mif.modifyingBt.setVisible(false);
		mg.mif.logoutBt.setVisible(false);
		// 정보수정 컴포넌트들 비가시화
		mg.mif.jtp.setVisible(false);
	}

	public void chgLoginToMyInfo() { // 로그인 후 간단한 정보표시
		// 로그인관련 컴포넌트들 비가시화
		mg.mif.emailLb.setVisible(false);
		mg.mif.emailTf.setVisible(false);
		mg.mif.pwdLb.setVisible(false);
		mg.mif.pwdTf.setVisible(false);
		mg.mif.logInBt.setVisible(false);
		mg.mif.signUpBt.setVisible(false);
		// 내 정보 컴포턴드들 비가시화
		mg.mif.avatar.setVisible(true);
		mg.mif.nicknameLb_myinfo.setVisible(true);
		mg.mif.emailLb_myinfo.setVisible(true);
		mg.mif.mileagelb.setVisible(true);
		mg.mif.mileageLb_myinfo.setVisible(true);
		mg.mif.won.setVisible(true);
		mg.mif.modifyingBt.setVisible(true);
		mg.mif.logoutBt.setVisible(true);
		// 정보수정 컴포넌트들 비가시화
		mg.mif.jtp.setVisible(false);
	}

	public void chgMyInfoToModifying() { // 정보표시->정보수정
		// 로그인관련 레이블들 가시화
		mg.mif.emailLb.setVisible(false);
		mg.mif.emailTf.setVisible(false);
		mg.mif.pwdLb.setVisible(false);
		mg.mif.pwdTf.setVisible(false);
		mg.mif.logInBt.setVisible(false);
		mg.mif.signUpBt.setVisible(false);
		// 내정보 관련 컴포넌트들 비가시화
		mg.mif.avatar.setVisible(false);
		mg.mif.nicknameLb_myinfo.setVisible(false);
		mg.mif.emailLb_myinfo.setVisible(false);
		mg.mif.mileagelb.setVisible(false);
		mg.mif.mileageLb_myinfo.setVisible(false);
		mg.mif.won.setVisible(false);
		mg.mif.modifyingBt.setVisible(false);
		mg.mif.logoutBt.setVisible(false);
		// 정보수정 컴포넌트들 가시화
		mg.mif.jtp.setVisible(true);
	}

	public void chgModifyingToMyInfo() {
		// 내정보 관련 컴포넌트들 가시화
		mg.mif.avatar.setVisible(true);
		mg.mif.nicknameLb_myinfo.setVisible(true);
		mg.mif.emailLb_myinfo.setVisible(true);
		mg.mif.mileagelb.setVisible(true);
		mg.mif.mileageLb_myinfo.setVisible(true);
		mg.mif.won.setVisible(true);
		mg.mif.modifyingBt.setVisible(true);
		mg.mif.logoutBt.setVisible(true);
		// 정보수정 컴포넌트들 비가시화
		mg.mif.jtp.setVisible(false);
	}

	public void chgSelcInfoToPayInfo() {
		// 요약정보, 결제정보 패널 가시화
		mg.ord.summaryPn.setVisible(true);
		mg.ord.payPanel.setVisible(true);
		mg.ord.payBt.setVisible(true);
		// 선택사항 확인 컴포넌트 비가시화
		mg.ord.title_bar_lb1.setVisible(false);
		mg.ord.ordered_mtitle_lb.setVisible(false);
		mg.ord.ordered_btitle_lb.setVisible(false);
		mg.ord.ordered_ctitle_lb.setVisible(false);
		mg.ord.ordered_vtitle_lb.setVisible(false);
		mg.ord.ordered_stitle_lb.setVisible(false);
		mg.ord.ordered_smtitle_lb.setVisible(false);
		mg.ord.storeName.setVisible(false);
		mg.ord.storeNameInOrderFrame.setVisible(false);
		mg.ord.amount_title_lb.setVisible(false);
		mg.ord.amount_lb.setVisible(false);
		mg.ord.minusBt.setVisible(false);
		mg.ord.count_lb.setVisible(false);
		mg.ord.plusBt.setVisible(false);
		mg.ord.count_lb1.setVisible(false);
		mg.ord.buttomBG.setVisible(false);
		mg.ord.jsp1.setVisible(false);
		mg.ord.jsp2.setVisible(false);
		mg.ord.ordered_mname_lb.setVisible(false);
		mg.ord.ordered_smname_tf.setVisible(false);
		mg.ord.ordered_bname_tf.setVisible(false);
		mg.ord.ordered_cname_tf.setVisible(false);
		mg.ord.ordered_sname_ta.setVisible(false);
		mg.ord.ordered_vname_ta.setVisible(false);
		mg.ord.cancelBtInFrame.setVisible(false);
		mg.ord.basketBtInFrame.setVisible(false);
		mg.ord.orderBtInFrame.setVisible(false);
		mg.orderBt.setVisible(false);
	}

	public void chgPayInfoToSelcInfo() {
		// 요약정보, 결제정보 패널 비가시화
		mg.ord.summaryPn.setVisible(false);
		mg.ord.payPanel.setVisible(false);
		mg.ord.payBt.setVisible(false);
		// 선택사항 확인 컴포넌트 가시화
		mg.ord.title_bar_lb1.setVisible(true);
		mg.ord.ordered_mtitle_lb.setVisible(true);
		mg.ord.ordered_btitle_lb.setVisible(true);
		mg.ord.ordered_ctitle_lb.setVisible(true);
		mg.ord.ordered_vtitle_lb.setVisible(true);
		mg.ord.ordered_stitle_lb.setVisible(true);
		mg.ord.ordered_smtitle_lb.setVisible(true);
		mg.ord.storeName.setVisible(true);
		mg.ord.storeNameInOrderFrame.setVisible(true);
		mg.ord.amount_title_lb.setVisible(true);
		mg.ord.amount_lb.setVisible(true);
		mg.ord.minusBt.setVisible(true);
		mg.ord.count_lb.setVisible(true);
		mg.ord.plusBt.setVisible(true);
		mg.ord.count_lb1.setVisible(true);
		mg.ord.buttomBG.setVisible(true);
		mg.ord.jsp1.setVisible(true);
		mg.ord.jsp2.setVisible(true);
		mg.ord.ordered_mname_lb.setVisible(true);
		mg.ord.ordered_smname_tf.setVisible(true);
		mg.ord.ordered_bname_tf.setVisible(true);
		mg.ord.ordered_cname_tf.setVisible(true);
		mg.ord.ordered_sname_ta.setVisible(true);
		mg.ord.ordered_vname_ta.setVisible(true);
		mg.ord.cancelBtInFrame.setVisible(true);
		mg.ord.basketBtInFrame.setVisible(true);
		mg.ord.orderBtInFrame.setVisible(true);
		mg.orderBt.setVisible(true);
	}

	public void pln(String str) {
		System.out.println(str);
	}
}
