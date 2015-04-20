package shoeseholic.order;

import shoeseholic.common.Beans;

public class OrderBeans extends Beans{

	private String order_idx,member_idx,order_name,order_zipcode,order_addr1,order_mobile,order_phone,order_comment,order_process_idx,order_type_idx,order_hiredate,order_addr2,order_price,order_point,order_delivery_code;
	private int[] product_idx_array,ORDER_PRODUCT_COUNT,ORDER_PRODUCT_SELL_PRICE,ORDER_PRODUCT_POINT;
	
	public String getOrder_idx() {
		return order_idx;
	}

	public void setOrder_idx(String order_idx) {
		this.order_idx = order_idx;
	}

	public String getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(String member_idx) {
		this.member_idx = member_idx;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getOrder_zipcode() {
		return order_zipcode;
	}

	public void setOrder_zipcode(String order_zipcode) {
		this.order_zipcode = order_zipcode;
	}

	public String getOrder_addr1() {
		return order_addr1;
	}

	public void setOrder_addr1(String order_addr1) {
		this.order_addr1 = order_addr1;
	}

	public String getOrder_mobile() {
		return order_mobile;
	}

	public void setOrder_mobile(String order_mobile) {
		this.order_mobile = order_mobile;
	}

	public String getOrder_phone() {
		return order_phone;
	}

	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

	public String getOrder_comment() {
		return order_comment;
	}

	public void setOrder_comment(String order_comment) {
		this.order_comment = order_comment;
	}

	public String getOrder_process_idx() {
		return order_process_idx;
	}

	public void setOrder_process_idx(String order_process_idx) {
		this.order_process_idx = order_process_idx;
	}

	public String getOrder_type_idx() {
		return order_type_idx;
	}

	public void setOrder_type_idx(String order_type_idx) {
		this.order_type_idx = order_type_idx;
	}

	public String getOrder_hiredate() {
		return order_hiredate;
	}

	public void setOrder_hiredate(String order_hiredate) {
		this.order_hiredate = order_hiredate;
	}

	public String getOrder_addr2() {
		return order_addr2;
	}

	public void setOrder_addr2(String order_addr2) {
		this.order_addr2 = order_addr2;
	}

	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}

	public String getOrder_price() {
		return order_price;
	}

	public void setOrder_point(String order_point) {
		this.order_point = order_point;
	}

	public String getOrder_point() {
		return order_point;
	}
	
	public String toString() {
		return "order_idx="+order_idx+"member_idx="+member_idx+"order_name="+order_name+"order_zipcode="+order_zipcode+"order_addr1="+order_addr1+"order_mobile="+order_mobile+"order_phone="+order_phone+"order_comment="+order_comment+"order_process_idx="+order_process_idx+"order_type_idx="+order_type_idx+"order_hiredate="+order_hiredate+"order_addr2="+order_addr2+"order_price="+order_price+"order_point="+order_point+"order_delivery_code="+order_delivery_code;
	}

	public void setProduct_idx_array(int[] product_idx_array) {
		this.product_idx_array = product_idx_array;
	}

	public int[] getProduct_idx_array() {
		return product_idx_array;
	}

	public void setORDER_PRODUCT_COUNT(int[] oRDER_PRODUCT_COUNT) {
		ORDER_PRODUCT_COUNT = oRDER_PRODUCT_COUNT;
	}

	public int[] getORDER_PRODUCT_COUNT() {
		return ORDER_PRODUCT_COUNT;
	}

	public void setORDER_PRODUCT_SELL_PRICE(int[] oRDER_PRODUCT_SELL_PRICE) {
		ORDER_PRODUCT_SELL_PRICE = oRDER_PRODUCT_SELL_PRICE;
	}

	public int[] getORDER_PRODUCT_SELL_PRICE() {
		return ORDER_PRODUCT_SELL_PRICE;
	}

	public void setORDER_PRODUCT_POINT(int[] oRDER_PRODUCT_POINT) {
		ORDER_PRODUCT_POINT = oRDER_PRODUCT_POINT;
	}

	public int[] getORDER_PRODUCT_POINT() {
		return ORDER_PRODUCT_POINT;
	}

	public void setOrder_delivery_code(String order_delivery_code) {
		this.order_delivery_code = order_delivery_code;
	}

	public String getOrder_delivery_code() {
		return order_delivery_code;
	}


}
