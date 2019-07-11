package no.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.model.Skakaonica;
import no.repository.SkakaonicaRepository;
import no.service.SkakaonicaService;

@Service
@Transactional
public class JpaSkakaonicaService implements SkakaonicaService{
	
	@Autowired
	private SkakaonicaRepository skakaonicaRepository;

	@Override
	public Skakaonica findOne(Long id) {
		// TODO Auto-generated method stub
		return skakaonicaRepository.findOne(id);
	}

	@Override
	public List<Skakaonica> findAll() {
		// TODO Auto-generated method stub
		return skakaonicaRepository.findAll();
	}

	@Override
	public Skakaonica save(Skakaonica skakaonica) {
		// TODO Auto-generated method stub
		return skakaonicaRepository.save(skakaonica);
	}

}
