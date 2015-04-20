package shoeseholic.staff;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.client.SenderException;



import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.good.GoodBeans;
import shoeseholic.good.GoodDAO;

public class AdminMemberLogout_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);

		if(session != null) {
	        session.invalidate();
	    }

		return "/";
	

	}
}