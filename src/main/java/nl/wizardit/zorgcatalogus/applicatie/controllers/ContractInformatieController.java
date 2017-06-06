package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.domein.Contract;

@Component
public class ContractInformatieController {
	
	@FXML
	private TextField pc_resultaat;
	
	@FXML
	private TextField gc_resultaat;
	
	@FXML
	private TextField lac_resultaat;
	
	@FXML
	private TextField sd_resultaat;

	@FXML
	private TextField ed_resultaat;
	
	@FXML
	private TextField p_resultaat;
	
	@FXML
	private TextField a_resultaat;
	
	@FXML
	private TextArea o_resultaat;
	

	
	private Contract contract;
	private int gemeenteCode;
	

	public void setContract(Contract geselecteerdeContract, int gemeentecode){
		this.gemeenteCode = gemeentecode;
		this.contract = geselecteerdeContract;
		
	}
	
	
	
	public void vulInformatieIn(){
		
		
		pc_resultaat.setText(Integer.toString(contract.getProductCode()));
		gc_resultaat.setText(Integer.toString(contract.getGroepCode()));
		lac_resultaat.setText(contract.getLeverancierAgbCode());
		sd_resultaat.setText(contract.getContractStartdatum().toString());
		ed_resultaat.setText(contract.getContractEinddatum().toString());
		p_resultaat.setText(contract.getContractPrijs().toString());
		a_resultaat.setText(contract.getContractAantal().toString());
		o_resultaat.setText(contract.getContractBeschrijving());
		

	}
	
	public void terugKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/ContractenOverzicht.fxml").openStream());
			ContractenOverzichtController contractenOverzichtController = (ContractenOverzichtController) loader.getController();
			contractenOverzichtController.setCodes(contract.getProductCode(),gemeenteCode);
			contractenOverzichtController.vulTabel();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}

}
