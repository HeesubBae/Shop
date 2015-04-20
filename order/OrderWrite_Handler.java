package shoeseholic.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class OrderWrite_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		OrderDAO od = new OrderDAO();
		OrderBeans bean= new OrderBeans();
		
		//
		bean.setOrder_idx(request.getParameter("order_idx"));
		bean.setMember_idx(request.getParameter("member_idx"));
		bean.setOrder_name(request.getParameter("order_name"));
		bean.setOrder_zipcode(request.getParameter("order_zipcode"));
		bean.setOrder_addr1(request.getParameter("order_addr1"));
		bean.setOrder_mobile(request.getParameter("order_mobile"));
		bean.setOrder_phone(request.getParameter("order_phone"));
		bean.setOrder_comment(request.getParameter("order_comment"));
		bean.setOrder_process_idx(request.getParameter("order_process_idx"));
		bean.setOrder_type_idx(request.getParameter("order_type_idx"));
		//beans.setOrder_hiredate(request.getParameter("order_hiredate"));
		bean.setOrder_addr2(request.getParameter("order_addr2"));
		//
		
		System.out.println("/////");
		System.out.println("order idx : " + request.getParameter("order_idx"));
		System.out.println("/////");
		
		od.insertOracle(bean);
		
		request.setAttribute("bean", bean);
		
		return "/order_list.do";
	}
}
