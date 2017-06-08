package nl.wizardit.zorgcatalogus.domein;

public class Specialiteit {
	private int specialiteitCode;
	private String specialiteitString;
	
	public Specialiteit(){
		
	}

	public Specialiteit(int specialiteitCode, String specialiteitString) {
		super();
		this.specialiteitCode = specialiteitCode;
		this.specialiteitString = specialiteitString;
	}



	public int getSpecialiteitCode() {
		return specialiteitCode;
	}

	public void setSpecialiteitCode(int specialiteitCode) {
		this.specialiteitCode = specialiteitCode;
	}

	public String getSpecialiteitString() {
		return specialiteitString;
	}

	public void setSpecialiteitString(String specialiteitString) {
		this.specialiteitString = specialiteitString;
	}
	
	

}
