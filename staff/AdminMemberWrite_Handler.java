package shoeseholic.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class AdminMemberWrite_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		StaffBeans bean=new StaffBeans();
		bean.setStaff_idx(request.getParameter("staff_idx"));
		bean.setStaff_id(request.getParameter("staff_id"));
		bean.setStaff_pass(request.getParameter("staff_pass"));
		bean.setStaff_name(request.getParameter("staff_name"));
		bean.setStaff_email(request.getParameter("staff_email"));
		bean.setStaff_mobile(request.getParameter("staff_mobile"));
		bean.setDepartment_idx(request.getParameter("department_idx"));
		bean.setStaff_level_idx(request.getParameter("staff_level_idx"));
		
		StaffDAO sb = new StaffDAO();
		sb.insertOracle(bean);
		
		
		return "/admin_member_list.do";
	}
}
