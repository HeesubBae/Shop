package shoeseholic.display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common_form.product_cx_code;


public class DisplaySequenceAndCategoryEdit_Handler implements CommandHandler{

	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		String display_idx = request.getParameter("display_idx");
		
		DisplayDAO dd = new DisplayDAO();
		DisplayBeans bean = dd.selectGood(display_idx);
		
		
		request.setAttribute("bean", bean);
		
		String c1=request.getParameter("product_c1_code_idx");
		if(c1==null){ c1="2";}
		String c2=request.getParameter("product_c2_code_idx");
		if(c2==null){ c2=bean.getProduct_c2_code_idx();}
		String c3=request.getParameter("product_c3_code_idx");
		if(c3==null){ c3=bean.getProduct_c3_code_idx();}
		
		System.out.println(" c1="+c1+" c2="+c2+" c3="+c3);

		request.setAttribute("product_cx_code_form", new product_cx_code().getProduct_cx_code_display_categoryselect(2,Integer.parseInt(c2),Integer.parseInt(c3)));
		
		return "/pop/display_update_sequence.jsp";
	}
}
