package shoeseholic.shop_member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoeseholic.common.CommandHandler;
import shoeseholic.member.MemberBeans;
import shoeseholic.member.MemberDAO;



public class ShopJoin_Handler  implements CommandHandler {

   


	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		
		MemberBeans bean=new MemberBeans();
		//bean.setMember_idx(request.getParameter("member_idx"));
		
		bean.setMember_id(request.getParameter("member_id"));
		bean.setMember_pass(request.getParameter("member_pass"));
		bean.setMember_name(request.getParameter("member_name"));
		bean.setMember_email(request.getParameter("member_email"));
		bean.setMember_addr1(request.getParameter("member_addr1"));
		bean.setMember_zipcode(request.getParameter("member_zipcode"));
		bean.setMember_mobile(request.getParameter("member_mobile"));
		bean.setMember_phone(request.getParameter("member_phone"));
		String member_birth_day01=request.getParameter("member_birth_day01");
		String member_birth_day02=request.getParameter("member_birth_day02");
		String member_birth_day03=request.getParameter("member_birth_day03");
		String member_birth_day=member_birth_day01+member_birth_day02+member_birth_day03;
		bean.setMember_birthday(member_birth_day.trim());
		//bean.setMember_hiredate(request.getParameter("member_hiredate"));
		bean.setMember_addr2(request.getParameter("member_addr2"));
		bean.setMember_point(request.getParameter("member_point"));
		bean.setMember_sex(request.getParameter("member_sex"));
		
		System.out.println(bean.getMember_idx());
		
		
		MemberDAO mb = new MemberDAO();
		mb.insertOracle2(bean);    
		
		//response.sendRedirect("/shoesholic/index.do");
		
		return "/";
	}
	
}
