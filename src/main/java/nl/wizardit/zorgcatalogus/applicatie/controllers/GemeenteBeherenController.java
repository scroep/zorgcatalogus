package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import org.springframework.stereotype.Component;
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
import nl.wizardit.zorgcatalogus.applicatie.models.GemeenteModel;
import nl.wizardit.zorgcatalogus.domein.Gemeente;

@Component
public class GemeenteBeherenController implements Initializable  {
	
	private GemeenteModel gemeenteModel = new GemeenteModel();

	@FXML
	private TableView<Gemeente> table;
	@FXML
	private TableColumn<?,?> gemeenteCode;
	@FXML
	private TableColumn<?,?> gemeenteNaam;
	@FXML
	private TableColumn<?,?> isActief;
	
	public ObservableList<Gemeente> data = FXCollections.observableArrayList();
	
	
	public GemeenteBeherenController(){
		System.out.println("constructoooor");


	}
    
	public void initialize(URL location, ResourceBundle resources) {

	
		gemeenteCode.setCellValueFactory(new PropertyValueFactory<>("gemeenteCode"));
		gemeenteNaam.setCellValueFactory(new PropertyValueFactory<>("gemeenteNaam"));
		isActief.setCellValueFactory(new PropertyValueFactory<>("isActief"));
		
	
		data.addAll(gemeenteModel.getAlleGemeentes());
		table.setItems(data);
	}
	
	
	public void gemeenteToevoegenKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/GemeenteToevoegen.fxml").openStream());
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();	 
	}
	
	
	public void gemeenteVerwijderenKnop_click(ActionEvent event){

	}
	

	
	
	
	
}
