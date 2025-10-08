package ar.edu.unlam.dominio;

import java.time.LocalDate;

public abstract class Evento {
	
	private static Integer idIncremento = 0;
	private Integer id;
	private String nombre;
	private LocalDate fecha;
	private String lugar;
	
	public Evento(String nombre, LocalDate fecha, String lugar) {
		this.id = ++idIncremento;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	
}
