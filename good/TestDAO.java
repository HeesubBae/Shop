package shoeseholic.good;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.CallableStatement;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import shoeseholic.common.DBcon;



public class TestDAO extends DBcon { 

		public static void insertOracle(TESTBEANS info)
		throws SQLException {
		java.sql.Connection con = getOracleConnection();	
		insert(con,info);
		}  

		public static void insert(Connection con,TESTBEANS info)
		throws SQLException {
		  int intArray[]={1,2,3,4,5};
			
		   ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("NUM_ARRAY", con);
		   ARRAY array_to_pass = new ARRAY(descriptor, con, intArray);
			   
		   CallableStatement cstmt =con.prepareCall("{call PRC_ARRAY_TEST(?)}");
		   cstmt.setArray(1, array_to_pass );   
		   cstmt.executeQuery();
		 
		}

		public static void insertOracle2(TESTBEANS info)
		throws SQLException {
		java.sql.Connection con = getOracleConnection();	

		  int intArray[]={1,2,3,4,5};
		  
		   ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("NUM_ARRAY", con);
		   ARRAY array_to_pass = new ARRAY(descriptor, con, intArray);
			   
		   CallableStatement cstmt =con.prepareCall("{call PRC_ARRAY_TEST(?)}");
		   cstmt.setArray(1, array_to_pass );   
		   cstmt.executeQuery();
		 
		}		

		public ArrayList getDBList() throws SQLException{
				
			ArrayList<TESTBEANS> datas = new ArrayList<TESTBEANS>();
			java.sql.Connection con = getOracleConnection();
			
			try {
				String strProcedure="{call kkk(?,?)}";
				CallableStatement cs = con.prepareCall(strProcedure);
				 cs.setInt(1,1);
				 cs.setInt(2,8);		 
				 
				 cs.execute();

				 if(con != null) con.close();
				 if(cs != null) cs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
			finally {
				
			}		
			return datas;
		}	
		
		
		public ArrayList getDBList(int a) throws SQLException{
			
			
			ArrayList<TESTBEANS> datas = new ArrayList<TESTBEANS>();
			java.sql.Connection con = getOracleConnection();
				
			
			String sql="SELECT * from f";

			
			
			System.out.println(sql);
			
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					TESTBEANS gb = new TESTBEANS();
					gb.setGrade(rs.getString("grade"));
					gb.setIdx(rs.getString("idx"));
					gb.setName(rs.getString("name"));
					gb.setProfessor(rs.getString("professor"));
					datas.add(gb);
				}
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
			finally {
				
			}
			return datas;
		}			
}
