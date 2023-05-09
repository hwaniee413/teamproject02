package pj2.dbhandle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Vector;

public class DBHandler {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt_isemail, pstmt_ispwd;//이메일, 비번 체크
	PreparedStatement pstmt_loginInfo; //로그인
	PreparedStatement pstmt_email2, pstmt_phone, pstmt_milg; //회원
	PreparedStatement pstmt_join; //회원가입
    PreparedStatement pstmt_loadmyinfo; //회원정보 가져오기
    PreparedStatement pstmt_update_nick, pstmt_update_pwd, pstmt_update_num; //회원 정보 수정
    PreparedStatement pstmt_withdraw;//회원탈퇴
    PreparedStatement pstmt_fcode, pstmt_menucode, pstmt_setcode; // 가맹점/메뉴/세트 코드 조회
    PreparedStatement pstmt_faddrbyword;
    PreparedStatement pstmt_insertDintoCart, pstmt_count_cart;
    PreparedStatement pstmt_chkSeqName, pstmt_pay, pstmt_updatePlusMilg, pstmt_updateMinusMilg;
    PreparedStatement pstmt_selectCartInfo, pstmt_isEmailinCart;
    PreparedStatement pstmt_payGoodsInCart, pstmt_deleteDfromCart;
    PreparedStatement pstmt_phColumn, pstmt_phRow, pstmt_isemail_pl;
	PreparedStatement pstmt7;
	
	ResultSet rs;

	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";

	SQL sql = new SQL();

	// 1. 드라이버연결
	public DBHandler() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "mimi", "mimi1234");
			stmt = con.createStatement();
			pstmt_isemail = con.prepareStatement(sql.select_email);
			pstmt_ispwd = con.prepareStatement(sql.select_pwd);
			pstmt_loginInfo = con.prepareStatement(sql.insert_loginInfo);
			pstmt_email2 = con.prepareStatement(sql.select_email); 
			pstmt_phone = con.prepareStatement(sql.select_phone);			
			pstmt_milg = con.prepareStatement(sql.select_milg); // 마일리지
			pstmt_join = con.prepareStatement(sql.insert_join); // 회원가입
			pstmt_loadmyinfo=con.prepareStatement(sql.select_myinfo);
			pstmt_withdraw = con.prepareStatement(sql.delete_all);//회원탈퇴
			pstmt_update_nick = con.prepareStatement(sql.update_nick);
			pstmt_update_pwd = con.prepareStatement(sql.update_pwd);
			pstmt_update_num = con.prepareStatement(sql.update_phone); // 휴대폰 번호 수정
			pstmt_fcode = con.prepareStatement(sql.select_fcode);
			pstmt_menucode = con.prepareStatement(sql.select_menucode);
			pstmt_setcode = con.prepareStatement(sql.select_setcode);
			pstmt_faddrbyword = con.prepareStatement(sql.select_faddrbyword);
			//pstmt_insertDintoCart = con.prepareStatement(sql.insertDintoCart); //카트에 넣기
			pstmt_isEmailinCart = con.prepareStatement(sql.select_emailinCart);
			pstmt_selectCartInfo = con.prepareStatement(sql.select_cartinfo);
			pstmt_payGoodsInCart = con.prepareStatement(sql.payGoodsInCart);
			pstmt_deleteDfromCart = con.prepareStatement(sql.deleteDfromCart); // 카트에서 제거
			pstmt_phColumn =con.prepareStatement(sql.select_phColumn);
			pstmt_phRow = con.prepareStatement(sql.select_phRow);
			pstmt_chkSeqName = con.prepareStatement(sql.check_seqName);
			pstmt_isemail_pl = con.prepareStatement(sql.select_emailinPaylog);
			pstmt_updatePlusMilg = con.prepareStatement(sql.updatePlusMilg);
			pstmt_updateMinusMilg = con.prepareStatement(sql.updateMinusMilg);
			//pstmt_pay = con.prepareStatement(sql.insert_intoPaylog);
			pln("connect");
		} catch (ClassNotFoundException cnfe) {
			pln("cnfe:" + cnfe);
		} catch (SQLException se) {
			pln("se: " + se);
		}
	}

	// "select EMAIL from MEMBER where EMAIL=?"
	public boolean isEmail(String email) {
		try {
			pstmt_isemail.setString(1, email);
			rs = pstmt_isemail.executeQuery();
			int i = 0;
			while (rs.next()) {
				i++;
				String email_id = rs.getString(i);
				if (email.equalsIgnoreCase(email_id)) {
					return true;
				}
			}
		} catch (SQLException se) {
		}
		return false;
	}

	// select PWD from MEMBER where PWD=? and EMAIL=?
	public boolean isPwd(String email, String pwd) {
		try {
			pstmt_ispwd.setString(1, pwd);
			pstmt_ispwd.setString(2, email);
			rs = pstmt_ispwd.executeQuery();
			int i = 0;
			while (rs.next()) {
				i++;
				String pwdb = rs.getString(1).trim();
				if (pwd.equals(pwdb)) {
					return true;
				}
			}
		} catch (SQLException se) {
		}
		return false;
	}
	// 로그인 시간 저장
	public void insertLoginInfo(String email) {
		try {
			pstmt_loginInfo.setString(1, email);
			int i = pstmt_loginInfo.executeUpdate();
			if (i > 0) {
				System.out.println("insertLoginInfo: " +i + "개의 row 변경 성공");
			} else {
				pln("입력 실패");
			}
		} catch (SQLException se) {
		}
	}
	// 회원 가입
	public boolean join(String email, String name, String pwd, String phone) {
		try {
			pstmt_join.setString(1, email);
			pstmt_join.setString(2, name);
			pstmt_join.setString(3, pwd);
			pstmt_join.setString(4, phone);
			int i = pstmt_join.executeUpdate();
			if(i>0) return true;
		} catch (SQLException se) {
			pln("se" + se);
		} finally {
		}
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException se2) {
		}
		return false;
	}
	//select NNAME, EMAIL, PWD, PHONE, MILG from MEMBER where EMAIL=?
	public Vector<String> getMyInfoFromMember(String email){
		Vector<String> myinfoList = new Vector<>();
		try {
			System.out.println(email);
			pstmt_loadmyinfo.setString(1, email);
			rs = pstmt_loadmyinfo.executeQuery();
			while(rs.next()) {
				String data1=rs.getString(1);
				String data2=rs.getString(2);
				String data3=rs.getString(3);
				String data4=rs.getString(4);
				String data5=rs.getString(5);
				myinfoList.add(data1);
				myinfoList.add(data2);
				myinfoList.add(data3);
				myinfoList.add(data4);
				myinfoList.add(data5);
			}
		}catch(SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {}
		}
		return myinfoList;
	}
	
	
	// 회원 닉네임, 비번 휴대폰번호 수정
	// update MEMBER set NNAME=? where EMAIL=?
	public boolean modifyNick(String email, String nname) {
		try {
			pstmt_update_nick.setString(1, nname);
			pstmt_update_nick.setString(2, email);
			int i = pstmt_update_nick.executeUpdate();
			if (i > 0) 
				return true;
		} catch (SQLException se) {}
		return false;
	}
	//update MEMBER set PWD=? where EMAIL=?;
	public boolean modifyPwd(String email, String pwd) {

		try {
			pstmt_update_pwd.setString(1, pwd);
			pstmt_update_pwd.setString(2, email);
			// 여기서 멈춤
			int i = pstmt_update_pwd.executeUpdate();
			if (i > 0) return true;
		} catch (SQLException se) {
			pln("modify_number:" + se);
		}
		return false;
	}
	public boolean modifyPhone(String email, String phone) {
		try {
			pstmt_update_num.setString(1, phone);
			pstmt_update_num.setString(2, email);
			// 여기서 멈춤
			int i = pstmt_update_num.executeUpdate();

			if (i > 0) return true;
			} catch (SQLException se) {}
		return false;
	}
	//회원탈퇴
	//delete from member where EMAIL=? and PWD=?
	public boolean withdraw(String email, String pwd) {
		try {
			pstmt_withdraw.setString(1, email);
			pstmt_withdraw.setString(2, pwd);
			int i = pstmt_withdraw.executeUpdate();
			if(i>0)
				return true;
		}catch(SQLException se) {}
		return false;
	}

	public Vector<String> getMenuName() {
		Vector<String> menuName = new Vector<>();
		String sql = "select MNAME from MENU";
		String str = null;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				str = rs.getString(1);
				menuName.add(str);
			}
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return menuName;
	}

	public Vector<Integer> getMenuCost() {
		Vector<Integer> menuCost = new Vector<>();
		String sql = "select MCOST from MENU";
		int cost = 0;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int i = rs.getInt(1);
				menuCost.add(i);
			}
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return menuCost;
	}

	public int countMenu() {
		String sql = "select count(MNAME) from MENU";
		int i = 0;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String str = rs.getString(1);
				i = Integer.parseInt(str);
			}
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return i;
	}
	public Vector<String> getSMenuName() {
		Vector<String> smenuName = new Vector<>();
		String sql = "select cookie from setmenu where scost='"+2000+"'";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String data1 = rs.getString(1);
				smenuName.add(data1);
			}
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return smenuName;
	}
	public Vector<Integer> getSMenuCost() {
		Vector<Integer> smenuCost = new Vector<>();
		String sql = "select SCOST from SETMENU";
		int cost = 0;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int i = rs.getInt(1);
				smenuCost.add(i);
			}
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return smenuCost;
	}

	public int countSMenu() {
		String sql = "select count(COOKIE) from SETMENU";
		int i = 0;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String str = rs.getString(1);
				i = Integer.parseInt(str);
			}
			
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return i;
	}
	public boolean isEmailinPaylog(String email) {
		try {
			pstmt_isemail_pl.setString(1, email);
			rs = pstmt_isemail_pl.executeQuery();
			int i = 0;
			while (rs.next()) {
				i++;
				String email_id = rs.getString(1);
				if (email.equalsIgnoreCase(email_id)) {
					return true;
				}
			}
		} catch (SQLException se) {
		}
		return false;
	}
	public Vector<String> getPaylogColumn(String email){
		Vector<String> plColumnNames = new Vector<>();
		try {
			pstmt_phColumn.setString(1, email);
			rs = pstmt_phColumn.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for (int i = 1; i <= cc; i++) {
				String cn = rsmd.getColumnName(i);
				plColumnNames.add(cn);
			}
		}catch(SQLException se) {
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return plColumnNames;	
	}
	public Vector<Vector<String>> getPlRow(String email) {
		Vector<Vector<String>> plRowData = new Vector<>();
		try {
			pstmt_phRow.setString(1, email);
			rs = pstmt_phRow.executeQuery();
			while (rs.next()) {
				String data1 = rs.getString(1);
				String data2 = rs.getString(2);
				String data3 = rs.getString(3);
				String data4 = rs.getString(4);
				//String data5 = rs.getString(5);
				Vector<String> vector = new Vector<>();
				vector.add(data1);
				vector.add(data2);
				vector.add(data3);
				vector.add(data4);
				plRowData.add(vector);
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return plRowData;
	}

	public Vector<String> getStoreColumnName() {
		Vector<String> columnNames = new Vector<String>();
		try {
			String sql = "select FNAME 가맹점명, FADDR 주소, FPHONE2 매장번호 from FRANCHISE";
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int cc = rsmd.getColumnCount();
			for (int i = 1; i <= cc; i++) {
				String cn = rsmd.getColumnName(i);
				columnNames.add(cn);
			}

		} catch (SQLException se) {
			pln("SQLException: " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return columnNames;
	}

	public Vector<Vector<String>> getStoreRowData() {
		String sql = "select FNAME, FADDR, FPHONE2 from FRANCHISE";
		Vector<Vector<String>> rowData = new Vector<>();
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String data1 = rs.getString(1);
				String data2 = rs.getString(2);
				String data3 = rs.getString(3);
				Vector<String> vector = new Vector<>();
				vector.add(data1);
				vector.add(data2);
				vector.add(data3);
				rowData.add(vector);
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return rowData;
	}
	// 콤보박스에서 지역 선택시 해당 지역만 JTable에 표시되도록
	public Vector<Vector<String>> reselectStoreInfo(String str) {
		String sql = "select FNAME 가맹점명, FADDR 주소, FPHONE2 매장번호 from FRANCHISE where FADDR like '%" + str + "%'";
		Vector<Vector<String>> rowData = new Vector<>();
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String data1 = rs.getString(1);
				String data2 = rs.getString(2);
				String data3 = rs.getString(3);
				Vector<String> vector = new Vector<>();
				vector.add(data1);
				vector.add(data2);
				vector.add(data3);
				rowData.add(vector);
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return rowData;
	}
	// 가맹점 검색 textfield에서 키이벤트 발생할 때마다
	public Vector<Vector<String>> selectFaddr(String str) {
		Vector<Vector<String>> rowData = new Vector<>();
		try {
			pstmt_faddrbyword.setString(1, "%"+str+"%");
			rs = pstmt_faddrbyword.executeQuery();
			while(rs.next()) {
				String data1 = rs.getString(1);
				String data2 = rs.getString(2);
				String data3 = rs.getString(3);
				Vector<String> vector = new Vector<>();
				vector.add(data1);
				vector.add(data2);
				vector.add(data3);
				rowData.add(vector);
			}
		}catch(SQLException se) {
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return rowData;
	}
	// select FCODE from franchise where FNAME=?
	public long getFCodeFromFranchise(String fname) {
		try {
			pstmt_fcode.setString(1, fname);
			rs = pstmt_fcode.executeQuery();
			if (rs.next()) {
				long fcode = rs.getLong(1);
				return fcode;
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return 0;
	}

	// select MCODE from MENU where MNAME=?
	public int getMCodeFromMenu(String menuname) {
		try {
			pstmt_menucode.setString(1, menuname);
			rs = pstmt_menucode.executeQuery();
			if (rs.next()) {
				int menucode = rs.getInt(1);
				return menucode;
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return 0;
	}

	// select SCODE from SETMENU where COOKIE=?
	public int getSCodeFromSet(String cookie) {
		try {
			pstmt_setcode.setString(1, cookie);
			rs = pstmt_setcode.executeQuery();
			if (rs.next()) {
				int setcode = rs.getInt(1);
				return setcode;
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return 0;
	}
	//카트에 있는 내 상품 불러오기 위해- ButtonsControl에서 사용
	public boolean isEmailinCart(String email) {
		try {
			pstmt_isEmailinCart.setString(1, email);
			rs = pstmt_isEmailinCart.executeQuery();
			while(rs.next()) {
				String data = rs.getString(1);
				if(email.equalsIgnoreCase(data)) {
					return true;
				}
			}
		}catch(SQLException se) {
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return false;
	}
	public boolean checkSeqName(String seqID) {
		String str = "CARTSEQ_"+seqID.toUpperCase();
		pln("checkSeqName():" + str);
		try {
			pstmt_chkSeqName.setString(1, seqID);
			rs = pstmt_chkSeqName.executeQuery();
			while(rs.next()) {
				String data = rs.getString(1);
				pln("checkSeqName():" +data);
				if(str.equalsIgnoreCase(data)) {
					return true;
				}
			}
		} catch (SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return false;
	}
	public void createSEQ(String seqID) {
		String seqSql = "create sequence CARTSEQ_"+ seqID.toUpperCase() + " start with 1 increment by 1 nocache";
		try {
			stmt.execute(seqSql);
			pln(seqSql+"\n 테이블 생성 완료");
		}catch(SQLException se) {
			pln("시퀀스 테이블 생성 실패");
		}
	}
	public void dropSEQ(String seqID) {
		String seqSql = "drop sequence CARTSEQ_"+ seqID.toUpperCase();
		try {
			boolean f = stmt.execute(seqSql);
			if(f) {
				pln("CARTSEQ_"+ seqID.toUpperCase()+" 시퀀스 삭제 완료");
			} else {
				pln("삭제할 CARTSEQ_"+ seqID.toUpperCase()+" 시퀀스가 없음");
			}
		}catch(SQLException se) {
			pln(seqSql+" 테이블 삭제 실패");
		}
		
	}
	//"insert into CART values(CARTSEQ_"+ seqID + ", '" + fcode + ",'" + email + "', " + menucode + ", '" + bread + "', '"
	//+ cheese + "', '" + vege + "', '" + sauce + "', " + setcode + ", " + quantity + ", " + amount
	//+ ")";
	public boolean insertDataIntoCart(long fcode, String email, int menucode, String bread, String cheese, String vege,
			String sauce, int setcode, int quantity, long amount, String seqID) {
		try {
			if(!isEmailinCart(email)) {
				dropSEQ(seqID.toUpperCase());
				createSEQ(seqID.toUpperCase());
			} 
			String sql = "insert into CART values(CARTSEQ_"+ seqID.toUpperCase() + ".nextval, " + fcode + ",'" + email + "', " + menucode + ", '" + bread + "', '"
					+ cheese + "', '" + vege + "', '" + sauce + "', " + setcode + ", " + quantity + ", " + amount
					+ ")";
			pln(sql);
			int i = stmt.executeUpdate(sql);
			if (i > 0) {
				return true;
			} 	
		} catch (SQLException se) {}
		return false;
	}
	public LinkedHashMap<Integer, Vector<String>> getCartInfo(String email){
		LinkedHashMap<Integer, Vector<String>> rowDataInCart = new LinkedHashMap<>();
		try {
			pstmt_selectCartInfo.setString(1, email);
			rs = pstmt_selectCartInfo.executeQuery();
			while(rs.next()) {
				int cartno = rs.getInt(1);
				String fname = rs.getString(2);
				String mname = rs.getString(3);
				String smname = rs.getString(4);
				String quantity = rs.getString(5);
				String amount = rs.getString(6);
				Vector<String> vector = new Vector<>();
				vector.add(fname);
				vector.add(mname);
				vector.add(smname);
				vector.add(quantity);
				vector.add(amount);
				rowDataInCart.put(cartno, vector);
			}	
			pln("dbh.getCartInfo: " + rowDataInCart);
		}catch(SQLException se) {
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return rowDataInCart;
	}
	public int countCart(String email) {
		String sql = "select count(email) from cart where email='"+email+"'";
		int i=0;
		try {
			rs =stmt.executeQuery(sql);
			if(rs.next())
				i = rs.getInt(1);
		
		}catch(SQLException se) {
		}
		return i;
	}
	// 장바구니에 있는 상품 불러와서 결제창에 보여주기
	public LinkedHashMap<Integer, Vector<String>> getAllinCart(String email, int cartno){
		LinkedHashMap<Integer, Vector<String>> rowDataInCart = new LinkedHashMap<>();
		try {
			pstmt_payGoodsInCart.setString(1, email);
			pstmt_payGoodsInCart.setInt(2, cartno);
			rs = pstmt_payGoodsInCart.executeQuery();
			while(rs.next()) {
				int cno = rs.getInt(1);
				String fname = rs.getString(2);
				String mname = rs.getString(3);
				String bread = rs.getString(4);
				String cheese = rs.getString(5);
				String vegetable= rs.getString(6);
				String seasoning = rs.getString(7);
				String sname = rs.getString(8);
				String quantity = rs.getString(9);
				String amount = rs.getString(10);
				Vector<String> vector = new Vector<>();
				vector.add(fname);
				vector.add(mname);
				vector.add(bread);
				vector.add(cheese);
				vector.add(vegetable);
				vector.add(seasoning);
				vector.add(sname);
				vector.add(quantity);
				vector.add(amount);
				rowDataInCart.put(cno, vector);
			}
			pln("dbh/payGinCart: "+ rowDataInCart);
		}catch(SQLException se) {	
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
			}
		}
		return rowDataInCart;
	}
	// 위에 것 결제 완료되면 호출..
	public boolean deleteDataFromCart(String email, int seqno) {
		try {
			pstmt_deleteDfromCart.setString(1, email);
			pstmt_deleteDfromCart.setInt(2, seqno);
			int i = pstmt_deleteDfromCart.executeUpdate();
			if(i>0) {
				return true;
			}
			
		}catch(SQLException se) {
		}
		return false;
	}

	// select count(EMAIL) from CART where EMAIL=?
	public int countCartNo(String email) {
		int i = 0;
		try {
			pstmt_count_cart.setString(1, email);
			rs = pstmt_count_cart.executeQuery();
			if (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (SQLException se) {
			pln("countMenu(): " + se);
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return i;
	}
	
	public boolean insertDintoPaylog(long fcode, String email, int menucode, String bread, String cheese, String vege,
		String sauce, int setcode, int quantity, long amount, int pcode) {
		try {
			String sql = "insert into PAYLOG values(pay_seq.nextval,"+ fcode + ",'" + email + "', " + menucode + ", '" + bread + "', '"
					+ cheese + "', '" + vege + "', '" + sauce + "', " + setcode + ", " + quantity + ", " + amount+", " +pcode
					+ ", current_timestamp)";
			int i =stmt.executeUpdate(sql);
			if(i>0) {
				return true;
			}
		}catch(SQLException se) {	
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return false;
	}
	
	public boolean updatePlusMilg(String email, long modifiedMilg) {
		try {
			pstmt_updatePlusMilg.setString(2, email);
			pstmt_updatePlusMilg.setLong(1, modifiedMilg);
			int i = pstmt_updatePlusMilg.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch(SQLException se) {
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return false;
	}
	public boolean updateMinusMilg(String email, long modifiedMilg) {
		try {
			pstmt_updateMinusMilg.setString(2, email);
			pstmt_updateMinusMilg.setLong(1, modifiedMilg);
			int i = pstmt_updateMinusMilg.executeUpdate();
			if(i>0) {
				return true;
			}
		}catch(SQLException se) {
		}finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException see) {
			}
		}
		return false;
	}
	public void closeAll() {
		try {
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException se) {

		}
	}

	public void pln(String str) {
		System.out.println(str);
	}

	public void p(String str) {
		System.out.print(str);
	}

}
