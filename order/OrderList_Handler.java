package shoeseholic.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.common_form.order_process_idx;
import shoeseholic.common_form.order_type_idx;
import shoeseholic.common_form.search_type;
import shoeseholic.good.GoodBeans;
import shoeseholic.good.GoodDAO;

public class OrderList_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
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

		String search_txt=request.getParameter("search_txt");
		if(search_txt==null){search_txt="0";}
		
		String search_type=request.getParameter("search_type");
		if(search_type==null){search_type="0";}
		
		String order_process_idx=request.getParameter("order_process_idx");
		if(order_process_idx==null){order_process_idx="0";}
		
		String order_type_idx=request.getParameter("order_type_idx");
		if(order_type_idx==null){order_type_idx="0";}
		
		OrderDAO od = new OrderDAO();
		ArrayList<OrderBeans> datas = od.getDBList(nowpage, pagesize, search_type, search_txt, order_process_idx, order_type_idx);
		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
			request.setAttribute("search_type",new search_type().get_common_list_search_type(Integer.parseInt(search_type)));
			request.setAttribute("order_process_idx",new order_process_idx().getOrder_process_idx(Integer.parseInt(order_process_idx)));
			request.setAttribute("order_type_idx",new order_type_idx().getOrder_type_idx(Integer.parseInt(order_type_idx)));
		return "/admin/admin_order/order_list.tiles";
	}

	
}
