package no.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import no.model.Skakaonica;
import no.model.Skok;

public class TakmicarDTO {

	private Long id;
	
	@NotBlank
	private String imeIPrezime;
	
	@Length(min=3, max=40)
	private String drzava;
	private Integer visina;
	private String email;
	private Integer godinaRodjenja;
	
	//kao obj
//	private Skakaonica skakaonica;
	private Long skakaonicaId;
	private String skakaonicaNaziv;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImeIPrezime() {
		return imeIPrezime;
	}
	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public Integer getVisina() {
		return visina;
	}
	public void setVisina(Integer visina) {
		this.visina = visina;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGodinaRodjenja() {
		return godinaRodjenja;
	}
	public void setGodinaRodjenja(Integer godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}
	public Long getSkakaonicaId() {
		return skakaonicaId;
	}
	public void setSkakaonicaId(Long skakaonicaId) {
		this.skakaonicaId = skakaonicaId;
	}
	public String getSkakaonicaNaziv() {
		return skakaonicaNaziv;
	}
	public void setSkakaonicaNaziv(String skakaonicaNaziv) {
		this.skakaonicaNaziv = skakaonicaNaziv;
	}
	
	
}
