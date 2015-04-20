package shoeseholic.shop_board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.board.BoardBeans;
import shoeseholic.board.BoardDAO;
import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;


public class ShopBoardMantoMan_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("member_idx")!=null){
			
		String nowpages=request.getParameter("nowpage");
		if(null==nowpages){
				nowpages="1";
		}
		String blockpages=request.getParameter("blockpage");
		if(null==blockpages){
			blockpages="10";
		}
		String pagesizes=request.getParameter("pagesize");
		if(null==pagesizes){
			pagesizes="15";
		}
		int nowpage=Integer.parseInt(nowpages);
		int blockpage=Integer.parseInt(blockpages);
		int pagesize=Integer.parseInt(pagesizes);

		String search_txt=request.getParameter("search_txt");
		if(search_txt==null){search_txt="0";}
		
		String search_type=request.getParameter("search_type");
		if(search_type==null){search_type="0";}
		
		String board_type=request.getParameter("board_type");
		if(board_type==null){board_type="2";}
		

		String member_idx=session.getAttribute("member_idx").toString();

		
		BoardDAO mb = new BoardDAO();
		ArrayList<BoardBeans> datas = mb.BOARD_SELECT_LIST_MEMBER_IDX(board_type, nowpage, pagesize, search_type, search_txt,member_idx);

		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
		return "/shop/member/member_board/board_mantoman.tiles";
	}
		return "/shop/login/login.tiles";
	}
}
