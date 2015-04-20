package shoeseholic.pop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common_form.product_cx_code;

public class Pop_Display_CategorySelect_Handler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		String c1=request.getParameter("product_c1_code_idx");
		if(c1==null){ c1="0";}
		String c2=request.getParameter("product_c2_code_idx");
		if(c2==null){ c2="0";}
		String c3=request.getParameter("product_c3_code_idx");
		if(c3==null){ c3="0";}
	
		request.setAttribute("product_cx_code_form", new product_cx_code().getProduct_cx_code_display_categoryselect(2,Integer.parseInt(c2),Integer.parseInt(c3)));
		
		
		return "/pop/display_select.jsp"; 
	}
}