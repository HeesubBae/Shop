package shoeseholic.shop_order;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.display.DisplayBeans;
import shoeseholic.display.DisplayDAO;
import shoeseholic.good.GoodBeans;

public class ShopBasketOk_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		String display_idx= request.getParameter("display_idx");

			if(request.getParameter("display_idx")!=null){

				DisplayDAO dao = new DisplayDAO();
				DisplayBeans temp = dao.selectGood(display_idx);

				BasketBeans beans = new BasketBeans();
				
				beans.setDisplay_idx(display_idx);
				beans.setProduct_idx(temp.getProduct_idx());
				beans.setProduct_name(temp.getProduct_name());
				beans.setProduct_sell_price(temp.getProduct_sell_price());
				beans.setProduct_list_img(temp.getProduct_list_img());
				beans.setProduct_point(temp.getProduct_point());
				beans.setProduct_count(request.getParameter("product_count"));
				//beans.setProduct_priceMcount(beans.getProduct_sell_price()+beans.getProduct_count());
				HttpSession session = request.getSession(true);
			
		
				ArrayList<BasketBeans> list = (ArrayList<BasketBeans>)session.getAttribute("basket");
				
					if(list==null) {
							list=new ArrayList<BasketBeans>();
							list.add(beans);
							session.setAttribute("basket", list);
					}else{
					list.add(beans);
					session.setAttribute("basket", list);
					}		
			}//if ³¡
			
		return "/shop/order/basket.tiles";
	}   	
}
