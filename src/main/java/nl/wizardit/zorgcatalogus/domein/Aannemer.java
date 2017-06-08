package nl.wizardit.zorgcatalogus.domein;

public class Aannemer {
	public String aannemerKvkNummer;
	public int specialiteitCode;
	public String aannemerNaam;
	public String aannemerTelefoonnummer;
	public String aannemerPostcode;
	public String aannemerHuisnummer;
	public int eerderIngehuurd;
	
	public Aannemer(){
		
	}
	

	public Aannemer(String aannemerKvkNummer, int specialiteitCode, String aannemerNaam, String aannemerTelefoonnummer,
			String aannemerPostcode, String aannemerHuisnummer, int eerderIngehuurd) {
		super();
		this.aannemerKvkNummer = aannemerKvkNummer;
		this.specialiteitCode = specialiteitCode;
		this.aannemerNaam = aannemerNaam;
		this.aannemerTelefoonnummer = aannemerTelefoonnummer;
		this.aannemerPostcode = aannemerPostcode;
		this.aannemerHuisnummer = aannemerHuisnummer;
		this.eerderIngehuurd = eerderIngehuurd;
	}



	public String getAannemerKvkNummer() {
		return aannemerKvkNummer;
	}

	public void setAannemerKvkNummer(String aannemerKvkNummer) {
		this.aannemerKvkNummer = aannemerKvkNummer;
	}

	public int getSpecialiteitCode() {
		return specialiteitCode;
	}

	public void setSpecialiteitCode(int specialiteitCode) {
		this.specialiteitCode = specialiteitCode;
	}

	public String getAannemerNaam() {
		return aannemerNaam;
	}

	public void setAannemerNaam(String aannemerNaam) {
		this.aannemerNaam = aannemerNaam;
	}

	public String getAannemerTelefoonnummer() {
		return aannemerTelefoonnummer;
	}

	public void setAannemerTelefoonnummer(String aannemerTelefoonnummer) {
		this.aannemerTelefoonnummer = aannemerTelefoonnummer;
	}

	public String getAannemerPostcode() {
		return aannemerPostcode;
	}

	public void setAannemerPostcode(String aannemerPostcode) {
		this.aannemerPostcode = aannemerPostcode;
	}

	public String getAannemerHuisnummer() {
		return aannemerHuisnummer;
	}

	public void setAannemerHuisnummer(String aannemerHuisnummer) {
		this.aannemerHuisnummer = aannemerHuisnummer;
	}

	public int getEerderIngehuurd() {
		return eerderIngehuurd;
	}

	public void setEerderIngehuurd(int eerderIngehuurd) {
		this.eerderIngehuurd = eerderIngehuurd;
	}
}
