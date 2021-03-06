package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@Component
public class MainController {

	public void gemeenteBeherenKnop_click(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = loader.load(getClass().getResource("/fxml/GemeenteScherm.fxml").openStream());
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.show();
	}

	public void ZorgbehoefteSysteemKnop_Click(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = loader.load(getClass().getResource("/fxml/ZorgbehoefteSysteemScherm.fxml").openStream());
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.show();
	}

	public void beherenKnop_click(ActionEvent event) throws IOException {
		((Node) event.getSource()).getScene().getWindow().hide();
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = loader.load(getClass().getResource("/fxml/BeherenScherm.fxml").openStream());
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.show();
	}

}
