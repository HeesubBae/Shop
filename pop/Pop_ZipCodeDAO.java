package shoeseholic.pop;

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
import shoeseholic.order.OrderBeans;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import shoeseholic.common.DBcon;

public class Pop_ZipCodeDAO extends DBcon{

	// 게시물 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
	public ArrayList getDBList(String dong, int nowpage, int pagesize) throws SQLException {

		// 게시물 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<Pop_ZipCodeBean> datas = new ArrayList<Pop_ZipCodeBean>();
		java.sql.Connection con = getOracleConnection();
		
		try {
			CallableStatement st=con.prepareCall("{call ZIPCODE_SELECT(?,?,?,?)}");
			String dong_a="%"+dong+"%";
			st.setString(1,dong_a);
			st.setInt(2,nowpage);  
			st.setInt(3,pagesize);
			st.registerOutParameter(4,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(4);
			st.close();
			
			
			// 루프를 돌면 ResultSet 을 이동하면서 모든 데이터 row 를 하나씩 가지고 와서 GuestBook 객체에 넣고
			// 이를 다시 ArrayList 에 넣는 작업을 반복.
			while (rs.next()) {
				 Pop_ZipCodeBean ob = new Pop_ZipCodeBean(); 
				ob.setSido(rs.getString("sido"));
				ob.setGugun(rs.getString("gugun"));
				ob.setDong(rs.getString("dong"));
				ob.setBunji(rs.getString("bunji"));
				ob.setZipcode(rs.getString("zipcode"));
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
