package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Evento {

	private static Integer idIncremento = 0;
	private Integer id;
	private String nombre;
	private LocalDate fecha;
	private String lugar;
	private HashSet<Persona> participantes;

	public Evento(String nombre, LocalDate fecha, String lugar) {
		this.id = ++idIncremento;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.participantes = new HashSet<>();
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

	public HashSet<Persona> getParticipantes() {
		return participantes;
	}

	public abstract Boolean agregarParticipantes(Persona participante);

	public Boolean eliminarUnParticipantePorSuDni(Persona participante) {

		HashSet<Persona> participantes = getParticipantes();

		for (Persona persona : participantes) {
			if (persona.getDni().equals(participante.getDni())) {
				return participantes.remove(persona);
			}
		}

		return false;

	}
}
