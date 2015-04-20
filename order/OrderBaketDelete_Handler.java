package shoeseholic.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.client.SenderException;



import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.good.GoodBeans;
import shoeseholic.good.GoodDAO;

public class OrderBaketDelete_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		
		String ck=request.getParameter("index");
		if(ck!=null){
		
				int index=Integer.parseInt(ck);
				System.out.println(index);
			
				ArrayList<GoodBeans> list=(ArrayList<GoodBeans>)session.getAttribute("basket");			
				list.remove(index);
					
				System.out.println(list.isEmpty());
						if(list.isEmpty()){
								response.sendRedirect("/shoesholic/shop/order/basket.tiles");
							}
						//session.setAttribute("basket", list);
		}
		
		return "/shop/order/basket.tiles";
	}

}
