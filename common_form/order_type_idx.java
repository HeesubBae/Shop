package shoeseholic.common_form;

public class order_type_idx {
	public String getOrder_type_idx(int order_type_idx){
		StringBuffer sb=new StringBuffer();
		
		sb.append("<select class='input_size10' name='order_type_idx' >");
		if(order_type_idx==0){
			sb.append("<option value='0'>--�ֹ�Ÿ��--</option>");
			sb.append("<option value='1'>�������Ա�</option>");
			sb.append("<option value='2'>�ſ�ī��</option>");
			sb.append("<option value='3'>������ü</option>");
			sb.append("<option value='4'>�������</option>");
			sb.append("<option value='5'>�ڵ���</option>");
			sb.append("<option value='6'>����Ʈ</option>");
			sb.append("<option value='7'>����ũ��-�ſ�ī��</option>");
			sb.append("<option value='8'>����ũ��-������ü</option>");
			sb.append("<option value='9'>����ũ��-�������</option>");
		}else{
			if(order_type_idx==0){	sb.append("<option value='1' selected>	--�ֹ�Ÿ��--	</option>");}else{sb.append("<option value='1'>	--�ֹ�Ÿ��--	</option>");}
			if(order_type_idx==1){	sb.append("<option value='1' selected>	�������Ա�	</option>");}else{sb.append("<option value='1'>	�������Ա�	</option>");}
			if(order_type_idx==2){	sb.append("<option value='2' selected>	�ſ�ī��	</option>");}else{sb.append("<option value='2'>	�ſ�ī��	</option>");}
			if(order_type_idx==3){	sb.append("<option value='3' selected>	������ü	</option>");}else{sb.append("<option value='3'>	������ü	</option>");}
			if(order_type_idx==4){	sb.append("<option value='4' selected>	�������	</option>");}else{sb.append("<option value='4'>	�������	</option>");}
			if(order_type_idx==5){	sb.append("<option value='5' selected>	�ڵ���	</option>");}else{sb.append("<option value='5'>	�ڵ���	</option>");}
			if(order_type_idx==6){	sb.append("<option value='6' selected>	����Ʈ	</option>");}else{sb.append("<option value='6'>	����Ʈ	</option>");}
			if(order_type_idx==7){	sb.append("<option value='7' selected>	����ũ��-�ſ�ī��	</option>");}else{sb.append("<option value='7'>	����ũ��-�ſ�ī��	</option>");}
			if(order_type_idx==8){	sb.append("<option value='8' selected>	����ũ��-������ü	</option>");}else{sb.append("<option value='8'>	����ũ��-������ü	</option>");}
			if(order_type_idx==9){	sb.append("<option value='9' selected>	����ũ��-�������	</option>");}else{sb.append("<option value='9'>	����ũ��-�������	</option>");}
		}
		sb.append("</select>");
		
		return sb.toString();		 
		
	}
}
