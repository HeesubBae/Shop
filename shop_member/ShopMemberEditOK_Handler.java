package shoeseholic.shop_member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shoeseholic.common.CommandHandler;
import shoeseholic.member.MemberBeans;
import shoeseholic.member.MemberDAO;

public class ShopMemberEditOK_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("member_idx")!=null){
			
				MemberBeans bean=new MemberBeans();
				bean.setMember_idx(session.getAttribute("member_idx").toString());
				bean.setMember_pass(request.getParameter("member_pass"));
				bean.setMember_addr1(request.getParameter("member_addr1"));
				bean.setMember_addr2(request.getParameter("member_addr2"));
				bean.setMember_zipcode(request.getParameter("member_zipcode"));
				bean.setMember_mobile(request.getParameter("member_mobile"));
				bean.setMember_phone(request.getParameter("member_phone"));
				
						
				MemberDAO mb = new MemberDAO();
				mb.SHOP_MEMBER_EDIT(bean);
				
				return "/shop_member_edit.do?member_idx="+bean.getMember_idx();
				}
		return "/shop/login/login.tiles";
	}		
}
