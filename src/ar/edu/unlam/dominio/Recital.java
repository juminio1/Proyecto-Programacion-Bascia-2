package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public class Recital extends Evento {

	private Boolean esAlAireLibre;
	private Integer bandasInvitadas;
	private static final Integer CANTIDAD_PARTICIPANTES = 2000;
	private static final Integer EDAD_PERMITIDA = 18;
	private static final Double PRECIO_POR_PARTICIPANTE = 3000.0;
	private static final Double PRECIO_BANDAS_INVITADAS = 10000.0;

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

	@Override
	public Boolean agregarParticipantes(Persona participante) {

		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();

		if (cantidadPersonas < Recital.CANTIDAD_PARTICIPANTES && participante.getEdad() >= Recital.EDAD_PERMITIDA) {
			return personas.add(participante);
		}

		return false;
	}

	@Override
	public Double calcularPrecioFinal() {
		HashSet<Persona> personas = getParticipantes();

		Integer cantidadPersonas = personas.size();

		Double precioFinal = cantidadPersonas * Recital.PRECIO_POR_PARTICIPANTE;

		if (esAlAireLibre) {
			precioFinal += precioFinal * 0.2;
		}

		precioFinal += bandasInvitadas * PRECIO_BANDAS_INVITADAS;

		return precioFinal;
	}

}
