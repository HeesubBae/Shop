package shoeseholic.good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class GoodSelect_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String product_idx=request.getParameter("product_idx");
		
		GoodDAO gb = new GoodDAO();
		GoodBeans bean=gb.selectGood(product_idx);
		
		request.setAttribute("bean", bean);
			
		return "/admin/admin_product/product_view.tiles";
	}
	
}
