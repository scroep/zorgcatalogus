package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Aannemer;
import nl.wizardit.zorgcatalogus.domein.Specialiteit;
import nl.wizardit.zorgcatalogus.repositories.AannemerRepository;

@RestController
public class AannemerController {
	
	@Autowired
	private AannemerRepository aannemerRepository;
	
	@RequestMapping("/zorgcatalogus/aannemer/{specialiteitcode}/{gemeentecode}")
	public List<Aannemer> getContracten(@PathVariable("specialiteitcode")int specialiteitCode,@PathVariable("gemeentecode") int gemeenteCode){
		List<Aannemer> aannemers = aannemerRepository.getAannemers(specialiteitCode, gemeenteCode);
		return aannemers;		
	}
	@RequestMapping("/zorgcatalogus/aannemer/specialiteit")
	public List<Specialiteit> getSpecialiteiten(){
		List<Specialiteit> specialiteiten = aannemerRepository.getAlleSpecialiteiten();
		return specialiteiten;
	}

}
