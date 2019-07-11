package no.service;

import java.util.List;

import no.model.Skakaonica;

public interface SkakaonicaService {
	
	Skakaonica findOne(Long id);
	List<Skakaonica> findAll();
	
	Skakaonica save(Skakaonica skakaonica);
}
