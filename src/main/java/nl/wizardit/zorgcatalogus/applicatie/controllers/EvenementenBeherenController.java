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
import nl.wizardit.zorgcatalogus.applicatie.models.EvenementModel;
import nl.wizardit.zorgcatalogus.domein.Evenement;


public class EvenementenBeherenController implements Initializable {
	
	

	@FXML
	private TableView<Evenement> evenementenTabel;
	@FXML
	private TableColumn<?,?> vCode;
	@FXML
	private TableColumn<?,?> eNaam;
	@FXML
	private TableColumn<?,?> eOmschrijving;
	@FXML
	private TableColumn<?,?> eDatum;
	
	
	private ObservableList<Evenement> data = FXCollections.observableArrayList();
	
	private EvenementModel evenementModel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		eNaam.setCellValueFactory(new PropertyValueFactory<>("evenementNaam"));
		vCode.setCellValueFactory(new PropertyValueFactory<>("verenigingCode"));
		eOmschrijving.setCellValueFactory(new PropertyValueFactory<>("evenementOmschrijving"));
		eDatum.setCellValueFactory(new PropertyValueFactory<>("evenementDatum"));
		
		evenementModel = new EvenementModel();
		data.addAll(evenementModel.getEvenementen(ZorgcatalogusApplication.getGemeentecode()));
		evenementenTabel.setItems(data);
		
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
