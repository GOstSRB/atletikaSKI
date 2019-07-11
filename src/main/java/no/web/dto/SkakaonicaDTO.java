package no.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import no.model.Takmicar;

public class SkakaonicaDTO {

	private Long id;
	
	@NotBlank
	private String naziv;
	
	@Min (0)
	private Double k;
	
	@Min((long) 1.2)
	@Max((long) 4.8)
	private Double d;
//	private Takmicar takmicar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getK() {
		return k;
	}

	public void setK(Double k) {
		this.k = k;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}
}
