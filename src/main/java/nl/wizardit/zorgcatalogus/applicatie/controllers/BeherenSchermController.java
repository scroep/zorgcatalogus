package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BeherenSchermController {
	
	

	public void contractenBeherenKnop_click(ActionEvent event) throws IOException{
	((Node) event.getSource()).getScene().getWindow().hide();
	 Stage stage = new Stage();
	 FXMLLoader  loader = new FXMLLoader();
	 Parent rootNode  = loader.load(getClass().getResource("/fxml/ContractenBeheren.fxml").openStream());
	 Scene scene = new Scene(rootNode);
	 stage.setScene(scene);
     stage.show();	 
	}
	
	
	public void terugNaarHoofdSchermKnop_klik(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		 Parent rootNode = fxmlLoader.load();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}
	

}
