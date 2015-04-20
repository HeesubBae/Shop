package shoeseholic.member;

import shoeseholic.common.Beans;

public class Member_point_log_Beans  extends Beans{
	private String member_idx,order_idx,member_point_log_type_idx,member_point_log_idx,staff_idx,member_point_log_memo,member_point_log_hiredate,member_point_log_point;
	
	public String toString(){
		return "member_idx="+member_idx+"order_idx="+order_idx+"member_point_log_type_idx="+member_point_log_type_idx+"member_point_log_idx="+member_point_log_idx+"staff_idx="+staff_idx+"member_point_log_memo="+member_point_log_memo ;
	}
	
	public String getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(String member_idx) {
		this.member_idx = member_idx;
	}

	public String getOrder_idx() {
		return order_idx;
	}

	public void setOrder_idx(String order_idx) {
		this.order_idx = order_idx;
	}

	public String getMember_point_log_type_idx() {
		return member_point_log_type_idx;
	}

	public void setMember_point_log_type_idx(String member_point_log_type_idx) {
		this.member_point_log_type_idx = member_point_log_type_idx;
	}

	public String getMember_point_log_idx() {
		return member_point_log_idx;
	}

	public void setMember_point_log_idx(String member_point_log_idx) {
		this.member_point_log_idx = member_point_log_idx;
	}

	public String getStaff_idx() {
		return staff_idx;
	}

	public void setStaff_idx(String staff_idx) {
		this.staff_idx = staff_idx;
	}

	public String getMember_point_log_memo() {
		return member_point_log_memo;
	}

	public void setMember_point_log_memo(String member_point_log_memo) {
		this.member_point_log_memo = member_point_log_memo;
	}

	public void setMember_point_log_hiredate(String member_point_log_hiredate) {
		this.member_point_log_hiredate = member_point_log_hiredate;
	}

	public String getMember_point_log_hiredate() {
		return member_point_log_hiredate;
	}

	public void setMember_point_log_point(String member_point_log_point) {
		this.member_point_log_point = member_point_log_point;
	}

	public String getMember_point_log_point() {
		return member_point_log_point;
	}
	
}
