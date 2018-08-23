package com.utn.vista;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{
	private String nombre;
	private String apellido;
	private int dni;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Nombre:" + nombre + "\nApellido:" + apellido + "\nDNI:" + dni;
	}

	public Persona(String nombre, String apellido, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	@Override
	public boolean equals(Object Persona) {
		boolean resultado = false;
		if ((Persona != null) && (Persona instanceof Persona)) {
			Persona p = (Persona) Persona;
			if ((p.nombre.equals(this.nombre)) && (p.apellido.equals(this.apellido)) && (p.dni == this.dni)) {
				resultado = true;
			}
		}
		return resultado;
	}

	public int hashCode() {
		int hash = 7;
		hash = 199 * hash * this.dni;
		hash = 263 * hash * Objects.hashCode(nombre);
		hash = 883 * hash * Objects.hashCode(apellido);
		hash = 7 * hash + (int) (Double.doubleToLongBits(this.dni) ^ (Double.doubleToLongBits(dni) >>> 32));
		return hash;
	}

}
