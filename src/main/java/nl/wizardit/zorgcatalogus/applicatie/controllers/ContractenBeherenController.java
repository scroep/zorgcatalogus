package nl.wizardit.zorgcatalogus.applicatie.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.wizardit.zorgcatalogus.applicatie.models.ContractModel;
import nl.wizardit.zorgcatalogus.domein.Contract;

public class ContractenBeherenController implements Initializable {
	
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));
		groepCode.setCellValueFactory(new PropertyValueFactory<>("groepCode"));
		agbCode.setCellValueFactory(new PropertyValueFactory<>("leverancierAgbCode"));
		startDatum.setCellValueFactory(new PropertyValueFactory<>("contractStartdatum"));
		
		contractModel = new ContractModel();
		Contract[] contracten = contractModel.getAlleContracten();
		
		data.addAll(contracten);
		contractenTabel.setItems(data);

		
	}
	
	
	
}
