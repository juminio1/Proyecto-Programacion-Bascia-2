package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Casamiento extends Evento{

	private Boolean tieneCatering;

	public Casamiento(String nombre, LocalDate fecha, String lugar, Boolean tieneCatering) {
		super(nombre, fecha, lugar);
		this.tieneCatering = tieneCatering;
	}

	public Boolean getTieneCatering() {
		return tieneCatering;
	}

	public void setTieneCatering(Boolean tieneCatering) {
		this.tieneCatering = tieneCatering;
	}
	
	

}
