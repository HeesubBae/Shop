package shoeseholic.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;


public class OrderEditOk_Handler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("euc-kr");
		OrderBeans bean = new OrderBeans();
				
		bean.setOrder_idx(request.getParameter("order_idx"));
		bean.setMember_idx(request.getParameter("member_idx"));
		bean.setOrder_name(request.getParameter("order_name"));
		bean.setOrder_zipcode(request.getParameter("order_zipcode"));
		bean.setOrder_addr1(request.getParameter("order_addr1"));
		bean.setOrder_mobile(request.getParameter("order_mobile"));
		bean.setOrder_phone(request.getParameter("order_phone"));
		bean.setOrder_comment(request.getParameter("order_comment"));
		bean.setOrder_addr2(request.getParameter("order_addr2"));
		bean.setOrder_process_idx(request.getParameter("order_process_idx"));
		bean.setOrder_type_idx(request.getParameter("order_type_idx"));
		bean.setOrder_delivery_code(request.getParameter("order_delivery_code"));
		bean.setStaff_idx(session.getAttribute("staff_idx").toString());
		bean.setOrder_price(request.getParameter("order_price"));
		bean.setOrder_point(request.getParameter("order_point"));
		
		OrderDAO od = new OrderDAO();
		od.editBeans(bean);
	
		return "/order_view.do?order_idx=" + bean.getOrder_idx();
	}
}
