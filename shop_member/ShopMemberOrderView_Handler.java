package shoeseholic.shop_member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.member.MemberBeans;
import shoeseholic.member.MemberDAO;
import shoeseholic.order.OrderBeans;
import shoeseholic.order.OrderDAO;
import shoeseholic.order.Order_process_log_Beans;
import shoeseholic.order.Order_product_Beans;

public class ShopMemberOrderView_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("member_idx")!=null){		
						
						String order_idx = request.getParameter("order_idx");
						
						OrderDAO od = new OrderDAO();
						OrderBeans beans2 = od.selectOrder(order_idx); // 주문 정보
						
						ArrayList<Order_product_Beans> opBeans = od.getOrder_product_select_list(order_idx); //주문 상품 리스트 들
						
						String member_idx=(String) session.getAttribute("member_idx"); 
						MemberDAO mb = new MemberDAO();
						MemberBeans bean=mb.selectMember(member_idx);
						
						request.setAttribute("bean", bean);
						request.setAttribute("beans2", beans2); // 주문 정보
						request.setAttribute("opBeans", opBeans); //주문 상품 리스트 들
						
						
						return "/shop/member/member_order/member_order_view.tiles";
					}
		return "/shop/login/login.tiles";
	}		
}
