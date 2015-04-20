package shoeseholic.good;

import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

import shoeseholic.common.DBcon;

import shoeseholic.common.Pageing;


public class Test_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {

		String nowpages=request.getParameter("nowpage");
		if(null==nowpages){
				nowpages="1";
		}
		String blockpages=request.getParameter("blockpage");
		if(null==blockpages){
			blockpages="10";
		}
		String pagesizes=request.getParameter("pagesize");
		if(null==pagesizes){
			pagesizes="15";
		}
		int nowpage=Integer.parseInt(nowpages);
		int blockpage=Integer.parseInt(blockpages);
		int pagesize=Integer.parseInt(pagesizes);
		String [] aa=request.getParameterValues("product_idx_array");
		
		//TESTBEANS beans=new TESTBEANS();
		//beans.setProduct_idx_array(aa);
		
		//String cat=request.getParameter("g_category");
		TestDAO gb = new TestDAO();
		ArrayList<TESTBEANS> datas = gb.getDBList();
		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			//request.setAttribute("nowpage", nowpage);
			//request.setAttribute("blockpage", blockpage);
			//request.setAttribute("pagesize", pagesize);
			//request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
		return "/admin/admin_product/test_list.tiles";
	}

}
