package no.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.Skakaonica;
import no.model.Takmicar;
import no.service.SkakaonicaService;
import no.service.TakmicarService;
import no.web.dto.TakmicarDTO;

@Component
public class TakmicarDTOToTakmicar implements Converter<TakmicarDTO, Takmicar>{
	
	@Autowired
	private TakmicarService takmicarService;
	
	@Autowired
	private SkakaonicaService skakaonicaService;
	

	@Override
	public Takmicar convert(TakmicarDTO takmicarDTO) {
		// TODO Auto-generated method stub
		
		Skakaonica skakaonica = skakaonicaService.findOne(takmicarDTO.getSkakaonicaId());
		
		if (skakaonica !=null) {
			Takmicar takmicar = null;
			
			if (takmicarDTO.getId() != null) {
				takmicar = takmicarService.findOne(takmicarDTO.getId());
			} else {
				takmicar = new Takmicar();
			}
			
			takmicar.setImeIPrezime(takmicarDTO.getImeIPrezime());
			takmicar.setDrzava(takmicarDTO.getDrzava());
			takmicar.setVisina(takmicarDTO.getVisina());
			takmicar.setEmail(takmicarDTO.getEmail());
			takmicar.setGodinaRodjenja(takmicarDTO.getGodinaRodjenja());
			
			takmicar.setSkakaonica(skakaonica);
			
			return takmicar;
			
		} else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}
		
	}
	
	

}
