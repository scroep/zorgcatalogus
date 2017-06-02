package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class ProductCodeInvullenController {

	@FXML
	private TextField invoerVak;

	@FXML
	private Button zoekKnop;

	public void zoekKnop_click(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = loader.load(getClass().getResource("/fxml/ProductInformatie.fxml").openStream());
		ProductInformatieController productInformatieController = (ProductInformatieController) loader.getController();


		try {
			int productCode;
			productCode = Integer.parseInt(invoerVak.getText());
			
			productInformatieController.setProductDienstCode(productCode);
			
			if (!productInformatieController.vulInformatieIn()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Product bestaat niet");
				alert.setContentText("De ingevoerde productcode komt niet overeen met een product");
				alert.showAndWait();
				return;
			}
			
		} catch (NumberFormatException e) {
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
	
	public void terugNaarHoofdSchermKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		 Parent rootNode = fxmlLoader.load();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}
	

}
