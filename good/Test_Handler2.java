package shoeseholic.good;

import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

import shoeseholic.common.DBcon;

import shoeseholic.common.Pageing;


public class Test_Handler2 implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {

		TestDAO gb = new TestDAO();
		TESTBEANS beans=new TESTBEANS();
		
		
		ArrayList<TESTBEANS> aa=gb.getDBList(1);
		
		request.setAttribute("aa",aa);
		return "/123.jsp";
	}

}
