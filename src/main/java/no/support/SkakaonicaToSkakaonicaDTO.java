package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.Skakaonica;
import no.web.dto.SkakaonicaDTO;

@Component
public class SkakaonicaToSkakaonicaDTO implements Converter<Skakaonica, SkakaonicaDTO>{

	@Override
	public SkakaonicaDTO convert(Skakaonica skakaonica) {
		if (skakaonica==null) {
			return null;
		}
		
		SkakaonicaDTO dto = new SkakaonicaDTO();
		
		dto.setId(skakaonica.getId());
		dto.setNaziv(skakaonica.getNaziv());
		dto.setD(skakaonica.getD());
		dto.setK(skakaonica.getK());
		
		return dto;
	}
	
	public List<SkakaonicaDTO> convert (List<Skakaonica> skakaonice) {
		List<SkakaonicaDTO> dtoList = new ArrayList<>();
		
		for (Skakaonica skakaonica : skakaonice) {
			dtoList.add(convert(skakaonica));
		}
		
		return dtoList;
	}

}
