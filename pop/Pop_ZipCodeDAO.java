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

	// �Խù� ��� ����� ���� ��ü �Խù��� ������ ���� �޼���
	public ArrayList getDBList(String dong, int nowpage, int pagesize) throws SQLException {

		// �Խù� ����� �����ϱ� ���� ArrayList ��ü ����, ��������� ArrayList �� �� ������ Ÿ���� ������.
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
			
			
			// ������ ���� ResultSet �� �̵��ϸ鼭 ��� ������ row �� �ϳ��� ������ �ͼ� GuestBook ��ü�� �ְ�
			// �̸� �ٽ� ArrayList �� �ִ� �۾��� �ݺ�.
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
		// ó���� ���� ArrayList �� ������.
		return datas;
	}
	
	
}
