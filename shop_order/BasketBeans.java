package shoeseholic.shop_order;

public class BasketBeans {

	private String display_idx,product_idx,product_name,product_sell_price,product_point,product_count,product_detail_info,sum,product_sell_tot,product_list_img,product_priceMcount;
	
	@Override
	public String toString() {
		return "display_idx="+"display_idx"+"product_idx="+product_idx+"product_name="+product_name+"product_sell_price="+product_sell_price+"product_point="+product_point+"product_count="+product_count+"product_detail_info="+product_detail_info+"sum="+sum+"product_sell_tot="+product_sell_tot+"product_list_img="+product_list_img+"product_priceMcount="+product_priceMcount;
	}


	public String getDisplay_idx() {
		return display_idx;
	}
	public void setDisplay_idx(String display_idx) {
		this.display_idx = display_idx;
	}
	public String getProduct_idx() {
		return product_idx;
	}
	public void setProduct_idx(String product_idx) {
		this.product_idx = product_idx;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_sell_price() {
		return product_sell_price;
	}
	public void setProduct_sell_price(String product_sell_price) {
		this.product_sell_price = product_sell_price;
	}
	public String getProduct_point() {
		return product_point;
	}
	public void setProduct_point(String product_point) {
		this.product_point = product_point;
	}
	public String getProduct_count() {
		return product_count;
	}
	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}
	public String getProduct_detail_info() {
		return product_detail_info;
	}
	public void setProduct_detail_info(String product_detail_info) {
		this.product_detail_info = product_detail_info;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getProduct_sell_tot() {
		return product_sell_tot;
	}
	public void setProduct_sell_tot(String product_sell_tot) {
		this.product_sell_tot = product_sell_tot;
	}
	public String getProduct_list_img() {
		return product_list_img;
	}
	public void setProduct_list_img(String product_list_img) {
		this.product_list_img = product_list_img;
	}


	public void setProduct_priceMcount(String product_priceMcount) {
		this.product_priceMcount = product_priceMcount;
	}


	public String getProduct_priceMcount() {
		return product_priceMcount;
	}
}
