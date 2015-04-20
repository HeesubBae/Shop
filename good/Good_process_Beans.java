package shoeseholic.good;

import shoeseholic.common.Beans;

public class Good_process_Beans extends Beans{

	private String product_process_idx, product_process_name;

	public String toString() {
		return "product_process_idx="+product_process_idx+"product_process_name"+product_process_name;
	}
	public String getProduct_process_idx() {
		return product_process_idx;
	}

	public void setProduct_process_idx(String product_process_idx) {
		this.product_process_idx = product_process_idx;
	}

	public String getProduct_process_name() {
		return product_process_name;
	}

	public void setProduct_process_name(String product_process_name) {
		this.product_process_name = product_process_name;
	}
}
