package shoeseholic.member;

import shoeseholic.common.Beans;

public class MemberBeans extends Beans {
   private String member_idx,member_id,member_pass,member_name,member_email,member_addr1,member_addr2,member_zipcode,member_mobile,member_phone,member_birthday,member_hiredate,member_point,member_sex;
   
   public String toString(){
	   return "member_idx="+member_idx+"member_id="+member_id+"member_pass="+member_pass+"member_name="+member_name+"member_email="+member_email+"member_addr1="+member_addr1+"member_addr2="+member_addr2+"member_zipcode="+member_zipcode+"member_mobile="+ member_mobile+"member_phone="+member_phone+"member_birthday="+member_birthday+"member_hiredate="+member_hiredate+"member_point="+member_point+"member_sex="+member_sex;
   }
   //

public String getMember_idx() {
	return member_idx;
}

public void setMember_idx(String member_idx) {
	this.member_idx = member_idx;
}

public String getMember_id() {
	return member_id;
}

public void setMember_id(String member_id) {
	this.member_id = member_id;
}

public String getMember_pass() {
	return member_pass;
}

public void setMember_pass(String member_pass) {
	this.member_pass = member_pass;
}

public String getMember_name() {
	return member_name;
}

public void setMember_name(String member_name) {
	this.member_name = member_name;
}

public String getMember_email() {
	return member_email;
}

public void setMember_email(String member_email) {
	this.member_email = member_email;
}

public String getMember_addr1() {
	return member_addr1;
}

public void setMember_addr1(String member_addr1) {
	this.member_addr1 = member_addr1;
}

public String getMember_addr2() {
	return member_addr2;
}

public void setMember_addr2(String member_addr2) {
	this.member_addr2 = member_addr2;
}

public String getMember_zipcode() {
	return member_zipcode;
}

public void setMember_zipcode(String member_zipcode) {
	this.member_zipcode = member_zipcode;
}

public String getMember_mobile() {
	return member_mobile;
}

public void setMember_mobile(String member_mobile) {
	this.member_mobile = member_mobile;
}

public String getMember_phone() {
	return member_phone;
}

public void setMember_phone(String member_phone) {
	this.member_phone = member_phone;
}

public String getMember_birthday() {
	return member_birthday;
}

public void setMember_birthday(String member_birthday) {
	this.member_birthday = member_birthday;
}

public String getMember_hiredate() {
	return member_hiredate;
}

public void setMember_hiredate(String member_hiredate) {
	this.member_hiredate = member_hiredate;
}

public String getMember_point() {
	return member_point;
}

public void setMember_point(String member_point) {
	this.member_point = member_point;
}

public void setMember_sex(String member_sex) {
	this.member_sex = member_sex;
}

public String getMember_sex() {
	return member_sex;
}
   
   
}
