package shoeseholic.display;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.common_form.product_cx_code;

public class DisplayList_Handler implements CommandHandler{

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
		
		String search_txt=request.getParameter("search_txt");
		if(search_txt==null){search_txt="0";}
		
		int nowpage=Integer.parseInt(nowpages);
		int blockpage=Integer.parseInt(blockpages);
		int pagesize=Integer.parseInt(pagesizes);

		String c1=request.getParameter("product_c1_code_idx");
		if(c1==null){ c1="2";}
		String c2=request.getParameter("product_c2_code_idx");
		if(c2==null){ c2="0";}
		String c3=request.getParameter("product_c3_code_idx");
		if(c3==null){ c3="0";}
			
			
		DisplayDAO dd= new DisplayDAO();
		ArrayList<DisplayBeans> datas = dd.getDBList(c3, c2, c1,search_txt,nowpage,pagesize);
		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("blockpage", blockpage);
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("paging", new Pageing().getPage((datas.get(0)).getTOTCNT() , pagesize, blockpage, nowpage));
		}
		request.setAttribute("product_cx_code_form", new product_cx_code().getProduct_cx_code_display_categoryselect(2,Integer.parseInt(c2),Integer.parseInt(c3)));
		
		return "/admin/admin_product/display_list.tiles";
	}

}
