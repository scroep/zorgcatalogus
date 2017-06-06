package nl.wizardit.zorgcatalogus.domein;

import java.math.BigDecimal;
import java.sql.Date;

public class Contract {
	private int productCode;
	private int groepCode;
	private String leverancierAgbCode;
	private Date contractStartdatum;
	private String contractBeschrijving;
	private Date contractEinddatum;
	private BigDecimal contractPrijs;
	private BigDecimal contractAantal;
	
	public Contract(){
		
	}
	

	
	public Contract(int productCode, int groepCode, String leverancierAgbCode, Date contractStartdatum,
			String contractBeschrijving, Date contractEinddatum, BigDecimal contractPrijs, BigDecimal contractAantal) {
		super();
		this.productCode = productCode;
		this.groepCode = groepCode;
		this.leverancierAgbCode = leverancierAgbCode;
		this.contractStartdatum = contractStartdatum;
		this.contractBeschrijving = contractBeschrijving;
		this.contractEinddatum = contractEinddatum;
		this.contractPrijs = contractPrijs;
		this.contractAantal = contractAantal;
	}


	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getGroepCode() {
		return groepCode;
	}
	public void setGroepCode(int groepCode) {
		this.groepCode = groepCode;
	}
	public String getLeverancierAgbCode() {
		return leverancierAgbCode;
	}
	public void setLeverancierAgbCode(String leverancierAgbCode) {
		this.leverancierAgbCode = leverancierAgbCode;
	}
	public Date getContractStartdatum() {
		return contractStartdatum;
	}
	public void setContractStartdatum(Date contractStartdatum) {
		this.contractStartdatum = contractStartdatum;
	}
	public String getContractBeschrijving() {
		return contractBeschrijving;
	}
	public void setContractBeschrijving(String contractBeschrijving) {
		this.contractBeschrijving = contractBeschrijving;
	}
	public Date getContractEinddatum() {
		return contractEinddatum;
	}
	public void setContractEinddatum(Date contractEinddatum) {
		this.contractEinddatum = contractEinddatum;
	}
	public BigDecimal getContractPrijs() {
		return contractPrijs;
	}
	public void setContractPrijs(BigDecimal contractPrijs) {
		this.contractPrijs = contractPrijs;
	}
	public BigDecimal getContractAantal() {
		return contractAantal;
	}
	public void setContractAantal(BigDecimal contractAantal) {
		this.contractAantal = contractAantal;
	}
	
	
	

}
