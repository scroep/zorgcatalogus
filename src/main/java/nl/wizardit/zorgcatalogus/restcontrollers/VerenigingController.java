package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Vereniging;
import nl.wizardit.zorgcatalogus.repositories.VerenigingRepository;

@RestController
public class VerenigingController {

	
	@Autowired
	private VerenigingRepository verenigingRepository;
	
	@RequestMapping("/zorgcatalogus/verenigingen/{gemeentecode}")
	 public List<Vereniging> getVerenigingen(@PathVariable("gemeentecode") int gemeenteCode){
		 List<Vereniging> verenigingen = verenigingRepository.getVerenigingen(gemeenteCode);
		 return verenigingen;
		 
	 }
	@RequestMapping("/zorgcatalogus/vereniging/{verenigingcode}")
	 public Vereniging getVereniging(@PathVariable("verenigingcode") int verenigingCode){
		  Vereniging vereniging = verenigingRepository.getVereniging(verenigingCode);
		 return vereniging;
	 }
	@RequestMapping(value ="/zorgcatalogus/vereniging/toevoegen",method=RequestMethod.POST)
	public Vereniging verenigingToevoegen(@RequestBody Vereniging vereniging){
		verenigingRepository.verenigingToevoegen(vereniging);
		 return vereniging;
	 }
	@RequestMapping(value ="/zorgcatalogus/vereniging/updaten",method=RequestMethod.POST)
	public Vereniging verenigingUpdaten(@RequestBody Vereniging vereniging){
		verenigingRepository.verenigingUpdaten(vereniging);
		 return vereniging;
	 }
}
