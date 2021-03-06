package no.web.dto;

import no.model.Takmicar;

public class SkokDTO {

	private Long id;
	private Double daljina;
	private Double ocenaSudija;
	private Double zbirPoena;
//	private Takmicar takmicar;
	
	private Long takmicarId;
	private String takmicarImeIPrezime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getDaljina() {
		return daljina;
	}
	public void setDaljina(Double daljina) {
		this.daljina = daljina;
	}
	public Double getOcenaSudija() {
		return ocenaSudija;
	}
	public void setOcenaSudija(Double ocenaSudija) {
		this.ocenaSudija = ocenaSudija;
	}
	public Double getZbirPoena() {
		return zbirPoena;
	}
	public void setZbirPoena(Double zbirPoena) {
		this.zbirPoena = zbirPoena;
	}
	public Long getTakmicarId() {
		return takmicarId;
	}
	public void setTakmicarId(Long takmicarId) {
		this.takmicarId = takmicarId;
	}
	public String getTakmicarImeIPrezime() {
		return takmicarImeIPrezime;
	}
	public void setTakmicarImeIPrezime(String takmicarImeIPrezime) {
		this.takmicarImeIPrezime = takmicarImeIPrezime;
	}
}
