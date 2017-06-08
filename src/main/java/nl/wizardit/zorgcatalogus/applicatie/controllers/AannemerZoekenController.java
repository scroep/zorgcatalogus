package nl.wizardit.zorgcatalogus.applicatie.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AannemerZoekenController {

	@FXML
	private TextField specialiteitCode;
	
	public void zoekKnop_click(ActionEvent event){
		
		
		FXMLLoader loader = new FXMLLoader();
		//Parent rootNode = loader.load(getClass().getResource("/fxml/AannemersOverzicht.fxml").openStream());
		AannemersOverzichtController  aannemersOverzichtController = (AannemersOverzichtController) loader.getController();

/*
		try {
			int specialiteitcode;
			specialiteitcode = Integer.parseInt(specialiteitCode.getText());
			
			aannemersOverzichtController.setSpecialiteitCode(specialiteitcode);
			
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
		*/
	}
	
	
}
