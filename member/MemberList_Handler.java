package shoeseholic.member;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.common_form.search_type;

public class MemberList_Handler implements CommandHandler{

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
		 
		MemberDAO mb = new MemberDAO();
		ArrayList<MemberBeans> datas = mb.getDBList(search_txt,nowpage,pagesize,search_type);

		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
			request.setAttribute("search_type",new search_type().get_common_list_search_type(Integer.parseInt(search_type)));
		return "/admin/admin_member/member_list.tiles";
	}

}


