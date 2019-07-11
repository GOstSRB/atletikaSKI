package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import no.service.SkokService;

import no.support.SkokToSkokDTO;

import no.web.dto.SkokDTO;

@RestController
@RequestMapping(value="/api/skokovi")
public class ApiSkokController {

	
	@Autowired
	private SkokService skokService;
	
	@Autowired
	private SkokToSkokDTO toDTO;

	
	@RequestMapping(method=RequestMethod.GET) public ResponseEntity<List<SkokDTO>> getSkokovi() {
		
		return new ResponseEntity<> (toDTO.convert(skokService.findAll()), HttpStatus.OK);
	}
}
