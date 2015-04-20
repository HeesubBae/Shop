package shoeseholic.shop_member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.member.MemberBeans;
import shoeseholic.member.MemberDAO;

public class ShopMemberEdit_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		if(session.getAttribute("member_idx")!=null){
	
			String member_idx=(String) session.getAttribute("member_idx"); 
			MemberDAO mb = new MemberDAO();
			MemberBeans bean=mb.selectMember(member_idx);
			
			request.setAttribute("bean", bean);
		
			return "/shop/member/member_edit/member_edit.tiles";
			}
		return "/shop/login/login.tiles";
	}
	
}