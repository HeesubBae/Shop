package shoeseholic.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class MemberView_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String member_id=request.getParameter("member_idx"); 
		MemberDAO mb = new MemberDAO();
		MemberBeans bean=mb.selectMember(member_id);
		
		request.setAttribute("bean", bean);
	
		return "/admin/admin_member/member_view.tiles";
	}
	
}