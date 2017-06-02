package nl.wizardit.zorgcatalogus.domein;

import org.springframework.stereotype.Component;

@Component
public class Gemeente {
	private int gemeenteCode;
	private String gemeenteNaam;
	
	
	public Gemeente(){
		
	}
	
	public Gemeente(int gemeenteCode, String gemeenteNaam) {
		super();
		this.gemeenteCode = gemeenteCode;
		this.gemeenteNaam = gemeenteNaam;
	}


	public int getGemeenteCode() {
		return gemeenteCode;
	}
	public void setGemeenteCode(int gemeenteCode) {
		this.gemeenteCode = gemeenteCode;
	}
	public String getGemeenteNaam() {
		return gemeenteNaam;
	}
	public void setGemeenteNaam(String gemeenteNaam) {
		this.gemeenteNaam = gemeenteNaam;
	}
}
