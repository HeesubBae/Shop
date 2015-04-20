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
		OrderBeans beans = od.selectOrder(order_idx); // �ֹ� ����
		ArrayList<Order_product_Beans> opBeans = od.getOrder_product_select_list(order_idx); //�ֹ� ��ǰ ����Ʈ ��
		ArrayList<Order_process_log_Beans> oplBeans=od.getOrder_process_log_select_list(order_idx);//�ֹ� ���μ��� ���� ���� ����Ʈ��
		
		request.setAttribute("bean", beans); // �ֹ� ����
		request.setAttribute("opBeans", opBeans); //�ֹ� ��ǰ ����Ʈ ��
		request.setAttribute("oplBeans", oplBeans); //�ֹ� ���μ��� ���� ���� ����Ʈ��
		
		return "/admin/admin_order/order_view.tiles";
	}

}
