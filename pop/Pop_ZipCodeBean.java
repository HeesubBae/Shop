package shoeseholic.pop;

import shoeseholic.common.Beans;

public class Pop_ZipCodeBean extends Beans {
	
	private String zipcode,sido,gugun,dong,bunji,seq;
	
	 public String toString(){
		 return "zipcode="+zipcode+"sido="+sido+"gugun="+gugun+"dong="+dong+"bunji="+bunji+"seq="+seq;		 
	 }
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSido() {
		return sido;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getGugun() {
		return gugun;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getDong() {
		return dong;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	public String getBunji() {
		return bunji;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getSeq() {
		return seq;
	}
	
}