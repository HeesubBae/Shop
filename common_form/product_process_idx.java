package shoeseholic.common_form;

public class product_process_idx {

	public String getProduct_process_idx_view(int product_process_idx) {
		
		StringBuffer sb=new StringBuffer();
			
				sb.append("<select class='input_size10' name='product_process_idx' >");
				if(product_process_idx==0){
					sb.append("<option value='1'>��ǰ���߽�û</option>");
					sb.append("<option value='2'>���û����û</option>");
					sb.append("<option value='3'>���û������</option>");
					sb.append("<option value='4'>���û���Ϸ�</option>");
					sb.append("<option value='5'>�������</option>");
					sb.append("<option value='6'>��ǰ�Կ�</option>");
					sb.append("<option value='7'>��ǰ���</option>");
					sb.append("<option value='8'>�ǸŽ���</option>");
					sb.append("<option value='9'>�������</option>");
					sb.append("<option value='10'>�Ǹ�����</option>");
				}else{
					if(product_process_idx==1){	sb.append("<option value='1' selected>	��ǰ���߽�û	</option>");}else{sb.append("<option value='1'>	��ǰ���߽�û	</option>");}
					if(product_process_idx==2){	sb.append("<option value='2' selected>	���û����û	</option>");}else{sb.append("<option value='2'>	���û����û	</option>");}
					if(product_process_idx==3){	sb.append("<option value='3' selected>	���û������	</option>");}else{sb.append("<option value='3'>	���û������	</option>");}
					if(product_process_idx==4){	sb.append("<option value='4' selected>	���û���Ϸ�	</option>");}else{sb.append("<option value='4'>	���û���Ϸ�	</option>");}
					if(product_process_idx==5){	sb.append("<option value='5' selected>	�������	</option>");}else{sb.append("<option value='5'>	�������	</option>");}
					if(product_process_idx==6){	sb.append("<option value='6' selected>	��ǰ�Կ�	</option>");}else{sb.append("<option value='6'>	��ǰ�Կ�	</option>");}
					if(product_process_idx==7){	sb.append("<option value='7' selected>	��ǰ���	</option>");}else{sb.append("<option value='7'>	��ǰ���	</option>");}
					if(product_process_idx==8){	sb.append("<option value='8' selected>	�ǸŽ���	</option>");}else{sb.append("<option value='8'>	�ǸŽ���	</option>");}
					if(product_process_idx==9){	sb.append("<option value='9' selected>	�������	</option>");}else{sb.append("<option value='9'>	�������	</option>");}
					if(product_process_idx==10){sb.append("<option value='10' selected>	�Ǹ�����	</option>");}else{sb.append("<option value='10'>	�Ǹ�����	</option>");}
				}
				sb.append("</select>");
				
				return sb.toString();
		}
	
	public String getProduct_process_idx_list(int product_process_idx) {
		
		StringBuffer sb=new StringBuffer();
			
				sb.append("<select class='input_size10' name='product_process_idx' onChange='form.submit()'>");
				if(product_process_idx==0){
					sb.append("<option value='0'>--��ǰó������--</option>");
					sb.append("<option value='1'>��ǰ���߽�û</option>");
					sb.append("<option value='2'>���û����û</option>");
					sb.append("<option value='3'>���û������</option>");
					sb.append("<option value='4'>���û���Ϸ�</option>");
					sb.append("<option value='5'>�������</option>");
					sb.append("<option value='6'>��ǰ�Կ�</option>");
					sb.append("<option value='7'>��ǰ���</option>");
					sb.append("<option value='8'>�ǸŽ���</option>");
					sb.append("<option value='9'>�������</option>");
					sb.append("<option value='10'>�Ǹ�����</option>");
				}else{
					if(product_process_idx==0){	sb.append("<option value='0' selected>	--��ǰó������--	</option>");}else{sb.append("<option value='0'>	--��ǰó������--</option>");}
					if(product_process_idx==1){	sb.append("<option value='1' selected>	��ǰ���߽�û	</option>");}else{sb.append("<option value='1'>	��ǰ���߽�û	</option>");}
					if(product_process_idx==2){	sb.append("<option value='2' selected>	���û����û	</option>");}else{sb.append("<option value='2'>	���û����û	</option>");}
					if(product_process_idx==3){	sb.append("<option value='3' selected>	���û������	</option>");}else{sb.append("<option value='3'>	���û������	</option>");}
					if(product_process_idx==4){	sb.append("<option value='4' selected>	���û���Ϸ�	</option>");}else{sb.append("<option value='4'>	���û���Ϸ�	</option>");}
					if(product_process_idx==5){	sb.append("<option value='5' selected>	�������	</option>");}else{sb.append("<option value='5'>	�������	</option>");}
					if(product_process_idx==6){	sb.append("<option value='6' selected>	��ǰ�Կ�	</option>");}else{sb.append("<option value='6'>	��ǰ�Կ�	</option>");}
					if(product_process_idx==7){	sb.append("<option value='7' selected>	��ǰ���	</option>");}else{sb.append("<option value='7'>	��ǰ���	</option>");}
					if(product_process_idx==8){	sb.append("<option value='8' selected>	�ǸŽ���	</option>");}else{sb.append("<option value='8'>	�ǸŽ���	</option>");}
					if(product_process_idx==9){	sb.append("<option value='9' selected>	�������	</option>");}else{sb.append("<option value='9'>	�������	</option>");}
					if(product_process_idx==10){sb.append("<option value='10' selected>	�Ǹ�����	</option>");}else{sb.append("<option value='10'>	�Ǹ�����	</option>");}
				}
				sb.append("</select>");
				
				return sb.toString();
		}	
}
