package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
import nl.wizardit.zorgcatalogus.applicatie.models.TestModel;
import nl.wizardit.zorgcatalogus.domein.Gemeente;
import nl.wizardit.zorgcatalogus.repositories.GemeenteRepository;
//import nl.wizardit.zorgcatalogus.restcontrollers.GemeenteController;

@RestController
public class GemeenteBeherenController implements Initializable  {
	
  // private TestModel testmodel = new TestModel();
	
	@Autowired
	public GemeenteRepository gemeenterepository; 

	
	//public GemeenteController gemeenteController;
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
		//List<Gemeente> lijst = gemeenteRepository.findAll();

	}
    
	public void initialize(URL location, ResourceBundle resources) {
		
		data.add(new Gemeente(55,"Apeldoorn",true));
		data.add(new Gemeente(26,"Arnhem",true));
		data.add(new Gemeente(34,"Ede",true));
		
		table.setItems(data);
		
		gemeenteCode.setCellValueFactory(new PropertyValueFactory<>("gemeenteCode"));
		gemeenteNaam.setCellValueFactory(new PropertyValueFactory<>("gemeenteNaam"));
		isActief.setCellValueFactory(new PropertyValueFactory<>("isActief"));
		
		
	    // System.out.println(testmodel.getAlleGemeentes());
		System.out.println("initializattieeee");
	
		//System.out.println(testmodel.getAlleGemeentes());
		
		//List<Gemeente> lijst = gemeenteRepository.findAll();
		//System.out.println(""+gemeentePository.findAll());
		
		//data.addAll(gemeenteController.getAllgemeentes());
		//table.setItems(data);
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
	    System.out.println("De bots: " + gemeenterepository);

	}
	

	
	
	
	
}
