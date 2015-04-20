package shoeseholic.order;
import shoeseholic.common.Beans;

public class Order_process_log_Beans extends Beans{

	private String order_process_log_idx,before_order_process_log_idx,after_order_process_log_idx,order_process_log_hiredate,staff_idx,orer_idx;

	public String toString() {
		return "order_process_log_idx="+order_process_log_idx+"before_order_process_log_idx="+before_order_process_log_idx+"after_order_process_log_idx="+after_order_process_log_idx+"order_process_log_hiredate="+order_process_log_hiredate+"staff_idx="+staff_idx+"orer_idx="+orer_idx;
	}
	public String getOrder_process_log_idx() {
		return order_process_log_idx;
	}

	public void setOrder_process_log_idx(String order_process_log_idx) {
		this.order_process_log_idx = order_process_log_idx;
	}

	public String getBefore_order_process_log_idx() {
		return before_order_process_log_idx;
	}

	public void setBefore_order_process_log_idx(String before_order_process_log_idx) {
		this.before_order_process_log_idx = before_order_process_log_idx;
	}

	public String getAfter_order_process_log_idx() {
		return after_order_process_log_idx;
	}

	public void setAfter_order_process_log_idx(String after_order_process_log_idx) {
		this.after_order_process_log_idx = after_order_process_log_idx;
	}

	public String getOrder_process_log_hiredate() {
		return order_process_log_hiredate;
	}

	public void setOrder_process_log_hiredate(String order_process_log_hiredate) {
		this.order_process_log_hiredate = order_process_log_hiredate;
	}

	public String getStaff_idx() {
		return staff_idx;
	}

	public void setStaff_idx(String staff_idx) {
		this.staff_idx = staff_idx;
	}
	public void setOrer_idx(String orer_idx) {
		this.orer_idx = orer_idx;
	}
	public String getOrer_idx() {
		return orer_idx;
	}
}
