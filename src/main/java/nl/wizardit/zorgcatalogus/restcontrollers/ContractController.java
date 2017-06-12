package nl.wizardit.zorgcatalogus.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.wizardit.zorgcatalogus.domein.Contract;

import nl.wizardit.zorgcatalogus.repositories.ContractRepository;

@RestController
public class ContractController {
	
	@Autowired
	private ContractRepository contractRepository;
	
	
	@RequestMapping("/zorgcatalogus/contract/{productcode}/{gemeentecode}")
	public List<Contract> getContracten(@PathVariable("productcode")int productCode,@PathVariable("gemeentecode") int gemeenteCode){
		List<Contract> contracten = contractRepository.getContracten(productCode, gemeenteCode);
		return contracten;		
	}
	
	@RequestMapping("/zorgcatalogus/contract/{gemeentecode}")
	public List<Contract> getAlleContract(@PathVariable("gemeentecode") int gemeenteCode){
		List<Contract> contracten = contractRepository.getAlleContracten(gemeenteCode);
		return contracten;
	}
	
	
	@RequestMapping(value ="/zorgcatalogus/contract/toevoegen",method=RequestMethod.POST)
	public Contract slaOfferteOp(@RequestBody Contract contract){
	    contractRepository.contractToevoegen(contract);
		return contract;
	}

}
