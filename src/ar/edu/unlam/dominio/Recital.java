package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Recital extends Evento{

	private Boolean esAlAireLibre;
	private Integer bandasInvitadas;

	public Recital(String nombre, LocalDate fecha, String lugar, Boolean esAlAireLibre, Integer bandasInvitadas) {
		super(nombre, fecha, lugar);
		this.esAlAireLibre = esAlAireLibre;
		this.bandasInvitadas = bandasInvitadas;
	}

	public Boolean getEsAlAireLibre() {
		return esAlAireLibre;
	}

	public void setEsAlAireLibre(Boolean esAlAireLibre) {
		this.esAlAireLibre = esAlAireLibre;
	}

	public Integer getBandasInvitadas() {
		return bandasInvitadas;
	}

	public void setBandasInvitadas(Integer bandasInvitadas) {
		this.bandasInvitadas = bandasInvitadas;
	}
	
	

}
