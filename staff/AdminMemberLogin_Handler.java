package shoeseholic.staff;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.client.SenderException;



import shoeseholic.common.CommandHandler;
import shoeseholic.common.Pageing;
import shoeseholic.good.GoodBeans;
import shoeseholic.good.GoodDAO;

public class AdminMemberLogin_Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("euc-kr");
		HttpSession session = request.getSession(true);
		//System.out.println("---------------l");
		String url="/";
		String staff_id=request.getParameter("staff_id");
		String staff_pass=request.getParameter("staff_pass");
		
		if(staff_id==null){
			System.out.println("id values is null");
		}
		//System.out.println("id values is not null");
		StaffDAO sb=new StaffDAO();
		StaffBeans bean=sb.login(staff_id,staff_pass);
		//System.out.println("check id : "+bean.getStaff_id());
		
		if(staff_id.equals(bean.getStaff_id())){
			System.out.println("beans not null");
			url="/admin_member_list.do";
			session.setAttribute("staff_id",bean.getStaff_id());
			session.setAttribute("staff_name",bean.getStaff_name());
			session.setAttribute("staff_idx",bean.getStaff_idx());
			System.out.println("staff_idx="+session.getAttribute("staff_idx"));
		}
		else
		{
			System.out.println("beans is null");
			url="admin/admin_login.jsp";
		}
		
		//session.setAttribute("basket", list);
		//String js="<script language='javascript'>alert('아이디혹은 비밀번호가 잘못되었습니다.');</script>";
		
		//request.setAttribute("js",js);
		System.out.println("print url: "+url);
		return url;
	}
}