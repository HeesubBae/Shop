package shoeseholic.common_form;

public class order_process_idx {
	
	public String getOrder_process_idx(int order_process_idx){
		StringBuffer sb=new StringBuffer();
		
		sb.append("<select class='input_size10' name='order_process_idx' >");
		if(order_process_idx==0){
			sb.append("<option value='0'>--주문상태--</option>");
			sb.append("<option value='1'>입금대기</option>");
			sb.append("<option value='2'>결재확인</option>");
			sb.append("<option value='3'>상품준비</option>");
			sb.append("<option value='4'>배송준비</option>");
			sb.append("<option value='5'>배송완료</option>");
			sb.append("<option value='6'>교환신청</option>");
			sb.append("<option value='7'>교환신청확인</option>");
			sb.append("<option value='8'>환불신청</option>");
			sb.append("<option value='9'>환불반품확인</option>");
			sb.append("<option value='10'>환불승인</option>");
			sb.append("<option value='11'>환불완료</option>");
			sb.append("<option value='12'>판매완료</option>");
		}else{
			if(order_process_idx==0){	sb.append("<option value='0' selected>	--주문상태--	</option>");}else{sb.append("<option value='0'>	--주문상태--	</option>");}
			if(order_process_idx==1){	sb.append("<option value='1' selected>	입금대기	</option>");}else{sb.append("<option value='1'>	입금대기	</option>");}
			if(order_process_idx==2){	sb.append("<option value='2' selected>	결재확인	</option>");}else{sb.append("<option value='2'>	결재확인	</option>");}
			if(order_process_idx==3){	sb.append("<option value='3' selected>	상품준비	</option>");}else{sb.append("<option value='3'>	상품준비	</option>");}
			if(order_process_idx==4){	sb.append("<option value='4' selected>	배송준비	</option>");}else{sb.append("<option value='4'>	배송준비	</option>");}
			if(order_process_idx==5){	sb.append("<option value='5' selected>	배송완료	</option>");}else{sb.append("<option value='5'>	배송완료	</option>");}
			if(order_process_idx==6){	sb.append("<option value='6' selected>	교환신청	</option>");}else{sb.append("<option value='6'>	교환신청	</option>");}
			if(order_process_idx==7){	sb.append("<option value='7' selected>	교환신청확인	</option>");}else{sb.append("<option value='7'>	교환신청확인	</option>");}
			if(order_process_idx==8){	sb.append("<option value='8' selected>	환불신청	</option>");}else{sb.append("<option value='8'>	환불신청	</option>");}
			if(order_process_idx==9){	sb.append("<option value='9' selected>	환불반품확인	</option>");}else{sb.append("<option value='9'>	환불반품확인	</option>");}
			if(order_process_idx==10){	sb.append("<option value='10' selected>	환불승인	</option>");}else{sb.append("<option value='10'>	환불승인	</option>");}
			if(order_process_idx==11){	sb.append("<option value='11' selected>	환불완료	</option>");}else{sb.append("<option value='11'>	환불완료	</option>");}
			if(order_process_idx==12){	sb.append("<option value='12' selected>	판매완료	</option>");}else{sb.append("<option value='12'>판매완료	</option>");}
		}
		sb.append("</select>");
		
		return sb.toString();		
		
	}
}
