package nl.wizardit.zorgcatalogus.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Voorraad;
import nl.wizardit.zorgcatalogus.repositories.VoorraadRepository;

@RestController
public class VoorraadController {
	
	@Autowired
	private VoorraadRepository voorraadRepository;
	
	@RequestMapping("/zorgcatalogus/voorraad/{gemeentecode}/{productcode}")
	public Voorraad getVoorraad(@PathVariable("gemeentecode") int gemeenteCode, @PathVariable("productcode") int productCode){
        Voorraad voorraad = voorraadRepository.getVoorraad(gemeenteCode, productCode);
        return voorraad;
	}
	
	@RequestMapping("/zorgcatalogus/update_voorraad/{gemeentecode}/{productcode}/{aantal}")
	public void updateVoorraad(@PathVariable("gemeentecode") int gemeenteCode, @PathVariable("productcode") int productCode,  @PathVariable("aantal") double aantal) {
        voorraadRepository.updateVoorraadAantal(gemeenteCode, productCode, aantal);
	}
	

}
