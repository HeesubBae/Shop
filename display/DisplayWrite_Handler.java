package shoeseholic.display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

import shoeseholic.good.GoodBeans;
import shoeseholic.good.GoodDAO;

public class DisplayWrite_Handler implements CommandHandler{

	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		/*
		DisplayDAO dd = new DisplayDAO();
		DisplayBeans display_bean = new DisplayBeans();		
		
		String product_idx = request.getParameter("product_idx");
		
		dd.insertOracle(display_bean);
		*/
		
		GoodDAO gd = new GoodDAO();
		GoodBeans bean = gd.selectGood(request.getParameter("product_idx"));
		
		request.setAttribute("bean", bean);
		
		return "/pop/display_select.jsp";
	}

}
