package shoeseholic.common_form;

public class product_process_idx {

	public String getProduct_process_idx_view(int product_process_idx) {
		
		StringBuffer sb=new StringBuffer();
			
				sb.append("<select class='input_size10' name='product_process_idx' >");
				if(product_process_idx==0){
					sb.append("<option value='1'>상품개발신청</option>");
					sb.append("<option value='2'>샘플생산신청</option>");
					sb.append("<option value='3'>샘플생산승인</option>");
					sb.append("<option value='4'>샘플생산완료</option>");
					sb.append("<option value='5'>생산승인</option>");
					sb.append("<option value='6'>상품촬영</option>");
					sb.append("<option value='7'>상품등록</option>");
					sb.append("<option value='8'>판매승인</option>");
					sb.append("<option value='9'>노출승인</option>");
					sb.append("<option value='10'>판매중지</option>");
				}else{
					if(product_process_idx==1){	sb.append("<option value='1' selected>	상품개발신청	</option>");}else{sb.append("<option value='1'>	상품개발신청	</option>");}
					if(product_process_idx==2){	sb.append("<option value='2' selected>	샘플생산신청	</option>");}else{sb.append("<option value='2'>	샘플생산신청	</option>");}
					if(product_process_idx==3){	sb.append("<option value='3' selected>	샘플생산승인	</option>");}else{sb.append("<option value='3'>	샘플생산승인	</option>");}
					if(product_process_idx==4){	sb.append("<option value='4' selected>	샘플생산완료	</option>");}else{sb.append("<option value='4'>	샘플생산완료	</option>");}
					if(product_process_idx==5){	sb.append("<option value='5' selected>	생산승인	</option>");}else{sb.append("<option value='5'>	생산승인	</option>");}
					if(product_process_idx==6){	sb.append("<option value='6' selected>	상품촬영	</option>");}else{sb.append("<option value='6'>	상품촬영	</option>");}
					if(product_process_idx==7){	sb.append("<option value='7' selected>	상품등록	</option>");}else{sb.append("<option value='7'>	상품등록	</option>");}
					if(product_process_idx==8){	sb.append("<option value='8' selected>	판매승인	</option>");}else{sb.append("<option value='8'>	판매승인	</option>");}
					if(product_process_idx==9){	sb.append("<option value='9' selected>	노출승인	</option>");}else{sb.append("<option value='9'>	노출승인	</option>");}
					if(product_process_idx==10){sb.append("<option value='10' selected>	판매중지	</option>");}else{sb.append("<option value='10'>	판매중지	</option>");}
				}
				sb.append("</select>");
				
				return sb.toString();
		}
	
	public String getProduct_process_idx_list(int product_process_idx) {
		
		StringBuffer sb=new StringBuffer();
			
				sb.append("<select class='input_size10' name='product_process_idx' onChange='form.submit()'>");
				if(product_process_idx==0){
					sb.append("<option value='0'>--상품처리상태--</option>");
					sb.append("<option value='1'>상품개발신청</option>");
					sb.append("<option value='2'>샘플생산신청</option>");
					sb.append("<option value='3'>샘플생산승인</option>");
					sb.append("<option value='4'>샘플생산완료</option>");
					sb.append("<option value='5'>생산승인</option>");
					sb.append("<option value='6'>상품촬영</option>");
					sb.append("<option value='7'>상품등록</option>");
					sb.append("<option value='8'>판매승인</option>");
					sb.append("<option value='9'>노출승인</option>");
					sb.append("<option value='10'>판매중지</option>");
				}else{
					if(product_process_idx==0){	sb.append("<option value='0' selected>	--상품처리상태--	</option>");}else{sb.append("<option value='0'>	--상품처리상태--</option>");}
					if(product_process_idx==1){	sb.append("<option value='1' selected>	상품개발신청	</option>");}else{sb.append("<option value='1'>	상품개발신청	</option>");}
					if(product_process_idx==2){	sb.append("<option value='2' selected>	샘플생산신청	</option>");}else{sb.append("<option value='2'>	샘플생산신청	</option>");}
					if(product_process_idx==3){	sb.append("<option value='3' selected>	샘플생산승인	</option>");}else{sb.append("<option value='3'>	샘플생산승인	</option>");}
					if(product_process_idx==4){	sb.append("<option value='4' selected>	샘플생산완료	</option>");}else{sb.append("<option value='4'>	샘플생산완료	</option>");}
					if(product_process_idx==5){	sb.append("<option value='5' selected>	생산승인	</option>");}else{sb.append("<option value='5'>	생산승인	</option>");}
					if(product_process_idx==6){	sb.append("<option value='6' selected>	상품촬영	</option>");}else{sb.append("<option value='6'>	상품촬영	</option>");}
					if(product_process_idx==7){	sb.append("<option value='7' selected>	상품등록	</option>");}else{sb.append("<option value='7'>	상품등록	</option>");}
					if(product_process_idx==8){	sb.append("<option value='8' selected>	판매승인	</option>");}else{sb.append("<option value='8'>	판매승인	</option>");}
					if(product_process_idx==9){	sb.append("<option value='9' selected>	노출승인	</option>");}else{sb.append("<option value='9'>	노출승인	</option>");}
					if(product_process_idx==10){sb.append("<option value='10' selected>	판매중지	</option>");}else{sb.append("<option value='10'>	판매중지	</option>");}
				}
				sb.append("</select>");
				
				return sb.toString();
		}	
}
