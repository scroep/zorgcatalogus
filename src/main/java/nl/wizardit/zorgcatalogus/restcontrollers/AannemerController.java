package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Aannemer;
import nl.wizardit.zorgcatalogus.domein.Specialiteit;
import nl.wizardit.zorgcatalogus.repositories.AannemerRepository;

@RestController
public class AannemerController {
	
	@Autowired
	private AannemerRepository aannemerRepository;
	
	@RequestMapping("/zorgcatalogus/aannemer/{specialiteitcode}/{gemeentecode}")
	public List<Aannemer> getAannemers(@PathVariable("specialiteitcode")int specialiteitCode,@PathVariable("gemeentecode") int gemeenteCode){
		List<Aannemer> aannemers = aannemerRepository.getAannemers(specialiteitCode, gemeenteCode);
		return aannemers;		
	}
	
	@RequestMapping("/zorgcatalogus/aannemer/{kvknummer}")
	public Aannemer getAannemer(@PathVariable("kvknummer") String kvknummer){
		Aannemer aannemer = aannemerRepository.getAannemer(kvknummer);
		return aannemer;
	}
	
	
	@RequestMapping("/zorgcatalogus/aannemer/specialiteit")
	public List<Specialiteit> getSpecialiteiten(){
		List<Specialiteit> specialiteiten = aannemerRepository.getAlleSpecialiteiten();
		return specialiteiten;
	}
	
	
	@RequestMapping(value ="/zorgcatalogus/aannemer/updaten",method=RequestMethod.POST)
	public Aannemer aannemerUpdaten(@RequestBody Aannemer aannemer){
		aannemerRepository.aannemerUpdaten(aannemer);
		 return aannemer;
	 }
	

	@RequestMapping(value ="/zorgcatalogus/aannemer/toevoegen",method=RequestMethod.POST)
	public Aannemer aannemerToevoegen(@RequestBody Aannemer aannemer){
		aannemerRepository.aannemerToevoegen(aannemer);
		 return aannemer;
	 }

}
