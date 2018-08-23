package com.utn.vista;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		Persona profesor = null;
		Persona alumno = null;
		int Dni;
		String DniS;
		Set<Persona> listaPersonas = new TreeSet<>();

		Path bDniAlumn = Paths
				.get("C:\\Users\\Java\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Alumno.ser");
		Path bDniProf = Paths
				.get("C:\\Users\\Java\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Profesor.ser");
		if (Files.exists(bDniProf) == false) {
			System.out.println("No se cargaron profesores");
		} else {
			System.out.println("Abriendo archivo de Profesores");
		}
		if (Files.exists(bDniAlumn) == false) {
			System.out.println("No se cargaron alumnos");
		} else {
			System.out.println("Abriendo archivo de Alumnos");
		}
		while (true) {
			try {
				ObjectInputStream datosAlumno = new ObjectInputStream(Files.newInputStream(bDniAlumn));
				try {
					alumno = (Alumno)datosAlumno.readObject();
					System.out.println("Jia");
				} catch (ClassNotFoundException e) {

				}
				ObjectInputStream datosProfesor = new ObjectInputStream(Files.newInputStream(bDniProf));
				try {
					profesor =(Profesor) datosProfesor.readObject();
					System.out.println("Jia");
				} catch (ClassNotFoundException e) {

				}
			} catch (IOException e) {
				System.out.println("Final del archivo");
			}
			break;
		}
		System.out.println(alumno.getDni());
		System.out.println(profesor.getDni());
	}
}
