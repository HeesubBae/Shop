package shoeseholic.shop_member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.member.MemberBeans;
import shoeseholic.member.MemberDAO;
import shoeseholic.order.OrderDAO;
import shoeseholic.order.OrderBeans;
public class ShopMemberProductList_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("member_idx")!=null){
			String member_idx=(String) session.getAttribute("member_idx"); 
				
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
		
		MemberDAO md= new MemberDAO();
		OrderDAO od = new OrderDAO();
		MemberBeans beans = md.selectMember(member_idx);
		ArrayList<OrderBeans> datas = od.getSHOP_MEMBER_ORDER_LIST(member_idx, nowpage, pagesize);
		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
			request.setAttribute("bean",beans);
			return "/shop/member/member_order/member_order_list.tiles";
		}
		return "/shop/login/login.tiles";
	}
	
}