package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import no.model.Takmicar;

import no.web.dto.TakmicarDTO;

@Component
public class TakmicarToTakmicarDTO implements Converter<Takmicar, TakmicarDTO>{

	@Override
	public TakmicarDTO convert(Takmicar takmicar) {
		// TODO Auto-generated method stub
		
		if(takmicar == null) {
			
			return null;
		}
		
		TakmicarDTO dto = new TakmicarDTO();
		
		dto.setId(takmicar.getId());
		dto.setImeIPrezime(takmicar.getImeIPrezime());
		dto.setDrzava(takmicar.getDrzava());
		dto.setVisina(takmicar.getVisina());
		dto.setEmail(takmicar.getEmail());
		dto.setGodinaRodjenja(takmicar.getGodinaRodjenja());
		
		dto.setSkakaonicaId(takmicar.getSkakaonica().getId());
		dto.setSkakaonicaNaziv(takmicar.getSkakaonica().getNaziv());
		
		
		return dto;
	}
	
	public List<TakmicarDTO> convert (List<Takmicar> takmicari) {
		List<TakmicarDTO> dtoList = new ArrayList<>();
		
		for (Takmicar takmicar : takmicari) {
			dtoList.add(convert(takmicar));
		}
		
		return dtoList;
	}

}
