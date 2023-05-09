package pj2.dbhandle;

public class SQL {
	//이메일 비번 일치
	public final String select_email="select EMAIL from MEMBER where EMAIL=?";
	public final String select_pwd="select PWD from MEMBER where PWD=? and EMAIL=?";
	//로그인 기록
	public final String insert_loginInfo="insert into LOGININFO(EMAIL, LOGINDATE) values (?, current_timestamp)";
	//회원가입
	public final String insert_join="insert into MEMBER values (MEMBER_SEQ.nextval, ?, ?, ?, ?, SYSDATE,0)";
	// 회원정보 조회
	public final String select_myinfo="select NNAME, EMAIL, PWD, PHONE, MILG from MEMBER where EMAIL=?";
	//회원정보수정
	public final String update_nick="update MEMBER set NNAME=? where EMAIL=?";
	public final String update_pwd="update MEMBER set PWD=? where EMAIL=?";
	public final String update_phone="update MEMBER set PHONE=? where EMAIL=?";
	//회원탈퇴
	public final String delete_all = "delete from member where EMAIL=? and PWD=?";
	
	public final String select_nname="select NNAME from MEMBER where EMAIL=?"; 
	public final String select_login="select PWD from MEMBER where EMAIL=?";
	public final String select_phone="select PHONE from MEMBER where PHONE=?";
	public final String select_milg="select MILG from MEMBER where EMAIL=?";
	//가맹점 코드, 메뉴코드, 세트코드 조회
	public final String select_fcode= "select FCODE from franchise where FNAME=?";
	public final String select_menucode="select MCODE from MENU where MNAME=?";
	public final String select_setcode="select SCODE from SETMENU where COOKIE=?";
	public final String select_faddrbyword="select FNAME, FADDR, FPHONE2 from franchise where faddr like ? order by fcode";
	//장바구니 입력
	public final String check_seqName="select sequence_name from user_sequences where sequence_name=CARTSEQ_?";
	//public final String insertDintoCart ="insert into CART values(?,?,?,?,?,?,?,?,?,?)";
	//장바구니에서 데이터 가져오기
	public final String select_emailinCart = "select email from cart where email =?";
	public final String select_cartinfo ="select cartno, '매장:'||fname, '메뉴:'||mname, cookie||'세트', quantity, amount from CART natural join franchise natural join menu natural join setmenu where email=? order by cartno";
	
	//public final String select_cartinfo ="select '매장:'||fname, '메뉴:'||mname, cookie||' 세트', quantity||'개', amount||'원' from CART natural join franchise natural join menu natural join setmenu where email=? order by cartno";
	//결제
	public final String insert_intoPaylog="insert into PAYLOG values(pay_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,current_timestamp)";
	public final String insertDataIntoPaylog ="insert into CART values(?,?,?,?,?,?,?,?,?,?)";
	public final String updatePlusMilg="update MEMBER set MILG=MILG+? where email=?";
	public final String updateMinusMilg="update MEMBER set MILG=MILG-? where email=?";
	// 장바구니 데이터 삭제
	public final String payGoodsInCart ="select cartno, fname, mname, bread, cheese, vegetable, seasoning, cookie, quantity, amount from cart natural join franchise natural join menu natural join setmenu where email=? and cartno=? order by cartno";
	public final String deleteDfromCart = "delete from cart where email =? and cartno=?";
	//...
	//결제 내역
	public final String select_emailinPaylog = "select email from PAYLOG where email =?";
	public final String select_phColumn="select pdate 결제일시, payseq 주문번호, amount 결제금액, pname 결제방법 from paylog natural join payment natural join franchise where email=?";
	public final String select_phRow="select to_char(pdate, 'yyyy-mm-dd AM HH:MI:SS') 결제일시, 'M00'||payseq 주문번호, amount||'원' 결제금액, pname 결제방법 from paylog natural join payment natural join franchise where email=? order by pdate";
	public final String select_countCart="select count(EMAIL) from CART where EMAIL=?";
	
	
}
