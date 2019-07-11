package no.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import no.model.Takmicar;
import no.repository.TakmicarRepository;
import no.service.TakmicarService;

@Service
@Transactional
public class JpaTakmicarService implements TakmicarService{
	
	@Autowired
	private TakmicarRepository takmicarRepository;

	@Override
	public Takmicar findOne(Long id) {
		// TODO Auto-generated method stub
		return takmicarRepository.findOne(id);
	}

	@Override
	public Page<Takmicar> findAll(int pageNum) {
		// TODO Auto-generated method stub
		return takmicarRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Takmicar save(Takmicar takmicar) {
		// TODO Auto-generated method stub
		return takmicarRepository.save(takmicar);
	}

	@Override
	public Takmicar delete(Long id) {
		// TODO Auto-generated method stub
		Takmicar takmicar= takmicarRepository.findOne(id);
		
		if(takmicar == null) {
			throw new IllegalArgumentException("Tried to delete non-existant record");
		}
		takmicarRepository.delete(id);
		return takmicar;
	}

	@Override
	public Page<Takmicar> search(Long skakaonicaId, String imeIPrezime, String drzava, int pageNum) {
		// TODO Auto-generated method stub
		if(imeIPrezime != null || drzava != null) {
			imeIPrezime = "%"+imeIPrezime+"%";
			drzava = "%"+drzava+"%";
		}
		
		return takmicarRepository.search(skakaonicaId, imeIPrezime, drzava, new PageRequest(pageNum, 5));
	}

}
