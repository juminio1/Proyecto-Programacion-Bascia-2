package ar.edu.unlam.dominio;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

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
}
