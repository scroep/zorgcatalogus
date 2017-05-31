package nl.wizardit.zorgcatalogus.applicatie.controllers;



import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nl.wizardit.zorgcatalogus.applicatie.models.ProductDienstModel;
import nl.wizardit.zorgcatalogus.domein.ProductDienst;

public class ProductDienstInformatieController {
	
	@FXML
	private TextField codeResultaat;
	
	@FXML
	private TextField categorieCodeResultaat;

	@FXML
	private TextField naamResultaat;
	
	@FXML
	private TextArea omschrijvingResultaat;
	
	private int productDienstCode;
	
	private ProductDienstModel productDienstModel;
	
	
	public void setProductDienstCode(int productDienstCode) {
		this.productDienstCode = productDienstCode;
	}
	
	/**
	 * 
	 * @return True is successful, false if unsuccessful.
	 */
	public boolean vulInformatieIn() {
        productDienstModel = new ProductDienstModel();
		ProductDienst productDienst = productDienstModel.getProductDienst(productDienstCode);
		
		if (productDienst == null)
			return false;
		
		codeResultaat.setText(Integer.toString(productDienstCode));
		categorieCodeResultaat.setText(Integer.toString(productDienst.getCategorieCode()));
		naamResultaat.setText(productDienst.getProductDienstNaam());
		omschrijvingResultaat.setText(productDienst.getProductDienstOmschrijving());
		
		return true;
	}
}
