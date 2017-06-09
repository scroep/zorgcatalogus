package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.applicatie.models.AannemerModel;
import nl.wizardit.zorgcatalogus.domein.Aannemer;
import nl.wizardit.zorgcatalogus.restcontrollers.OfferteController;


public class AannemersOverzichtController {
	
	
	@FXML
	private TableView<Aannemer> aannemersTabel;
	
	@FXML
	private TableColumn<?,?> kvkNummer;
	
	@FXML
	private TableColumn<?,?> eerderIngehuurd;
	
	@FXML
	private TableColumn<?,?> aNaam;
	
	@FXML
	private TableColumn<?,?> aTelefoonnummer;
	

	
	public ObservableList<Aannemer> data = FXCollections.observableArrayList();
	
	

	private int specialiteitCode;
	
	private AannemerModel aannemerModel;
	public void setSpecialiteitCode(int specialiteitCode){
		this.specialiteitCode = specialiteitCode;
	}
	
	
	
	
	public boolean vulInformatieIn(){
	   
		kvkNummer.setCellValueFactory(new PropertyValueFactory<>("aannemerKvkNummer"));
		aNaam.setCellValueFactory(new PropertyValueFactory<>("aannemerNaam"));
		aTelefoonnummer.setCellValueFactory(new PropertyValueFactory<>("aannemerTelefoonnummer"));
		eerderIngehuurd.setCellValueFactory(new PropertyValueFactory<>("eerderIngehuurd"));
		aannemerModel = new AannemerModel();
		
		Aannemer[] aannemers = aannemerModel.getAannemers(specialiteitCode, 1);
		
		if(aannemers == null){
			return false;
		}
		
		data.addAll(aannemers);
		aannemersTabel.setItems(data);
		
		return true;
		
	}
	
	
	
	public void offerteAanmakenKnop_klik(ActionEvent event) throws IOException {
	
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/OfferteAanmaken.fxml").openStream());
		 OfferteAanmakenController offerteAanmakenController = (OfferteAanmakenController) loader.getController();
		 try{
			 
		 Aannemer geselecteerdeAannemer = aannemersTabel.getSelectionModel().getSelectedItem();
		 offerteAanmakenController.setAannemer(geselecteerdeAannemer);
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();	
		 }catch(Exception e){
			 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("Geen aannemer geselecteerd");
			 alert.setContentText("Er is geen aannemer geselecteerd");
			 alert.showAndWait();
		 }
		  
		 
		
	}
	

}
