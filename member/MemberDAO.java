package shoeseholic.member;

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
import shoeseholic.staff.StaffBeans;


public class MemberDAO extends DBcon{ 

		public static void insertOracle(MemberBeans info)
		throws SQLException {
		java.sql.Connection con=getOracleConnection();
		String sql = "insert into member(member_idx,member_id,member_pass,member_name,member_email,member_addr1,member_addr2,member_zipcode,member_mobile,member_phone,member_birthday,member_hiredate)";
		sql=sql+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		insert(con, sql, info);

		}

		public static void insert(Connection con, String sql, MemberBeans info)
		throws SQLException {
		
		Calendar dateIn=Calendar.getInstance();
		String indate=Integer.toString(dateIn.get(Calendar.YEAR))+ "-";
		indate=indate + Integer.toString(dateIn.get(Calendar.MONTH)+1)+ "-";
		indate=indate + Integer.toString(dateIn.get(Calendar.DATE))+ " ";	
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,info.getMember_idx());
		st.setString(2,info.getMember_id());
		st.setString(3,info.getMember_pass());
		st.setString(4,info.getMember_name());
		st.setString(5,info.getMember_email()); 
		st.setString(6,info.getMember_addr1());
		st.setString(7,info.getMember_addr2());
		st.setString(8,info.getMember_zipcode());
		st.setString(9,info.getMember_mobile());
		st.setString(10,info.getMember_phone());
		st.setString(11,info.getMember_birthday());
		st.setString(12,indate);
		//st.setString(13,info.getMember_point());
		
		st.executeUpdate();
		st.close();
		}


		public static void insertOracle2(MemberBeans info)
		throws SQLException {
		java.sql.Connection con=getOracleConnection();
		   
		   CallableStatement st =con.prepareCall("{call member_insert(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			st.setString(1,info.getMember_id());
			st.setString(2,info.getMember_pass());
			st.setString(3,info.getMember_name());
			st.setString(4,info.getMember_email()); 
			st.setString(5,info.getMember_addr1());
			st.setString(6,info.getMember_addr2());
			st.setString(7,info.getMember_zipcode());
			st.setString(8,info.getMember_mobile());
			st.setString(9,info.getMember_phone());
			st.setString(10,info.getMember_birthday());
			st.setString(11,"1");//hiredate
			st.setString(12,"0");//point//
			st.setString(13,info.getMember_sex());
		
		st.executeUpdate();
		st.close();
		}		
		
		public MemberBeans login(String member_id,String member_pass) throws SQLException{
			java.sql.Connection con = getOracleConnection();
			MemberBeans bean=new MemberBeans();
			try{
				//System.out.println("first : "+staff_id);
				
				String sql=" select * from member where rtrim(member_id)=? and rtrim(member_pass)=? ";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,member_id.trim());
				pstmt.setString(2,member_pass.trim());
				ResultSet rs=pstmt.executeQuery(); 
				
				if(rs.next()){
				//	System.out.println("?????????");
					bean.setMember_idx(rs.getString("member_idx"));
					bean.setMember_id(rs.getString("member_id").trim());
					bean.setMember_pass(rs.getString("member_pass"));
					bean.setMember_name(rs.getString("member_name"));
					bean.setMember_email(rs.getString("member_email"));
					bean.setMember_addr1(rs.getString("member_addr1"));
					bean.setMember_addr2(rs.getString("member_addr2"));
					bean.setMember_zipcode(rs.getString("member_zipcode"));
					bean.setMember_mobile(rs.getString("member_mobile"));
					bean.setMember_phone(rs.getString("member_phone"));
					bean.setMember_birthday(rs.getString("member_birthday"));
					bean.setMember_hiredate(rs.getString("member_hiredate"));
					bean.setMember_point(rs.getString("member_point"));
					
				}else
				{
					//
				}

				}catch(SQLException e){
					e.printStackTrace();
				}
				
				System.out.println("login test : |" + bean.getMember_idx()+"|");
				
				//4단계 : 닫기
				disconnect(con);
				return bean;
				
		}
		
		public void editMember(MemberBeans info) throws SQLException{
			java.sql.Connection con = getOracleConnection();
			
			//String sql=" update good set member_idx=?,member_id=?,member_pass=?,member_name=?,member_email=?,member_addr1=?,member_zipcode=?,member_mobile=?,member_phone=?,member_birthday=?,member_hiredate=?,member_addr2=?,member_point=? ";
			String sql=" update member set member_id=?,member_pass=?,member_name=?,member_email=?,member_zipcode=?,member_addr1=?,member_addr2=?,member_mobile=?,member_phone=?,member_birthday=? ";
			sql=sql+" where member_idx=?";
			PreparedStatement st=con.prepareStatement(sql);
			
			
			st.setString(1,info.getMember_id());
			st.setString(2,info.getMember_pass()); 
			st.setString(3,info.getMember_name());
			st.setString(4,info.getMember_email());
			st.setString(5,info.getMember_zipcode());
			st.setString(6,info.getMember_addr1());
			st.setString(7,info.getMember_addr2());
			st.setString(8,info.getMember_mobile());
			st.setString(9,info.getMember_phone());
			st.setString(10,info.getMember_birthday());
			st.setString(11,info.getMember_idx());
			
			
			System.out.println(st.toString());
			System.out.println(sql);
			st.executeUpdate();
			st.close();
		} 
		
		public MemberBeans selectMember(String member_idx) throws SQLException{

			java.sql.Connection con = getOracleConnection();
			MemberBeans bean=new MemberBeans();
			try{
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call MEMBER_SELECT(?,?)}");
			st.setInt(1,Integer.parseInt(member_idx));
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();

			//3단계 : 결과 처리
			if(rs.next()){  
					bean.setMember_idx(rs.getString("member_idx"));
					bean.setMember_id(rs.getString("member_id"));
					bean.setMember_pass(rs.getString("member_pass"));
					bean.setMember_name(rs.getString("member_name"));
					bean.setMember_email(rs.getString("member_email"));
					bean.setMember_addr1(rs.getString("member_addr1"));
					bean.setMember_addr2(rs.getString("member_addr2"));
					bean.setMember_zipcode(rs.getString("member_zipcode"));
					bean.setMember_mobile(rs.getString("member_mobile"));
					bean.setMember_phone(rs.getString("member_phone"));
					bean.setMember_hiredate(rs.getString("member_hiredate"));
					bean.setMember_point(rs.getString("member_point"));
					bean.setMember_sex(rs.getString("member_sex"));
					bean.setMember_birthday(rs.getString("member_birthday"));
				}
					else
					{
						System.out.println("none");
					}

			}catch(SQLException e){
			e.printStackTrace();
			}

			//4단계 : 닫기
			disconnect(con);
			return bean;	
		}

		public MemberBeans selectID(String member_id) throws SQLException{

			java.sql.Connection con = getOracleConnection();
			MemberBeans bean=new MemberBeans();
			try{
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call MEMBER_SELECT_ID(?,?)}");
			st.setString(1,member_id);
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();
			//3단계 : 결과 처리
			if(rs.next()){
				bean.setMember_id(rs.getString("member_id").toString());
				bean.setMember_idx(rs.getString("member_idx").toString());	
			}
				else
				{
					bean.setMember_id(member_id);
					bean.setMember_idx("!@#$");
				}

			}catch(SQLException e){
			e.printStackTrace();
			}

			//4단계 : 닫기
			disconnect(con);
			return bean;	
		}		
		
		// 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
		public ArrayList getDBList(String member_id,int nowpage,int pagesize,String search_type) throws SQLException{

			// 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
			ArrayList<MemberBeans> datas = new ArrayList<MemberBeans>();
			java.sql.Connection con = getOracleConnection();
			
			try {
				CallableStatement st=con.prepareCall("{call MEMBER_SELECT_LIST(?,?,?,?,?)}");
					
					st.setString(1,member_id);
					st.setInt(2,nowpage);
					st.setInt(3,pagesize);
					st.registerOutParameter(4,OracleTypes.CURSOR);
					st.setInt(5,Integer.parseInt(search_type));
					st.executeQuery();
					ResultSet rs=(ResultSet)st.getObject(4);
					st.close();
					
				while(rs.next()) {
					MemberBeans mb = new MemberBeans();
					mb.setMember_idx(rs.getString("member_idx"));
					mb.setMember_id(rs.getString("member_id"));
					mb.setMember_name(rs.getString("member_name"));
					mb.setMember_hiredate(rs.getString("member_hiredate"));
					mb.setMember_email(rs.getString("member_email"));
					mb.setMember_addr1(rs.getString("member_addr1"));
					mb.setMember_addr2(rs.getString("member_addr2"));
					mb.setMember_email(rs.getString("member_email"));
					mb.setMember_zipcode(rs.getString("member_zipcode"));
					mb.setMember_mobile(rs.getString("member_mobile"));
					mb.setMember_phone(rs.getString("member_phone"));
					mb.setMember_birthday(rs.getString("member_birthday"));
					mb.setMember_point(rs.getString("member_point"));
					mb.setRNUM(rs.getString("RNUM"));
					mb.setTOTCNT(rs.getString("TOT_CNT"));
					datas.add(mb);
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

		
		// 목록 출력을 위해 전체 게시물을 가지고 오는 메서드
		public ArrayList getMEMBER_POINT_LOG_SELECT_LIST(String member_idx,int nowpage,int pagesize) throws SQLException{

			// 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
			ArrayList<Member_point_log_Beans> datas = new ArrayList<Member_point_log_Beans>();
			java.sql.Connection con = getOracleConnection();
			
			try {
				CallableStatement st=con.prepareCall("{call MEMBER_POINT_LOG_SELECT_LIST(?,?,?,?)}");
					
					st.setInt(1,nowpage);
					st.setInt(2,pagesize);
					st.setInt(3,Integer.parseInt(member_idx));
					st.registerOutParameter(4,OracleTypes.CURSOR);
					st.executeQuery();
					ResultSet rs=(ResultSet)st.getObject(4);
					st.close();
					
				while(rs.next()) {
					Member_point_log_Beans mb = new Member_point_log_Beans();
					mb.setMember_point_log_idx(rs.getString("member_point_log_idx"));
					mb.setMember_idx(rs.getString("member_idx"));
					mb.setOrder_idx(rs.getString("order_idx"));
					mb.setMember_point_log_type_idx(rs.getString("member_point_log_type_idx"));
					mb.setMember_point_log_memo(rs.getString("member_point_log_memo"));
					mb.setStaff_idx(rs.getString("staff_idx"));
					mb.setMember_point_log_hiredate(rs.getString("member_point_hire_date"));
					mb.setMember_point_log_point(rs.getString("member_point_log_point"));
					mb.setRNUM(rs.getString("RNUM"));
					mb.setTOTCNT(rs.getString("TOT_CNT"));
					datas.add(mb);
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
		
		public static void SHOP_MEMBER_EDIT(MemberBeans info)
		throws SQLException {
		java.sql.Connection con=getOracleConnection();
		   CallableStatement st =con.prepareCall("{call SHOP_MEMBER_EDIT(?,?,?,?,?,?,?)}");
			st.setString(1,info.getMember_idx());
			st.setString(2,info.getMember_pass()); 
			st.setString(3,info.getMember_addr1());
			st.setString(4,info.getMember_addr2());
			st.setString(5,info.getMember_zipcode());
			st.setString(6,info.getMember_mobile());
			st.setString(7,info.getMember_phone());
		st.executeUpdate();
		st.close();
		}				
				
}
