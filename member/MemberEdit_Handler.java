package shoeseholic.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class MemberEdit_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		String member_idx=request.getParameter("member_idx");
		
		 
		MemberDAO mb = new MemberDAO();
		MemberBeans bean=mb.selectMember(member_idx);
		
		request.setAttribute("bean", bean);
		System.out.println("==========");
		System.out.println("|" + bean.getMember_email() + "|");
		System.out.println("==========");
		
		return "/admin/admin_member/member_edit.tiles";
	}
	
}
