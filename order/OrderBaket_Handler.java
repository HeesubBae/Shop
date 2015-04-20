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

public class OrderBaket_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		
		
		String g_id=request.getParameter("g_id");
		if(g_id!=null){
		
			
		GoodDAO gb=new GoodDAO();
		GoodBeans bean=gb.selectGood(g_id);
		
		
		ArrayList<GoodBeans> list=(ArrayList<GoodBeans>)session.getAttribute("basket");
		
		if(list==null){
			list = new ArrayList<GoodBeans>();
			
		}	
		list.add(bean);
		
		session.setAttribute("basket", list);
		}
		
		
		return "/shop/order/basket.tiles";
	}

}
