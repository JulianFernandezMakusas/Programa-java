package com.utn.vista;

public class Profesor extends Persona implements java.io.Serializable {
	private int padron;

	public int getPadron() {
		return padron;
	}

	public void setPadron(int padron) {
		this.padron = padron;
	}

	@Override
	public String toString() {
		return "Profesor\n" + super.toString() + "\n" + "Numero de padron: " + padron;
	}

	public Profesor(String nombre, String apellido, int dni, int padron) {
		super(nombre, apellido, dni);
		this.padron = padron;
	}

}
