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

public class OrderAccount_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String url;
		url="member/login/login.tiles";	
		HttpSession session = request.getSession(true);
		
			if(session.getAttribute("member_id")!=null){
				url="shop/order/account.tiles";
				
			}
			
		return url;
	}
		
}
