package nl.wizardit.zorgcatalogus.restcontrollers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.wizardit.zorgcatalogus.domein.Gemeente;
import nl.wizardit.zorgcatalogus.repositories.GemeenteRepository;

@RestController
public class ProductDienstController {

	@Autowired
	private GemeenteRepository gemeenteRepository;

	@FXML
	private TableView<Gemeente> table;
	@FXML
	private TableColumn<?, ?> gemeenteCode;
	@FXML
	private TableColumn<?, ?> gemeenteNaam;
	@FXML
	private TableColumn<?, ?> isActief;

	public ObservableList<Gemeente> data = FXCollections.observableArrayList();

	

	@RequestMapping("/tests")
	public List<Gemeente> getAllgemeentes() {
		List<Gemeente> gemeenten = gemeenteRepository.findAll();
		
		System.out.println(gemeenten);
		for(Gemeente gemeente : gemeenten){
			
			System.out.println(gemeente.getGemeenteNaam());	
		}
		System.out.println("REST API : " + gemeenteRepository);
		return gemeenten;
		
	}
	
	

	public void vulTable(ActionEvent event){
		System.out.println("Applicatie :" + gemeenteRepository);
		
		
		
		
		
		//gemeenteCode.setCellValueFactory(new PropertyValueFactory<>("gemeenteCode"));
		//gemeenteNaam.setCellValueFactory(new PropertyValueFactory<>("gemeenteNaam"));
		//isActief.setCellValueFactory(new PropertyValueFactory<>("isActief"));
		
		//List<Gemeente> lijst = gemeenteRepository.findAll();
		//data.addAll(lijst);
		//table.setItems(data);
	}

}
