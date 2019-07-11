package no;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import no.model.Skakaonica;
import no.model.Skok;
import no.model.Takmicar;
import no.service.SkakaonicaService;
import no.service.SkokService;
import no.service.TakmicarService;

@Component
public class TestData {
		
	@Autowired
	private SkakaonicaService skakaonicaService;
	
	@Autowired
	private TakmicarService takmicarService;
	
	@Autowired
	private SkokService skokService;
	
	
	@PostConstruct
	public void init() {
		
		Skakaonica s1 = new Skakaonica();
		s1.setD(3.2);
		s1.setK(4.0);
		s1.setNaziv("SuRent");

		skakaonicaService.save(s1);
		
		Skakaonica s2 = new Skakaonica();
		s2.setD(2.3);
		s2.setK(5.0);
		s2.setNaziv("NSRent");
	
		skakaonicaService.save(s2);
		
		
		
		
		Takmicar t1 = new Takmicar();
		t1.setImeIPrezime("prvi takmicar");
		t1.setDrzava("Malta");
		t1.setVisina(190);
		t1.setEmail("milan@milan.com");
		t1.setGodinaRodjenja(1979);
		
		t1.setSkakaonica(s1);
		takmicarService.save(t1);
		
		
		Takmicar t2 = new Takmicar();
		t2.setImeIPrezime("drugi takmicar");
		t2.setDrzava("Grcka");
		t2.setVisina(193);
		t2.setEmail("milan@milan1.com");
		t2.setGodinaRodjenja(1989);
		
		t2.setSkakaonica(s2);
		takmicarService.save(t2);
		
		
		
		Skok a1 = new Skok();
		a1.setDaljina(4.2);
		a1.setOcenaSudija(8.5);
		a1.setZbirPoena(10.0);
		
		a1.setTakmicar(t1);
		
		skokService.save(a1);
		
		Skok a2 = new Skok();
		a2.setDaljina(3.2);
		a2.setOcenaSudija(4.5);
		a2.setZbirPoena(4.0);
		
		a2.setTakmicar(t1);
		
		skokService.save(a2);
		
		Skok a3 = new Skok();
		a3.setDaljina(5.2);
		a3.setOcenaSudija(5.5);
		a3.setZbirPoena(10.7);;
		
		a3.setTakmicar(t2);
		
		skokService.save(a3);
	}

}
