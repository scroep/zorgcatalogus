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
public class InloggenController {

	@FXML
	private TextField textField_gebruikersnaam;

	@FXML
	private TextField textField_wachtwoord;
	
	public void inloggen_click(ActionEvent event) throws IOException {
		
		System.out.println(textField_gebruikersnaam.getText() + "   " + textField_wachtwoord.getText());

	}
	

}
