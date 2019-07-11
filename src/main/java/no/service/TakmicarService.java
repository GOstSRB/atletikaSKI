package no.service;

import java.util.List;

import org.springframework.data.domain.Page;

import no.model.Takmicar;

public interface TakmicarService {

	Takmicar findOne(Long id);
	Page<Takmicar> findAll(int pageNum);
	Takmicar save(Takmicar takmicar);
	Takmicar delete(Long id);
	Page<Takmicar> search(Long skakaonicaId, String imeIPrezime, String drzava, int pageNum);
	
}
