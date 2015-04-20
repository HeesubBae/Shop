package shoeseholic.good;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;

public class GoodWriteHandler implements CommandHandler{

	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("euc-kr");
		GoodDAO gd = new GoodDAO();
		GoodBeans beans = new GoodBeans();
		
		//
		//beans.setProduct_process_idx(request.getParameter("product_process_idx"));
		beans.setProduct_name(request.getParameter("product_name"));
		beans.setProduct_sell_price(request.getParameter("product_sell_price"));
		beans.setProduct_make_price(request.getParameter("product_make_price"));
		beans.setProduct_count(request.getParameter("product_count"));
		beans.setProduct_thumtail_info(request.getParameter("product_thumtail_info"));
		beans.setProduct_detail_info(request.getParameter("product_detail_info"));
		beans.setProduct_list_img(request.getParameter("product_list_img"));
		beans.setProduct_c3_code_idx(request.getParameter("product_c3_code_idx"));
		beans.setProduct_c2_code_idx(request.getParameter("product_c2_code_idx"));
		beans.setProduct_c1_code_idx(request.getParameter("product_c1_code_idx"));
		beans.setProduct_main_img(request.getParameter("product_main_img").toString());
		beans.setProduct_point(request.getParameter("product_point"));
		beans.setStaff_idx(session.getAttribute("staff_idx").toString());
		//
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
		gd.insertOracle(beans);
		
		request.setAttribute("bean", beans);
		
		return "/product_list.do";
	}
}
