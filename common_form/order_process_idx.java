package shoeseholic.common_form;

public class order_process_idx {
	
	public String getOrder_process_idx(int order_process_idx){
		StringBuffer sb=new StringBuffer();
		
		sb.append("<select class='input_size10' name='order_process_idx' >");
		if(order_process_idx==0){
			sb.append("<option value='0'>--�ֹ�����--</option>");
			sb.append("<option value='1'>�Աݴ��</option>");
			sb.append("<option value='2'>����Ȯ��</option>");
			sb.append("<option value='3'>��ǰ�غ�</option>");
			sb.append("<option value='4'>����غ�</option>");
			sb.append("<option value='5'>��ۿϷ�</option>");
			sb.append("<option value='6'>��ȯ��û</option>");
			sb.append("<option value='7'>��ȯ��ûȮ��</option>");
			sb.append("<option value='8'>ȯ�ҽ�û</option>");
			sb.append("<option value='9'>ȯ�ҹ�ǰȮ��</option>");
			sb.append("<option value='10'>ȯ�ҽ���</option>");
			sb.append("<option value='11'>ȯ�ҿϷ�</option>");
			sb.append("<option value='12'>�ǸſϷ�</option>");
		}else{
			if(order_process_idx==0){	sb.append("<option value='0' selected>	--�ֹ�����--	</option>");}else{sb.append("<option value='0'>	--�ֹ�����--	</option>");}
			if(order_process_idx==1){	sb.append("<option value='1' selected>	�Աݴ��	</option>");}else{sb.append("<option value='1'>	�Աݴ��	</option>");}
			if(order_process_idx==2){	sb.append("<option value='2' selected>	����Ȯ��	</option>");}else{sb.append("<option value='2'>	����Ȯ��	</option>");}
			if(order_process_idx==3){	sb.append("<option value='3' selected>	��ǰ�غ�	</option>");}else{sb.append("<option value='3'>	��ǰ�غ�	</option>");}
			if(order_process_idx==4){	sb.append("<option value='4' selected>	����غ�	</option>");}else{sb.append("<option value='4'>	����غ�	</option>");}
			if(order_process_idx==5){	sb.append("<option value='5' selected>	��ۿϷ�	</option>");}else{sb.append("<option value='5'>	��ۿϷ�	</option>");}
			if(order_process_idx==6){	sb.append("<option value='6' selected>	��ȯ��û	</option>");}else{sb.append("<option value='6'>	��ȯ��û	</option>");}
			if(order_process_idx==7){	sb.append("<option value='7' selected>	��ȯ��ûȮ��	</option>");}else{sb.append("<option value='7'>	��ȯ��ûȮ��	</option>");}
			if(order_process_idx==8){	sb.append("<option value='8' selected>	ȯ�ҽ�û	</option>");}else{sb.append("<option value='8'>	ȯ�ҽ�û	</option>");}
			if(order_process_idx==9){	sb.append("<option value='9' selected>	ȯ�ҹ�ǰȮ��	</option>");}else{sb.append("<option value='9'>	ȯ�ҹ�ǰȮ��	</option>");}
			if(order_process_idx==10){	sb.append("<option value='10' selected>	ȯ�ҽ���	</option>");}else{sb.append("<option value='10'>	ȯ�ҽ���	</option>");}
			if(order_process_idx==11){	sb.append("<option value='11' selected>	ȯ�ҿϷ�	</option>");}else{sb.append("<option value='11'>	ȯ�ҿϷ�	</option>");}
			if(order_process_idx==12){	sb.append("<option value='12' selected>	�ǸſϷ�	</option>");}else{sb.append("<option value='12'>�ǸſϷ�	</option>");}
		}
		sb.append("</select>");
		
		return sb.toString();		
		
	}
}
