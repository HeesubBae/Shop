package shoeseholic.good;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import oracle.jdbc.OracleTypes;

import shoeseholic.common.DBcon;
import shoeseholic.display.DisplayBeans;

public class GoodDAO extends DBcon {

	public static void insertOracle(GoodBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();
		String sql = "insert into product(product_idx,product_name,product_sell_price,product_make_price,product_count,product_thumtail_info,product_detail_info,product_list_img,product_process_idx,product_c3_code_idx,product_c2_code_idx,product_c1_code_idx,product_main_img,product_point)";
		sql += " values(?,?,?,?,?,?,?,?,1,?,?,?,?)";
		insert(con, sql, info);

	}

	public static void insert(Connection con, String sql, GoodBeans info)
			throws SQLException {
		CallableStatement st =con.prepareCall("{call PRODUCT_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	
		// sequence not used
		st.setString(1, info.getProduct_name());
		st.setInt(2, Integer.parseInt(info.getProduct_sell_price()));
		st.setInt(3, Integer.parseInt(info.getProduct_make_price()));
		st.setInt(4, Integer.parseInt(info.getProduct_count()));
		st.setString(5, info.getProduct_thumtail_info());
		st.setString(6, info.getProduct_detail_info());
		st.setString(7, info.getProduct_list_img());
		st.setInt(8, Integer.parseInt(info.getProduct_c3_code_idx()));
		st.setInt(9, Integer.parseInt(info.getProduct_c2_code_idx()));
		st.setInt(10, Integer.parseInt(info.getProduct_c1_code_idx()));
		st.setString(11, info.getProduct_main_img());
		st.setInt(12, Integer.parseInt(info.getProduct_point()));
		st.setInt(13, Integer.parseInt(info.getStaff_idx()));

		
		st.executeUpdate();
		st.close();
	}

	public void editGood(GoodBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();

		CallableStatement st =con.prepareCall("{call PRODUCT_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		st.setString(1, info.getProduct_idx());
		st.setString(2, info.getProduct_name());
		st.setInt(3, Integer.parseInt(info.getProduct_sell_price()));
		st.setInt(4, Integer.parseInt(info.getProduct_make_price()));
		st.setInt(5, Integer.parseInt(info.getProduct_count()));
		st.setString(6, info.getProduct_thumtail_info());
		st.setString(7, info.getProduct_detail_info());
		st.setString(8, info.getProduct_list_img());
		st.setInt(9, Integer.parseInt(info.getProduct_process_idx()));
		st.setInt(10, Integer.parseInt(info.getProduct_c3_code_idx()));
		st.setInt(11, Integer.parseInt(info.getProduct_c2_code_idx()));
		st.setInt(12, Integer.parseInt(info.getProduct_c1_code_idx()));
		st.setString(13, info.getProduct_main_img());
		st.setInt(14,Integer.parseInt(info.getProduct_point()));
		st.setInt(15, Integer.parseInt(info.getStaff_idx()));
		
		st.executeUpdate();
		st.close();
	}

	public GoodBeans selectGood(String product_idx) throws SQLException {

		java.sql.Connection con = getOracleConnection();
		GoodBeans bean = new GoodBeans();
		try {
			// 2단계 : SQL 구문 실행
			String sql = "select * from product where product_idx =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_idx);
			ResultSet rs = pstmt.executeQuery(); // -- 처리한 결과

			// 3단계 : 결과 처리
			if (rs.next()) {
				bean.setProduct_idx(rs.getString("product_idx"));
				bean.setProduct_name(rs.getString("product_name"));
				bean.setProduct_sell_price(rs.getString("product_sell_price"));
				bean.setProduct_make_price(rs.getString("product_make_price"));
				bean.setProduct_count(rs.getString("product_count"));
				bean.setProduct_thumtail_info(rs.getString("product_thumtail_info"));
				bean.setProduct_detail_info(rs.getString("product_detail_info"));
				bean.setProduct_list_img(rs.getString("product_list_img"));
				bean.setProduct_process_idx(rs.getString("product_process_idx"));
				bean.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				bean.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				bean.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				bean.setProduct_main_img(rs.getString("product_main_img"));
				bean.setProduct_point(rs.getString("product_point"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4단계 : 닫기
		disconnect(con);
		return bean;
	}

	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList getDBList(String product_c3_code_idx,
			String product_c2_code_idx, String product_c1_code_idx,
			String product_process_idx, String search_txt, int nowpage, int pagesize) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<GoodBeans> datas = new ArrayList<GoodBeans>();
		java.sql.Connection con = getOracleConnection();


		try {
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.				
			CallableStatement st=con.prepareCall("{call PRODUCT_SELECT_LIST(?,?,?,?,?,?,?,?)}");
			st.setInt(1,Integer.parseInt(product_c1_code_idx));
			st.setInt(2,Integer.parseInt(product_c2_code_idx));  
			st.setInt(3,Integer.parseInt(product_c3_code_idx));
			st.setInt(4,Integer.parseInt(product_process_idx));
			st.setString(5,search_txt);
			st.setInt(6,nowpage);
			st.setInt(7,pagesize);
			st.registerOutParameter(8,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(8);
			st.close();
			
			
			while (rs.next()) {
				GoodBeans gb = new GoodBeans();

				gb.setProduct_idx(rs.getString("product_idx"));
				gb.setProduct_process_idx(rs.getString("product_process_idx"));
				gb.setProduct_name(rs.getString("product_name"));
				gb.setProduct_sell_price(rs.getString("product_sell_price"));
				gb.setProduct_make_price(rs.getString("product_make_price"));
				gb.setProduct_count(rs.getString("product_count"));
				gb.setProduct_thumtail_info(rs.getString("product_thumtail_info"));
				gb.setProduct_detail_info(rs.getString("product_detail_info"));
				gb.setProduct_list_img(rs.getString("product_list_img"));
				gb.setProduct_process_idx(rs.getString("product_process_idx"));
				gb.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				gb.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				gb.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				gb.setProduct_main_img(rs.getString("product_main_img"));
				gb.setProduct_point(rs.getString("product_point"));
				gb.setRNUM(rs.getString("RNUM"));
				gb.setTOTCNT(rs.getString("TOT_CNT"));
				datas.add(gb);

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
	public ArrayList PRODUCT_PROCESS_LOG_SELECT(String product_idx) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<Good_process_log_Beans> datas = new ArrayList<Good_process_log_Beans>();
		java.sql.Connection con = getOracleConnection();
		
		try {
			CallableStatement st=con.prepareCall("{call PRODUCT_PROCESS_LOG_SELECT(?,?)}");
			int idx=Integer.parseInt(product_idx);
			st.setInt(1,idx);
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();
			
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.
			while (rs.next()) {
				Good_process_log_Beans ob = new Good_process_log_Beans(); 
				ob.setProduct_process_log_idx(rs.getString("product_process_log_idx"));
				ob.setBefore_product_process_idx(rs.getString("before_product_process_idx"));
				ob.setAfter_product_process_idx(rs.getString("after_product_process_idx"));
				ob.setProduct_process_log_hiredate(rs.getString("product_process_log_hiredate"));
				ob.setStaff_idx(rs.getString("staff_idx"));
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
}
