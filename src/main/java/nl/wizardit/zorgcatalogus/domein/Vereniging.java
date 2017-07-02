package nl.wizardit.zorgcatalogus.domein;

public class Vereniging {

	private int vereningingCode;
	private int gemeenteCode;
	private String verenigingNaam;
	private String verenigingOmschrijving;
	
	public Vereniging(){
	}

	public Vereniging(int vereningingCode, int gemeenteCode, String verenigingNaam, String verenigingOmschrijving) {
		super();
		this.vereningingCode = vereningingCode;
		this.gemeenteCode = gemeenteCode;
		this.verenigingNaam = verenigingNaam;
		this.verenigingOmschrijving = verenigingOmschrijving;
	}
	public int getVereningingCode() {
		return vereningingCode;
	}
	public void setVereningingCode(int vereningingCode) {
		this.vereningingCode = vereningingCode;
	}
	public int getGemeenteCode() {
		return gemeenteCode;
	}
	public void setGemeenteCode(int gemeenteCode) {
		this.gemeenteCode = gemeenteCode;
	}
	public String getVerenigingNaam() {
		return verenigingNaam;
	}
	public void setVerenigingNaam(String verenigingNaam) {
		this.verenigingNaam = verenigingNaam;
	}
	public String getVerenigingOmschrijving() {
		return verenigingOmschrijving;
	}
	public void setVerenigingOmschrijving(String verenigingOmschrijving) {
		this.verenigingOmschrijving = verenigingOmschrijving;
	}	
}
