package nl.wizardit.zorgcatalogus.domein;

import java.sql.Date;

public class Offerte {
	private int offerteCode;
	private int gemeenteCode;
	private String aannemerKvkNummer;
	private String offerteTitel;
	private String offerteSamenvating;
	private String offerteUitleg;
	private Date offerteGeldigTot;
	private byte[] offerteDocument;
	
   public Offerte(){
	   
   }
   

public Offerte(int offerteCode, int gemeenteCode, String aannemerKvkNummer, String offerteTitel,
		String offerteSamenvating, String offerteUitleg, Date offerteGeldigTot, byte[] offerteDocument) {
	super();
	this.offerteCode = offerteCode;
	this.gemeenteCode = gemeenteCode;
	this.aannemerKvkNummer = aannemerKvkNummer;
	this.offerteTitel = offerteTitel;
	this.offerteSamenvating = offerteSamenvating;
	this.offerteUitleg = offerteUitleg;
	this.offerteGeldigTot = offerteGeldigTot;
	this.offerteDocument = offerteDocument;
}


public int getOfferteCode() {
	return offerteCode;
}

public void setOfferteCode(int offerteCode) {
	this.offerteCode = offerteCode;
}

public int getGemeenteCode() {
	return gemeenteCode;
}

public void setGemeenteCode(int gemeenteCode) {
	this.gemeenteCode = gemeenteCode;
}

public String getAannemerKvkNummer() {
	return aannemerKvkNummer;
}

public void setAannemerKvkNummer(String aannemerKvkNummer) {
	this.aannemerKvkNummer = aannemerKvkNummer;
}

public String getOfferteTitel() {
	return offerteTitel;
}

public void setOfferteTitel(String offerteTitel) {
	this.offerteTitel = offerteTitel;
}

public String getOfferteSamenvating() {
	return offerteSamenvating;
}

public void setOfferteSamenvating(String offerteSamenvating) {
	this.offerteSamenvating = offerteSamenvating;
}

public String getOfferteUitleg() {
	return offerteUitleg;
}

public void setOfferteUitleg(String offerteUitleg) {
	this.offerteUitleg = offerteUitleg;
}

public Date getOfferteGeldigTot() {
	return offerteGeldigTot;
}

public void setOfferteGeldigTot(Date offerteGeldigTot) {
	this.offerteGeldigTot = offerteGeldigTot;
}

public byte[] getOfferteDocument() {
	return offerteDocument;
}

public void setOfferteDocument(byte[] offerteDocument) {
	this.offerteDocument = offerteDocument;
}
   
   

}
