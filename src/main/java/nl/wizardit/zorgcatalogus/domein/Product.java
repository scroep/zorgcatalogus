package nl.wizardit.zorgcatalogus.domein;

public class Product {
	private int productCode;
	private int categorieCode;
	private String productNaam;
	private String productEenheid;


	public Product() {

	}
	


	public Product(int productCode, int categorieCode, String productNaam, String productEenheid) {
		super();
		this.productCode = productCode;
		this.categorieCode = categorieCode;
		this.productNaam = productNaam;
		this.productEenheid = productEenheid;
	}



	public int getProductCode() {
		return productCode;
	}


	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}


	public int getCategorieCode() {
		return categorieCode;
	}


	public void setCategorieCode(int categorieCode) {
		this.categorieCode = categorieCode;
	}


	public String getProductNaam() {
		return productNaam;
	}


	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}


	public String getProductEenheid() {
		return productEenheid;
	}


	public void setProductEenheid(String productEenheid) {
		this.productEenheid = productEenheid;
	}
	
	
	
}

