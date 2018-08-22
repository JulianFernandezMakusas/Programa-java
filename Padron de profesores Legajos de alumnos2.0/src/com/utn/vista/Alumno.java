package com.utn.vista;

public class Alumno extends Persona implements java.io.Serializable{
	private int legajo;

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return "Alumno\n"+super.toString()+"\n"+"legajo:" + legajo;
	}

	public Alumno(String nombre,String apellido, int dni, int legajo) {
		super(nombre, apellido, dni);
		this.legajo = legajo;
	}
	
	
}
