package shoeseholic.good;

import java.io.PrintStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common_form.product_cx_code_DAO;
import shoeseholic.common_form.product_cx_code_beans;
import shoeseholic.display.DisplayBeans;
import shoeseholic.display.DisplayDAO;

public class GoodView_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String product_idx=request.getParameter("product_idx");
		
		//System.out.println(product_idx);
		
		GoodDAO gb = new GoodDAO();
		GoodBeans bean=gb.selectGood(product_idx);
		
		ArrayList<Good_process_log_Beans> gpbean=gb.PRODUCT_PROCESS_LOG_SELECT(product_idx);
		
		product_cx_code_DAO pd = new product_cx_code_DAO();
		product_cx_code_beans pbean = pd.getCodename(bean.getProduct_c3_code_idx());
		
		DisplayDAO dd=new DisplayDAO();
		ArrayList<DisplayBeans> dbean=dd.DISPLAY_SELECT_LIST_PRODCT_IDX(bean.getProduct_idx());
		
		
		request.setAttribute("pbean", pbean);
		request.setAttribute("bean", bean);
		request.setAttribute("dbean", dbean);
		request.setAttribute("gpbean", gpbean);
		
		return "/admin/admin_product/product_view.tiles";
	}
	

}
