package shoeseholic.shop_product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

import shoeseholic.common.DBcon;
import shoeseholic.display.DisplayBeans;
import shoeseholic.display.DisplayDAO;

public class ShopProductView_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String display_idx = request.getParameter("display_idx");
		
		DisplayDAO dd = new DisplayDAO();
		DisplayBeans bean = dd.selectGood(display_idx);
		
		request.setAttribute("bean", bean);
		
		return "/shop/product/product_view.tiles";
	}
}