package shoeseholic.order;

import shoeseholic.common.Beans;

public class Order_product_Beans extends Beans{

	private String order_product_idx,order_idx,product_idx,order_product_count,order_product_sell_price,order_process_log_idx,order_product_point;
	
	public String toString() {
		return "order_product_idx="+order_product_idx+"order_idx="+order_idx+"product_idx="+product_idx+"order_product_count="+order_product_count+"order_product_sell_price="+order_product_sell_price+"order_process_log_idx="+order_process_log_idx+"order_product_point="+order_product_point;
	}

	public String getOrder_product_idx() {
		return order_product_idx;
	}

	public void setOrder_product_idx(String order_product_idx) {
		this.order_product_idx = order_product_idx;
	}

	public String getOrder_idx() {
		return order_idx;
	}

	public void setOrder_idx(String order_idx) {
		this.order_idx = order_idx;
	}

	public String getProduct_idx() {
		return product_idx;
	}

	public void setProduct_idx(String product_idx) {
		this.product_idx = product_idx;
	}

	public String getOrder_product_count() {
		return order_product_count;
	}

	public void setOrder_product_count(String order_product_count) {
		this.order_product_count = order_product_count;
	}

	public String getOrder_product_sell_price() {
		return order_product_sell_price;
	}

	public void setOrder_product_sell_price(String order_product_sell_price) {
		this.order_product_sell_price = order_product_sell_price;
	}

	public String getOrder_process_log_idx() {
		return order_process_log_idx;
	}

	public void setOrder_process_log_idx(String order_process_log_idx) {
		this.order_process_log_idx = order_process_log_idx;
	}

	public void setOrder_product_point(String order_product_point) {
		this.order_product_point = order_product_point;
	}

	public String getOrder_product_point() {
		return order_product_point;
	}
	
}
