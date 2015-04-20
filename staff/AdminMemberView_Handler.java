package shoeseholic.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class AdminMemberView_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String staff_id=request.getParameter("staff_idx"); 
		StaffDAO mb = new StaffDAO();
		StaffBeans bean=mb.selectStaff(staff_id);
		
		request.setAttribute("bean", bean);
		
		return "/admin/admin_operate/admin_member_view.tiles";
	}
}