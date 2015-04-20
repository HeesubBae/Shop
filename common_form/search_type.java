package shoeseholic.common_form;

public class search_type {
	
	public String get_common_list_search_type(int search_type){
		StringBuffer sb=new StringBuffer();
		
		sb.append("<select class='input_size10' name='search_type' >");
		if(search_type==0){
			sb.append("<option value='0'>--통합검색--</option>");
			sb.append("<option value='1'>회원아이디</option>");
			sb.append("<option value='2'>회원명</option>");
			sb.append("<option value='3'>회원폰번호</option>");
			sb.append("<option value='4'>회원전화번호</option>");
			sb.append("<option value='5'>회원주소</option>");
			sb.append("<option value='6'>회원이메일</option>");
		}else{
			if(search_type==0){	sb.append("<option value='1' selected>	--통합검색--	</option>");}else{sb.append("<option value='0'>	--통합검색--	</option>");}
			if(search_type==1){	sb.append("<option value='1' selected>	회원아이디	</option>");}else{sb.append("<option value='1'>	회원아이디	</option>");}
			if(search_type==2){	sb.append("<option value='2' selected>	회원명	</option>");}else{sb.append("<option value='2'>	회원명	</option>");}
			if(search_type==3){	sb.append("<option value='3' selected>	회원폰번호	</option>");}else{sb.append("<option value='3'>	회원폰번호	</option>");}
			if(search_type==4){	sb.append("<option value='4' selected>	회원전화번호	</option>");}else{sb.append("<option value='4'>	회원전화번호	</option>");}
			if(search_type==5){	sb.append("<option value='5' selected>	회원주소	</option>");}else{sb.append("<option value='5'>	회원주소	</option>");}
			if(search_type==6){	sb.append("<option value='6' selected>	회원이메일	</option>");}else{sb.append("<option value='6'>	회원이메일	</option>");}
		}
		sb.append("</select>");
		
		return sb.toString();
	}
	
}
