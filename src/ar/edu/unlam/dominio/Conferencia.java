package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Conferencia extends Evento{

	private Boolean tienePatrocinio;
	private Boolean conTraduccionSimultanea;

	public Conferencia(String nombre, LocalDate fecha, String lugar, Boolean tienePatrocinio, Boolean conTraduccionSimultanea) {
		super(nombre, fecha, lugar);
		this.tienePatrocinio = tienePatrocinio;
		this.conTraduccionSimultanea = conTraduccionSimultanea;
	}

	public Boolean getTienePatrocinio() {
		return tienePatrocinio;
	}

	public void setTienePatrocinio(Boolean tienePatrocinio) {
		this.tienePatrocinio = tienePatrocinio;
	}

	public Boolean getConTraduccionSimultanea() {
		return conTraduccionSimultanea;
	}

	public void setConTraduccionSimultanea(Boolean conTraduccionSimultanea) {
		this.conTraduccionSimultanea = conTraduccionSimultanea;
	}
	
	

}
