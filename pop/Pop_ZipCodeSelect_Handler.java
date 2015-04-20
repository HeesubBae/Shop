package shoeseholic.pop;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.order.OrderBeans;
import shoeseholic.order.OrderDAO;


public class Pop_ZipCodeSelect_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-KR");
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

		
		String dong=request.getParameter("dong");
		System.out.println("dong="+dong);
		Pop_ZipCodeDAO od = new Pop_ZipCodeDAO();
		ArrayList<Pop_ZipCodeBean> datas = od.getDBList(dong,nowpage,pagesize);
		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}

		return "/pop/zipcode.jsp";
	}

	
}