package shoeseholic.staff;

import shoeseholic.common.Beans;

public class StaffBeans extends Beans{
	private String staff_idx,staff_id,staff_pass,staff_name,staff_email,staff_mobile,department_idx,staff_level_idx,department_name,staff_level_name;
	
	public String toString(){
		return "staff_idx="+staff_idx+"staff_id="+staff_id+"staff_pass="+staff_pass+"staff_name="+staff_name+"staff_email="+staff_email+"staff_mobile="+staff_mobile+"department_idx="+department_idx+"staff_level_idx="+staff_level_idx+"department_name="+department_name+"staff_level_name="+staff_level_name;
	}

	public String getStaff_idx() {
		return staff_idx;
	}

	public void setStaff_idx(String staff_idx) {
		this.staff_idx = staff_idx;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_pass() {
		return staff_pass;
	}

	public void setStaff_pass(String staff_pass) {
		this.staff_pass = staff_pass;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getStaff_email() {
		return staff_email;
	}

	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}

	public String getStaff_mobile() {
		return staff_mobile;
	}

	public void setStaff_mobile(String staff_mobile) {
		this.staff_mobile = staff_mobile;
	}

	public String getDepartment_idx() {
		return department_idx;
	}

	public void setDepartment_idx(String department_idx) {
		this.department_idx = department_idx;
	}
	

	public String getStaff_level_idx() {
		return staff_level_idx;
	}

	public void setStaff_level_idx(String staff_level_idx) {
		this.staff_level_idx = staff_level_idx;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setStaff_level_name(String staff_level_name) {
		this.staff_level_name = staff_level_name;
	}

	public String getStaff_level_name() {
		return staff_level_name;
	}
	
}
