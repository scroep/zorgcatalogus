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
	
	
	public void setProductDienstCode(int code){
		this.productDienstCode = code;
	}
	
	
	public void vulInformatieIn(){
        productDienstModel = new ProductDienstModel();
		
		ProductDienst productDienst = productDienstModel.getProductDienst(productDienstCode);
		
		codeResultaat.setText(""+productDienstCode);
		categorieCodeResultaat.setText(""+productDienst.getCategorieCode());
		naamResultaat.setText(productDienst.getProductDienstNaam());
		omschrijvingResultaat.setText(productDienst.getProductDienstOmschrijving());
		
		
	}
	
	
}
