package me.jvegaf.Agenda.Model;

public class Contact {
	
	private Integer id;
	private String nombre;
	private int telefono;
	private String correo;

	public Contact(Integer id, String nombre, int telefono, String correo) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getCorreo() {
		return correo;
	}
}
