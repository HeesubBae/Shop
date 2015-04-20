package shoeseholic.display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class DisplaySequenceAndCategoryEditOk_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		DisplayDAO dd = new DisplayDAO();
		DisplayBeans bean = new DisplayBeans();		
		
		String display_idx = request.getParameter("display_idx");
		String product_c1_code_idx=request.getParameter("product_c1_code_idx");
		String product_c2_code_idx=request.getParameter("product_c2_code_idx");
		String product_c3_code_idx=request.getParameter("product_c3_code_idx");
		String display_seq=request.getParameter("display_seq");

		bean.setDisplay_idx(display_idx);
		bean.setProduct_c1_code_idx(request.getParameter("product_c1_code_idx"));
		bean.setProduct_c2_code_idx(request.getParameter("product_c2_code_idx"));
		bean.setProduct_c3_code_idx(request.getParameter("product_c3_code_idx"));
		bean.setDisplay_seq(display_seq);

		System.out.println("display_idx = " + display_idx);
		System.out.println("c1=" + product_c1_code_idx);
		System.out.println("c2=" + product_c2_code_idx);
		System.out.println("c3=" + product_c3_code_idx);
		System.out.println("bean c1="+bean.getProduct_c1_code_idx());
		System.out.println("bean c2="+bean.getProduct_c2_code_idx());
		System.out.println("bean c3="+bean.getProduct_c3_code_idx());
		
		dd.Display_Update_CategoryAndSequence(bean);
		
		request.setAttribute("bean", bean);
		
		return "/pop/opener_location_reload.jsp";
	}
}
