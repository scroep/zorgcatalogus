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
import nl.wizardit.zorgcatalogus.applicatie.models.ProductModel;
import nl.wizardit.zorgcatalogus.domein.Product;

public class ProductInformatieController {
	
	@FXML
	private TextField codeResultaat;
	
	@FXML
	private TextField categorieCodeResultaat;

	@FXML
	private TextField naamResultaat;
	
	@FXML
	private TextField eenheidResultaat;
	
	@FXML
	private TextField gc_invoer;
	
	
	private int productCode;
	
	private ProductModel productModel;
	
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	/**
	 * 
	 * @return True is successful, false if unsuccessful.
	 */
	public boolean vulInformatieIn() {
        productModel = new ProductModel();
		Product product = productModel.getProduct(productCode);
		
		if (product == null)
			return false;
		
		codeResultaat.setText(Integer.toString(productCode));
		categorieCodeResultaat.setText(Integer.toString(product.getCategorieCode()));
		naamResultaat.setText(product.getProductNaam());
		eenheidResultaat.setText(product.getProductEenheid());
		
		return true;
	}
	
	
	public void terugKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/ProductCodeInvullen.fxml").openStream());
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}
	
	public void toonContracten(ActionEvent event) throws IOException{
		
		
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = loader.load(getClass().getResource("/fxml/ContractenOverzicht.fxml").openStream());
		ContractenOverzichtController contractenOverzichtController = (ContractenOverzichtController) loader.getController();
		
		try{
			int gemeenteCode;
			gemeenteCode = Integer.parseInt(gc_invoer.getText());
			
			contractenOverzichtController.setCodes(productCode, gemeenteCode);
			
			
			if(!contractenOverzichtController.vulTabel()){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Geen contracten");
				alert.setContentText("Er zijn geen contracten gevonden voor het product");
				alert.show();
			}
			
		}catch (NumberFormatException e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ongeldige invoer");
			alert.setContentText("De invoer is ongeldig. Gebruik een nummer.");
			alert.showAndWait();
			return;
		}
		

		((Node) event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
	
	    Scene scene = new Scene(rootNode);
	    stage.setScene(scene);
        stage.show();
		
		
		
	}
}
