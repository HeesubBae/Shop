package shoeseholic.staff;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class AdminMemberEditOk_Handler implements CommandHandler {

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
		
		System.out.println("editok : " + bean.getStaff_idx());
		System.out.println("editok : " + bean.getStaff_id());
		StaffDAO sb = new StaffDAO();
		sb.editStaff(bean);
	//	System.out.println(request.getParameter("member_idx"));	
	//	System.out.println(request.getParameter("member_id"));
	//	System.out.println(bean.getMember_idx());
		return "/admin_member_view.do?staff_idx="+bean.getStaff_idx();
	}
	
}
