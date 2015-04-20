package shoeseholic.staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import shoeseholic.common.DBcon;
import shoeseholic.member.MemberBeans;

public class StaffDAO extends DBcon{ 
	
		public static void insertOracle(StaffBeans info)
		throws SQLException {
		java.sql.Connection con=getOracleConnection();
		String sql = "insert into staff(staff_idx,staff_id,staff_pass,staff_name,staff_email,staff_mobile,department_idx,staff_level_idx)";
		sql=sql+ "values (?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		insert(con, sql, info);

		}

		public static void insert(Connection con, String sql, StaffBeans info)
		throws SQLException {
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,info.getStaff_idx());
		st.setString(2,info.getStaff_id());
		st.setString(3,info.getStaff_pass());
		st.setString(4,info.getStaff_name());
		st.setString(5,info.getStaff_email()); 
		st.setString(6,info.getStaff_mobile());
		st.setString(7,info.getDepartment_idx());
		st.setString(8,info.getStaff_level_idx());
		
		
		st.executeUpdate();
		st.close();
		}

		public StaffBeans login(String staff_id,String staff_pass) throws SQLException{
			java.sql.Connection con = getOracleConnection();
			StaffBeans bean=new StaffBeans();
			try{
				//System.out.println("first : "+staff_id);
				
				String sql=" select * from staff where rtrim(staff_id)=? and rtrim(staff_pass)=? ";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,staff_id.trim());
				pstmt.setString(2,staff_pass.trim());
				ResultSet rs=pstmt.executeQuery(); 
				
				if(rs.next()){
					//System.out.println("?????????");
					bean.setStaff_idx(rs.getString("staff_idx"));
					bean.setStaff_id(rs.getString("staff_id").trim());
					bean.setStaff_pass(rs.getString("staff_pass"));
					bean.setStaff_name(rs.getString("staff_name"));
					bean.setStaff_email(rs.getString("staff_email"));
					bean.setStaff_mobile(rs.getString("staff_mobile"));
					bean.setDepartment_idx(rs.getString("department_idx"));
					bean.setStaff_level_idx(rs.getString("staff_level_idx"));
					
				}else
				{
					//
				}

				}catch(SQLException e){
					e.printStackTrace();
				}
				
				System.out.println("login test : |" + bean.getStaff_id()+"|");
				
				//4단계 : 닫기
				disconnect(con);
				return bean;
				
		}
	
		public void editStaff(StaffBeans info) throws SQLException{
			java.sql.Connection con = getOracleConnection();
			
			//String sql=" update good set member_idx=?,member_id=?,member_pass=?,member_name=?,member_email=?,member_addr1=?,member_zipcode=?,member_mobile=?,member_phone=?,member_birthday=?,member_hiredate=?,member_addr2=?,member_point=? ";
			String sql=" update staff set staff_id=?,staff_pass=?,staff_name=?,staff_email=?,staff_mobile=?,department_idx=?,staff_level_idx=? ";
			sql=sql+" where staff_idx=?";
			PreparedStatement st=con.prepareStatement(sql);
			
			
			st.setString(1,info.getStaff_id());
			st.setString(2,info.getStaff_pass()); 
			st.setString(3,info.getStaff_name());
			st.setString(4,info.getStaff_email());
			st.setString(5,info.getStaff_mobile());
			st.setString(6,info.getDepartment_idx());
			st.setString(7,info.getStaff_level_idx());
			st.setString(8, info.getStaff_idx());
			
			
			System.out.println(st.toString());
			System.out.println(sql);
			st.executeUpdate();
			st.close();
		} 
		
		public StaffBeans selectStaff(String staff_idx) throws SQLException{

			java.sql.Connection con = getOracleConnection();
			StaffBeans bean=new StaffBeans();
			try{
			//2단계 : SQL 구문 실행
			String sql="select * from staff where staff_idx =?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,staff_idx);
			ResultSet rs=pstmt.executeQuery(); //			-- 처리한 결과 
			//	ResultSet rs=pstmt.executeUpdate()() -- 처리한 갯수
				//System.out.println(sql); 
			
			//3단계 : 결과 처리
			//System.out.println("!!!!!");
			if(rs.next()){
				//System.out.println("?????????");
				bean.setStaff_idx(rs.getString("staff_idx"));
				bean.setStaff_id(rs.getString("staff_id"));
				bean.setStaff_pass(rs.getString("staff_pass"));
				bean.setStaff_name(rs.getString("staff_name"));
				bean.setStaff_email(rs.getString("staff_email"));
				bean.setStaff_mobile(rs.getString("staff_mobile"));
				bean.setDepartment_idx(rs.getString("department_idx"));
				bean.setStaff_level_idx(rs.getString("staff_level_idx"));
				
			}
			else
			{
				System.out.println("none");
			}

			}catch(SQLException e){
				e.printStackTrace();
			}
			
			//System.out.println("select test : " + bean.getStaff_id());
			
			//4단계 : 닫기
			disconnect(con);
			return bean;
			
		}
				
		
		// 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
		public ArrayList getDBList(String staff_id,int nowpage,int pagesize) throws SQLException{

			// 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
			ArrayList<StaffBeans> datas = new ArrayList<StaffBeans>();
			java.sql.Connection con = getOracleConnection();
			
			String sql="SELECT * FROM (SELECT ROWNUM RNUM,COUNT(*) OVER() TOT_CNT,A.* FROM " ;
			sql=sql + "(SELECT * FROM staff_info ";
			if(staff_id!=null)
			{
				sql=sql +" where staff_id like '%"+staff_id+"%'";
			}

			sql=sql + "	order by staff_idx asc) A) ";
			sql=sql + " WHERE RNUM BETWEEN ("+nowpage+"- 1) * "+pagesize+" + 1 AND " +nowpage+ " * "+pagesize;			
			  
			if(staff_id!=null)
			{
				sql=sql +" and staff_id like '%"+staff_id+"%'";
			}
			
			//sql=sql +" order by staff_idx desc ";
			
			//System.out.println(sql);
			
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					StaffBeans sb = new StaffBeans();
					sb.setStaff_idx(rs.getString("staff_idx"));
					sb.setStaff_id(rs.getString("staff_id"));
					sb.setStaff_name(rs.getString("staff_name"));
					sb.setStaff_email(rs.getString("staff_email"));
					sb.setStaff_mobile(rs.getString("staff_mobile"));
					//sb.setDepartment_idx(rs.getString("department_idx"));
					//sb.setStaff_level_idx(rs.getString("staff_level_idx"));
					sb.setDepartment_name(rs.getString("department_name"));
					sb.setStaff_level_name(rs.getString("staff_level_name"));
					sb.setRNUM(rs.getString("RNUM"));
					sb.setTOTCNT(rs.getString("TOT_CNT"));
					datas.add(sb);
				}
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
			finally {
				
			}
			// 처리가 끝나 ArrayList 를 리턴함.
			return datas;
		}
		
}
