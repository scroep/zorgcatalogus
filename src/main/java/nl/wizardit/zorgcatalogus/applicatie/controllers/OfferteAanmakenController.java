package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;
import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.applicatie.models.OfferteModel;
import nl.wizardit.zorgcatalogus.domein.Aannemer;
import nl.wizardit.zorgcatalogus.domein.Offerte;

public class OfferteAanmakenController {

	
	@FXML
	private TextField invoerTitel;
	
	@FXML
	private DatePicker invoerDatum;
	
	private Aannemer aannemer;
	
	private OfferteModel offerteModel;
	
	private Offerte offerte;
	
	
	public void setAannemer(Aannemer aannemer){
		this.aannemer = aannemer;
	}
	
	public void aanmakenKnop(ActionEvent event) throws IOException{
		System.out.println(invoerDatum.getValue());
		
	    offerteModel = new OfferteModel();
	    
	    offerte = new Offerte();
	    offerte.setAannemerKvkNummer(aannemer.getAannemerKvkNummer());
	    offerte.setGemeenteCode(1);
	    
	    try{
	    offerte.setOfferteTitel(invoerTitel.getText());
	    
	    Date date = Date.valueOf(invoerDatum.getValue());
	    offerte.setOfferteGeldigTot(date);
	    } catch(Exception e){
	    	 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("fout gegaan");
			 alert.setContentText("jwz");
			 alert.showAndWait();
	    }
	    
	    offerteModel.offerteOpSlaan(offerte);
	    
	    ((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		 Parent rootNode = fxmlLoader.load();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
		
		
	}
}
