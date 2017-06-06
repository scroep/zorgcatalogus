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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import nl.wizardit.zorgcatalogus.applicatie.models.ContractModel;
import nl.wizardit.zorgcatalogus.domein.Contract;


@Component
public class ContractenOverzichtController {
	
	private ContractModel contractModel;
	
	@FXML
	private TableView<Contract> contractenTabel;
	
	@FXML
	private TableColumn<?,?> productCode;
	
	@FXML
	private TableColumn<?,?> groepCode;
	
	@FXML
	private TableColumn<?,?> agbCode;
	
	@FXML
	private TableColumn<?,?> startDatum;
	
	
	public ObservableList<Contract> data = FXCollections.observableArrayList();
	
	private int productcode, gemeenteCode;


	public boolean vulTabel() {
		contractModel = new ContractModel();
		
		productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
		groepCode.setCellValueFactory(new PropertyValueFactory<>("groepCode"));
		agbCode.setCellValueFactory(new PropertyValueFactory<>("leverancierAgbCode"));
		startDatum.setCellValueFactory(new PropertyValueFactory<>("contractStartdatum"));
		
		Contract[] contracten = contractModel.getContracten(productcode, gemeenteCode);
		
		if(contracten == null){
			return false;
		}
		data.addAll(contracten);
		contractenTabel.setItems(data);
		
		return true;
		
	}
	
	
	public void setCodes(int productCode, int gemeenteCode){
		this.productcode = productCode;
		this.gemeenteCode = gemeenteCode;
	}
	
	public void detailsKnop_click(ActionEvent event) throws IOException{
		
		
		FXMLLoader loader = new FXMLLoader();
		Parent rootNode = loader.load(getClass().getResource("/fxml/ContractInformatie.fxml").openStream());
		ContractInformatieController contractInformatieController = (ContractInformatieController) loader.getController();
		
		try{
		Contract geselecteerdeContract = contractenTabel.getSelectionModel().getSelectedItem();
		   contractInformatieController.setContract(geselecteerdeContract,gemeenteCode);
		   contractInformatieController.vulInformatieIn();
		   
		   ((Node) event.getSource()).getScene().getWindow().hide();
			Stage stage = new Stage();
		
		    Scene scene = new Scene(rootNode);
		    stage.setScene(scene);
	        stage.show();
	     
		
		
		}catch (Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Geen contract geselecteerd");
			alert.setContentText("Er is geen contract geselecteerd");
			alert.showAndWait();
		}
		
		
		
		
		
	}
	
	public void terugKnop_click(ActionEvent event) throws IOException{
		((Node) event.getSource()).getScene().getWindow().hide();
		 Stage stage = new Stage();
		 FXMLLoader  loader = new FXMLLoader();
		 Parent rootNode  = loader.load(getClass().getResource("/fxml/ProductInformatie.fxml").openStream());
		ProductInformatieController productInformatieController = (ProductInformatieController) loader.getController();
		productInformatieController.setProductCode(productcode);
		productInformatieController.vulInformatieIn();
		 Scene scene = new Scene(rootNode);
		 stage.setScene(scene);
	     stage.show();
	}


}
