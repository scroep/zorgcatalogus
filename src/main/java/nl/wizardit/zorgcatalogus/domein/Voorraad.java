package nl.wizardit.zorgcatalogus.domein;

import java.math.BigDecimal;

public class Voorraad {
	private int gemeenteCode;
	private int productCode;
	private BigDecimal voorraadAantal;
	private String voorraadOmschrijving;
	
	public Voorraad(){
		
	}

	public Voorraad(int gemeenteCode, int productCode, BigDecimal voorraadAantal, String voorraadOmschrijving) {
		super();
		this.gemeenteCode = gemeenteCode;
		this.productCode = productCode;
		this.voorraadAantal = voorraadAantal;
		this.voorraadOmschrijving = voorraadOmschrijving;
	}



	public int getGemeenteCode() {
		return gemeenteCode;
	}

	public void setGemeenteCode(int gemeenteCode) {
		this.gemeenteCode = gemeenteCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public BigDecimal getVoorraadAantal() {
		return voorraadAantal;
	}

	public void setVoorraadAantal(BigDecimal voorraadAantal) {
		this.voorraadAantal = voorraadAantal;
	}

	public String getVoorraadOmschrijving() {
		return voorraadOmschrijving;
	}

	public void setVoorraadOmschrijving(String voorraadOmschrijving) {
		this.voorraadOmschrijving = voorraadOmschrijving;
	}
	
	

}
