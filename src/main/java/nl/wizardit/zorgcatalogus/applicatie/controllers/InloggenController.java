package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.ZorgcatalogusApplication;
import nl.wizardit.zorgcatalogus.applicatie.models.GebruikerModel;
import nl.wizardit.zorgcatalogus.repositories.GebruikerRepository.Gebruikersfunctie;

@Component
public class InloggenController {

	@FXML
	private TextField textField_gebruikersnaam;

	@FXML
	private TextField textField_wachtwoord;
	
	public void inloggen_click(ActionEvent event) throws IOException {
		String gebruikersnaam = textField_gebruikersnaam.getText();
		String wachtwoord = textField_wachtwoord.getText();
		
		ZorgcatalogusApplication.createSpringContext(gebruikersnaam, wachtwoord);
		
		FXMLLoader mainLoader = new FXMLLoader();
		Parent rootNode = mainLoader.load(getClass().getResource("/fxml/Main.fxml").openStream());
		
		GebruikerModel gebruikerModel = new GebruikerModel();
		Gebruikersfunctie gebruikersfunctie = gebruikerModel.getGebruikerFunctie();
		
		int gemeentecode = -1;
		
		if (gebruikersfunctie != Gebruikersfunctie.ONBEKEND) {
			
			if (gebruikersfunctie == Gebruikersfunctie.ADMINISTRATIEF_MEDEWERKER) {
				gemeentecode = gebruikerModel.getGebruikerGemeentecode();
				System.out.println("Gemeentecode: " + gemeentecode);
			}
			
			ZorgcatalogusApplication.setGebruikersInfo(gebruikersfunctie, gemeentecode);
			
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
			Scene scene = new Scene(rootNode);
			stage.setScene(scene);
			stage.show();
		} else {
			// Inloggen was onsuccesvol. Toon error.
			System.err.println("Inloggen onsuccesvol!");
		}
	}
	
}
