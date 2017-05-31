package nl.wizardit.zorgcatalogus.applicatie.controllers;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
	
	
	public void terugKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/ProductDienstCodeInvullen.fxml").openStream());
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}
	
	public void toonContracten(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Geen contracten");
		alert.setContentText("Er zijn geen contracten gevonden voor het product of dienst.");
		alert.show();
		
	}
}
