package shoeseholic.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;

public class MemberEditOk_Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		MemberBeans bean=new MemberBeans();
		bean.setMember_idx(request.getParameter("member_idx"));
		bean.setMember_id(request.getParameter("member_id"));
		bean.setMember_pass(request.getParameter("member_pass"));
		bean.setMember_name(request.getParameter("member_name"));
		bean.setMember_email(request.getParameter("member_email"));
		bean.setMember_addr1(request.getParameter("member_addr1"));
		bean.setMember_zipcode(request.getParameter("member_zipcode"));
		bean.setMember_mobile(request.getParameter("member_mobile"));
		bean.setMember_phone(request.getParameter("member_phone"));
		bean.setMember_birthday(request.getParameter("member_birthday"));
		bean.setMember_addr2(request.getParameter("member_addr2"));
		bean.setMember_point(request.getParameter("member_point"));
		
		//System.out.println("after : " + bean.getMember_idx());
		//System.out.println("after : " + bean.getMember_id());
		//System.out.println("after : " + bean.getMember_name());
		
		MemberDAO mb = new MemberDAO();
		mb.editMember(bean);
		
		System.out.println("==========");
		System.out.println("|" + bean.getMember_email() + "|");
		System.out.println("==========");
		
	//	System.out.println(request.getParameter("member_idx"));	
	//	System.out.println(request.getParameter("member_id"));
	//	System.out.println(bean.getMember_idx());
		return "/member_view.do?member_idx="+bean.getMember_idx();
	}
	
}
