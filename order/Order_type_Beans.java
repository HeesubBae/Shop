package shoeseholic.order;

import shoeseholic.common.Beans;

public class Order_type_Beans extends Beans{
	
	public String getOrder_type_idx() {
		return order_type_idx;
	}

	public void setOrder_type_idx(String order_type_idx) {
		this.order_type_idx = order_type_idx;
	}

	public String getOrder_type_name() {
		return order_type_name;
	}

	public void setOrder_type_name(String order_type_name) {
		this.order_type_name = order_type_name;
	}

	private String order_type_idx,order_type_name;
	
	public String toString() {
		return "order_type_idx="+order_type_idx+"order_type_name="+order_type_name;
	}

}
