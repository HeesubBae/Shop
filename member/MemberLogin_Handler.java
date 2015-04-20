package shoeseholic.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.client.SenderException;



import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.good.GoodBeans;
import shoeseholic.good.GoodDAO;

public class MemberLogin_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		//System.out.println("---------------l");
		String url="/";
		String member_id=request.getParameter("member_id");
		String member_pass=request.getParameter("member_pass");
		
		if(member_id==null){
			System.out.println("id values is null");
		}
		//System.out.println("id values is not null");
		MemberDAO sb=new MemberDAO();
		MemberBeans bean=sb.login(member_id,member_pass);
		//System.out.println("check id : "+bean.getStaff_id());
		
		if(member_id.equals(bean.getMember_id())){
			System.out.println("beans not null");
			url="/index.do";
			
			session.setAttribute("member_id",bean.getMember_id());
			session.setAttribute("member_name",bean.getMember_name());
			session.setAttribute("member_idx",bean.getMember_idx());
			System.out.println("member_idx="+session.getAttribute("member_idx"));
		}
		else
		{
			System.out.println("beans is null");
			url="/shop/login/login.tiles";
		}
		
		//session.setAttribute("basket", list);
		//String js="<script language='javascript'>alert('아이디혹은 비밀번호가 잘못되었습니다.');</script>";
		
		//request.setAttribute("js",js);
		//System.out.println("print url: "+url);
		return url;
	}
}