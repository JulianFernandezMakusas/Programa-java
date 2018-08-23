package com.utn.vista;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PersonalNoDocente extends Persona implements MetodosAbstractos {
	private LocalTime horaDeIngreso;
	private LocalTime horaDeEgreso;
	public LocalTime getHoraDeIngreso() {
		return horaDeIngreso;
	}

	public void setHoraDeIngreso(LocalTime horaDeIngreso) {
		this.horaDeIngreso = horaDeIngreso;
	}

	public LocalTime getHoraDeEgreso() {
		return horaDeEgreso;
	}

	public void setHoraDeEgreso(LocalTime horaDeEgreso) {
		this.horaDeEgreso = horaDeEgreso;
	}

	public PersonalNoDocente(String nombre, String apellido, int dni, LocalTime horaDeIngreso, LocalTime horaDeEgreso) {
		super(nombre, apellido, dni);
		this.horaDeIngreso = horaDeIngreso;
		this.horaDeEgreso = horaDeEgreso;
	}
	@Override
	public String toString() {
		return "Personal No Docente \n" + super.toString() + "\nHora de ingreso: " + horaDeIngreso
				+ "\nHora de egreso: " + horaDeEgreso + "\nHoras Trabajadas: " + calcularHora();
	}

	@Override
	public float calcularHora() {
		float horas = ChronoUnit.HOURS.between(horaDeIngreso, horaDeEgreso);
		return horas;
	}

}
