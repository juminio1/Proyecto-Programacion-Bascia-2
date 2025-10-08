package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public class Conferencia extends Evento{

	private Boolean tienePatrocinio;
	private Boolean conTraduccionSimultanea;
	private static final Integer CANTIDAD_PARTICIPANTES = 500;
	private static final Integer EDAD_PERMITIDA = 13;

	
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

	@Override
	public Boolean agregarParticipantes(Persona participante) {
		
		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();
		
		if(cantidadPersonas < Conferencia.CANTIDAD_PARTICIPANTES && participante.getEdad() >= Conferencia.EDAD_PERMITIDA) {
			return personas.add(participante);
		}
		
		return false;
	}
	
	

}
