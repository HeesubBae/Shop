package shoeseholic.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class OrderWriteOk_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		OrderBeans bean = new OrderBeans();
			
		bean.setOrder_idx(request.getParameter("order_idx"));
				
		
		//System.out.println("bean2 : " + bean.getOrder());
		
		return "/order_list.tils";
	}

}
