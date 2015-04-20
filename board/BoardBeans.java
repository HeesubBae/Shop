package shoeseholic.board;

import shoeseholic.common.Beans;

public class BoardBeans extends Beans{

	private String board_idx,board_type,board_notice,product_idx,board_rep_count,staff_name,member_idx,member_name,board_title,board_content,board_date,writer_idx,writer_name,board_count;
	
	public String to_String() {
		return "board_idx="+board_idx+"board_type="+board_type+"board_notice="+board_notice+"product_idx="+product_idx+"board_rep_count="+board_rep_count+"member_idx="+member_idx+"member_name="+member_name+"board_title="+board_title+"boart_content="+board_content+"board_date="+board_date+"writer_idx="+writer_idx+"writer_name="+writer_name;
	}
	public void setBoard_idx(String board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_idx() {
		return board_idx;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_notice(String board_notice) {
		this.board_notice = board_notice;
	}

	public String getBoard_notice() {
		return board_notice;
	}

	public void setProduct_idx(String product_idx) {
		this.product_idx = product_idx;
	}

	public String getProduct_idx() {
		return product_idx;
	}

	public void setBoard_rep_count(String board_rep_count) {
		this.board_rep_count = board_rep_count;
	}

	public String getBoard_rep_count() {
		return board_rep_count;
	}

	public void setMember_idx(String member_idx) {
		this.member_idx = member_idx;
	}

	public String getMember_idx() {
		return member_idx;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	public String getBoard_date() {
		return board_date;
	}
	public void setWriter_idx(String writer_idx) {
		this.writer_idx = writer_idx;
	}
	public String getWriter_idx() {
		return writer_idx;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setBoard_count(String board_count) {
		this.board_count = board_count;
	}
	public String getBoard_count() {
		return board_count;
	}
	
}
