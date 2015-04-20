package shoeseholic.order;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import oracle.jdbc.*;
import shoeseholic.common.DBcon;
import shoeseholic.member.MemberBeans;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import shoeseholic.common.DBcon;

public class OrderDAO extends DBcon {

	public static void insertOracle(OrderBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();
		// test version
		String sql = "insert into orders(order_idx,member_idx,order_name,order_zipcode,order_addr1,order_mobile,order_phone,order_comment,order_process_idx,order_type_idx,order_hiredate,order_addr2)";
		sql += "values(?,?,?,?,?,?,?,?,?,?,sysdate,?)";

		insert(con, sql, info);

	}

	public static void insert(Connection con, String sql, OrderBeans info)
			throws SQLException {
		PreparedStatement st = con.prepareStatement(sql);
		
		/// test version
		st.setString(1, info.getOrder_idx());
		st.setString(2, info.getMember_idx());
		st.setString(3, info.getOrder_name());
		st.setString(4, info.getOrder_zipcode());
		st.setString(5, info.getOrder_addr1());
		st.setString(6, info.getOrder_mobile());
		st.setString(7, info.getOrder_phone());
		st.setString(8, info.getOrder_comment());
		st.setString(9, info.getOrder_process_idx());
		st.setString(10, info.getOrder_type_idx());
		//st.setString(11, info.getOrder_hiredate());
		st.setString(11, info.getOrder_addr2());
		///
		
		st.executeUpdate();
		st.close();
	}

	public static void insertOracle2(OrderBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();

		
		   ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("NUM_ARRAY", con);
		   ARRAY array_to_pass = new ARRAY(descriptor, con, info.getProduct_idx_array());
		   ARRAY array_to_pass2 = new ARRAY(descriptor, con, info.getORDER_PRODUCT_COUNT());
		   ARRAY array_to_pass3 = new ARRAY(descriptor, con, info.getORDER_PRODUCT_SELL_PRICE());
		   ARRAY array_to_pass4 = new ARRAY(descriptor, con, info.getORDER_PRODUCT_POINT());
		   
		   CallableStatement cstmt =con.prepareCall("{call order_insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		   cstmt.setInt(1,Integer.parseInt(info.getMember_idx()));
		   cstmt.setString(2,info.getOrder_name());
		   cstmt.setString(3,info.getOrder_zipcode());
		   cstmt.setString(4,info.getOrder_addr1());
		   cstmt.setString(5,info.getOrder_addr2());
		   cstmt.setString(6,info.getOrder_mobile());
		   cstmt.setString(7,info.getOrder_phone());
		   cstmt.setString(8,info.getOrder_comment());
		   cstmt.setInt(9,Integer.parseInt(info.getOrder_type_idx()));
		   cstmt.setInt(10,Integer.parseInt(info.getOrder_price()));
		   cstmt.setInt(11,Integer.parseInt(info.getOrder_point()));
		   cstmt.setArray(12,array_to_pass);
		   cstmt.setArray(13,array_to_pass2);
		   cstmt.setArray(14,array_to_pass3);
		   cstmt.setArray(15,array_to_pass4);
		   cstmt.executeQuery();
	}	
	
	
	public void editBeans(OrderBeans info) throws SQLException {
		java.sql.Connection con = getOracleConnection();
		
		CallableStatement st =con.prepareCall("{call ORDER_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		st.setString(1, info.getOrder_idx());
		st.setString(2, info.getMember_idx());
		st.setString(3, info.getOrder_name());
		st.setString(4, info.getOrder_zipcode());
		st.setString(5, info.getOrder_addr1());
		st.setString(6, info.getOrder_mobile());
		st.setString(7, info.getOrder_phone());
		st.setString(8, info.getOrder_comment());
		st.setString(9, info.getOrder_addr2());
		st.setString(10, info.getOrder_process_idx());
		st.setString(11, info.getOrder_type_idx());
		//st.setString(10, info.getOrder_hiredate());
		st.setString(12,info.getOrder_price());
		st.setString(13,info.getOrder_point());
		st.setString(14,info.getOrder_delivery_code());
		st.setString(15,info.getStaff_idx());
		
		st.executeUpdate();
		st.close();
	}

	public OrderBeans selectOrder(String order_idx) throws SQLException {

		java.sql.Connection con = getOracleConnection();
		OrderBeans bean = new OrderBeans();
		try {
			// 2단계 : SQL 구문 실행
			String sql = "select * from orders where order_idx =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_idx);
			ResultSet rs = pstmt.executeQuery(); // -- 처리한 결과
			// ResultSet rs=pstmt.executeUpdate()(); --s 처리한 갯수
			// System.out.println(sql);

			// 3단계 : 결과 처리
			if (rs.next()) {
				bean.setOrder_idx(rs.getString("order_idx"));
				bean.setMember_idx(rs.getString("member_idx"));
				bean.setOrder_name(rs.getString("order_name"));
				bean.setOrder_zipcode(rs.getString("order_zipcode"));
				bean.setOrder_addr1(rs.getString("order_addr1"));
				bean.setOrder_mobile(rs.getString("order_mobile"));
				bean.setOrder_phone(rs.getString("order_phone"));
				bean.setOrder_comment(rs.getString("order_comment"));
				bean.setOrder_process_idx(rs.getString("order_process_idx"));
				bean.setOrder_type_idx(rs.getString("order_type_idx"));
				bean.setOrder_hiredate(rs.getString("order_hiredate"));
				bean.setOrder_addr2(rs.getString("order_addr2"));
				bean.setOrder_delivery_code(rs.getString("order_delivery_code"));
				bean.setOrder_point(rs.getString("order_point"));
				bean.setOrder_price(rs.getString("order_price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 4단계 : 닫기
		disconnect(con);
		return bean;

	}

	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList getDBList( int nowpage, int pagesize,String search_type,String search_txt,String order_process_idx,String order_type_idx) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<OrderBeans> datas = new ArrayList<OrderBeans>();
		java.sql.Connection con = getOracleConnection();


		try {
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call ORDER_SELECT_LIST(?,?,?,?,?,?,?)}");
			st.setInt(1,nowpage);
			st.setInt(2,pagesize);
			st.setInt(3,Integer.parseInt(search_type));
			st.setString(4,search_txt);
			st.setInt(5,Integer.parseInt(order_process_idx));
			st.setInt(6,Integer.parseInt(order_type_idx));
			st.registerOutParameter(7,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(7);
			st.close();
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.

			while (rs.next()) {
				OrderBeans ob = new OrderBeans(); 
				
				ob.setOrder_idx(rs.getString("order_idx"));
				ob.setMember_idx(rs.getString("member_idx"));
				ob.setOrder_name(rs.getString("order_name"));
				ob.setOrder_zipcode(rs.getString("order_zipcode"));
				ob.setOrder_addr1(rs.getString("order_addr1"));
				ob.setOrder_mobile(rs.getString("order_mobile"));
				ob.setOrder_phone(rs.getString("order_phone"));
				ob.setOrder_comment(rs.getString("order_comment"));
				ob.setOrder_process_idx(rs.getString("order_process_idx"));
				ob.setOrder_type_idx(rs.getString("order_type_idx"));
				ob.setOrder_hiredate(rs.getString("order_hiredate"));
				ob.setOrder_addr2(rs.getString("order_addr2"));
				ob.setOrder_price(rs.getString("order_price"));
				ob.setOrder_point(rs.getString("order_point"));
				ob.setOrder_delivery_code(rs.getString("order_delivery_code"));
				ob.setRNUM(rs.getString("RNUM"));
				ob.setTOTCNT(rs.getString("TOT_CNT"));
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

	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList getOrder_product_select_list(String order_idx) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<Order_product_Beans> datas = new ArrayList<Order_product_Beans>();
		java.sql.Connection con = getOracleConnection();


		try {
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call ORDER_PRODUCT_SELECT_LIST(?,?)}");
			st.setInt(1,Integer.parseInt(order_idx));
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.

			while (rs.next()) {
				Order_product_Beans ob = new Order_product_Beans(); 
				ob.setOrder_product_idx(rs.getString("order_product_idx"));
				ob.setProduct_idx(rs.getString("product_idx"));
				ob.setOrder_idx(rs.getString("order_idx"));
				ob.setOrder_product_count(rs.getString("order_product_count"));
				ob.setOrder_product_sell_price(rs.getString("order_product_sell_price"));
				ob.setOrder_product_point(rs.getString("order_product_point"));
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
	
	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList getOrder_process_log_select_list(String order_idx) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<Order_process_log_Beans> datas = new ArrayList<Order_process_log_Beans>();
		java.sql.Connection con = getOracleConnection();


		try {
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call ORDER_PROCESS_LOG_SELECT_LIST(?,?)}");
			st.setInt(1,Integer.parseInt(order_idx));
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.

			while (rs.next()) {
				Order_process_log_Beans ob = new Order_process_log_Beans(); 
				ob.setOrder_process_log_idx(rs.getString("order_process_log_idx"));
				ob.setBefore_order_process_log_idx(rs.getString("before_order_process_log_idx"));
				ob.setAfter_order_process_log_idx(rs.getString("after_order_process_log_idx"));
				ob.setOrder_process_log_hiredate(rs.getString("order_process_log_hiredate"));
				ob.setStaff_idx(rs.getString("staff_idx"));
				ob.setOrer_idx(rs.getString("order_idx"));
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
	
	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList getSHOP_MEMBER_ORDER_LIST (String member_idx, int nowpage, int pagesize) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<OrderBeans> datas = new ArrayList<OrderBeans>();
		java.sql.Connection con = getOracleConnection();


		try {
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call SHOP_MEMBER_ORDER_LIST (?,?,?,?)}");
			st.setInt(1,nowpage);
			st.setInt(2,pagesize);
			st.setInt(3,Integer.parseInt(member_idx));
			st.registerOutParameter(4,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(4);
			st.close();
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.

			while (rs.next()) {
				OrderBeans ob = new OrderBeans(); 
				ob.setOrder_idx(rs.getString("order_idx"));
				ob.setMember_idx(rs.getString("member_idx"));
				ob.setOrder_name(rs.getString("order_name"));
				ob.setOrder_zipcode(rs.getString("order_zipcode"));
				ob.setOrder_addr1(rs.getString("order_addr1"));
				ob.setOrder_mobile(rs.getString("order_mobile"));
				ob.setOrder_phone(rs.getString("order_phone"));
				ob.setOrder_comment(rs.getString("order_comment"));
				ob.setOrder_process_idx(rs.getString("order_process_idx"));
				ob.setOrder_type_idx(rs.getString("order_type_idx"));
				ob.setOrder_hiredate(rs.getString("order_hiredate"));
				ob.setOrder_addr2(rs.getString("order_addr2"));
				ob.setOrder_price(rs.getString("order_price"));
				ob.setOrder_point(rs.getString("order_point"));
				ob.setOrder_delivery_code(rs.getString("order_delivery_code"));
				ob.setRNUM(rs.getString("RNUM"));
				ob.setTOTCNT(rs.getString("TOT_CNT"));
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
