package shoeseholic.good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.common_form.product_cx_code;
import shoeseholic.common_form.product_cx_code_DAO;
import shoeseholic.common_form.product_cx_code_beans;
import shoeseholic.common_form.product_process_idx;

public class GoodEdit_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String product_idx = request.getParameter("product_idx");
		
		GoodDAO gd = new GoodDAO();
		GoodBeans bean  = gd.selectGood(product_idx);
		
		product_cx_code_DAO pd = new product_cx_code_DAO();
		product_cx_code_beans pbean = pd.getCodename(bean.getProduct_c3_code_idx());
		
		request.setAttribute("pbean", pbean);
		request.setAttribute("bean", bean);
		request.setAttribute("product_process_idx_form", new product_process_idx().getProduct_process_idx_view(Integer.parseInt(bean.getProduct_process_idx())));
		
		
		return "/admin/admin_product/product_edit.tiles";
	}
	
}
