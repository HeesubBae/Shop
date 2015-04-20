package shoeseholic.display;

import java.sql.Connection;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import shoeseholic.common.DBcon;
import shoeseholic.pop.Pop_ZipCodeBean;

public class DisplayDAO extends DBcon {
	public static void insertOracle(DisplayBeans info)
			throws SQLException {

		java.sql.Connection con = getOracleConnection();
		CallableStatement st =con.prepareCall("{call DISPLAY_INSERT(?,?,?,?,?)}");
		System.out.println("info c1="+info.getProduct_c1_code_idx());
		System.out.println("info c2="+info.getProduct_c2_code_idx());
		System.out.println("info seq="+info.getDisplay_seq());
        st.setInt(1, Integer.parseInt(info.getProduct_idx()));
        st.setInt(2, Integer.parseInt(info.getProduct_c3_code_idx()));
        st.setInt(3, Integer.parseInt(info.getProduct_c2_code_idx()));
        st.setInt(4, Integer.parseInt(info.getProduct_c1_code_idx()));
        st.setInt(5, Integer.parseInt(info.getDisplay_seq()));
		
		st.executeUpdate();
		System.out.println("업데이트 되었습니다.");
		st.close();
	}

	public void editGood(DisplayBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();

		String sql = " update display set product_idx=?,product_name=?,product_sell_price=?,product_thumtail_info=?,product_list_img=?,product_detail_info=?,product_main_img=?,product_c3_code_idx=?,product_point=?";
		sql += " where display_idx=?";

		PreparedStatement st = con.prepareStatement(sql);

		// //
		st.setString(1, info.getProduct_idx());
		st.setString(2, info.getProduct_name());
		st.setString(3, info.getProduct_sell_price());
		st.setString(4, info.getProduct_thumtail_info());
		st.setString(5, info.getProduct_list_img());
		st.setString(6, info.getProduct_detail_info());
		st.setString(7, info.getProduct_main_img());
		st.setString(8, info.getProduct_c3_code_idx());
		st.setString(9, info.getDisplay_idx());
		st.setString(10, info.getProduct_point());
		// /

		st.executeUpdate();
		st.close();
	}

	public DisplayBeans selectGood(String display_idx) throws SQLException {

		java.sql.Connection con = getOracleConnection();
		DisplayBeans bean = new DisplayBeans();
		try {
			// 2단계 : SQL 구문 실행
			String sql = "select * from display where display_idx=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, display_idx);
			ResultSet rs = pstmt.executeQuery(); // -- 처리한 결과
			// ResultSet rs=pstmt.executeUpdate()(); --s 처리한 갯수
			// System.out.println(sql);

			// 3단계 : 결과 처리
			if (rs.next()) {
				bean.setDisplay_idx(rs.getString("display_idx"));
				bean.setProduct_idx(rs.getString("product_idx"));
				bean.setProduct_name(rs.getString("product_name"));
				bean.setProduct_sell_price(rs.getString("product_sell_price"));
				bean.setProduct_thumtail_info(rs.getString("product_thumtail_info"));
				
				bean.setProduct_detail_info(rs.getString("product_detail_info"));
				bean.setProduct_list_img(rs.getString("product_list_img"));
				bean.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				bean.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				bean.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				bean.setProduct_main_img(rs.getString("product_main_img"));
				bean.setProduct_point(rs.getString("product_point"));
				bean.setDisplay_seq(rs.getString("display_seq"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4단계 : 닫기
		disconnect(con);
		return bean;

	}

	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList<DisplayBeans> getDBList(String product_c3_code_idx,
			String product_c2_code_idx, String product_c1_code_idx,
			String search_txt,int nowpage, int pagesize) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<DisplayBeans> datas = new ArrayList<DisplayBeans>();
		java.sql.Connection con = getOracleConnection();


		try {
			CallableStatement st=con.prepareCall("{call DISPLAY_SELECT_LIST(?,?,?,?,?,?,?)}");
			st.setInt(1,Integer.parseInt(product_c1_code_idx));
			st.setInt(2,Integer.parseInt(product_c2_code_idx));  
			st.setInt(3,Integer.parseInt(product_c3_code_idx));
			st.setString(4,search_txt);
			st.setInt(5,nowpage);
			st.setInt(6,pagesize);
			st.registerOutParameter(7,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(7);
			st.close();
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.

			while (rs.next()) {
				// System.out.println("why");
				DisplayBeans db = new DisplayBeans();

				// /////////////
				db.setDisplay_idx(rs.getString("display_idx"));
				db.setProduct_idx(rs.getString("product_idx"));
				db.setProduct_name(rs.getString("product_name"));
				db.setProduct_sell_price(rs.getString("product_sell_price"));
				db.setProduct_thumtail_info(rs.getString("product_thumtail_info"));
				db.setProduct_detail_info(rs.getString("product_detail_info"));
				db.setProduct_list_img(rs.getString("product_list_img"));
				db.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				db.setProduct_main_img(rs.getString("product_main_img"));
				db.setProduct_point(rs.getString("product_point"));
				db.setDisplay_seq(rs.getString("display_seq"));
				// ////////////

				db.setRNUM(rs.getString("RNUM"));
				db.setTOTCNT(rs.getString("TOT_CNT"));
				datas.add(db);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {

		}
		// 처리가 끝나 ArrayList 를 리턴함.
		return datas;
	}

	
	
	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList DISPLAY_SELECT_LIST_PRODCT_IDX(String product_idx) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<DisplayBeans> datas = new ArrayList<DisplayBeans>();
		java.sql.Connection con = getOracleConnection();
		
		try {
			CallableStatement st=con.prepareCall("{call DISPLAY_SELECT_LIST_PRODCT_IDX(?,?)}");
			int idx=Integer.parseInt(product_idx);
			st.setInt(1,idx);
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();
			
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.
			while (rs.next()) {
				DisplayBeans ob = new DisplayBeans(); 
				ob.setDisplay_idx(rs.getString("display_idx"));
				ob.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				ob.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				ob.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				ob.setProduct_c1_code_name(rs.getString("product_c1_code_name"));
				ob.setProduct_c2_code_name(rs.getString("product_c2_code_name"));
				ob.setProduct_c3_code_name(rs.getString("product_c3_code_name"));
				ob.setDisplay_seq(rs.getString("display_seq"));
				datas.add(ob);
			}
			rs.close();  

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {

		}
		// 처리가 끝나 ArrayList 를 리턴함.
		return datas;
	}

	public void Display_Update_CategoryAndSequence(DisplayBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();


		CallableStatement st =con.prepareCall("{call DISPLAY_UPDATE(?,?,?,?,?)}");
		System.out.println("info c1="+info.getProduct_c1_code_idx());
		System.out.println("info c2="+info.getProduct_c2_code_idx());
		System.out.println("info c3="+info.getProduct_c3_code_idx());
		System.out.println("info seq="+info.getDisplay_seq());
        st.setInt(1, Integer.parseInt(info.getDisplay_idx()));
        st.setInt(2, Integer.parseInt(info.getProduct_c3_code_idx()));
        st.setInt(3, Integer.parseInt(info.getProduct_c2_code_idx()));
        st.setInt(4, Integer.parseInt(info.getProduct_c1_code_idx()));
        st.setInt(5, Integer.parseInt(info.getDisplay_seq()));
		// /

		st.executeUpdate();
		st.close();
	}
	
	
	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList<DisplayBeans> SHOP_DISPLAY_SELECT_LIST(String product_c3_code_idx,
			String product_c2_code_idx, String product_c1_code_idx,
			String search_txt,int nowpage, int pagesize) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<DisplayBeans> datas = new ArrayList<DisplayBeans>();
		java.sql.Connection con = getOracleConnection();


		try {
			CallableStatement st=con.prepareCall("{call SHOP_DISPLAY_SELECT_LIST(?,?,?,?,?,?,?)}");
			st.setInt(1,Integer.parseInt(product_c1_code_idx));
			st.setInt(2,Integer.parseInt(product_c2_code_idx));  
			st.setInt(3,Integer.parseInt(product_c3_code_idx));
			st.setString(4,search_txt);
			st.setInt(5,nowpage);
			st.setInt(6,pagesize);
			st.registerOutParameter(7,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(7);
			st.close();
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.

			while (rs.next()) {
				// System.out.println("why");
				DisplayBeans db = new DisplayBeans();

				// /////////////
				db.setDisplay_idx(rs.getString("display_idx"));
				db.setProduct_idx(rs.getString("product_idx"));
				db.setProduct_name(rs.getString("product_name"));
				db.setProduct_sell_price(rs.getString("product_sell_price"));
				db.setProduct_thumtail_info(rs.getString("product_thumtail_info"));
				db.setProduct_detail_info(rs.getString("product_detail_info"));
				db.setProduct_list_img(rs.getString("product_list_img"));
				db.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				db.setProduct_main_img(rs.getString("product_main_img"));
				db.setProduct_point(rs.getString("product_point"));
				db.setDisplay_seq(rs.getString("display_seq"));
				// ////////////

				db.setRNUM(rs.getString("RNUM"));
				db.setTOTCNT(rs.getString("TOT_CNT"));
				datas.add(db);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		} finally {

		}
		// 처리가 끝나 ArrayList 를 리턴함.
		return datas;
	}	
}
