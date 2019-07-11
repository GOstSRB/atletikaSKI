package no.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.model.Skok;
import no.repository.SkokRepository;
import no.service.SkokService;

@Service
@Transactional
public class JpaSkokService implements SkokService{
	
	@Autowired
	private SkokRepository skokRepository;

	@Override
	public Skok findOne(Long id) {
		// TODO Auto-generated method stub
		return skokRepository.findOne(id);
	}

	@Override
	public List<Skok> findAll() {
		// TODO Auto-generated method stub
		return skokRepository.findAll();
	}

	@Override
	public Skok save(Skok skok) {
		// TODO Auto-generated method stub
		return skokRepository.save(skok);
	}

	@Override
	public List<Skok> findByTakmicarId(Long id) {
		// TODO Auto-generated method stub
		return skokRepository.findByTakmicarId(id);
	}

}
