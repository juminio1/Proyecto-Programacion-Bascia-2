package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Test_Eventos {

	private SistemaDeEventos sistema;

	@Before
	public void sistemaDeEventos() {
		sistema = new SistemaDeEventos();
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnRecitalExitosamente() {

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Recital recitalNuevo = new Recital(nombre, fecha, lugar, false, 0);

		Boolean seAgrego = sistema.agregarEvento(recitalNuevo);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnaConferenciaExitosamente() {

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Conferencia conferenciaNueva = new Conferencia(nombre, fecha, lugar, false, false);

		Boolean seAgrego = sistema.agregarEvento(conferenciaNueva);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoExitosamente() {

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);

		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoQueSupereLaCantidadDeParticipantesProvistas() {

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

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);

		Integer idInventado = 70;

		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(5, "Julieta", 74);

		Boolean seAgregoParticipante = sistema.agregarParticipante(idInventado, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(idInventado, persona2);

		assertTrue(seAgrego);
		assertFalse(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);
	}

	@Test
	public void dadoQueExisteUnSistemaDeEventosNoPuedoAgregarDosEventosConLaMismaFecha() {

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

	@Test
	public void dadoQueExisteUnEventoConSuIdEsPosibleEliminarloExitosamente() {
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		assertTrue(seAgrego);

		Integer eventoId = casamientoNueva.getId();
		Boolean eliminado = sistema.eliminarEventoPorId(eventoId);

		assertTrue(eliminado);
	}

	@Test
	public void dadoQueExisteUnEventoDevolverUnaListaConCantidadDeParticipantes() {

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer casamientoId = casamientoNueva.getId();
		assertTrue(seAgrego);
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(1, "Julieta", 74); // False porque el limite de CANTIDAD_PARTICIPANTES es 1
		Persona persona3 = new Persona(188, "Salva", 20); // False porque el limite de CANTIDAD_PARTICIPANTES es 1

		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);
		Boolean seAgregoParticipante3 = sistema.agregarParticipante(casamientoId, persona3);

		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);
		assertFalse(seAgregoParticipante3);

		Integer valorEsperado = 1;
		Integer valorObtenido = casamientoNueva.getParticipantes().size();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueTengoUnCasamientoCalculoElCostoFinalCorrecto() {

		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";

		Casamiento casamientoSinCatering = new Casamiento(nombre, fecha, lugar, false);
		sistema.agregarEvento(casamientoSinCatering);
		Persona persona1 = new Persona(912, "Jose", 20);
		sistema.agregarParticipante(casamientoSinCatering.getId(), persona1);
		Double precioSinCatering = casamientoSinCatering.calcularPrecioFinal();
		Double precioEsperado = 500.0;
		assertEquals(precioEsperado, precioSinCatering); // costo sin catering

		String nombre2 = "Lolamento";
		LocalDate fecha2 = LocalDate.of(2025, 8, 6);
		String lugar2 = "Tandil";

		Casamiento casamientoConCatering = new Casamiento(nombre2, fecha2, lugar2, true);
		sistema.agregarEvento(casamientoConCatering);
		Persona persona2 = new Persona(876, "Maria", 22);
		sistema.agregarParticipante(casamientoConCatering.getId(), persona2);
		Double precioConCatering = casamientoConCatering.calcularPrecioFinal();
		Double precioEsperado2 = 550.0;
		assertEquals(precioEsperado2, precioConCatering);

	}

	@Test
	public void dadoQueTengoUnRecitalVerificoNoAgregarAUnMenorYCalculoElCosto() {
		String nombre = "Nirvana";
		LocalDate fecha2 = LocalDate.of(2025, 8, 6);
		String lugar = "Movistar Arena";

		Recital recital = new Recital(nombre, fecha2, lugar, true, 2);
		sistema.agregarEvento(recital);

		Persona persona1 = new Persona(876, "Maria", 22);
		Persona persona2 = new Persona(855, "jose", 24);
		Persona persona3 = new Persona(890, "ofelia", 15);

		Boolean seAgrego = sistema.agregarParticipante(recital.getId(), persona1);
		Boolean seAgrego2 = sistema.agregarParticipante(recital.getId(), persona2);
		Boolean seAgrego3 = sistema.agregarParticipante(recital.getId(), persona3);
		assertTrue(seAgrego);
		assertTrue(seAgrego2);
		assertFalse(seAgrego3);

		Double precioFinal = recital.calcularPrecioFinal();
		Double precioEsperado = 27200.0;

		assertEquals(precioEsperado, precioFinal);
	}

	@Test
	public void dadoQueTengoUnaConferenciaVerificoNoAgregarAUnMenorYCalculoElCosto() {

		String nombre = "Jim Morrison";
		LocalDate fecha2 = LocalDate.of(2025, 8, 6);
		String lugar = "Movistar Arena";
		Conferencia conferencia = new Conferencia(nombre, fecha2, lugar, true, false);

		sistema.agregarEvento(conferencia);

		Persona persona1 = new Persona(876, "Maria", 22);
		Persona persona2 = new Persona(855, "jose", 12);

		Boolean seAgrego = sistema.agregarParticipante(conferencia.getId(), persona1);
		Boolean seAgrego2 = sistema.agregarParticipante(conferencia.getId(), persona2);

		assertTrue(seAgrego);
		assertFalse(seAgrego2); // no agrega por ser menor de 13

		Double costoFinal = conferencia.calcularPrecioFinal();
		Double costoEsperado = 900.0;

		assertEquals(costoEsperado, costoFinal);
	}

	@Test
	public void dadoQueTengoEventosRegistradosBuscoUnEventoPorFecha() {
		String nombre = "Jim Morrison";
		LocalDate fecha1 = LocalDate.of(2025, 8, 6);
		String lugar = "Movistar Arena";

		Evento conferencia = new Conferencia(nombre, fecha1, lugar, true, false);

		String nombre2 = "Nirvana";
		LocalDate fecha2 = LocalDate.of(2025, 8, 6);
		String lugar2 = "Movistar Arena";

		Evento recital = new Recital(nombre2, fecha2, lugar2, true, 2);

		String nombre3 = "Lol";
		LocalDate fecha3 = LocalDate.of(2025, 10, 6);
		String lugar3 = "Movistar Arena";

		Evento casamientoNueva = new Casamiento(nombre3, fecha3, lugar3, false);

		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Boolean seAgrego2 = sistema.agregarEvento(recital);
		Boolean seAgrego3 = sistema.agregarEvento(conferencia);

		Evento encontrado = sistema.buscarEventoPorFecha(LocalDate.of(2025, 10, 6));

		assertTrue(seAgrego);
		assertTrue(seAgrego2);
		assertFalse(seAgrego3); // no se agrega porque recital agregado antes tiene la misma fecha

		assertNotNull(encontrado);
		assertEquals(nombre3, encontrado.getNombre());
		assertTrue(encontrado instanceof Casamiento);
	}



	@Test
	public void buscarCuantosEventosSeEncuentranDisponiblesEnUnLapsoDeDosFechas() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		LocalDate fechaInicio = LocalDate.of(2025, 10, 1);
		LocalDate fechaFinal = LocalDate.of(2025, 12, 1);
		
		String nombreRecital = "Recital";
		LocalDate fechaRecital = LocalDate.of(2025,10,6);
		String lugarRecital = "Movistar Arena";
		Boolean esAlAireLibre = false;
		Integer bandaInvitadas = 1;
		
		Recital recitalNuevo = new Recital(nombreRecital, fechaRecital,lugarRecital, esAlAireLibre, bandaInvitadas);
		
		String nombreConferencia = "Conferencia";
		LocalDate fechaConferencia = LocalDate.of(2025,11,6);
		String lugarConferencia = "Gran Rex";
		Conferencia conferenciaNueva = new Conferencia(nombreConferencia, fechaConferencia,lugarConferencia,false,false);
		
		String nombreCasamiento = "Casamiento";
		LocalDate fechaCasamiento = LocalDate.of(2025,12,6);
		String lugarCasamiento = "Buenos Aires Gala";
		Casamiento casamientoNuevo = new Casamiento(nombreCasamiento, fechaCasamiento,lugarCasamiento, false);
		

		Boolean seAgregoRecital = sistema.agregarEvento(recitalNuevo);
		Boolean seAgregoConferencia = sistema.agregarEvento(conferenciaNueva);
		Boolean seAgregoCasamiento = sistema.agregarEvento(casamientoNuevo);

		
		Integer cantidadEventosEntreFecha = sistema.buscarEventoEntreFecha(fechaInicio, fechaFinal);
		Integer cantidadEventosEntreFechaEsperada = 2;
		
		assertTrue(seAgregoRecital);
		assertTrue(seAgregoConferencia);
		assertTrue(seAgregoCasamiento);
		assertEquals(cantidadEventosEntreFechaEsperada, cantidadEventosEntreFecha);
		
	}
}


