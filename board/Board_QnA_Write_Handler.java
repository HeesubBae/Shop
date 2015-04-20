package shoeseholic.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.staff.StaffBeans;
import shoeseholic.staff.StaffDAO;

public class Board_QnA_Write_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("euc-kr");
		String member_idx=request.getParameter("member_idx");
		
		 
		StaffDAO mb = new StaffDAO();
		StaffBeans bean=mb.selectStaff(session.getAttribute("staff_idx").toString());
		
		request.setAttribute("bean", bean);
		request.setAttribute("board_type",2);
		return "/admin/admin_board/board_write.tiles";
	}
}
