package shoeseholic.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.common_form.search_type;
import shoeseholic.member.MemberBeans;

public class Board_WriteOK_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");

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
		if(board_type==null){board_type="1";}

		String board_notice=request.getParameter("board_notice");
		if(board_notice==null){board_notice="1";}
		
		String product_idx=request.getParameter("product_idx");
		if(product_idx==null){product_idx="0";}
		
		String url=request.getParameter("url");
		if(url==null){url="/board_notic.do";}
		
		
		System.out.println("idx="+request.getParameter("writer_idx"));
		System.out.println("name="+request.getParameter("writer_name"));
		BoardBeans bean=new BoardBeans();
		
		bean.setBoard_type(board_type);
		bean.setBoard_notice(board_notice);
		bean.setProduct_idx(product_idx);
		bean.setWriter_idx(request.getParameter("writer_idx"));
		bean.setWriter_name(request.getParameter("writer_name"));
		bean.setBoard_title(request.getParameter("board_title"));
		bean.setBoard_content(request.getParameter("board_content"));
		
		BoardDAO mb = new BoardDAO();
		mb.BOARD_INSERT(bean);

		return url;
	}

}
