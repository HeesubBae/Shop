package shoeseholic.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common_form.order_process_idx;
import shoeseholic.common_form.order_type_idx;

public class OrderEdit_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String order_idx = request.getParameter("order_idx");
		
		OrderDAO od = new OrderDAO();
		OrderBeans bean = od.selectOrder(order_idx);
		
		
		request.setAttribute("bean", bean);
		request.setAttribute("order_process_idx",new order_process_idx().getOrder_process_idx(Integer.parseInt(bean.getOrder_process_idx())));
		request.setAttribute("order_type_idx",new order_type_idx().getOrder_type_idx(Integer.parseInt(bean.getOrder_type_idx())));
		return "/admin/admin_order/order_edit.tiles";
	}

}
