package shoeseholic.shop_common;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.common_form.product_cx_code_DAO;
import shoeseholic.common_form.product_cx_code_beans;
import shoeseholic.display.DisplayBeans;
import shoeseholic.display.DisplayDAO;

public class Index_Handler  implements CommandHandler{

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
			pagesizes="16";
		}
		
		String search_txt=request.getParameter("search_txt");
		if(search_txt==null){search_txt="0";}
		
		int nowpage=Integer.parseInt(nowpages);
		int blockpage=Integer.parseInt(blockpages);
		int pagesize=Integer.parseInt(pagesizes);

		String c1=request.getParameter("product_c1_code_idx");
		if(c1==null){ c1="2";}
		String c2=request.getParameter("product_c2_code_idx");
		if(c2==null){ c2="11";}
		String c3=request.getParameter("product_c3_code_idx");
		if(c3==null){ c3="0";}
			
		
		product_cx_code_DAO dc3 = new product_cx_code_DAO();
		ArrayList<product_cx_code_beans> datas3 = dc3.getProduct_c3_code_list(Integer.parseInt(c2));
		
		DisplayDAO dd= new DisplayDAO();
		ArrayList<DisplayBeans> datas = dd.SHOP_DISPLAY_SELECT_LIST("0", "11", "2",search_txt,nowpage,pagesize);
		ArrayList<DisplayBeans> datas2 = dd.SHOP_DISPLAY_SELECT_LIST("0", "18", "2",search_txt,nowpage,pagesize);
		if(!datas.isEmpty()){
			request.setAttribute("datas", datas);
			request.setAttribute("datas2", datas2);
		}
			//request.setAttribute("datas3", datas3);
			//request.setAttribute("c2_code_name",datas3.get(0).getProduct_c2_code_name());

			return "/shop/index/index.tiles";
	}

	  
}
