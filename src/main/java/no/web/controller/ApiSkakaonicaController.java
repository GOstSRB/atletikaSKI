package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import no.service.SkakaonicaService;
import no.support.SkakaonicaToSkakaonicaDTO;
import no.web.dto.SkakaonicaDTO;


@RestController
@RequestMapping(value="/api/skakaonice")
public class ApiSkakaonicaController {
	
	@Autowired
	private SkakaonicaService skakaonicaService;
	
	@Autowired
	private SkakaonicaToSkakaonicaDTO toDTO;

	
	@RequestMapping(method=RequestMethod.GET) public ResponseEntity<List<SkakaonicaDTO>> getSkakaonice() {
		
		return new ResponseEntity<> (toDTO.convert(skakaonicaService.findAll()), HttpStatus.OK);
	}
}
