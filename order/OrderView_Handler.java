package shoeseholic.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class OrderView_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String order_idx = request.getParameter("order_idx");
		
		OrderDAO od = new OrderDAO();
		OrderBeans beans = od.selectOrder(order_idx); // 주문 정보
		ArrayList<Order_product_Beans> opBeans = od.getOrder_product_select_list(order_idx); //주문 상품 리스트 들
		ArrayList<Order_process_log_Beans> oplBeans=od.getOrder_process_log_select_list(order_idx);//주문 프로세스 변경 내역 리스트들
		
		request.setAttribute("bean", beans); // 주문 정보
		request.setAttribute("opBeans", opBeans); //주문 상품 리스트 들
		request.setAttribute("oplBeans", oplBeans); //주문 프로세스 변경 내역 리스트들
		
		return "/admin/admin_order/order_view.tiles";
	}

}
