package shoeseholic.common_form;

public class search_type {
	
	public String get_common_list_search_type(int search_type){
		StringBuffer sb=new StringBuffer();
		
		sb.append("<select class='input_size10' name='search_type' >");
		if(search_type==0){
			sb.append("<option value='0'>--���հ˻�--</option>");
			sb.append("<option value='1'>ȸ�����̵�</option>");
			sb.append("<option value='2'>ȸ����</option>");
			sb.append("<option value='3'>ȸ������ȣ</option>");
			sb.append("<option value='4'>ȸ����ȭ��ȣ</option>");
			sb.append("<option value='5'>ȸ���ּ�</option>");
			sb.append("<option value='6'>ȸ���̸���</option>");
		}else{
			if(search_type==0){	sb.append("<option value='1' selected>	--���հ˻�--	</option>");}else{sb.append("<option value='0'>	--���հ˻�--	</option>");}
			if(search_type==1){	sb.append("<option value='1' selected>	ȸ�����̵�	</option>");}else{sb.append("<option value='1'>	ȸ�����̵�	</option>");}
			if(search_type==2){	sb.append("<option value='2' selected>	ȸ����	</option>");}else{sb.append("<option value='2'>	ȸ����	</option>");}
			if(search_type==3){	sb.append("<option value='3' selected>	ȸ������ȣ	</option>");}else{sb.append("<option value='3'>	ȸ������ȣ	</option>");}
			if(search_type==4){	sb.append("<option value='4' selected>	ȸ����ȭ��ȣ	</option>");}else{sb.append("<option value='4'>	ȸ����ȭ��ȣ	</option>");}
			if(search_type==5){	sb.append("<option value='5' selected>	ȸ���ּ�	</option>");}else{sb.append("<option value='5'>	ȸ���ּ�	</option>");}
			if(search_type==6){	sb.append("<option value='6' selected>	ȸ���̸���	</option>");}else{sb.append("<option value='6'>	ȸ���̸���	</option>");}
		}
		sb.append("</select>");
		
		return sb.toString();
	}
	
}
