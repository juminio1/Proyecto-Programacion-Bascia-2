package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class Test_Eventos {

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnRecitalExitosamente() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		// Evento evento = new Evento(nombre, fecha, lugar);
		Recital recitalNuevo = new Recital(nombre, fecha, lugar, false, 0); // cambio agregue 2 atributos

		Boolean seAgrego = sistema.agregarEvento(recitalNuevo);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnaConferenciaExitosamente() {
		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Conferencia conferenciaNueva = new Conferencia(nombre, fecha, lugar, false, false);

		Boolean seAgrego = sistema.agregarEvento(conferenciaNueva);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoExitosamente() {
		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);

		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoQueSupereLaCantidadDeParticipantesProvistas() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);

		Integer casamientoId = casamientoNueva.getId();

		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(31, "Julieta", 74);

		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);

		assertTrue(seAgrego);
		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);

	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroAgregarDosPersonasAlEventoConElMismoDNIyObtenerError() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer casamientoId = casamientoNueva.getId();

		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(912, "Julieta", 74);

		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);

		assertTrue(seAgrego);
		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);

	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroAgregarParticipantesEnUnEventoConIdInventado() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer idInventado = 70;

		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(1, "Julieta", 74);

		Boolean seAgregoParticipante = sistema.agregarParticipante(idInventado, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(idInventado, persona2);

		assertTrue(seAgrego);
		assertFalse(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosNoPuedoAgregarDosEventosConLaMismaFecha() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		Recital recital = new Recital(nombre, fecha, lugar, esAlAireLibre, bandaInvitadas);

		String nombre2 = "Conferencia";
		String lugar2 = "Auditorio";
		Boolean tienePatrocinio = false;
		Boolean conTraduccionSimultanea = false;

		Conferencia conferencia = new Conferencia(nombre2, fecha, lugar2, tienePatrocinio, conTraduccionSimultanea);

		Boolean seAgregoRecital = sistema.agregarEvento(recital);
		Boolean seAgregoConferencia = sistema.agregarEvento(conferencia);

		assertTrue(seAgregoRecital);
		assertFalse(seAgregoConferencia);

	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberCuantosEventosEstanRegistradosDeCadaTipo() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		Recital recital = new Recital(nombre, fecha, lugar, esAlAireLibre, bandaInvitadas);

		String nombre2 = "Conferencia";
		LocalDate fecha2 = LocalDate.of(2025, 10, 7);
		String lugar2 = "Auditorio";
		Boolean tienePatrocinio = false;
		Boolean conTraduccionSimultanea = false;

		Conferencia conferencia = new Conferencia(nombre2, fecha2, lugar2, tienePatrocinio, conTraduccionSimultanea);

		String nombre3 = "Casamiento";
		LocalDate fecha3 = LocalDate.of(2025, 10, 8);
		String lugar3 = "Salon";

		Casamiento casamiento = new Casamiento(nombre3, fecha3, lugar3, true);

		sistema.agregarEvento(recital);
		sistema.agregarEvento(conferencia);
		sistema.agregarEvento(casamiento);

		Integer cantCasamientos = sistema.getCantCasamientos();
		Integer cantRecital = sistema.getCantRecital();
		Integer cantConferencia = sistema.getCantConferencias();

		Integer cantEsperada = 1;

		assertEquals(cantEsperada, cantCasamientos);
		assertEquals(cantEsperada, cantRecital);
		assertEquals(cantEsperada, cantConferencia);

	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberCuantosEventosEstanRegistrados() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		Recital recital = new Recital(nombre, fecha, lugar, esAlAireLibre, bandaInvitadas);

		String nombre2 = "Conferencia";
		LocalDate fecha2 = LocalDate.of(2025, 10, 7);
		String lugar2 = "Auditorio";
		Boolean tienePatrocinio = false;
		Boolean conTraduccionSimultanea = false;

		Conferencia conferencia = new Conferencia(nombre2, fecha2, lugar2, tienePatrocinio, conTraduccionSimultanea);

		String nombre3 = "Casamiento";
		LocalDate fecha3 = LocalDate.of(2025, 10, 8);
		String lugar3 = "Salon";

		Casamiento casamiento = new Casamiento(nombre3, fecha3, lugar3, true);

		sistema.agregarEvento(recital);
		sistema.agregarEvento(conferencia);
		sistema.agregarEvento(casamiento);

		ArrayList<Evento> eventos = sistema.getEventos();
		Integer cantEventos = eventos.size();
		Integer cantEsperada = 3;
		assertEquals(cantEsperada, cantEventos);

	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberElPromedioDeEdadDeUnEvento() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		Recital recital = new Recital(nombre, fecha, lugar, esAlAireLibre, bandaInvitadas);
		Integer idR = recital.getId();

		sistema.agregarEvento(recital);

		Persona persona1 = new Persona(912, "Adrian", 20);
		Persona persona2 = new Persona(31, "Emilia", 30);

		sistema.agregarParticipante(idR, persona1);
		sistema.agregarParticipante(idR, persona2);

		double promedioEdad = sistema.obtenerPromedioDeEdadDeEvento(idR);
		double esperado = 25.0;

		assertEquals((int) esperado, (int) promedioEdad);

	}

	@Test
	public void dadoQueExisteUnaGestionDeEventosMuestraElEventoConMayorCantidadDeParticipantes() {
		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre = "Viva la vida";
		LocalDate fecha = LocalDate.of(2025, 10, 7);
		String lugar = "Movistar Arena";

		String nombre2 = "Fernet y coca";
		LocalDate fecha2 = LocalDate.of(2025, 10, 8);
		String lugar2 = "River Plate";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		String nombre3 = "Bait";
		LocalDate fecha3 = LocalDate.of(2025, 10, 9);
		String lugar3 = "New York";
		Boolean tienePatrocinio = false;
		Boolean conTraduccionSimultanea = false;

		Casamiento casamiento = new Casamiento(nombre, fecha, lugar, false);
		Recital recital = new Recital(nombre2, fecha2, lugar2, esAlAireLibre, bandaInvitadas);
		Conferencia conferencia = new Conferencia(nombre3, fecha3, lugar3, tienePatrocinio, conTraduccionSimultanea);

		sistema.agregarEvento(casamiento);
		sistema.agregarEvento(recital);
		sistema.agregarEvento(conferencia);

		Persona persona1 = new Persona(9123, "Julieta", 20);
		Persona persona2 = new Persona(1121, "San Martín", 74);
		Persona persona3 = new Persona(1457, "Veronica", 25);
		Persona persona4 = new Persona(1901, "Lucas", 62);
		Persona persona5 = new Persona(2421, "Emir", 56);
		Persona persona6 = new Persona(7181, "Dorian", 41);

		sistema.agregarParticipante(recital.getId(), persona1);
		sistema.agregarParticipante(recital.getId(), persona2);
		sistema.agregarParticipante(recital.getId(), persona3);

		sistema.agregarParticipante(casamiento.getId(), persona4);

		sistema.agregarParticipante(conferencia.getId(), persona5);
		sistema.agregarParticipante(conferencia.getId(), persona6);

		Evento eventoMaxParticipanteObtenido = sistema.obtenerEventoConMayorCantidadDeParticipantes();

		Evento eventoMaxParticipanteEsperado = recital;

		assertEquals(eventoMaxParticipanteEsperado, eventoMaxParticipanteObtenido);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroBuscarUnParticipanteDeUnEventoPorSuDNI() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre2 = "Fernet y coca";
		LocalDate fecha2 = LocalDate.of(2025, 10, 8);
		String lugar2 = "River Plate";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		Recital recital = new Recital(nombre2, fecha2, lugar2, esAlAireLibre, bandaInvitadas);

		sistema.agregarEvento(recital);

		Persona persona1 = new Persona(9123, "Julieta", 20);

		sistema.agregarParticipante(recital.getId(), persona1);

		Persona participanteObtenido = sistema.BuscarParticipantePorSuDNI(persona1.getDni());

		assertEquals(persona1, participanteObtenido);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroEliminarUnParticipanteDeUnEventoPorSuDNI() {

		SistemaDeEventos sistema = new SistemaDeEventos();

		String nombre2 = "Fernet y coca";
		LocalDate fecha2 = LocalDate.of(2025, 10, 8);
		String lugar2 = "River Plate";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;

		Recital recital = new Recital(nombre2, fecha2, lugar2, esAlAireLibre, bandaInvitadas);

		sistema.agregarEvento(recital);

		Persona persona1 = new Persona(9123, "Julieta", 20);

		sistema.agregarParticipante(recital.getId(), persona1);

		Boolean participanteEliminado = sistema.eliminarParticipantePorSuDNI(persona1);

		assertTrue(participanteEliminado);

	}

}
