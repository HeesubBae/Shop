package shoeseholic.common;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pageing {

public String getPage(String b,int pagesize,int blockpage,int nowpage ) {
	
	StringBuffer sb=new StringBuffer();
			
			int a=Integer.parseInt(b);  
			int totalpage=(int)Math.ceil((float)a/pagesize);		
			
			int temp = ((nowpage - 1) / blockpage) * blockpage + 1;
			if(temp==1){
				sb.append("<a href='#'><<</a>");
				sb.append("<a href='#'><</a>");
			}else{
				sb.append("<a href=javascript:paging('"+1+"')><<</a>");
				sb.append("<a href=javascript:paging('"+(temp-blockpage)+"')><</a>");
			}
			
			int loop;
			
			for(loop=0; loop<blockpage; loop ++  ){
				if(temp==nowpage){
					sb.append("<a href=javascript:paging('"+temp+"') class='on'>"+temp+"</a>");
				}else{
					sb.append("<a href=javascript:paging('"+temp+"')>"+temp+"</a>");	
				}
				 temp = temp + 1;
				if(temp==totalpage+1 || temp==1) {break;}
			}
			
			//sb.append("temp="+temp);
			//sb.append("totalpage="+totalpage);
			
			if(temp > totalpage){
				sb.append("<a href='#'>></a>");
			}else{
				sb.append("<a href=javascript:paging('"+temp+"')>></a>");
			}
			sb.append("<a href=javascript:paging('"+totalpage+"')>>></a>");
			return sb.toString();
	}

}
