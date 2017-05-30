package nl.wizardit.zorgcatalogus.domein;

public class ProductDienst {
	private int productDienstcode;
	private int categorieCode;
	private String productDienstNaam;
    private String productDienstOmschrijving;
	private boolean isActief;
	
	
	public ProductDienst(){
		
	}

	
	public ProductDienst(int productDienstcode, int categorieCode, String productDienstNaam,
			String productDienstOmschrijving, boolean isActief) {
		super();
		this.productDienstcode = productDienstcode;
		this.categorieCode = categorieCode;
		this.productDienstNaam = productDienstNaam;
		this.productDienstOmschrijving = productDienstOmschrijving;
		this.isActief = isActief;
	}



	public String getProductDienstOmschrijving() {
		return productDienstOmschrijving;
	}



	public void setProductDienstOmschrijving(String productDienstOmschrijving) {
		this.productDienstOmschrijving = productDienstOmschrijving;
	}

	public int getProductDienstcode() {
		return productDienstcode;
	}


	public void setProductDienstcode(int productDienstcode) {
		this.productDienstcode = productDienstcode;
	}


	public int getCategorieCode() {
		return categorieCode;
	}


	public void setCategorieCode(int categorieCode) {
		this.categorieCode = categorieCode;
	}


	public String getProductDienstNaam() {
		return productDienstNaam;
	}


	public void setProductDienstNaam(String productDienstNaam) {
		this.productDienstNaam = productDienstNaam;
	}


	public boolean isActief() {
		return isActief;
	}


	public void setActief(boolean isActief) {
		this.isActief = isActief;
	}
	
	

}
