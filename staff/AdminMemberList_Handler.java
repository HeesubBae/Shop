package shoeseholic.staff;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;

public class AdminMemberList_Handler implements CommandHandler{
	
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String staff_id=request.getParameter("staff_id_s");
				
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
 
		StaffDAO mb = new StaffDAO();
		ArrayList<StaffBeans> datas = mb.getDBList(staff_id,nowpage,pagesize);
		//System.out.println("44444");
		if(!datas.isEmpty()){
		//	System.out.println("55555");
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
		
		System.out.println("AdminMemberList_Handler");
		return "/admin/admin_operate/admin_member_list.tiles";
	}

}
