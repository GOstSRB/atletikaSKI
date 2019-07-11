package no.service;

import java.util.List;


import no.model.Skok;

public interface SkokService {

	Skok findOne(Long id);
	List<Skok> findAll();
	
	Skok save(Skok skok);
	
	List<Skok> findByTakmicarId(Long id);
}
