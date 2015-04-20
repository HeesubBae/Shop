package shoeseholic.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import shoeseholic.common.DBcon;
import shoeseholic.display.DisplayBeans;
import shoeseholic.good.GoodBeans;
import shoeseholic.member.MemberBeans;

public class BoardDAO extends DBcon {

	public static void BOARD_INSERT(BoardBeans info)
	throws SQLException {
		java.sql.Connection con = getOracleConnection();
		CallableStatement st =con.prepareCall("{call BOARD_INSERT(?,?,?,?,?,?,?)}");

        
		st.setInt(1, Integer.parseInt(info.getBoard_type()));
        st.setInt(2, Integer.parseInt(info.getBoard_notice()));
        st.setInt(3, Integer.parseInt(info.getProduct_idx()));
        st.setInt(4, Integer.parseInt(info.getWriter_idx()));
        st.setString(5, info.getWriter_name());
        st.setString(6, info.getBoard_title());
        st.setString(7, info.getBoard_content());
		
		st.executeUpdate();
		System.out.println("게시물이 되었습니다.");
		st.close();	
	}
	
	public static void BOARD_UPDATE(BoardBeans info)
	throws SQLException {
		java.sql.Connection con = getOracleConnection();
		CallableStatement st =con.prepareCall("{call BOARD_UPDATE(?,?,?,?,?,?,?,?)}");

        st.setInt(1, Integer.parseInt(info.getBoard_idx()));
		st.setInt(2, Integer.parseInt(info.getBoard_type()));
        st.setInt(3, Integer.parseInt(info.getBoard_notice()));
        st.setInt(4, Integer.parseInt(info.getProduct_idx()));
        st.setInt(5, Integer.parseInt(info.getWriter_idx()));
        st.setString(6, info.getWriter_name());
        st.setString(7, info.getBoard_title());
        st.setString(8, info.getBoard_content());
		
		st.executeUpdate();
		System.out.println("게시물이 업데이트 되었습니다..");
		st.close();	
	}
	
	public BoardBeans BOARD_SELECT(String board_idx) throws SQLException {

		java.sql.Connection con = getOracleConnection();
		BoardBeans bean = new BoardBeans();
		try{
			//2단계 : SQL 구문 실행
			CallableStatement st=con.prepareCall("{call MEMBER_SELECT(?,?)}");
			st.setInt(1,Integer.parseInt(board_idx));
			st.registerOutParameter(2,OracleTypes.CURSOR);
			st.executeQuery();
			ResultSet rs=(ResultSet)st.getObject(2);
			st.close();

			//3단계 : 결과 처리
			if(rs.next()){
					bean.setBoard_idx(rs.getString("board_idx"));
					bean.setBoard_type(rs.getString("board_type"));
					bean.setBoard_notice(rs.getString("boerd_notice"));
					bean.setProduct_idx(rs.getString("product_idx"));
					bean.setBoard_rep_count(rs.getString("board_rep_count"));
					bean.setStaff_idx(rs.getString("staff_idx"));
					bean.setMember_idx(rs.getString("member_idx"));
					bean.setStaff_name(rs.getString("staff_name"));
					bean.setMember_name(rs.getString("member_name"));
					bean.setBoard_title(rs.getString("board_title"));
					bean.setBoard_content(rs.getString("board_content"));
					bean.setBoard_date(rs.getString("board_date"));
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
		
	
	public ArrayList BOARD_SELECT_LIST(String board_type,int nowpage,int pagesize,String search_type,String search_txt) throws SQLException{

		// 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<BoardBeans> datas = new ArrayList<BoardBeans>();
		java.sql.Connection con = getOracleConnection();
		
		try {
			CallableStatement st=con.prepareCall("{call BOARD_SELECT_LIST(?,?,?,?,?,?)}");
			System.out.println("board_type="+board_type);
			System.out.println("nowpage="+nowpage);
			System.out.println("pagesize="+pagesize);
			System.out.println("search_type="+search_type);
			System.out.println("search_txt="+search_txt);
			
				st.setInt(1,Integer.parseInt(board_type));
				st.setInt(2,nowpage);
				st.setInt(3,pagesize);
				st.setInt(4,Integer.parseInt(search_type));
				st.setString(5,search_txt);
				st.registerOutParameter(6,OracleTypes.CURSOR);
				st.executeQuery();
				ResultSet rs=(ResultSet)st.getObject(6);
				st.close();
				

				
				
			while(rs.next()) {
				BoardBeans mb = new BoardBeans();
				
				mb.setBoard_idx(rs.getString("board_idx"));
				mb.setBoard_type(rs.getString("board_type"));
				mb.setBoard_notice(rs.getString("board_notice"));
				mb.setProduct_idx(rs.getString("product_idx"));
				mb.setBoard_rep_count(rs.getString("board_rep_count"));
				mb.setStaff_idx(rs.getString("staff_idx"));
				mb.setMember_idx(rs.getString("member_idx"));
				mb.setStaff_name(rs.getString("staff_name"));
				mb.setMember_name(rs.getString("member_name"));
				if(rs.getString("staff_idx")==null){
					mb.setWriter_idx(rs.getString("member_idx"));	
					mb.setWriter_name(rs.getString("member_name"));
				}else{
					mb.setWriter_idx(rs.getString("staff_idx"));	
					mb.setWriter_name(rs.getString("staff_name"));
				}
				mb.setBoard_title(rs.getString("board_title"));
				mb.setBoard_content(rs.getString("board_content"));
				mb.setBoard_date(rs.getString("board_date"));
				mb.setBoard_count(rs.getString("board_count"));
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
	
	public ArrayList BOARD_SELECT_LIST_MEMBER_IDX(String board_type,int nowpage,int pagesize,String search_type,String search_txt,String member_idx) throws SQLException{

		// 목록을 리턴하기 위한 ArrayList 객체 생성, 명시적으로 ArrayList 에 들어갈 데이터 타잎을 선언함.
		ArrayList<BoardBeans> datas = new ArrayList<BoardBeans>();
		java.sql.Connection con = getOracleConnection();
		
		try {
			CallableStatement st=con.prepareCall("{call BOARD_SELECT_LIST_MEMBER_IDX(?,?,?,?,?,?,?)}");
			System.out.println("board_type="+board_type);
			System.out.println("nowpage="+nowpage);
			System.out.println("pagesize="+pagesize);
			System.out.println("search_type="+search_type);
			System.out.println("search_txt="+search_txt);
			
				st.setInt(1,Integer.parseInt(board_type));
				st.setInt(2,nowpage);
				st.setInt(3,pagesize);
				st.setInt(4,Integer.parseInt(search_type));
				st.setString(5,search_txt);
				st.registerOutParameter(6,OracleTypes.CURSOR);
				st.setInt(7,Integer.parseInt(member_idx));
				st.executeQuery();
				ResultSet rs=(ResultSet)st.getObject(6);
				st.close();
				

				
				
			while(rs.next()) {
				BoardBeans mb = new BoardBeans();
				
				mb.setBoard_idx(rs.getString("board_idx"));
				mb.setBoard_type(rs.getString("board_type"));
				mb.setBoard_notice(rs.getString("board_notice"));
				mb.setProduct_idx(rs.getString("product_idx"));
				mb.setBoard_rep_count(rs.getString("board_rep_count"));
				mb.setStaff_idx(rs.getString("staff_idx"));
				mb.setMember_idx(rs.getString("member_idx"));
				mb.setStaff_name(rs.getString("staff_name"));
				mb.setMember_name(rs.getString("member_name"));
				if(rs.getString("staff_idx")==null){
					mb.setWriter_idx(rs.getString("member_idx"));	
					mb.setWriter_name(rs.getString("member_name"));
				}else{
					mb.setWriter_idx(rs.getString("staff_idx"));	
					mb.setWriter_name(rs.getString("staff_name"));
				}
				mb.setBoard_title(rs.getString("board_title"));
				mb.setBoard_content(rs.getString("board_content"));
				mb.setBoard_date(rs.getString("board_date"));
				mb.setBoard_count(rs.getString("board_count"));
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
}
