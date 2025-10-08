package ar.edu.unlam.dominio;

public class Persona {
	private Integer dni;
	private String nombre;
	private Integer edad;
	
	public Persona(Integer dni, String nombre, Integer edad) {
		this.dni = dni;
		this.nombre = nombre;
			this.edad = edad;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
}
