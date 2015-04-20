package shoeseholic.good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class GoodInsert_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		GoodBeans bean=new GoodBeans();
		
		bean.setProduct_name(request.getParameter("product_name"));
		bean.setProduct_sell_price(request.getParameter("product_sell_price"));
		bean.setProduct_make_price(request.getParameter("product_make_price"));
		bean.setProduct_count(request.getParameter("product_count"));
		bean.setProduct_thumtail_info(request.getParameter("product_thumtail_info"));
		bean.setProduct_detail_info(request.getParameter("product_detail_info"));
		bean.setProduct_process_idx(request.getParameter("product_process_idx"));
		bean.setProduct_c3_code_idx(request.getParameter("product_c3_code_idx"));
		bean.setProduct_c2_code_idx(request.getParameter("product_c2_code_idx"));
		bean.setProduct_c1_code_idx(request.getParameter("product_c1_code_idx"));
		bean.setProduct_main_img(request.getParameter("product_main_img"));
		/*
		bean.setG_category(request.getParameter("g_category"));
		bean.setG_color(request.getParameter("g_color"));
		bean.setG_detail(request.getParameter("g_detail"));
		bean.setG_id(request.getParameter("g_id"));
		bean.setG_image(request.getParameter("g_image"));
		bean.setG_maker(request.getParameter("g_maker"));
		bean.setG_name(request.getParameter("g_name"));
		bean.setG_price(request.getParameter("g_price"));
		bean.setG_size(request.getParameter("g_size"));
		bean.setG_type(request.getParameter("g_type"));
		*/  
		GoodDAO gb = new GoodDAO();
		gb.insertOracle(bean);
		
		
		return "/product_list.do";
	}
	
}
