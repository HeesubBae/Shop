package shoeseholic.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class AdminMemberEdit_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String staff_idx=request.getParameter("staff_idx");
		
		 
		StaffDAO sb = new StaffDAO();
		StaffBeans bean=sb.selectStaff(staff_idx);
		
		request.setAttribute("bean", bean);
		System.out.println("edit : "+staff_idx);
		return "/admin/admin_operate/admin_member_edit.tiles";
	}
	
}