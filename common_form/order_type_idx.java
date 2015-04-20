package shoeseholic.common_form;

public class order_type_idx {
	public String getOrder_type_idx(int order_type_idx){
		StringBuffer sb=new StringBuffer();
		
		sb.append("<select class='input_size10' name='order_type_idx' >");
		if(order_type_idx==0){
			sb.append("<option value='0'>--주문타입--</option>");
			sb.append("<option value='1'>무통장입금</option>");
			sb.append("<option value='2'>신용카드</option>");
			sb.append("<option value='3'>계좌이체</option>");
			sb.append("<option value='4'>가상계좌</option>");
			sb.append("<option value='5'>핸드폰</option>");
			sb.append("<option value='6'>포인트</option>");
			sb.append("<option value='7'>에스크로-신용카드</option>");
			sb.append("<option value='8'>에스크로-계좌이체</option>");
			sb.append("<option value='9'>에스크로-가상계좌</option>");
		}else{
			if(order_type_idx==0){	sb.append("<option value='1' selected>	--주문타입--	</option>");}else{sb.append("<option value='1'>	--주문타입--	</option>");}
			if(order_type_idx==1){	sb.append("<option value='1' selected>	무통장입금	</option>");}else{sb.append("<option value='1'>	무통장입금	</option>");}
			if(order_type_idx==2){	sb.append("<option value='2' selected>	신용카드	</option>");}else{sb.append("<option value='2'>	신용카드	</option>");}
			if(order_type_idx==3){	sb.append("<option value='3' selected>	계좌이체	</option>");}else{sb.append("<option value='3'>	계좌이체	</option>");}
			if(order_type_idx==4){	sb.append("<option value='4' selected>	가상계좌	</option>");}else{sb.append("<option value='4'>	가상계좌	</option>");}
			if(order_type_idx==5){	sb.append("<option value='5' selected>	핸드폰	</option>");}else{sb.append("<option value='5'>	핸드폰	</option>");}
			if(order_type_idx==6){	sb.append("<option value='6' selected>	포인트	</option>");}else{sb.append("<option value='6'>	포인트	</option>");}
			if(order_type_idx==7){	sb.append("<option value='7' selected>	에스크로-신용카드	</option>");}else{sb.append("<option value='7'>	에스크로-신용카드	</option>");}
			if(order_type_idx==8){	sb.append("<option value='8' selected>	에스크로-계좌이체	</option>");}else{sb.append("<option value='8'>	에스크로-계좌이체	</option>");}
			if(order_type_idx==9){	sb.append("<option value='9' selected>	에스크로-가상계좌	</option>");}else{sb.append("<option value='9'>	에스크로-가상계좌	</option>");}
		}
		sb.append("</select>");
		
		return sb.toString();		 
		
	}
}
