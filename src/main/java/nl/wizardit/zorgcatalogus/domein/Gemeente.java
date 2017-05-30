package nl.wizardit.zorgcatalogus.domein;

import org.springframework.stereotype.Component;

@Component
public class Gemeente {
	
	private int gemeenteCode;
	private String gemeenteNaam;
	private boolean isActief;
	
	public Gemeente(){
		
	}
	
	public Gemeente(int gemeenteCode, String gemeenteNaam, boolean isActief) {
		super();
		this.gemeenteCode = gemeenteCode;
		this.gemeenteNaam = gemeenteNaam;
		this.isActief = isActief;
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
	
	public boolean isActief() {
		return isActief;
	}
	
	public void setActief(boolean isActief) {
		this.isActief = isActief;
	}
}
