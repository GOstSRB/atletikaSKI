package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.model.Skok;
import no.model.Takmicar;
import no.service.SkokService;
import no.service.TakmicarService;
import no.support.SkokToSkokDTO;
import no.support.TakmicarDTOToTakmicar;
import no.support.TakmicarToTakmicarDTO;
import no.web.dto.SkokDTO;
import no.web.dto.TakmicarDTO;

@RestController
@RequestMapping(value="/api/takmicari")
public class ApiTakmicarController {
	
	@Autowired
	private TakmicarService takmicarService;
	
	@Autowired
	private TakmicarToTakmicarDTO toDTO;
	
	@Autowired
	private TakmicarDTOToTakmicar toTakmicar;
	
	@Autowired
	private SkokService skokService;
	
	@Autowired
	private SkokToSkokDTO toDTOs;
	
	
@RequestMapping(method=RequestMethod.GET) public ResponseEntity<List<TakmicarDTO>> getAll(
		@RequestParam(required=false) Long skakaonicaId,
		@RequestParam(required=false) String imeIPrezime,
		@RequestParam(required=false) String drzava,
		
		@RequestParam(value="pageNum", defaultValue="0")int pageNum) {
	
	Page<Takmicar> takmicari = null;
	
	if(skakaonicaId !=null || imeIPrezime !=null || drzava !=null) {
		takmicari = takmicarService.search(skakaonicaId, imeIPrezime, drzava, pageNum);
	} else {
		takmicari = takmicarService.findAll(pageNum);
	}
	
	HttpHeaders headers = new HttpHeaders();
	headers.add("totalPages", Integer.toString(takmicari.getTotalPages()));
	
		
		return new ResponseEntity<> (toDTO.convert(takmicari.getContent()),headers, HttpStatus.OK);
	}

@RequestMapping(value="/{id}", method=RequestMethod.GET) public ResponseEntity<TakmicarDTO> getOne(
		@PathVariable Long id) {
	Takmicar takmicar = takmicarService.findOne(id);
	
	if(takmicar == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
			return new ResponseEntity<> (toDTO.convert(takmicar), HttpStatus.OK);
			

}

@RequestMapping(value="/{id}/skokovi", method=RequestMethod.GET) public ResponseEntity<List<SkokDTO>> getOneTakmicarAndSkokovi(
		@PathVariable Long id) {
	List<Skok> skok = skokService.findByTakmicarId(id);
	
	if(skok.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
			return new ResponseEntity<> (toDTOs.convert(skok), HttpStatus.OK);
}

@RequestMapping(value="/{id}", method=RequestMethod.DELETE) public ResponseEntity <TakmicarDTO> delete (
		@PathVariable Long id){
	Takmicar deleted = takmicarService.delete(id);
	
	if(deleted == null) {
		return new ResponseEntity<> (HttpStatus.NOT_FOUND); 
	}
	return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK );
	
}

@RequestMapping (method=RequestMethod.POST, consumes="application/json") public ResponseEntity<TakmicarDTO> add(
		@Validated
		@RequestBody TakmicarDTO newTakmicarDTO) {
	
	Takmicar savedTakmicar = takmicarService.save(toTakmicar.convert(newTakmicarDTO));
	return new ResponseEntity<> (toDTO.convert(savedTakmicar), HttpStatus.CREATED);
}

@RequestMapping (method=RequestMethod.PUT, value="/{id}", consumes="application/json") 
public ResponseEntity <TakmicarDTO> edit (
		@Validated @RequestBody TakmicarDTO takmicarDTO, 
		@PathVariable Long id) {
	
	if(!id.equals(takmicarDTO.getId())) {
		return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
	}
	
	Takmicar persisted = takmicarService.save(toTakmicar.convert(takmicarDTO));
	
	return new ResponseEntity<> (toDTO.convert(persisted), HttpStatus.OK);
	
	
}




}
