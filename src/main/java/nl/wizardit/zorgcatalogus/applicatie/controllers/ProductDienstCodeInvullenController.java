package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

@Component
public class ProductDienstCodeInvullenController {
	
	@FXML
	private TextField invoerVak;
	
	@FXML
	private Button zoekKnop;
	
	
	public void zoekKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/ProductDienstInformatie.fxml").openStream());
		 ProductDienstInformatieController productDienstInformatieController = (ProductDienstInformatieController) loader.getController();
		 productDienstInformatieController.setProductDienstCode(Integer.parseInt(invoerVak.getText()));
		 productDienstInformatieController.vulInformatieIn();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
		
	}
	
	
	

}
