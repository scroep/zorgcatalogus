package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.applicatie.models.ContractModel;
import nl.wizardit.zorgcatalogus.domein.Contract;

public class ContractToevoegenController {
	@FXML
	private TextField pc_invoer;
	
	@FXML
	private TextField gc_invoer;
	
	@FXML
	private TextField lac_invoer;
	
	@FXML
	private DatePicker sd_invoer;
	
	@FXML
	private TextArea o_invoer;
	
	@FXML
	private DatePicker ed_invoer;
	
	@FXML
	private TextField p_invoer;
	
	@FXML
	private TextField a_invoer;
	
	private Contract contract;
	
	private ContractModel contractModel;
	
	
	public void toevoegenKnop_klik(ActionEvent event) throws IOException{
		
		contractModel = new ContractModel();
		contract = new Contract();
		
		
		try{
			contract.setProductCode(Integer.parseInt(pc_invoer.getText()));
			contract.setGroepCode(Integer.parseInt(gc_invoer.getText()));
			contract.setLeverancierAgbCode(lac_invoer.getText());
			
			Date startdatum = Date.valueOf(sd_invoer.getValue());
			Date einddatum = Date.valueOf(ed_invoer.getValue());
			 
			contract.setContractStartdatum(startdatum);
			contract.setContractEinddatum(einddatum);
			
			contract.setContractBeschrijving(o_invoer.getText());
			
			
			BigDecimal prijs = new BigDecimal(p_invoer.getText());
			contract.setContractPrijs(prijs);
			
			BigDecimal aantal = new BigDecimal(a_invoer.getText());
			contract.setContractAantal(aantal);
			
			
		
			
		} catch(Exception e){
	    	 Alert alert = new Alert(AlertType.ERROR);
			 alert.setTitle("fout gegaan");
			 alert.setContentText(e.getMessage());
			 alert.showAndWait();
	    }
		
		contractModel.voegContractToe(contract);
		
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ContractenBeheren.fxml"));
		 Parent rootNode = fxmlLoader.load();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}
	
	public void terugKnop_klik(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ContractenBeheren.fxml"));
		 Parent rootNode = fxmlLoader.load();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}

}
