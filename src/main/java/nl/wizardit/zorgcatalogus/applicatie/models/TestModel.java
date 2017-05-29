package nl.wizardit.zorgcatalogus.applicatie.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.wizardit.zorgcatalogus.domein.Gemeente;
import nl.wizardit.zorgcatalogus.repositories.GemeenteRepository;


@Component
public class TestModel {
	
	@Autowired
	private GemeenteRepository gemeenteRepository;
	

	
	//public List<Gemeente> getAlleGemeentes(){
	//	List<Gemeente> gemeenten = gemeenteRepository.findAll();
	//	return gemeenten;
	//}
	

}
