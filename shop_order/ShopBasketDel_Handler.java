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

public class ShopBasketDel_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		String array_list_idx= request.getParameter("array_list_idx");
			if(request.getParameter("array_list_idx")!=null){ 
				int idx=Integer.parseInt(array_list_idx);
				/*				
				DisplayDAO dao = new DisplayDAO();
				DisplayBeans temp = dao.selectGood(display_idx);
				
				BasketBeans beans = new BasketBeans();
				
				beans.setDisplay_idx(display_idx);
				beans.setProduct_count(temp.getProduct_idx());
				beans.setProduct_name(temp.getProduct_name());
				beans.setProduct_sell_price(temp.getProduct_sell_price());
				beans.setProduct_list_img(temp.getProduct_list_img());
				 */		
				HttpSession session = request.getSession(true);
			
				
				ArrayList<BasketBeans> list = (ArrayList<BasketBeans>)session.getAttribute("basket");
				
					if(list==null) {
							list=new ArrayList<BasketBeans>();
							System.out.println("null 이란다.");
							System.out.println("idx = " + idx);
							
							list.remove(idx);
							session.setAttribute("basket", list);
					}else{
						System.out.println("null 아니란다..");
						System.out.println("idx = " + idx);
						list.remove(idx);
						session.setAttribute("basket", list);
					
					}		
			}//if 끝
		response.reset();
		return "/shop/order/basket.tiles";
	}   	
}
