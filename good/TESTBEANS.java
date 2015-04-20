package shoeseholic.good;

import shoeseholic.common.Beans;

public class TESTBEANS extends Beans{
	private String idx,professor,name,grade;
	String[] product_idx_array;

	public String toString(){
		return "idx="+idx+"professor="+professor+"professor="+name+"grade="+grade;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getIdx() {
		return idx;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getProfessor() {
		return professor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}
	


}