package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.ZorgcatalogusApplication;
import nl.wizardit.zorgcatalogus.applicatie.models.OfferteModel;
import nl.wizardit.zorgcatalogus.domein.Offerte;

public class OffertenBeherenController implements Initializable   {
	
	@FXML
	private TableView<Offerte> offertesTabel;
	@FXML
	private TableColumn<?,?> gemeenteCode;
	@FXML
	private TableColumn<?,?> offerteCode;
	@FXML
	private TableColumn<?,?> kvkNummer;
	@FXML
	private TableColumn<?,?> offerteTitel;
	@FXML
	private TableColumn<?,?> offerteSamenvating;
	@FXML
	private TableColumn<?,?> offerteUitleg;
	@FXML
	private TableColumn<?,?> offerteGeldigTot;
	
	
	public ObservableList<Offerte> data = FXCollections.observableArrayList();
	
	private OfferteModel offerteModel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		offerteModel = new OfferteModel();
		gemeenteCode.setCellValueFactory(new PropertyValueFactory<>("gemeenteCode"));
		offerteCode.setCellValueFactory(new PropertyValueFactory<>("offerteCode"));
		kvkNummer.setCellValueFactory(new PropertyValueFactory<>("aannemerKvkNummer"));
		offerteTitel.setCellValueFactory(new PropertyValueFactory<>("offerteTitel"));
		offerteSamenvating.setCellValueFactory(new PropertyValueFactory<>("offerteSamenvating"));
		offerteUitleg.setCellValueFactory(new PropertyValueFactory<>("offerteUitleg"));
		offerteGeldigTot.setCellValueFactory(new PropertyValueFactory<>("offerteGeldigTot"));
		
		data.addAll(offerteModel.getOffertes(ZorgcatalogusApplication.getGemeentecode()));
		offertesTabel.setItems(data);
		
		
	}
	
	public void terugKnop_klik(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/GemeenteScherm.fxml"));
		 Parent rootNode = fxmlLoader.load();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}

}
