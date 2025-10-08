package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class SistemaDeEventos {

	private ArrayList<Evento> eventos;

	public SistemaDeEventos() {

		this.eventos = new ArrayList<>();
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public Boolean agregarEvento(Evento eventoNuevo) {
		for (Evento evento : eventos) {
			if (evento.getFecha().equals(eventoNuevo.getFecha())) {
				return false;
			}
		}

		return eventos.add(eventoNuevo);
	}

	public Boolean agregarParticipante(Integer id, Persona participante) {

		for (Evento evento : eventos) {
			if (evento.getId().equals(id)) {

				if (evento instanceof Casamiento) {
					return evento.agregarParticipantes(participante);
				}

				if (evento instanceof Conferencia) {
					return evento.agregarParticipantes(participante);
				}

				if (evento instanceof Recital) {
					return evento.agregarParticipantes(participante);
				}

			}

		}

		return false;
	}

	public Integer getCantCasamientos() {

		Integer cantidadDeCasamientos = 0;

		for (Evento evento : eventos) {
			if (evento instanceof Casamiento) {
				cantidadDeCasamientos++;
			}
		}

		return cantidadDeCasamientos;
	}

	public Integer getCantConferencias() {

		Integer cantidadDeConferencias = 0;

		for (Evento evento : eventos) {
			if (evento instanceof Conferencia) {
				cantidadDeConferencias++;
			}
		}

		return cantidadDeConferencias;
	}

	public Integer getCantRecital() {

		Integer cantidadDeRecital = 0;

		for (Evento evento : eventos) {
			if (evento instanceof Recital) {
				cantidadDeRecital++;
			}
		}

		return cantidadDeRecital;
	}

	public Double obtenerPromedioDeEdadDeEvento(Integer id) {

		Double edad = 0.0;

		for (Evento evento : eventos) {
			if (evento.getId().equals(id)) {
				HashSet<Persona> participantes = evento.getParticipantes();

				if (!participantes.isEmpty()) {
					for (Persona p : participantes) {
						edad += p.getEdad();
					}

					edad = edad / participantes.size();
				}

			}
		}

		return edad;
	}

	public Evento obtenerElEventoConMayorPromedioDeEdad() {

		Evento eventoConMayorPromedio = null;
		Double promedio = 0.0;
		Double promedioProgresivo = 0.0;

		for (Evento evento : eventos) {
			promedio = obtenerPromedioDeEdadDeEvento(evento.getId());

			if (promedio > promedioProgresivo) {
				promedioProgresivo = promedio;
				eventoConMayorPromedio = evento;

			}
		}

		return eventoConMayorPromedio;

	}

	public Evento obtenerEventoConMayorCantidadDeParticipantes() {
		Evento eventoCantMaxParticipantes = null;
		Integer cantMaxParticipante = 0;

		for (Evento evento : this.eventos) {
			Integer cantidadParticipantes = evento.getParticipantes().size();

			if (cantidadParticipantes > cantMaxParticipante) {
				cantMaxParticipante = cantidadParticipantes;
				eventoCantMaxParticipantes = evento;
			}
		}

		return eventoCantMaxParticipantes;
	}

	public Persona BuscarParticipantePorSuDNI(Integer dni) {

		Persona personaBuscada = null;

		for (Evento evento : eventos) {
			HashSet<Persona> personas = evento.getParticipantes();
			for (Persona persona : personas) {
				if (persona.getDni().equals(dni)) {
					personaBuscada = persona;
				}
			}
		}

		return personaBuscada;
	}

	public Boolean eliminarParticipantePorSuDNI(Persona participante) {

		for (Evento evento : eventos) {
			return evento.eliminarUnParticipantePorSuDni(participante);
		}

		return false;
	}

}
