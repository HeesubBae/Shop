package shoeseholic.good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;

public class GoodEditOk_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("euc-kr");
		GoodBeans bean = new GoodBeans();
		
		/////////////////////////
		bean.setProduct_idx(request.getParameter("product_idx"));
		bean.setProduct_name(request.getParameter("product_name"));
		bean.setProduct_sell_price(request.getParameter("product_sell_price"));
		bean.setProduct_make_price(request.getParameter("product_make_price"));
		bean.setProduct_count(request.getParameter("product_count"));
		bean.setProduct_thumtail_info(request.getParameter("product_thumtail_info"));
		bean.setProduct_detail_info(request.getParameter("product_detail_info"));
		bean.setProduct_list_img(request.getParameter("product_list_img").trim());
		bean.setProduct_process_idx(request.getParameter("product_process_idx"));
		bean.setProduct_c3_code_idx(request.getParameter("product_c3_code_idx"));
		bean.setProduct_c2_code_idx(request.getParameter("product_c2_code_idx"));
		bean.setProduct_c1_code_idx(request.getParameter("product_c1_code_idx"));
		bean.setProduct_main_img(request.getParameter("product_main_img"));
		bean.setProduct_point(request.getParameter("product_point"));
		bean.setStaff_idx(session.getAttribute("staff_idx").toString());	
		////////////////////////////

		System.out.println(request.getParameter("product_name"));
		System.out.println(request.getParameter("product_sell_price"));
		System.out.println(request.getParameter("product_make_price"));
		System.out.println(request.getParameter("product_count"));
		System.out.println(request.getParameter("product_thumtail_info"));
		System.out.println(request.getParameter("product_detail_info"));
		System.out.println(request.getParameter("product_list_img"));
		System.out.println(request.getParameter("product_c3_code_idx"));
		System.out.println(request.getParameter("product_c2_code_idx"));
		System.out.println(request.getParameter("product_c1_code_idx"));
		System.out.println(request.getParameter("product_main_img"));
		System.out.println(request.getParameter("product_point"));
		System.out.println(session.getAttribute("staff_idx").toString());
		
		GoodDAO gb = new GoodDAO();
		gb.editGood(bean);
		
		return "/product_view.do?product_idx=" + bean.getProduct_idx();
	}
	
}
