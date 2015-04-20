package shoeseholic.shop_order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.order.OrderBeans;
import shoeseholic.order.OrderDAO;

public class ShopOrderOK_Handler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("member_idx")!=null){		
		
					OrderDAO od = new OrderDAO();
					OrderBeans bean= new OrderBeans();
			/*
			                  (order_idx_seq.nextval
			                  ,member_idx
			                  ,order_name
			                  ,order_zipcode
			                  ,order_addr1
			                  ,order_mobile
			                  ,order_phone
			                  ,order_comment
			                  ,1
			                  ,order_type_idx
			                  ,sysdate
			                  ,order_addr2
			                  ,order_price
			                  ,order_point);
			                  
			                , PRODUCT_idx in NUM_ARRAY
							,ORDER_PRODUCT_COUNT
							,ORDER_PRODUCT_SELL_PRICE
							,ORDER_PRODUCT_POINT
					*/
					//bean.setOrder_idx(request.getParameter("order_idx"));
					request.setCharacterEncoding("euc-kr");
					bean.setMember_idx(((String)session.getAttribute("member_idx")));
					bean.setOrder_name(request.getParameter("order_name"));
					bean.setOrder_zipcode(request.getParameter("order_zipcode"));
					bean.setOrder_addr1(request.getParameter("order_addr1"));
					bean.setOrder_mobile(request.getParameter("order_mobile"));
					bean.setOrder_phone(request.getParameter("order_phone"));
					bean.setOrder_comment(request.getParameter("order_comment"));
					//bean.setOrder_process_idx(request.getParameter("order_process_idx"));
					bean.setOrder_type_idx(request.getParameter("order_type_idx"));
					//beans.setOrder_hiredate(request.getParameter("order_hiredate"));
					bean.setOrder_addr2(request.getParameter("order_addr2"));
					bean.setOrder_price(request.getParameter("order_price"));
					bean.setOrder_point(request.getParameter("order_point"));
					
					request.setAttribute("bean", bean);
					
					String[] array01=request.getParameterValues("product_idx");
					int[] product_idx_array=new int[array01.length];
					for(int i=0; i<array01.length; i++)
					{
						product_idx_array[i]=Integer.parseInt(array01[i]); 
					}
					bean.setProduct_idx_array(product_idx_array);
			
					
					String[] array02=request.getParameterValues("order_product_count");
					int[] order_product_count=new int[array02.length];
					for(int i=0; i<array02.length; i++)
					{
						order_product_count[i]=Integer.parseInt(array02[i]); 
					}
					bean.setORDER_PRODUCT_COUNT(order_product_count);
					
					String[] array03=request.getParameterValues("order_product_sell_price");
					int[] order_product_sell_price=new int[array03.length];
					for(int i=0; i<array03.length; i++)
					{
						order_product_sell_price[i]=Integer.parseInt(array03[i]); 
					}
					bean.setORDER_PRODUCT_SELL_PRICE(order_product_sell_price);
					
					String[] array04=request.getParameterValues("order_product_point");
					int[] order_product_poing=new int[array04.length];
					for(int i=0; i<array04.length; i++)
					{
						order_product_poing[i]=Integer.parseInt(array04[i]); 
					}
					bean.setORDER_PRODUCT_POINT(order_product_poing);
					
					
				
					od.insertOracle2(bean);
					
					
					
					return "/shop/order/order_finish.tiles";
					}
		return "/shop/login/login.tiles";	
	}	
}
