package shoeseholic.pop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.member.MemberBeans;
import shoeseholic.member.MemberDAO;



public class POP_IdCheck_Handler  implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		String member_id=request.getParameter("member_id");
		
		MemberDAO mb = new MemberDAO();
		MemberBeans bean=mb.selectID(member_id);
		
		request.setAttribute("bean", bean);
		return "/pop/idck.jsp";
	}
	
}
