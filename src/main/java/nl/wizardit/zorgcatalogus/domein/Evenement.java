package nl.wizardit.zorgcatalogus.domein;

import java.sql.Timestamp;

public class Evenement {
	private String evenementNaam;
	private int verenigingCode;
	private String evenementOmschrijving;
	private Timestamp evenementDatum;
	
	public Evenement(){
		
	}
	

	public Evenement(String evenementNaam, int verenigingCode, String evenementOmschrijving, Timestamp evenementDatum) {
		super();
		this.evenementNaam = evenementNaam;
		this.verenigingCode = verenigingCode;
		this.evenementOmschrijving = evenementOmschrijving;
		this.evenementDatum = evenementDatum;
	}



	public String getEvenementNaam() {
		return evenementNaam;
	}

	public void setEvenementNaam(String evenementNaam) {
		this.evenementNaam = evenementNaam;
	}

	public int getVerenigingCode() {
		return verenigingCode;
	}

	public void setVerenigingCode(int verenigingCode) {
		this.verenigingCode = verenigingCode;
	}

	public String getEvenementOmschrijving() {
		return evenementOmschrijving;
	}

	public void setEvenementOmschrijving(String evenementOmschrijving) {
		this.evenementOmschrijving = evenementOmschrijving;
	}

	public Timestamp getEvenementDatum() {
		return evenementDatum;
	}

	public void setEvenementDatum(Timestamp evenementDatum) {
		this.evenementDatum = evenementDatum;
	}
	
	

}
