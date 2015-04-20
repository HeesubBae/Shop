package shoeseholic.common_form;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import shoeseholic.common.DBcon;
import shoeseholic.good.GoodBeans;

public class product_cx_code_DAO extends DBcon{
	 
	public ArrayList getProduct_c1_code_list() throws SQLException{
		java.sql.Connection con = getOracleConnection();
		ArrayList<product_cx_code_beans> datas=new ArrayList<product_cx_code_beans>();
		
		try{
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call PRODUCT_C1_CODE_SELECT(?,?)}");
			st.setInt(1,1);
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();

			//3단계 : 결과 처리
			while(rs.next()){  
				product_cx_code_beans pb=new product_cx_code_beans();
				pb.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				pb.setProduct_c1_code_name(rs.getString("product_c1_code_name"));
				datas.add(pb);
			}
			
	}catch(SQLException e){
	e.printStackTrace();
	}
	finally {
		
	}	
	//4단계 : 닫기
	disconnect(con);
	return datas;	
	}

	
	
	public ArrayList getProduct_c2_code_list(int c1_code) throws SQLException{
		java.sql.Connection con = getOracleConnection();
		ArrayList<product_cx_code_beans> datas=new ArrayList<product_cx_code_beans>();
		
		try{
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call PRODUCT_C2_CODE_SELECT(?,?)}");
			st.setInt(1,c1_code);
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();

			//3단계 : 결과 처리
			while(rs.next()){  
				product_cx_code_beans pb=new product_cx_code_beans();
				pb.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				pb.setProduct_c2_code_name(rs.getString("product_c2_code_name"));
				datas.add(pb);
			}
			
	}catch(SQLException e){
	e.printStackTrace();
	}
	finally {
		
	}	
	//4단계 : 닫기
	disconnect(con);
	return datas;	
	}
	
	
	
	public ArrayList getProduct_c3_code_list(int c2_code) throws SQLException{
		java.sql.Connection con = getOracleConnection();
		ArrayList<product_cx_code_beans> datas=new ArrayList<product_cx_code_beans>();
		
		try{
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call PRODUCT_C3_CODE_SELECT(?,?)}");
			st.setInt(1,c2_code);
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();

			//3단계 : 결과 처리
			while(rs.next()){  
				product_cx_code_beans pb=new product_cx_code_beans();
				pb.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				pb.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				pb.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				pb.setProduct_c1_code_name(rs.getString("product_c1_code_name"));
				pb.setProduct_c2_code_name(rs.getString("product_c2_code_name"));
				pb.setProduct_c3_code_name(rs.getString("product_c3_code_name"));
				datas.add(pb);
			}
			
	}catch(SQLException e){
	e.printStackTrace();
	}
	finally {
		
	}	
	//4단계 : 닫기
	disconnect(con);
	return datas;	
	}

	public product_cx_code_beans getCodename(String c3_code) throws SQLException {

		java.sql.Connection con = getOracleConnection();
		product_cx_code_beans bean = new product_cx_code_beans();
		try {
			// 2단계 : SQL 구문 실행
			CallableStatement st =con.prepareCall("{call CODENAME_SELECT (?,?)}");
			st.setInt(1, Integer.parseInt(c3_code));
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();

			// 3단계 : 결과 처리
			if (rs.next()) {
				bean.setProduct_c3_code_idx(rs.getString("product_c3_code_idx"));
				bean.setProduct_c2_code_idx(rs.getString("product_c2_code_idx"));
				bean.setProduct_c1_code_idx(rs.getString("product_c1_code_idx"));
				bean.setProduct_c1_code_name(rs.getString("product_c1_code_name"));
				bean.setProduct_c2_code_name(rs.getString("product_c2_code_name"));
				bean.setProduct_c3_code_name(rs.getString("product_c3_code_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4단계 : 닫기
		disconnect(con);
		return bean;
	}


}