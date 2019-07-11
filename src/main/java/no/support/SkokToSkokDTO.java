package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.Skok;
import no.web.dto.SkokDTO;

@Component
public class SkokToSkokDTO implements Converter<Skok, SkokDTO>{

	@Override
	public SkokDTO convert(Skok skok) {
		// TODO Auto-generated method stub
		
		if(skok == null) {
			return null;
			
		}
		SkokDTO dto = new SkokDTO();
		
		dto.setId(skok.getId());
		dto.setDaljina(skok.getDaljina());
		dto.setOcenaSudija(skok.getOcenaSudija());
		dto.setZbirPoena(skok.getZbirPoena());
		
		dto.setTakmicarId(skok.getTakmicar().getId());
		dto.setTakmicarImeIPrezime(skok.getTakmicar().getImeIPrezime());
		
		return dto;
	}
	
	public List<SkokDTO> convert(List<Skok> skokovi){
		List<SkokDTO> dtoList = new ArrayList<>();
		
		for(Skok skok : skokovi) {
			dtoList.add(convert(skok));
		}
		
		return dtoList;
	}
	
	

}
