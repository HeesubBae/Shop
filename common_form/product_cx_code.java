package shoeseholic.common_form;

import java.sql.SQLException;
import java.util.ArrayList;



public class product_cx_code {
	
	public String getProduct_cx_code_categoryselect(int c1_code,int c2_code,int c3_code) throws SQLException {
	StringBuffer sb=new StringBuffer();

			if(c1_code!=0 && c2_code!=0){//2���з� ���ý� 3�� �з� �˻� ����
					
						product_cx_code_DAO c2 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
						sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;' valign='top'>");
						sb.append("<select class='input_size90' name='product_c2_code_idx' onChange=form.submit();>");
						sb.append("<option value='0'>--2�� �з�--</option>");
						for(int i=0;i<datas2.size();i++){				
							if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
							}
						}
						sb.append("</select>");
						sb.append("</td>");
						
					product_cx_code_DAO c3 = new product_cx_code_DAO();
					ArrayList<product_cx_code_beans> datas3 = c3.getProduct_c3_code_list(c2_code);
						sb.append("<td style='width:50%; border-right:1px solid #e2e2e2; padding-left:0;'>");
						sb.append("<table>");
						for(int i=0;i<datas3.size();i++){				
							sb.append("<tr>");	
							sb.append("<td height='30px' align=center><a href=\"javascript:reback('"+c1_code+"','"+c2_code+"','"+datas3.get(i).getProduct_c3_code_idx()+"','"+datas3.get(i).getProduct_c1_code_name()+"','"+datas3.get(i).getProduct_c2_code_name()+"','"+datas3.get(i).getProduct_c3_code_name()+"')\">"+datas3.get(i).getProduct_c3_code_name()+"</a></td>");
							sb.append("<tr>");	
						}
						sb.append("</table>");
						sb.append("</td>");
						

			}else if(c1_code!=0){//1�� �з� ���ý� 2�� �з� �˻�
				
					product_cx_code_DAO c2 = new product_cx_code_DAO();
					ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
					sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;'>");
					sb.append("<select class='input_size90' name='product_c2_code_idx' onChange=form.submit();>");
					sb.append("<option value='0'>--2�� �з�--</option>");
					for(int i=0;i<datas2.size();i++){				
						if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
						sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
						}else{
						sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
						}
					}
					sb.append("</select>");
					sb.append("</td>");
					
					sb.append("<td style='width:50%; border-right:1px solid #e2e2e2; padding-left:0;'>");
					sb.append("<table><tr><td id='noborder'>&nbsp;</td></tr></table>");
					}			 
		return sb.toString();
		}
	

	public String getProduct_cx_code_list(int c1_code,int c2_code,int c3_code) throws SQLException {
		StringBuffer sb=new StringBuffer();

				if(c1_code!=0 && c2_code!=0){//2���з� ���ý� 3�� �з� �˻� ����
						product_cx_code_DAO c1 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas = c1.getProduct_c1_code_list();
							sb.append("<select class='input_size10' name='product_c1_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--1�� �з�--</option>");
						for(int i=0;i<datas.size();i++){				
							if(Integer.parseInt(datas.get(i).getProduct_c1_code_idx())==c1_code){
							sb.append("<option value='"+datas.get(i).getProduct_c1_code_idx()+"'  selected>"+datas.get(i).getProduct_c1_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas.get(i).getProduct_c1_code_idx()+"' >"+datas.get(i).getProduct_c1_code_name()+"</option>");	
							}
						}
							sb.append("</select>");
							
						product_cx_code_DAO c2 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
							sb.append("<select class='input_size10' name='product_c2_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--2�� �з�--</option>");
						for(int i=0;i<datas2.size();i++){				
							if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
							}
						}
							sb.append("</select>");
							
						product_cx_code_DAO c3 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas3 = c3.getProduct_c3_code_list(c2_code);
							sb.append("<select class='input_size10' name='product_c3_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--3�� �з�--</option>");
						for(int i=0;i<datas3.size();i++){				
							if(Integer.parseInt(datas3.get(i).getProduct_c3_code_idx())==c3_code){
							sb.append("<option value='"+datas3.get(i).getProduct_c3_code_idx()+"'  selected>"+datas3.get(i).getProduct_c3_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas3.get(i).getProduct_c3_code_idx()+"' >"+datas3.get(i).getProduct_c3_code_name()+"</option>");	
							}
						}
							sb.append("</select>");
							
			}else if(c1_code!=0){//1�� �з� ���ý� 2�� �з� �˻�
						product_cx_code_DAO c1 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas = c1.getProduct_c1_code_list();
							sb.append("<select class='input_size10' name='product_c1_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--1�� �з�--</option>");
						for(int i=0;i<datas.size();i++){				
							if(Integer.parseInt(datas.get(i).getProduct_c1_code_idx())==c1_code){
							sb.append("<option value='"+datas.get(i).getProduct_c1_code_idx()+"'  selected>"+datas.get(i).getProduct_c1_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas.get(i).getProduct_c1_code_idx()+"' >"+datas.get(i).getProduct_c1_code_name()+"</option>");	
							}
						}
							sb.append("</select>");
							
						product_cx_code_DAO c2 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
							sb.append("<select class='input_size10' name='product_c2_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--2�� �з�--</option>");
						for(int i=0;i<datas2.size();i++){				
							if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
							}
						}
							sb.append("</select>");
							
							sb.append("<select class='input_size10' name='product_c3_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--3�� �з�--</option>");
							sb.append("</select>");					
					
						
			}else if(c1_code==0 ){//�׳� ��ﶧ C1�ڵ� ��ü�˻�	
					
						product_cx_code_DAO c1 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas = c1.getProduct_c1_code_list();
							sb.append("<select class='input_size10' name='product_c1_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--1�� �з�--</option>");
						for(int i=0;i<datas.size();i++){				
							if(Integer.parseInt(datas.get(i).getProduct_c1_code_idx())==c1_code){
							sb.append("<option value='"+datas.get(i).getProduct_c1_code_idx()+"'  selected>"+datas.get(i).getProduct_c1_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas.get(i).getProduct_c1_code_idx()+"' >"+datas.get(i).getProduct_c1_code_name()+"</option>");	
							}
						}
							sb.append("</select>");
							
							sb.append("<select class='input_size10' name='product_c2_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--2�� �з�--</option>");
							sb.append("</select>");
							
							sb.append("<select class='input_size10' name='product_c3_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--3�� �з�--</option>");
							sb.append("</select>");

					}				
					return sb.toString();
			}	


	public String getProduct_cx_code_display_categoryselect(int c1_code,int c2_code,int c3_code) throws SQLException {
		StringBuffer sb=new StringBuffer();
					
		
		
		if(c2_code!=0 && c3_code!=0){//2���з� ���ý� 3�� �з� �˻� ����
			
			product_cx_code_DAO c2 = new product_cx_code_DAO();
			ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
			sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;' valign='top'>");
			sb.append("<select class='input_size90' name='product_c2_code_idx' onChange=form.submit();>");
			sb.append("<option value='0'>--2�� �з�--</option>");
			for(int i=0;i<datas2.size();i++){				
				if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
				sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
				}else{
				sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
				}
			}
			sb.append("</select>");
			sb.append("</td>");
			
		product_cx_code_DAO c3 = new product_cx_code_DAO();
		ArrayList<product_cx_code_beans> datas3 = c3.getProduct_c3_code_list(c2_code);
			sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;'>");
			sb.append("<select class='input_size90' name='product_c3_code_idx' onChange=form.submit();>");
			sb.append("<option value='0'>--3�� �з�--</option>");
			for(int i=0;i<datas3.size();i++){				
				if(Integer.parseInt(datas3.get(i).getProduct_c3_code_idx())==c3_code){
				sb.append("<option value='"+datas3.get(i).getProduct_c3_code_idx()+"' selected>"+datas3.get(i).getProduct_c3_code_name()+"</option>");	
				}else{
				sb.append("<option value='"+datas3.get(i).getProduct_c3_code_idx()+"' >"+datas3.get(i).getProduct_c3_code_name()+"</option>");
				}
			}
			sb.append("</select>");
			sb.append("</td>");
			

		}else if(c2_code!=0 && c3_code==0){//2���з� ���ý� 3�� �з� �˻� ����
						
							product_cx_code_DAO c2 = new product_cx_code_DAO();
							ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
							sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;' valign='top'>");
							sb.append("<select class='input_size90' name='product_c2_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--2�� �з�--</option>");
							for(int i=0;i<datas2.size();i++){				
								if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
								sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
								}else{
								sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
								}
							}
							sb.append("</select>");
							sb.append("</td>");
							
						product_cx_code_DAO c3 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas3 = c3.getProduct_c3_code_list(c2_code);
							sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;'>");
							sb.append("<select class='input_size90' name='product_c3_code_idx' onChange=form.submit();>");
							sb.append("<option value='0'>--3�� �з�--</option>");
							for(int i=0;i<datas3.size();i++){				
								if(Integer.parseInt(datas3.get(i).getProduct_c3_code_idx())==c3_code){
								sb.append("<option value='"+datas3.get(i).getProduct_c3_code_idx()+"' selected>"+datas3.get(i).getProduct_c3_code_name()+"</option>");	
								}else{
								sb.append("<option value='"+datas3.get(i).getProduct_c3_code_idx()+"' >"+datas3.get(i).getProduct_c3_code_name()+"</option>");
								}
							}
							sb.append("</select>");
							sb.append("</td>");
							
				
				}else if(c1_code!=0){//1�� �з� ���ý� 2�� �з� �˻�
					
						product_cx_code_DAO c2 = new product_cx_code_DAO();
						ArrayList<product_cx_code_beans> datas2 = c2.getProduct_c2_code_list(c1_code);
						sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;'>");
						sb.append("<select class='input_size90' name='product_c2_code_idx' onChange=form.submit();>");
						sb.append("<option value='0'>--2�� �з�--</option>");
						for(int i=0;i<datas2.size();i++){				
							if(Integer.parseInt(datas2.get(i).getProduct_c2_code_idx())==c2_code){
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"'  selected>"+datas2.get(i).getProduct_c2_code_name()+"</option>");
							}else{
							sb.append("<option value='"+datas2.get(i).getProduct_c2_code_idx()+"' >"+datas2.get(i).getProduct_c2_code_name()+"</option>");	
							}
						}
						sb.append("</select>");
						sb.append("</td>");
						
						sb.append("<td style='width:50%; border-right:1px solid #e2e2e2;'>");
						sb.append("<select class='input_size90' name='product_c3_code_idx' onChange=form.submit();>");
						sb.append("<option value='0'>--3�� �з�--</option>");
						sb.append("</select>");
						sb.append("</td>");			  			
						}			 
			return sb.toString();
			}

}
